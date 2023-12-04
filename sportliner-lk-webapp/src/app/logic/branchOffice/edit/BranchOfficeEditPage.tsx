import {Button, Collapse, Form, Input, Row, Space, Typography} from 'antd';
import {useForm} from 'antd/es/form/Form';
import {requestHandlerStore} from 'app/App';
import {AppRoutes} from 'app/AppRoutes';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from "app/logic/Navigator";
import {requiredWithTrimValidator} from 'app/logic/Validators';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {BranchOfficeEditPageStore} from "./BranchOfficeEditPageStore";
import {BranchOfficeAddress, DayOfWeek, UserAccountItem} from "../../../../api";
import ClassScheduleTable from "./ClassScheduleTable";
import {openAddClassScheduleModal} from "./AddClassScheduleModal";

const PAGE_TITLE = "Редактирование филиала";

const {Panel} = Collapse;

export const formatDayOfWeek = (day: DayOfWeek): string => {
    switch (day) {
        case DayOfWeek.MONDAY:
            return "Понедельник";
        case DayOfWeek.TUESDAY:
            return "Вторник";
        case DayOfWeek.WEDNESDAY:
            return "Среда";
        case DayOfWeek.THURSDAY:
            return "Четверг";
        case DayOfWeek.FRIDAY:
            return "Пятнциа";
        case DayOfWeek.SATURDAY:
            return "Суббота";
        case DayOfWeek.SUNDAY:
            return "Воскресенье";
        default:
            throw new Error("Unexpected day: " + day);
    }
};

interface Props {
    branchOfficeId?: string;
}

const BranchOfficeEditPage: FC<Props> = (props: Props) => {
    const [form] = useForm();
    const [init, setInit] = useState(false);
    const store: BranchOfficeEditPageStore = useLocalObservable(() => new BranchOfficeEditPageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init(props.branchOfficeId);

                setInit(true);
            });
        })();
    }, []);

    const onSave = async () => {
        try {
            await form.validateFields();
        } catch {
            return;
        }

        const address: BranchOfficeAddress = {
            city: form.getFieldsValue().city,
            street: form.getFieldsValue().street,
            buildingNumber: form.getFieldsValue().buildingNumber
        }


        await requestHandlerStore.requestWithBlockingUI(async () => {
            await store.save({
                ...store.branchOffice!,
                name: form.getFieldsValue().name,
                address: address
            });
        });

        goBack()
    };

    const goBack = () => {
        navigator.safeNavigate(AppRoutes.branchOfficeListPage.toUrl());
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
                    name: store.branchOffice?.name,
                    city: store.branchOffice?.address.city,
                    street: store.branchOffice?.address.street,
                    buildingNumber: store.branchOffice?.address.buildingNumber
                }}
                autoComplete="off"
            >
                <Row className="dp-row">

                    <Space direction={'vertical'}>

                        <Typography>Данные о филиале</Typography>

                        <Form.Item
                            name="name"
                            label="Наименование филиала:"
                            style={{marginBottom: 0, width: '100%'}}
                            rules={[requiredWithTrimValidator()]}
                        >
                            <Input/>
                        </Form.Item>

                    </Space>

                </Row>

                <Row className="dp-row">
                    <Space direction={'vertical'}>

                        <Typography>Адрес</Typography>

                        <Space direction={"horizontal"}>
                            <Form.Item
                                name="city"
                                label="Город:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input/>
                            </Form.Item>
                            <Form.Item
                                name="street"
                                label="Улица:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input/>
                            </Form.Item>
                            <Form.Item
                                name="buildingNumber"
                                label="Номер дома:"
                                style={{marginBottom: 0, width: '100%'}}
                                rules={[requiredWithTrimValidator()]}
                            >
                                <Input/>
                            </Form.Item>

                        </Space>
                    </Space>

                </Row>

                <Row className="dp-row">

                    <Space direction={'vertical'} style={{width: "100%"}}>
                        <Space direction={"horizontal"}>
                            <Typography>Расписание</Typography>

                            <Button
                                className="dp-button"
                                type="link"
                                onClick={() =>
                                    openAddClassScheduleModal((day: DayOfWeek, time: string, trainer: UserAccountItem) => store.addClassSchedule(day, time, trainer))
                                }
                            >
                                Добавить занятие
                            </Button>
                        </Space>

                        <Collapse accordion style={{width: "100%"}}>
                            {Object.values(DayOfWeek).map((day) => {
                                return (
                                    <Panel
                                        header={formatDayOfWeek(day)}
                                        key={day}
                                    >
                                        <ClassScheduleTable
                                            content={store.getClassSchedulesByDay(day)}
                                            handleOnDelete={(index) => store.deleteClassSchedule(day, index)}
                                        />
                                    </Panel>
                                )
                            })}
                        </Collapse>
                    </Space>

                </Row>

            </Form>
        </PageBorder>
    );
};

export default observer(BranchOfficeEditPage);
