import {Button, Form, Modal, Row, Select, Space, TimePicker} from "antd";
import {DayOfWeek, UserAccountItem} from "api";
import {requiredWithTrimValidator, timeRequired} from "app/logic/Validators";
import {catalogApi} from "app/service/Apis";
import {observer} from "mobx-react";
import React, {FC} from "react";
import {formatDayOfWeek} from "./BranchOfficeEditPage";

export const openAddClassScheduleModal = async (onAddNewClassSchedule: (day: DayOfWeek, time: string, trainer: UserAccountItem) => void) => {
    const availableTrainers = await catalogApi.getTrainers();

    const modal = Modal.info({
        title: "Добавить занятие",
        closable: false,
        icon: null,
        okButtonProps: {
            hidden: true
        },
        style: {top: 20},
        width: 400,
        content: (
            <AddClassScheduleModal
                onAddNewClassSchedule={onAddNewClassSchedule}
                handleApply={() => modal.destroy()}
                handleCancel={() => modal.destroy()}
                availableTrainers={availableTrainers}
            />
        )
    });
};

interface Props {
    onAddNewClassSchedule: (day: DayOfWeek, time: string, trainer: UserAccountItem) => void
    handleApply: () => void;
    handleCancel?: () => void;
    availableTrainers: UserAccountItem[];
}

const AddClassScheduleModal: FC<Props> = observer((props: Props) => {
    const [form] = Form.useForm();

    const handleApply = async () => {
        try {
            await form.validateFields();
        } catch {
            return;
        }

        const trainerIndex = props.availableTrainers.findIndex(it => it.id === form.getFieldsValue().trainer);

        props.onAddNewClassSchedule(form.getFieldsValue().day, form.getFieldsValue().time.format('HH:mm'), props.availableTrainers[trainerIndex]);

        props.handleApply();
    };

    const handleCancel = () => props.handleCancel && props.handleCancel();

    return (
        <Space style={{width: "100%"}} direction="vertical" size={25}>
            <Space style={{width: "100%"}} direction="vertical">
                <Form
                    form={form}
                    autoComplete="off"
                    layout="vertical"
                    style={{width: "335px"}}
                >
                    <Form.Item
                        name="day"
                        label="День недели:"
                        rules={[requiredWithTrimValidator()]}
                    >
                        <Select>
                            <Select.Option value=""> </Select.Option>
                            {Object.values(DayOfWeek).map((day) => {
                                return (
                                    <Select.Option
                                        key={day}
                                        value={day}
                                    >
                                        {formatDayOfWeek(day)}
                                    </Select.Option>
                                )
                            })}
                        </Select>
                    </Form.Item>

                    <Form.Item
                        name="trainer"
                        label="Тренер:"
                        rules={[requiredWithTrimValidator()]}
                    >

                        <Select>
                            <Select.Option value=""> </Select.Option>
                            {props.availableTrainers.map((trainer) => {
                                return (
                                    <Select.Option
                                        key={trainer.id}
                                        value={trainer.id}
                                    >
                                        {trainer.fullName}
                                    </Select.Option>
                                )
                            })}
                        </Select>
                    </Form.Item>

                    <Form.Item
                        name="time"
                        label="Время начала занятия:"
                        rules={[timeRequired()]}
                    >
                        <TimePicker
                            style={{width: 335}}
                            format={'HH:mm'}
                            placeholder={'Выберите время'}
                            showNow={false}
                            minuteStep={15}
                        />
                    </Form.Item>
                </Form>
            </Space>

            <Row justify="end">
                <Space>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={handleApply}
                    >
                        Добавить
                    </Button>
                    <Button
                        className="dp-button"
                        type="default"
                        onClick={handleCancel}
                    >
                        Назад
                    </Button>
                </Space>
            </Row>
        </Space>
    );
});
