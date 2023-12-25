import {DoubleLeftOutlined, DoubleRightOutlined} from '@ant-design/icons';
import {Button, DatePicker} from 'antd';
import moment, {Moment} from 'moment';
import React from 'react';
import DateUtils from "../../utils/DateUtils";

/**
 * Year-month string in the format: YYYY-MM.
 * TODO use YearMonth class instead
 */
type YearMonth = string;

const DEFAULT_MIN_PERIOD = "1900-01";

const DEFAULT_MAX_PERIOD = "2100-12";

const convertToMoment = (value?: YearMonth) => value != null ? moment(value) : undefined;
const convertToYearMonth = (value: Moment) => moment(value).format('YYYY-MM');

const plusMonths = (value: YearMonth, delta: number): YearMonth => DateUtils.addMonths(value, delta);

interface MonthPickerProps {
    value?: YearMonth;
    minValue?: YearMonth;
    maxValue?: YearMonth;
    onChange: (value: YearMonth) => void;
    disabled?: boolean;
}

const MonthPicker: React.FC<MonthPickerProps> = (props: MonthPickerProps) => {

    const isWithinAllowedRange = (value: YearMonth) => {
        const min = props.minValue;
        const max = props.maxValue;

        return (min == null || min <= value) && (max == null || value <= max);
    };

    const updateValue = (value: YearMonth): void => {
        props.onChange(value);
    }

    const shiftBy = (delta: number): void => {
        if (props.value == null) {
            return;
        }
        updateValue(plusMonths(props.value, delta));
    }

    const canShiftBy = (delta: number): boolean => {
        if (props.value == null) {
            return false;
        }
        return isWithinAllowedRange(plusMonths(props.value, delta));
    }

    return (
        <div className="dp-month-picker">

            <Button
                type="text"
                icon={<DoubleLeftOutlined/>}
               // disabled={!canShiftBy(-1) || props.disabled}
                onClick={() => shiftBy(-1)}
            />

            <DatePicker
                picker="month"
                allowClear={false}
                defaultPickerValue={convertToMoment(props.value)}
                value={convertToMoment(props.value)}
                disabledDate={(value: Moment) => !isWithinAllowedRange(convertToYearMonth(value))}
                onSelect={(value: Moment) => updateValue(convertToYearMonth(value))}
                format={(value: Moment) => value.format('MMMM YYYY')}
                disabled={props.disabled}
                inputReadOnly
            />

            <Button
                type="text"
                icon={<DoubleRightOutlined/>}
                disabled={!canShiftBy(1) || props.disabled}
                onClick={() => shiftBy(1)}
            />

        </div>
    );
};

MonthPicker.defaultProps = {
    minValue: DEFAULT_MIN_PERIOD,
    maxValue: DEFAULT_MAX_PERIOD
} as MonthPickerProps;

export default MonthPicker;
