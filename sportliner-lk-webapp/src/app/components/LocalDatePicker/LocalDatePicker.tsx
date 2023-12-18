import {CloseCircleFilled} from '@ant-design/icons';
import {DatePicker} from 'antd';
import moment, {Moment} from 'moment';
import React, {useState} from 'react';

/**
 * Local date string in the format: YYYY-MM-DD.
 * TODO use LocalDate class instead
 */
type LocalDate = string;

const convertToLocalDate = (value?: Moment) => value != null ? moment(value).format('YYYY-MM-DD') : undefined;
const convertToMoment = (value?: LocalDate) => value != null ? moment(value) : undefined;

interface Props {
    value?: LocalDate;
    onChange: (value?: LocalDate) => void;
    placeholder?: string;
}

const LocalDatePicker: React.FC<Props> = (props: Props) => {

    const [value, setValue] = useState<Moment | undefined>(() => convertToMoment(props.value));

    const handleSelect = (value?: Moment): void => {
        props.onChange(convertToLocalDate(value));
        setValue(value);
    };

    return (
        <div className="dp-local-date-picker">
            <DatePicker
                style={{width: 200}}
                value={value}
                onSelect={handleSelect}
                allowClear
                placeholder={props.placeholder}
                clearIcon={
                    <CloseCircleFilled
                        style={{color: "#d9d9d9"}}
                        onClick={() => handleSelect()}
                    />
                }
            />

        </div>
    );
};

export default LocalDatePicker;
