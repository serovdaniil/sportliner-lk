import {Button, Form, Input, Modal, Row, Select, Space} from "antd";
import {BranchOfficeItem, TelegramBotApplication, TrialAttendance, TrialAttendanceStatus} from "api";
import {phoneValidator, requiredWithTrimValidator} from "app/logic/Validators";
import {catalogApi} from "app/service/Apis";
import {observer} from "mobx-react";
import React, {FC} from "react";
import LocalDatePicker from "../../components/LocalDatePicker/LocalDatePicker";


export const openAddTrialAttendanceModal = async (telegramBotApplication: TelegramBotApplication,
                                                  handleOnCreateTrialAttendance: (trialAttendance: TrialAttendance) => Promise<void>) => {
    const availableBranchOffice = await catalogApi.getAvailableBranchOffices();

    const modal = Modal.info({
        title: "Добавить заявку на пробное занятие",
        closable: false,
        icon: null,
        okButtonProps: {
            hidden: true
        },
        style: {top: 20},
        width: '35vw',
        content: (
            <AddTrialAttendanceModal
                handleOnCreateTrialAttendance={handleOnCreateTrialAttendance}
                handleApply={() => modal.destroy()}
                handleCancel={() => modal.destroy()}
                telegramBotApplication={telegramBotApplication}
                availableBranchOffice={availableBranchOffice}
            />
        )
    });
};

interface Props {
    handleOnCreateTrialAttendance: (trialAttendance: TrialAttendance) => Promise<void>;
    handleApply: () => void;
    handleCancel?: () => void;
    telegramBotApplication: TelegramBotApplication
    availableBranchOffice: BranchOfficeItem[];
}

const AddTrialAttendanceModal: FC<Props> = observer((props: Props) => {
    const telegramBotApplication = props.telegramBotApplication;
    const [form] = Form.useForm();
    const trialAttendance: TrialAttendance = {
        id: "",
        telegramUsername: telegramBotApplication.telegramUsername,
        branchOffice: telegramBotApplication.branchOffice!,
        name: "",
        phone: telegramBotApplication.phone!,
        date: "",
        diagnosis: "",
        status: TrialAttendanceStatus.UNPAID
    }

    const handleApply = async () => {
        try {
            await form.validateFields();
        } catch {
            return;
        }

        await props.handleOnCreateTrialAttendance(trialAttendance);
        await props.handleApply();
    };

    const handleCancel = () => props.handleCancel && props.handleCancel();

    return (
        <Space style={{width: '100vw'}} direction="vertical" size={25}>
            <Space style={{width: '100vw'}} direction="vertical">
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
                        initialValue={telegramBotApplication.branchOffice?.id}
                    >
                        <Select
                            onChange={(value) => {
                                const branchOfficeId = value;
                                const index = props.availableBranchOffice.findIndex(it => it.id === branchOfficeId);

                                trialAttendance.branchOffice = props.availableBranchOffice[index];
                            }}
                        >
                            {props.availableBranchOffice.map((branchOffice) => {
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
                        name="telegramUsername"
                        label="Telegram username:"
                        style={{marginBottom: 0, width: '30vw'}}
                        initialValue={telegramBotApplication.telegramUsername}
                    >
                        <Input
                            onChange={event => {
                                trialAttendance.telegramUsername = event.target.value
                            }}
                        />
                    </Form.Item>

                    <Form.Item
                        name="name"
                        label="Имя ребенка:"
                        style={{marginBottom: 0, width: '30vw'}}
                        rules={[requiredWithTrimValidator()]}
                    >
                        <Input
                            onChange={event => {
                                trialAttendance.name = event.target.value
                            }}
                        />
                    </Form.Item>

                    <Form.Item
                        name="phone"
                        label="Телефонный номер родителя:"
                        style={{marginBottom: 0, width: '30vw'}}
                        rules={[requiredWithTrimValidator(), phoneValidator()]}
                        initialValue={telegramBotApplication.phone}
                    >
                        <Input
                            onChange={event => {
                                trialAttendance.phone = event.target.value
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
                                trialAttendance.diagnosis = event.target.value
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
                            onChange={value => trialAttendance.date = value!}
                        />
                    </Form.Item>
                </Form>

            </Space>

            <Row >
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
