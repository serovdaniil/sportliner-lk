import {Column, ColumnConfig} from '@ant-design/plots';
import {observer} from 'mobx-react';
import React, {FC} from 'react';

interface ColumnItem {
    name: string;
    value: number;
}

interface Props {
    items: ColumnItem[];
}

const ColumnChart: FC<Props> = (props) => {
    if (props.items.length == 0) {
        return null;
    }

    const config: ColumnConfig = {
        data: props.items,
        xField: 'name',
        yField: 'value',
        height: 500,
        width: 500,
        label: {
            position: 'middle',
            style: {
                fill: '#ffffff',
                opacity: 0.6,
            },
        },
        xAxis: {
            label: {
                autoHide: true,
                autoRotate: false,
            },
        },
        meta: {
            name: {
                alias: 'Время занятия',
            },
            value: {
                alias: 'Количество человек на занятие',
            },
        },
    };

    return (
        <Column {...config} />
    );
};

export default observer(ColumnChart);
