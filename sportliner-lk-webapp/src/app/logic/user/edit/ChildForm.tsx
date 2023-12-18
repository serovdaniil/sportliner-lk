import {Form, FormInstance, Input, Select, Space} from "antd";
import {observer} from "mobx-react";
import React, {FC} from "react";
import {ChildAttributes} from "./ChildAttributes";
import {maxValueValidator, minValueValidator, requiredWithTrimValidator} from "../../Validators";
import {BranchOfficeItem} from "../../../../api";
import LocalDatePicker from "../../../components/LocalDatePicker/LocalDatePicker";
import TextArea from "antd/es/input/TextArea";

interface Props {
    child: ChildAttributes;
    branchOffices: BranchOfficeItem[];
    form: FormInstance;
}

const ChildForm: FC<Props> = (props: Props) => {
    const child = props.child;

    return (
        <Space style={{width: "100%"}} direction="vertical" size={25}>
            <Form
                form={props.form}
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
                    numberClassesPerMonth: child.numberClassesPerMonth,
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

                <Form.Item
                    name="branchOffice"
                    label="Филиал для посещения занятий:"
                    rules={[requiredWithTrimValidator()]}
                >

                    <Select
                        onChange={(value) => {
                            const branchOfficeId = value;
                            const index = props.branchOffices.findIndex(it => it.id === branchOfficeId);

                            child.updateBranchOffice(props.branchOffices[index]);
                        }}
                    >
                        <Select.Option value=""> </Select.Option>
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
                    name="tuitionBalance"
                    label="Количество оплаченных занятий:"
                    rules={[requiredWithTrimValidator(), minValueValidator(0)]}
                    style={{width: 300}}
                >
                    <Input
                        onChange={event => child.updateTuitionBalance(Number(event.target.value))}
                    />
                </Form.Item>

                <Form.Item
                    name="numberClassesPerMonth"
                    label="Количество посещений в месяц:"
                    rules={[requiredWithTrimValidator(), maxValueValidator(31), minValueValidator(1)]}
                    style={{width: 300}}
                >
                    <Input
                        onChange={event => child.updateNumberClassesPerMonth(Number(event.target.value))}
                    />
                </Form.Item>

            </Form>
        </Space>
    );
};

export default observer(ChildForm);
