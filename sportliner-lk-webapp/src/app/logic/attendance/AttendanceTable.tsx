import {Checkbox, Space, Table, Typography} from 'antd';
import {ColumnsType, ColumnType} from 'antd/es/table';
import {ChildInfo} from 'api';
import {AttendanceEditStore} from "app/logic/attendance/AttendanceEditStore";
import AttendanceModel from "app/logic/attendance/AttendanceModel";
import {observer} from "mobx-react";
import React from 'react';

interface CellProps {
    model: AttendanceModel;
}

const AttendanceCell: React.FC<CellProps> = observer((props: CellProps) => {
    const model = props.model;

    return (
        <Checkbox
            checked={model.value}
            onChange={e => {
                model.setValue(e.target.checked);
            }}
        />
    );
});

interface ClassScheduleTableProps {
    editStore: AttendanceEditStore
}

const ClassScheduleListTable: React.FC<ClassScheduleTableProps> = (props: ClassScheduleTableProps) => {
    const columns = (): ColumnsType<ChildInfo> => {
        const result: ColumnsType<ChildInfo> = Array.from(props.editStore.schedules.entries())
            .map(([date, times]) => {
                return {
                    title:
                        <Typography.Text
                            style={{writingMode: "vertical-rl"}}
                        >
                            {date}
                        </Typography.Text>,
                    key: date,
                    align: 'center',
                    children: times.map(it => {
                        return {
                            title:
                                <Typography.Text
                                    style={{writingMode: "vertical-rl"}}
                                >
                                    {it.slice(0, 5)}
                                </Typography.Text>,
                            key: date + " - " + it,
                            align: 'center',
                            width: 50,
                            render: (_, record) => {
                                return (
                                    <AttendanceCell model={props.editStore.getAttendanceModel(record.id, date, it)}/>
                                );
                            },
                        }
                    })
                }
            }) as ColumnsType<ChildInfo>;

        const first = {
            title: 'Имя ребенка',
            fixed: 'left',
            align: 'center',
            width: 250,
            render: (_: any, record: ChildInfo) => record.fullName,
        };

        result.unshift(first as ColumnType<ChildInfo>);

        return result;
    };

    return (
        <Space>
            <Table
                dataSource={props.editStore.children}
                columns={columns()}
                pagination={false}
                scroll={{y: 'calc(100vh - 350px)'}}
                rowKey={(record) => record.id}
                bordered
            />
        </Space>
    );
};

export default observer(ClassScheduleListTable);
