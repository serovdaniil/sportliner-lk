import {Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {BranchOfficeListItem} from 'api';
import DeleteActionButton from 'app/components/DeleteActionButton/DeleteActionButton';
import {useNavigator} from 'app/logic/Navigator';
import {isEventFromInteractiveChild} from 'app/utils/DomUtils';
import {isNothingSelectedOnPage} from 'app/utils/WindowUtils';
import React from 'react';
import {AppRoutes} from "../../../AppRoutes";

interface BranchOfficesTableProps {
    content: BranchOfficeListItem[];
    handleOnDelete: (id: string) => Promise<void>;
}

const BranchOfficeListTable: React.FC<BranchOfficesTableProps> = (props: BranchOfficesTableProps) => {
    const navigator = useNavigator();

    const columns: ColumnsType<BranchOfficeListItem> = [
        {
            title: "Наименование филиала",
            key: "name",
            align: "left",
            width: 1000,
            sorter: (a, b) => a.name.localeCompare(b.name),
            render: (_, record) => record.name
        },
        {
            title: "Адрес",
            key: "address",
            align: "left",
            sorter: false,
            width: 500,
            render: (_, record) => record.address
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
    ] as ColumnsType<BranchOfficeListItem>;

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
                            navigator.safeNavigate(AppRoutes.branchOfficeEditPage.toUrl({branchOfficeId: record.id}))
                        }
                    },
                })}
            />
        </Space>
    );
};

export default BranchOfficeListTable;
