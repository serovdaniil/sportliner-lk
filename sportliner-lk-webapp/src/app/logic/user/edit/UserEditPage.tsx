import {Button, Checkbox, Collapse, Form, Input, Modal, Row, Select, Space, Tooltip, Typography} from 'antd';
import {useForm} from 'antd/es/form/Form';
import {requestHandlerStore} from 'app/App';
import {AppRoutes} from 'app/AppRoutes';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from "app/logic/Navigator";
import {
    emailValidator,
    phoneValidator,
    requiredValidator,
    requiredWithTrimValidator,
    trueValidator,
    usernameValidator
} from 'app/logic/Validators';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {UserEditPageStore} from "./UserEditPageStore";
import {DeleteTwoTone, LockOutlined} from "@ant-design/icons";
import generatePassword from "password-generator";
import {ValidationException} from "../../../service/exceptions/ValidationException";
import copyToClipboard from "../../../utils/BrowserAPIs";
import LabelWarn from "../../../components/LabelWithWarning/LabelWithWarning";
import {UserRole} from "../../../../api";
import DateUtils from "../../../utils/DateUtils";
import ChildForm from "./ChildForm";
import AppNotification from "../../notification/AppNotification";

const PAGE_TITLE = "Редактирование пользователя";
const {Panel} = Collapse;

interface Props {
    userAccountId?: string;
}

