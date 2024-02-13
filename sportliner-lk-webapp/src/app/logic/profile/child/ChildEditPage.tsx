import {Button, Descriptions, Form, Row, Select, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from 'app/components/LoadingBlock/LoadingBlock';
import {useNavigator} from "app/logic/Navigator";
import AppNotification from 'app/logic/notification/AppNotification';
import React, {FC, useEffect, useState} from 'react';
import ChildEditPageStore from "./ChildEditPageStore";
import PageBorder from "../../border/PageBorder";
import DescriptionsItem from "antd/es/descriptions/Item";
import {requiredWithTrimValidator} from "../../Validators";
import TextArea from "antd/es/input/TextArea";
import ChildAttendancesTable from "./ChildAttendancesTable";
import {Tariff} from "../../../../api";

const PAGE_TITLE: string = "Данные о ребенке";

interface Props {
    childId: string;
}

const ChildEditPage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState<boolean>(false);
    const navigator = useNavigator();
    const [store] = useState<ChildEditPageStore>(() => new ChildEditPageStore(props.childId));
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

            AppNotification.success('Изменения сохранены');
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
                <Typography.Title level={5}>Персональные данные</Typography.Title>

                <Space direction="vertical" style={{width: "100%"}}>

                    <Descriptions size={"small"} layout={"vertical"} column={2} style={{width: 500}}>

                        <DescriptionsItem
                            label="Имя">{store.child.fullName}</DescriptionsItem>

                        <DescriptionsItem label="Дата рождения">{store.child.birthdate}</DescriptionsItem>

                        <DescriptionsItem
                            label="Остаток оплаченных занятий">{store.child.tuitionBalance}</DescriptionsItem>

                    </Descriptions>

                    <Form
                        form={form}
                        autoComplete="off"
                        layout="vertical"
                        initialValues={{
                            diagnosis: store.child.diagnosis,
                            notes: store.child.notes,
                            tariff: store.child.tariff
                        }}
                    >
                        <Form.Item
                            name="diagnosis"
                            label="Диагноз:"
                            rules={[requiredWithTrimValidator()]}
                            style={{width: 408}}
                        >
                            <TextArea
                                onBlur={(event) => {
                                    store.child.diagnosis = event.currentTarget.value;
                                }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="notes"
                            label="Пометки:"
                            style={{width: 408}}
                        >
                            <TextArea
                                onBlur={(event) => {
                                    store.child.notes = event.currentTarget.value;
                                }}
                            />
                        </Form.Item>
                        <Form.Item
                            name="tariff"
                            label="Количество посещений в неделю:"
                            rules={[requiredWithTrimValidator()]}
                            style={{width: 300}}
                        >
                            <Select
                                onChange={(value) => {
                                    store.child.tariff = value
                                }}>
                                <Select.Option value={Tariff.UNLIM}>Безлимитный абонемент</Select.Option>
                                <Select.Option value={Tariff.ONE_LESSON_PER_WEEK}>Одно занятие в неделю</Select.Option>
                                <Select.Option value={Tariff.TWO_LESSONS_PER_WEEK}>Два занятия в неделю</Select.Option>
                                <Select.Option value={Tariff.THREE_LESSONS_PER_WEEK}>Три занятия в неделю</Select.Option>
                            </Select>
                        </Form.Item>
                    </Form>

                </Space>
            </Row>

            <Row className="dp-row">
                <Space direction={"vertical"} style={{width: "100vw"}}>
                    <Typography.Title level={5}>Посещения занятий</Typography.Title>

                    <ChildAttendancesTable content={store.attendances}/>
                </Space>
            </Row>
        </PageBorder>
    );
};

export default ChildEditPage;
