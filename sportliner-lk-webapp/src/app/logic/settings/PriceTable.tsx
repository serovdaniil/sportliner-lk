import {InputNumber, Space, Table} from 'antd';
import {ColumnsType} from 'antd/es/table';
import {PriceItem, PriceItemType} from 'api';
import React from 'react';
import {observer} from "mobx-react";

interface PriceTableProps {
    content: PriceItem[];
    onUpdatePrice: (type: PriceItemType, value: number, benefits: boolean) => void;
}

const PriceTable: React.FC<PriceTableProps> = (props: PriceTableProps) => {
    const formatType = (type: PriceItemType): string => {
        switch (type) {
            case PriceItemType.ONE_LESSON:
                return "1";
            case PriceItemType.TWO_LESSONS:
                return "2";
            case PriceItemType.THREE_LESSONS:
                return "3";
            case PriceItemType.FOUR_LESSONS:
                return "4";
            case PriceItemType.FIVE_LESSONS:
                return "5";
            case PriceItemType.SIX_LESSONS:
                return "6";
            case PriceItemType.SEVEN_LESSONS:
                return "7";
            case PriceItemType.EIGHT_LESSONS:
                return "8";
            case PriceItemType.NINE_LESSONS:
                return "9";
            case PriceItemType.TEN_LESSONS:
                return "10";
            case PriceItemType.ELEVEN_LESSONS:
                return "11";
            case PriceItemType.TWELVE_LESSONS:
                return "12";
            case PriceItemType.UNLIM:
                return "Безлимитный";
            default:
                throw new Error("Unexpected type: " + type);
        }
    };

    const columns: ColumnsType<PriceItem> = [
        {
            title: "Количество занятий",
            key: "type",
            align: "center",
            width: '5vw',
            sorter: false,
            render: (_, record) => formatType(record.type)
        },
        {
            title: "Стоимость занятий",
            key: "normalPrice",
            align: "center",
            width: '15vw',
            sorter: false,
            render: (_, record) =>
                <InputNumber
                    defaultValue={record.normalPrice}
                    onChange={value => props.onUpdatePrice(record.type, value, false)}
                />
        },
        {
            title: "Стоимость занятий для отдельных категорий граждан",
            key: "prevPrice",
            align: "center",
            sorter: false,
            width: '15vw',
            render: (_, record) =>
                <InputNumber
                    defaultValue={record.benefitsPrice}
                    onChange={value => props.onUpdatePrice(record.type, value, true)}
                />
        }
    ] as ColumnsType<PriceItem>;

    return (
        <Space>
            <Table
                dataSource={props.content}
                columns={columns}
                className="dp-compressed-table"
                pagination={false}
                rowKey={(record) => record.type}
            />
        </Space>
    );
};

export default observer(PriceTable);