const UserEditPage: FC<Props> = (props: Props) => {
    const [form] = useForm();
    const [init, setInit] = useState(false);
    const store: UserEditPageStore = useLocalObservable(() => new UserEditPageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init(props.userAccountId);

                setInit(true);
            });
        })();
    }, []);

    const userAttributes = store.userAccount;

    const onSave = async () => {
        try {
            await form.validateFields();
        } catch {
            return;
        }

        const userAccount = form.getFieldsValue();

        try {
            await requestHandlerStore.requestWithBlockingUI(async () => {
                await store.save(userAccount);
            });

            goBack()
        } catch (e: any) {
            AppNotification.error(e.message)
        }
    };

    const goBack = () => {
        navigator.safeNavigate(AppRoutes.userListPage.toUrl());
    }

    const isNewUser = props.userAccountId == null;

    const formatUserRole = (role: UserRole): string => {
        switch (role) {
            case UserRole.ADMIN:
                return "Администратор";
            case UserRole.TRAINER:
                return "Тренер";
            case UserRole.PARENT:
                return "Законный представитель";
            default:
                throw new Error("Unexpected role: " + role);
        }
    };

    const hasPassword = () => {
        if (!isNewUser) {
            return true;
        }

        return form.getFieldsValue().password != null;
    }

    const isAcceptableValidPassword = (s: string): boolean => {
        return /^[\x21-\x7E]+$/.test(s)
            && s.length >= 8
            && s.length <= 20
            && /[0-9]/.test(s)
            && /[a-z]/.test(s)
            && /[A-Z]/.test(s);
    }

    const generateNewPassword = () => {
        let password: string = "";
        let attempt: number = 0;

        // need to generated strong password that completely satisfies client/server password complexity validations
        while (!isAcceptableValidPassword(password) && attempt < 100) {
            attempt++;
            password = generatePassword(20, false, /[0-9a-zA-Z]/);
        }

        if (!isAcceptableValidPassword(password)) {
            throw new ValidationException("Не удалось сгенерировать надежный пароль");
        }

        Modal.info({
            title: 'Генерация паролей',
            content: (
                <Space direction="vertical">
                    Password:
                    <Input name={"password"} value={password} size="small" style={{minWidth: 200}} disabled/>

                    <Typography.Link onClick={() => copyToClipboard(password)}>
                        Копирование пароля в буфер обмена
                    </Typography.Link>
                </Space>
            ),
            okText: 'Готово',
            onOk: () => {
                form.setFieldsValue({
                    password: password
                })
                userAttributes.setPassword(password);
                userAttributes.setPasswordMustBeChanged(true);
            },
            cancelText: 'Отмена',
            className: 'dp-modal_small',
        });
    };

    if (!init) {
        return (
            <PageBorder
                title={PAGE_TITLE}
                isLoading
            >
                <LoadingBlock/>
            </PageBorder>
        );
    }

    return (
        <PageBorder
            title={PAGE_TITLE}
            content={(
                <Space style={{float: 'right'}}>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={onSave}
                        style={{background: '#0f2d77'}}
                    >
                        Сохранить
                    </Button>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={goBack}
                        style={{background: '#0f2d77'}}
                    >
                        Назад
                    </Button>
                </Space>
            )}
        >
            <Form
                form={form}
                style={{
                    width: '100%',
                }}
                layout="vertical"
                initialValues={{
                    username: userAttributes.username,
                    password: userAttributes.password,
                    email: userAttributes.email,
                    role: userAttributes.role,
                    lastName: userAttributes.lastName,
                    firstName: userAttributes.firstName,
                    patronymic: userAttributes.patronymic,
                    phone: userAttributes.phone,
                    payAttention: userAttributes.payAttention,
                    reason: userAttributes.reason
                }}
                autoComplete="off"
            >
                <Row className="dp-row">

                    <Space direction={'vertical'}>

                        <Typography.Title level={4}>Информация об аккаунте</Typography.Title>

                        <Space align="start">
                            <Form.Item
                                name="username"
                                label="Логин:"
                                style={{marginBottom: 0, width: 280}}
                                rules={[usernameValidator()]}
                            >
                                <Input
                                    disabled={props.userAccountId != null}
                                    onChange={event => {
                                        userAttributes.setUsername(event.target.value)
                                    }}
                                />
                            </Form.Item>

                            <Form.Item
                                name="role"
                                label="Роль:"
                                rules={[requiredWithTrimValidator()]}
                                style={{width: 280}}
                            >
                                <Select onChange={(role: UserRole) => userAttributes.setRole(role)}>
                                    <Select.Option value=""> </Select.Option>
                                    {Object.values(UserRole).map((role) => {
                                        return (
                                            <Select.Option
                                                key={role}
                                                value={role}
                                            >
                                                {formatUserRole(role)}
                                            </Select.Option>
                                        )
                                    })}
                                </Select>
                            </Form.Item>
                        </Space>

                        <Space align="start">
                            <Form.Item
                                name="password"
                                label="Пароль:"
                                rules={[trueValidator(() => {
                                        return hasPassword()
                                    },
                                    'Поле обязательно для заполнения. Пожалуйста, воспользуйтесь ссылкой "Сгенерировать новый пароль"')
                                ]}
                                style={{width: 280}}
                            >
                                <Input.Password
                                    disabled
                                    prefix={<LockOutlined className="site-form-item-icon"/>}
                                    placeholder={hasPassword()
                                        ? '••••••••••••••••••••'
                                        : 'Требуется генерация пароля'}
                                    visibilityToggle={false}
                                />
                            </Form.Item>

                            <Form.Item
                                label={(
                                    <LabelWarn
                                        text=""
                                        warnText="Необходимо изменить пароль"
                                        isWarn={userAttributes.passwordMustBeChanged!}
                                    />
                                )}
                                rules={[requiredValidator()]}
                                style={{width: 280}}
                            >
                                <Button type="primary" onClick={generateNewPassword} style={{width: 280}}>
                                    Сгенерировать новый пароль
                                </Button>
                            </Form.Item>
                        </Space>

                    </Space>

                </Row>

                <Row className="dp-row">
                    <Space direction={'vertical'}>

                        <Typography>Персональные данные пользователя</Typography>

                        <Space direction={"horizontal"}>
                            <Form.Item
                                name="lastName"
                                label="Фамилия:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input
                                    onChange={event => {
                                        userAttributes.setLastName(event.target.value)
                                    }}
                                />
                            </Form.Item>
                            <Form.Item
                                name="firstName"
                                label="Имя:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input
                                    onChange={event => {
                                        userAttributes.setFirstName(event.target.value)
                                    }}
                                />
                            </Form.Item>
                            <Form.Item
                                name="patronymic"
                                label="Отчество:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input
                                    onChange={event => {
                                        userAttributes.setPatronymic(event.target.value)
                                    }}
                                />
                            </Form.Item>
                        </Space>

                        <Form.Item
                            name="phone"
                            label="Телефонный номер:"
                            style={{marginBottom: 0, width: '100%'}}
                            rules={[requiredWithTrimValidator(), phoneValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    userAttributes.setPhone(event.target.value)
                                }}
                                placeholder={"+375 (29) 212-51-79"}
                            />
                        </Form.Item>

                        <Form.Item
                            name="email"
                            label="E-mail:"
                            style={{marginBottom: 0, width: '100%'}}
                            rules={[requiredWithTrimValidator(), emailValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    userAttributes.setEmail(event.target.value)
                                }}
                            />
                        </Form.Item>

                        <Space direction={"horizontal"}>
                            <Form.Item
                                name="payAttention"
                                label="Обратить внимание:"
                            >
                                <Checkbox
                                    checked={store.userAccount?.payAttention}
                                    onChange={event => userAttributes.setPayAttention(event.target.checked)}
                                />
                            </Form.Item>
                            {store.userAccount?.payAttention === true && (
                                <Form.Item
                                    name="reason"
                                    label="Причина:"
                                >
                                    <Input
                                        onChange={event => {
                                            userAttributes.setReason(event.target.value)
                                        }}
                                    />
                                </Form.Item>
                            )}
                        </Space>
                    </Space>

                </Row>

                {store.userAccount?.role == UserRole.PARENT && (
                    <Row className="dp-row">
                        <Space direction={"horizontal"}>
                            <Typography>Дети</Typography>

                            <Button
                                className="dp-button"
                                type="link"
                                onClick={() => userAttributes.addChild()}
                            >
                                Добавить ребенка
                            </Button>
                        </Space>

                        <Collapse accordion style={{width: "100%"}}>
                            {userAttributes.children.map((child, index) => {
                                return (
                                    <Panel
                                        header={
                                            <Space direction={"horizontal"}>
                                                <Typography>
                                                    {child.lastName + " " + child.firstName + " " + child.patronymic}
                                                </Typography>
                                                <Tooltip title="Удалить">
                                                    <a onClick={() => userAttributes.deleteChild(index)}>
                                                        <DeleteTwoTone twoToneColor="red"/>
                                                    </a>
                                                </Tooltip>
                                            </Space>
                                        }
                                        key={child.id!}
                                    >
                                        <ChildForm
                                            child={child}
                                            branchOffices={store.branchOffices}
                                        />
                                    </Panel>

                                )
                            })}
                        </Collapse>
                    </Row>
                )}

                <Row className="dp-row">
                    <Space direction={"vertical"}>
                        {userAttributes.createTimestamp && (
                            <Typography.Paragraph className="dp-regular-text">
                                Дата создания аккаунта:&nbsp;
                                {DateUtils.formatDateLocalWithTime(userAttributes.createTimestamp)}
                            </Typography.Paragraph>
                        )}

                        {userAttributes.updateTimestamp && (
                            <Typography.Paragraph className="dp-regular-text">
                                Дата последнего обновления пользователя:&nbsp;
                                {DateUtils.formatDateLocalWithTime(userAttributes.updateTimestamp)}
                            </Typography.Paragraph>
                        )}

                        {userAttributes.loginTimestamp && (
                            <Typography.Paragraph className="dp-regular-text">
                                Последний вход в систему:&nbsp;
                                {DateUtils.formatDateLocalWithTime(userAttributes.loginTimestamp)}
                            </Typography.Paragraph>
                        )}
                    </Space>
                </Row>

            </Form>
        </PageBorder>
    );
};

export default observer(UserEditPage);
