import {Button, Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {DayOfWeek, TrialAttendance, TrialAttendanceStatus} from 'api';
import {useNavigator} from 'app/logic/Navigator';
import React from 'react';

interface TrialAttendanceTableProps {
    content: TrialAttendance[];
    handleOnConfirm: (id: string) => Promise<void>;
    handleOnPaidTrialAttendance: (id: string) => Promise<void>;
}

const TrialAttendanceListTable: React.FC<TrialAttendanceTableProps> = (props: TrialAttendanceTableProps) => {
    const formatTrialAttendanceStatus = (status: TrialAttendanceStatus): string => {
        switch (status) {
            case TrialAttendanceStatus.ATTENDED:
                return "Занятие посещено";
            case TrialAttendanceStatus.PAID:
                return "Занятие оплачено";
            case TrialAttendanceStatus.UNPAID:
                return "Занятие не оплачено";
            default:
                throw new Error("Unexpected status: " + status);
        }
    };

    const columns: ColumnsType<TrialAttendance> = [
        {
            title: "Telegram username",
            key: "telegramUsername",
            align: "center",
            width: '10vw',
            sorter: false,
            render: (_, record) => record.telegramUsername
        },
        {
            title: "Филиал",
            key: "name",
            align: "center",
            width: '15vw',
            sorter: (a, b) => a.branchOffice.address.localeCompare(b.branchOffice.address),
            render: (_, record) => record.branchOffice.address
        },
        {
            title: "Имя ребенка",
            key: "name",
            align: "center",
            sorter: false,
            width: '10vw',
            render: (_, record) => record.name
        },
        {
            title: "Контактный телефон родителей",
            key: "phone",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => record.phone
        },
        {
            title: "Диагноз",
            key: "diagnosis",
            align: "left",
            sorter: false,
            width: '20vw',
            render: (_, record) => record.diagnosis
        },
        {
            title: "Дата",
            key: "date",
            align: "left",
            sorter: false,
            width: '10vw',
            render: (_, record) => record.date
        },
        {
            title: "Статус",
            key: "status",
            align: "left",
            sorter: (a, b) => a.status.localeCompare(b.status),
            width: '10vw',
            render: (_, record) => formatTrialAttendanceStatus(record.status)
        },
        {
            title: 'Действие',
            key: 'action',
            align: 'center',
            width: '10vw',
            render: (_, record) => (
                <Space size="middle">
                    {record.status === TrialAttendanceStatus.PAID && (
                        <Button
                            className="dp-button"
                            type="primary"
                            onClick={async () => await props.handleOnConfirm(record.id)}
                            style={{background: '#0f2d77'}}
                        >
                            Отметить посещение
                        </Button>
                    )}
                    {record.status === TrialAttendanceStatus.UNPAID && (
                        <Button
                            className="dp-button"
                            type="primary"
                            onClick={async () => await props.handleOnPaidTrialAttendance(record.id)}
                            style={{background: '#0f2d77'}}
                        >
                            Отметить оплату пробного занятия
                        </Button>
                    )}
                </Space>
            ),
        },
    ] as ColumnsType<TrialAttendance>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={{
                    onChange: (page) => {
                    },
                    pageSize: 10,
                }}
                rowKey={(record) => record.id}
            />
        </Space>
    );
};

export default TrialAttendanceListTable;
