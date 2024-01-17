import {Button, Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {BranchOfficeListItem, TrialAttendance, TrialAttendanceStatus} from 'api';
import DeleteActionButton from 'app/components/DeleteActionButton/DeleteActionButton';
import {useNavigator} from 'app/logic/Navigator';
import {isEventFromInteractiveChild} from 'app/utils/DomUtils';
import {isNothingSelectedOnPage} from 'app/utils/WindowUtils';
import React from 'react';
import {AppRoutes} from "../../../../AppRoutes";

interface TrialAttendanceTableProps {
    content: TrialAttendance[];
    handleOnConfirm: (id: string) => Promise<void>;
}

const TrialAttendanceListTable: React.FC<TrialAttendanceTableProps> = (props: TrialAttendanceTableProps) => {
    const navigator = useNavigator();

    const columns: ColumnsType<TrialAttendance> = [
        {
            title: "Филиал",
            key: "name",
            align: "left",
            width: '15vw',
            sorter: (a, b) => a.branchOffice.address.localeCompare(b.branchOffice.address),
            render: (_, record) => record.branchOffice.address
        },
        {
            title: "Имя ребенка",
            key: "name",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => record.name
        },
        {
            title: "Контактный телефон родителей",
            key: "phone",
            align: "left",
            sorter: false,
            width: '10vw',
            render: (_, record) => record.phone
        },
        {
            title: "Диагноз",
            key: "diagnosis",
            align: "left",
            sorter: false,
            width: '30vw',
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
            render: (_, record) => record.status === "ATTENDED" ? 'Занятие посещено' : 'Занятие не посещено'
        },
        {
            title: 'Действие',
            key: 'action',
            align: 'center',
            width: '10vw',
            render: (_, record) => (
                <Space size="middle">
                    {record.status === TrialAttendanceStatus.UNATTENDED && (
                        <Button
                            className="dp-button"
                            type="primary"
                            onClick={async () => await props.handleOnConfirm(record.id)}
                            style={{background: '#0f2d77'}}
                        >
                            Отметить посещение
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
