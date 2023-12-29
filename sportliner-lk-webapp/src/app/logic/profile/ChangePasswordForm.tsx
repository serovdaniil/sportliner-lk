import {LockOutlined} from '@ant-design/icons';
import {Button, Form, Input, Modal, Row, Space, Typography} from 'antd';
import {ChangeCurrentUserPasswordRequest, UserProfile,} from 'api';
import {requestHandlerStore} from 'app/App';
import {passwordValidator, requiredValidator} from 'app/logic/Validators';
import {accountApi} from 'app/service/Apis';
import {observer} from 'mobx-react';
import React, {useState} from 'react';

export const changePasswordInModal = (profile: UserProfile) => {
    const modal = Modal.info({
        icon: null,
        okButtonProps: {
            hidden: true
        },
        content: (
            <ChangePasswordForm
                profile={profile}
                onSuccess={() => modal.destroy()}
                onCancel={() => modal.destroy()}
            />
        )
    });
}


interface ChangePasswordFormProps {
    profile: UserProfile;
    onSuccess: () => void;
    onCancel: () => void;
}

const ChangePasswordForm: React.FC<ChangePasswordFormProps> = (props: ChangePasswordFormProps) => {
    const [form] = Form.useForm();

    const [formError, setFormError] = useState<string>();

    const handleCancel = () => {
        props.onCancel();
    }

    const sendPasswordChange = async (data: { username: string, password: string, newPassword: string, newPasswordConfirm: string }) => {
        setFormError(undefined);

        if (data.newPassword !== data.newPasswordConfirm) {
            setFormError('confirm');
            return;
        }

        try {
            const request: ChangeCurrentUserPasswordRequest = {
                authChangePassword: {
                    username: props.profile.username,
                    oldPassword: data.password,
                    newPassword: data.newPassword,
                },
            };

            await accountApi.changeCurrentUserPassword(request);

            props.onSuccess();

            Modal.success({
                title: 'Ваш пароль был изменён',
                okText: 'Завершить',
                onOk: () => {
                },
                cancelText: 'Закрыть',
                className: 'dp-modal_small',
            });

        } catch (response: any) {
            throw response;
        }
    };


    return (
        <Form
            form={form}
            layout="vertical"
            name="change_password"
            onFinish={(data) => requestHandlerStore.serviceRequest(async () => {
                sendPasswordChange(data);
            })}
        >

            <Typography.Title level={4}>
                Введите новый пароль
            </Typography.Title>

            <Input
                name="username"
                value={props.profile.username}
                style={{display: 'none'}}
                hidden
            />

            <Form.Item
                name="password"
                label="Текущий пароль"
                validateStatus={formError == 'password' ? 'error' : undefined}
                help={formError == 'password' ? 'Wrong password' : undefined}
                rules={[requiredValidator()]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    autoComplete="current-password"
                    autoFocus
                />
            </Form.Item>

            <Form.Item
                name="newPassword"
                label="Новый пароль"
                rules={[requiredValidator(), passwordValidator()]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    autoComplete="new-password"
                />
            </Form.Item>

            <Form.Item
                name="newPasswordConfirm"
                label="Подтвердите новый пароль"
                validateStatus={formError == 'confirm' ? 'error' : undefined}
                help={formError == 'confirm' ? 'Пароль не совпадает' : undefined}
                rules={[requiredValidator()]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    autoComplete="new-password"
                />
            </Form.Item>

            <Row justify="end">
                <Space>
                    <Button className="dp-button" type="primary" htmlType="submit">Сохранить</Button>
                    <Button className="dp-button" type="default" htmlType="button"
                            onClick={() => handleCancel()}>Назад</Button>
                </Space>
            </Row>
        </Form>
    );
};

export default observer(ChangePasswordForm);
