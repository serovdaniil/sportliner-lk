import {Button, Form, Input, Row, Select, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from 'app/components/LoadingBlock/LoadingBlock';
import {useNavigator} from "app/logic/Navigator";
import AppNotification from 'app/logic/notification/AppNotification';
import React, {FC, useEffect, useState} from 'react';
import TrialAttendanceEditPageStore from "./TrialAttendanceEditPageStore";
import PageBorder from "../../../border/PageBorder";
import {phoneValidator, requiredWithTrimValidator} from "../../../Validators";
import LocalDatePicker from "../../../../components/LocalDatePicker/LocalDatePicker";


const PAGE_TITLE: string = "Добавление заявки на пробной занятие";

interface Props {
}

const TrialAttendanceEditPage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState<boolean>(false);
    const navigator = useNavigator();
    const [store] = useState<TrialAttendanceEditPageStore>(() => new TrialAttendanceEditPageStore());
    const [form] = Form.useForm();

    useEffect(() => {
        requestHandlerStore.initializePage(async () => {
            await store.init();

            setInit(true);
        });
    }, []);

    const goBack = () => {
        navigator.safeNavigate(-1);
    }

    const onSave = async () => {
        try {
            await form.validateFields();
        } catch {
            return;
        }

        try {
            await requestHandlerStore.requestWithBlockingUI(async () => await store.save());

            goBack();

            AppNotification.success('Заявка добавлена');
        } catch (e: any) {
            AppNotification.error(e.message)
        }
    }

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
                    >
                        Сохранить
                    </Button>
                    <Button
                        className="dp-button"
                        type="default"
                        onClick={goBack}
                    >
                        Назад
                    </Button>
                </Space>
            )}
        >
            <Row className="dp-row">
                <Typography.Title level={5}>Данные</Typography.Title>

                <Space direction="vertical" style={{width: "100%"}}>

                    <Form
                        form={form}
                        autoComplete="off"
                        layout="vertical"
                    >
                        <Form.Item
                            name="branchOffice"
                            label="Филиал для посещения занятий:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >

                            <Select
                                onChange={(value) => {
                                    const branchOfficeId = value;
                                    const index = store.branchOffices.findIndex(it => it.id === branchOfficeId);

                                    store.trialAttendance.branchOffice = store.branchOffices[index];
                                }}
                            >
                                {store.branchOffices.map((branchOffice) => {
                                    return (
                                        <Select.Option
                                            key={branchOffice.id}
                                            value={branchOffice.id}
                                        >
                                            {branchOffice.address}
                                        </Select.Option>
                                    )
                                })}
                            </Select>
                        </Form.Item>

                        <Form.Item
                            name="name"
                            label="Имя ребенка:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    store.trialAttendance.name = event.target.value
                                }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="phone"
                            label="Телефонный номер родителя:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator(), phoneValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    store.trialAttendance.phone = event.target.value
                                }}
                                placeholder={"+375 (29) 212-51-79"}
                            />
                        </Form.Item>

                        <Form.Item
                            name="diagnosis"
                            label="Диагноз:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    store.trialAttendance.diagnosis = event.target.value
                                }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="date"
                            label="Дата записи на пробное занятие:"
                            rules={[requiredWithTrimValidator()]}
                        >
                            <LocalDatePicker
                                placeholder={"Выберите дату пробного занятия"}
                                onChange={value => store.trialAttendance.date = value}
                            />
                        </Form.Item>
                    </Form>

                </Space>
            </Row>

        </PageBorder>
    );
};

export default TrialAttendanceEditPage;
