import {Button, Form, Input, Row, Select, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from 'app/components/LoadingBlock/LoadingBlock';
import {useNavigator} from "app/logic/Navigator";
import AppNotification from 'app/logic/notification/AppNotification';
import React, {FC, useEffect, useState} from 'react';
import TaskEditPageStore from "./TaskEditPageStore";


import {TaskStatus} from "../../../../api";
import PageBorder from "../../border/PageBorder";
import {requiredWithTrimValidator} from "../../Validators";
import TextArea from "antd/es/input/TextArea";

const PAGE_TITLE: string = "Создание задачи";

interface Props {
    id?: string;
}

export const formatTaskStatus = (status: TaskStatus): string => {
    switch (status) {
        case TaskStatus.OPEN:
            return "Открыта";
        case TaskStatus.IN_PROGRESS:
            return "В процессе";
        case TaskStatus.CLOSED:
            return "Закрыта";
        default:
            throw new Error("Unexpected status: " + status);
    }
};

const TaskEditPage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState<boolean>(false);
    const navigator = useNavigator();
    const [store] = useState<TaskEditPageStore>(() => new TaskEditPageStore(props.id));
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

            AppNotification.success('Задача сохранена');
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
                        initialValues={{
                            name: store.task.name,
                            description: store.task.description,
                            assignee: store.task.assignee?.id,
                            status: store.task.status
                        }}
                    >

                        <Form.Item
                            name="name"
                            label="Краткое наименование задачи:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <Input
                                onChange={event => {
                                    store.task.name = event.target.value
                                }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="description"
                            label="Описание задачи:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <TextArea
                                onChange={event => {
                                    store.task.description = event.target.value
                                }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="assignee"
                            label="Ответственный:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >

                            <Select
                                onChange={(value) => {
                                    const employeeId = value;
                                    const index = store.employees.findIndex(it => it.id === employeeId);

                                    store.task.assignee = store.employees[index];
                                }}
                            >
                                {store.employees.map((employee) => {
                                    return (
                                        <Select.Option
                                            key={employee.id}
                                            value={employee.id}
                                        >
                                            {employee.fullName}
                                        </Select.Option>
                                    )
                                })}
                            </Select>
                        </Form.Item>


                        <Form.Item
                            name="status"
                            label="Статус задачи:"
                            style={{marginBottom: 0, width: '30vw'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <Select
                                onChange={(value) => {
                                    store.task.status = value;
                                }}
                            >
                                {Object.values(TaskStatus).map((status) => {
                                    return (
                                        <Select.Option
                                            key={status}
                                            value={status}
                                        >
                                            {formatTaskStatus(status)}
                                        </Select.Option>
                                    )
                                })}
                            </Select>
                        </Form.Item>

                    </Form>

                </Space>
            </Row>

        </PageBorder>
    );
};

export default TaskEditPage;
