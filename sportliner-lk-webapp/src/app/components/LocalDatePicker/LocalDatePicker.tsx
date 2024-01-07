import {CloseCircleFilled} from '@ant-design/icons';
import {ConfigProvider, DatePicker} from 'antd';
import moment, {Moment} from 'moment';
import React, {useState} from 'react';
import locale from 'antd/es/date-picker/locale/ru_RU';
import localeProvider from 'antd/lib/locale/zh_CN';

import 'dayjs/locale/ru';

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
    moment.updateLocale("ru", {
        monthsShort: ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"],
        weekdaysMin: ["Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"]
    });

    const [value, setValue] = useState<Moment | undefined>(() => convertToMoment(props.value));

    const handleSelect = (value?: Moment): void => {
        props.onChange(convertToLocalDate(value));
        setValue(value);
    };

    return (
        <div className="dp-local-date-picker">
            <ConfigProvider locale={localeProvider}>
                <DatePicker
                    style={{width: '10vw'}}
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
                    locale={locale}
                />
            </ConfigProvider>
        </div>
    );
};

export default LocalDatePicker;
