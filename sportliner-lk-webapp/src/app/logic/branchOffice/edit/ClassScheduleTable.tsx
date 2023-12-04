import {Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {ClassSchedule} from 'api';
import DeleteActionButton from 'app/components/DeleteActionButton/DeleteActionButton';
import React from 'react';
import {observer} from "mobx-react";

interface ClassScheduleTableProps {
    content: ClassSchedule[];
    handleOnDelete: (index: number) => void;
}

const ClassScheduleListTable: React.FC<ClassScheduleTableProps> = (props: ClassScheduleTableProps) => {
    const columns: ColumnsType<ClassSchedule> = [
        {
            title: "Время начала занятия",
            key: "time",
            align: "left",
            width: 1000,
            sorter: (a, b) => a.time.slice(0, 5).localeCompare(b.time.slice(0, 5)),
            render: (_, record) => record.time.slice(0, 5)
        },
        {
            title: "Тренер",
            key: "trainer",
            align: "left",
            sorter: false,
            width: 1000,
            render: (_, record) => record.trainer.fullName
        },
        {
            title: 'Действие',
            key: 'action',
            align: 'center',
            width: 300,
            render: (_, record, index) => (
                <Space size="middle">
                    <DeleteActionButton
                        target={index}
                        executeDelete={async (target) => {
                            await props.handleOnDelete(target)
                        }}
                    />
                </Space>
            ),
        },
    ] as ColumnsType<ClassSchedule>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={false}
                rowKey={(record, index) => index!}
            />
        </Space>
    );
};

export default observer(ClassScheduleListTable);
