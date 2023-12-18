import {Button, Form, Input, Select, Space} from 'antd';
import {UserRole} from 'api';
import {observer} from 'mobx-react';
import {FC, useEffect} from 'react';
import {useDebouncedCallback} from 'use-debounce';
import UserAccountCriteriaModel from "./UserAccountCriteriaModel";
import delay from "../../../model/Delay";

export const formatUserRole = (role: UserRole): string => {
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

interface Props {
    model: UserAccountCriteriaModel;
}

const UserAccountCriteriaBlock: FC<Props> = (props: Props) => {
    const model = props.model;

    const [form] = Form.useForm();
    useEffect(() => {
        form.setFieldsValue(model.value);
    }, [model.value]);

    const search = async () => {
        model.setValue(form.getFieldsValue());
    };

    const deferredSearch = useDebouncedCallback(search, delay.FILTER);

    const resetFilter = () => {
        form.resetFields();
        model.setValue({});
    };

    return (

        <Form
            form={form}
            className="dp-form"
            layout="vertical"
            autoComplete="off"
        >
            <Space align="start">
                <Form.Item
                    name="lastName"
                    label="Фамилия:"
                >
                    <Input onChange={deferredSearch} maxLength={50}/>
                </Form.Item>


                <Form.Item name="role" label="Роль:" style={{width: 200}}>
                    <Select
                        onChange={search}
                        options={[
                            {label: "", value: ""},
                            ...Object.values(UserRole).map(it => ({
                                label: formatUserRole(it),
                                value: it
                            }))
                        ]}
                    />
                </Form.Item>

                <Form.Item name="payAttention" label="Требуется ли обратить внимание:">
                    <Select onChange={search}>
                        <Select.Option value=""> </Select.Option>
                        <Select.Option value="true">Да</Select.Option>
                        <Select.Option value="false">Нет</Select.Option>
                    </Select>
                </Form.Item>

                {!model.isEmpty && (
                    <Space direction="vertical">
                        <Space> </Space>

                        <Button className="dp-button" type="link" onClick={resetFilter}>
                            Очистить
                        </Button>
                    </Space>
                )}
            </Space>

        </Form>

    );
};

export default observer(UserAccountCriteriaBlock);
