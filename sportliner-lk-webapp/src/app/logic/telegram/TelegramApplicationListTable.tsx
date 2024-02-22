import {Button, Space, Table, Typography} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {TelegramBotApplication, TrialAttendance} from 'api';
import React from 'react';
import DateUtils from "../../utils/DateUtils";
import {openAddTrialAttendanceModal} from "./CreateTrialAttendanceModal";

interface TelegramApplicationTableProps {
    content: TelegramBotApplication[];
    handleOnCreateTrialAttendance: (trialAttendance: TrialAttendance) => Promise<void>;
}

const TelegramApplicationListTable: React.FC<TelegramApplicationTableProps> = (props: TelegramApplicationTableProps) => {
    const columns: ColumnsType<TelegramBotApplication> = [
        {
            title: "Telegram username",
            key: "telegramUsername",
            align: "center",
            width: '20vw',
            sorter: false,
            render: (_, record) => record.telegramUsername
        },
        {
            title: "Филиал",
            key: "name",
            align: "center",
            width: '50vw',
            sorter: false,
            render: (_, record) => record.branchOffice?.address
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
            title: "Дата и время заявки",
            key: "date",
            align: "left",
            sorter: false,
            width: '15vw',
            render: (_, record) => 
                <Typography.Text>
                    {DateUtils.formatDateLocalWithTime(record.createTimestamp)}
                </Typography.Text>

        },
        {
            title: 'Действие',
            key: 'action',
            align: 'center',
            width: '10vw',
            render: (_, record) => (
                <Space size="middle">
                    <Button
                        className="dp-button"
                        type="link"
                        onClick={() =>
                            openAddTrialAttendanceModal(record, props.handleOnCreateTrialAttendance)
                        }
                    >
                        Добавить пробное занятие
                    </Button>
                </Space>
            ),
        }
    ] as ColumnsType<TelegramBotApplication>;

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
            />
        </Space>
    );
};

export default TelegramApplicationListTable;
