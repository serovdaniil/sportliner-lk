import {Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {BranchOfficeListItem, DayOfWeek, UserAccountListItem, UserRole} from 'api';
import DeleteActionButton from 'app/components/DeleteActionButton/DeleteActionButton';
import {useNavigator} from 'app/logic/Navigator';
import {isEventFromInteractiveChild} from 'app/utils/DomUtils';
import {isNothingSelectedOnPage} from 'app/utils/WindowUtils';
import React from 'react';
import {AppRoutes} from "../../../AppRoutes";

interface UserTableProps {
    content: UserAccountListItem[];
    handleOnDelete: (id: string) => Promise<void>;
}

const UserListTable: React.FC<UserTableProps> = (props: UserTableProps) => {
    const navigator = useNavigator();

    const formatUserRole = (role: UserRole): string => {
        switch (role) {
            case UserRole.ADMIN:
                return "Администратор";
            case UserRole.PARENT:
                return "Родитель";
            case UserRole.TRAINER:
                return "Тренер";
            default:
                throw new Error("Unexpected role: " + role);
        }
    };

    const columns: ColumnsType<UserAccountListItem> = [
        {
            title: "ФИО",
            key: "fio",
            align: "left",
            width: 1000,
            sorter: (a, b) => a.fullName.localeCompare(b.fullName),
            render: (_, record) => record.fullName
        },
        {
            title: "Контактный телефон",
            key: "phone",
            align: "left",
            width: 1000,
            sorter: (a, b) => a.phone.localeCompare(b.phone),
            render: (_, record) => record.phone
        },
        {
            title: "Роль",
            key: "role",
            align: "left",
            sorter: false,
            width: 500,
            render: (_, record) => formatUserRole(record.role)
        },
        {
            title: 'Действие',
            key: 'action',
            align: 'center',
            width: 1000,
            render: (_, record) => (
                <Space size="middle">
                    <DeleteActionButton
                        target={record}
                        executeDelete={async (target) => await props.handleOnDelete(target.id)}
                    />
                </Space>
            ),
        },
    ] as ColumnsType<UserAccountListItem>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={{
                    onChange: (page) => {
                        console.log(page);
                    },
                    pageSize: 10,
                }}
                rowKey={(record) => record.id}
                onRow={(record) => ({
                    onClick: (e) => {
                        if (!isEventFromInteractiveChild(e) && isNothingSelectedOnPage()) {
                           navigator.safeNavigate(AppRoutes.userEditPage.toUrl({userAccountId: record.id}))
                        }
                    },
                })}
            />
        </Space>
    );
};

export default UserListTable;
