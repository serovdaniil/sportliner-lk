import {Checkbox, Form, Input, Select, Space} from "antd";
import {observer} from "mobx-react";
import React, {FC} from "react";
import {ChildAttributes} from "./ChildAttributes";
import {minValueValidator, requiredWithTrimValidator} from "../../Validators";
import {BranchOfficeItem, PayingEntity, PaymentType, Tariff} from "../../../../api";
import LocalDatePicker from "../../../components/LocalDatePicker/LocalDatePicker";
import TextArea from "antd/es/input/TextArea";
import {useForm} from "antd/es/form/Form";

interface Props {
    child: ChildAttributes;
    branchOffices: BranchOfficeItem[];
}

const ChildForm: FC<Props> = (props: Props) => {
    const [form] = useForm();
    const child = props.child;

    return (
        <Space style={{width: "100%"}} direction="vertical" size={25}>
            <Form
                form={form}
                autoComplete="off"
                layout="vertical"
                style={{width: "335px"}}
                initialValues={{
                    lastName: child.lastName,
                    firstName: child.firstName,
                    patronymic: child.patronymic,
                    birthdate: child.birthdate,
                    diagnosis: child.diagnosis,
                    notes: child.notes,
                    branchOffice: child.branchOffice?.id,
                    tuitionBalance: child.tuitionBalance,
                    tariff: child.tariff,
                    paymentType: child.paymentType,
                    benefits: child.benefits,
                    invoiceNumber: child.invoiceNumber,
                    payingEntity: child.payingEntity
                }}
            >
                <Space direction={"horizontal"}>
                    <Form.Item
                        name="lastName"
                        label="Фамилия:"
                        rules={[requiredWithTrimValidator()]}
                        style={{width: 200}}
                    >
                        <Input
                            value={child.lastName}
                            onBlur={(event) => {
                                child.updateLastName(event.currentTarget.value);
                            }}
                        />
                    </Form.Item>

                    <Form.Item
                        name="firstName"
                        label="Имя:"
                        rules={[requiredWithTrimValidator()]}
                        style={{width: 200}}
                    >
                        <Input
                            onBlur={(event) => {
                                child.updateFirstName(event.currentTarget.value);
                            }}
                        />
                    </Form.Item>

                    <Form.Item
                        name="patronymic"
                        label="Отчество:"
                        rules={[requiredWithTrimValidator()]}
                        style={{width: 200}}
                    >
                        <Input
                            onBlur={(event) => {
                                child.updatePatronymic(event.currentTarget.value);
                            }}
                        />
                    </Form.Item>

                    <Form.Item
                        name="birthdate"
                        label="Дата рождения:"
                        rules={[requiredWithTrimValidator()]}
                        style={{width: 200}}
                    >
                        <LocalDatePicker
                            placeholder={"Выберите дату рождения"}
                            onChange={value => child.updateBirthdate(value)}
                        />
                    </Form.Item>
                </Space>

                <Space direction={"horizontal"}>
                    <Form.Item
                        name="diagnosis"
                        label="Диагноз:"
                        rules={[requiredWithTrimValidator()]}
                        style={{width: 408}}
                    >
                        <TextArea
                            onBlur={(event) => {
                                child.updateDiagnosis(event.currentTarget.value);
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
                                child.updateNotes(event.currentTarget.value);
                            }}
                        />
                    </Form.Item>
                </Space>

                <Space direction={"horizontal"}>
                    <Form.Item
                        name="branchOffice"
                        label="Филиал для посещения занятий:"
                        style={{width: 300}}
                        rules={[requiredWithTrimValidator()]}
                    >

                        <Select
                            onChange={(value) => {
                                const branchOfficeId = value;
                                const index = props.branchOffices.findIndex(it => it.id === branchOfficeId);

                                child.updateBranchOffice(props.branchOffices[index]);
                            }}
                        >
                            {props.branchOffices.map((branchOffice) => {
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
                        name="payingEntity"
                        label="Организация-получатель:"
                        style={{width: 300}}
                        rules={[requiredWithTrimValidator()]}
                    >
                        <Select
                            onChange={(value) => {
                                child.updatePayingEntity(value)
                            }}>
                            <Select.Option value={PayingEntity.MICHALENIA}>ИП Михаленя А.М.</Select.Option>
                            <Select.Option value={PayingEntity.SPORTLINER}>ООО "Спортлинер"</Select.Option>
                        </Select>
                    </Form.Item>

                    <Form.Item
                        name="invoiceNumber"
                        label="Номер счета в EPOS:"
                        style={{width: 200}}
                    >
                        <Input
                            onBlur={(event) => {
                                child.updateInvoiceNumber(event.currentTarget.value);
                            }}
                        />
                    </Form.Item>
                </Space>

                <Form.Item
                    name="tuitionBalance"
                    label="Количество оплаченных занятий:"
                    rules={[requiredWithTrimValidator(), minValueValidator(-15)]}
                    style={{width: 300}}
                >
                    <Input
                        onChange={event => child.updateTuitionBalance(Number(event.target.value))}
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
                            child.updateTariff(value)
                        }}>
                        <Select.Option value={Tariff.UNLIM}>Безлимитный абонемент</Select.Option>
                        <Select.Option value={Tariff.ONE_LESSON_PER_WEEK}>Одно занятие в неделю</Select.Option>
                        <Select.Option value={Tariff.TWO_LESSONS_PER_WEEK}>Два занятия в неделю</Select.Option>
                        <Select.Option value={Tariff.THREE_LESSONS_PER_WEEK}>Три занятия в неделю</Select.Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name="paymentType"
                    label="Тип оплаты:"
                    rules={[requiredWithTrimValidator()]}
                >
                    <Select
                        onChange={(value) => {
                            child.updatePaymentType(value)
                        }}>
                        <Select.Option value={PaymentType.PREPAYMENT}>Предоплата</Select.Option>
                        <Select.Option value={PaymentType.POST_PAYMENT}>Оплата по факту</Select.Option>
                        <Select.Option value={PaymentType.PER_LESSON}>День в день</Select.Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name="benefits"
                    label="Применять льготы:"
                >
                    <Checkbox
                        checked={child.benefits}
                        onChange={event => child.updateBenefits(event.target.checked)}
                    />
                </Form.Item>

            </Form>
        </Space>
    );
};

export default observer(ChildForm);
