import {Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {Task} from 'api';
import React from 'react';
import {formatTaskStatus} from "../edit/TaskEditPage";
import {isEventFromInteractiveChild} from "../../../utils/DomUtils";
import {isNothingSelectedOnPage} from "../../../utils/WindowUtils";
import {AppRoutes} from "../../../AppRoutes";
import {useNavigator} from "../../Navigator";

interface TaskTableProps {
    content: Task[];
    // handleOnCreateTrialAttendance: (trialAttendance: TrialAttendance) => Promise<void>;
}

const TaskListTable: React.FC<TaskTableProps> = (props: TaskTableProps) => {
    const navigator = useNavigator();

    const columns: ColumnsType<Task> = [
        {
            title: "Наименование задачи",
            key: "name",
            align: "center",
            width: '20vw',
            sorter: false,
            render: (_, record) => record.name
        },
        {
            title: "Описание",
            key: "description",
            align: "center",
            width: '50vw',
            sorter: false,
            render: (_, record) => record.description
        },
        {
            title: "Ответственный",
            key: "assignee",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => record.assignee.fullName
        },
        {
            title: "Репортер",
            key: "reporter",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => record.reporter.fullName
        },
        {
            title: "Статус",
            key: "status",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => formatTaskStatus(record.status)
        },
        // {
        //     title: 'Действие',
        //     key: 'action',
        //     align: 'center',
        //     width: '10vw',
        //     render: (_, record) => (
        //         <Space size="middle">
        //             <Button
        //                 className="dp-button"
        //                 type="link"
        //                 onClick={() =>
        //                     openAddTrialAttendanceModal(record, props.handleOnCreateTrialAttendance)
        //                 }
        //             >
        //                 Добавить пробное занятие
        //             </Button>
        //         </Space>
        //     ),
        // }
    ] as ColumnsType<Task>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={{
                    onChange: () => {
                    },
                    pageSize: 10,
                }}
                rowKey={(record) => record.id}
                onRow={(record) => ({
                    onClick: (e) => {
                        if (!isEventFromInteractiveChild(e) && isNothingSelectedOnPage()) {
                            navigator.safeNavigate(AppRoutes.taskEditPage.toUrl({taskId: record.id}))
                        }
                    },
                })}
            />
        </Space>
    );
};

export default TaskListTable;
