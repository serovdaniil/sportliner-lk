import {Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {Attendance} from 'api';
import React from 'react';
import {observer} from "mobx-react";

interface AttendanceTableProps {
    content: Attendance[];
}

const ChildAttendancesTable: React.FC<AttendanceTableProps> = (props: AttendanceTableProps) => {
    const columns: ColumnsType<Attendance> = [
        {
            title: "Дата",
            key: "date",
            align: "center",
            sorter: false,
            width: "50vw",
            render: (_, record) => record.date
        },
        {
            title: "Время занятия",
            key: "time",
            align: "center",
            sorter: false,
            width: "50vw",
            render: (_, record) => record.time.slice(0, 5)
        }
    ] as ColumnsType<Attendance>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={{
                    pageSize: 10
                }}
                rowKey={(record, index) => index!}
            />
        </Space>
    );
};

export default observer(ChildAttendancesTable);
