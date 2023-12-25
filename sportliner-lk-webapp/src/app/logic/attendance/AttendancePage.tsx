import {Button, Form, Input, Row, Select, Space, Typography} from 'antd';
import {useForm} from 'antd/es/form/Form';
import {requestHandlerStore} from 'app/App';
import {AppRoutes} from 'app/AppRoutes';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import {AttendancePageStore} from "app/logic/attendance/AttendancePageStore";
import AttendanceTable from "app/logic/attendance/AttendanceTable";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from "app/logic/Navigator";
import {requiredWithTrimValidator} from 'app/logic/Validators';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {branchOfficeItemStore} from "../store/Catalog/BranchOfficeItemStore";
import MonthPicker from "../../components/MonthPicker/MonthPicker";

const PAGE_TITLE = "Посещаемость";

interface Props {
}

const AttendancePage: FC<Props> = (props: Props) => {
    const [form] = useForm();
    const [init, setInit] = useState(false);
    const store: AttendancePageStore = useLocalObservable(() => new AttendancePageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();

                setInit(true);
            });
        })();
    }, []);

    const onSave = async () => {
        await store.save();

        goBack()
    };

    const goBack = () => {
        navigator.safeNavigate(-1);
    }

    if (!init) {
        return (
            <PageBorder
                title={store.pageTitle}
                isLoading
            >
                <LoadingBlock/>
            </PageBorder>
        );
    }

    return (
        <PageBorder
            title={store.pageTitle}
            content={(
                <Space style={{float: 'right'}}>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={onSave}
                        style={{background: '#0f2d77'}}
                    >
                        Сохранить
                    </Button>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={goBack}
                        style={{background: '#0f2d77'}}
                    >
                        Назад
                    </Button>
                </Space>
            )}
        >
            {!store.isTrainer && (
                <Row className="dp-row">
                    <Space direction={"vertical"}>

                        <Typography.Text>Фильтр</Typography.Text>

                        <Space direction={"horizontal"}>

                            <Typography.Text>Филиал: </Typography.Text>

                            <Select
                                value={store.branchOffice.id}
                                onChange={(value) => {
                                    const branchOfficeId = value;
                                    const branchOffice = branchOfficeItemStore.getById(branchOfficeId);

                                    store.setBranchOffice(branchOffice);
                                }}
                                style={{width: 400}}
                            >
                                {branchOfficeItemStore.available.map((branchOffice) => {
                                    return (
                                        <Select.Option
                                            key={branchOffice.id}
                                            value={branchOffice.id}
                                        >
                                            {branchOffice.address}
                                        </Select.Option>
                                    )
                                })}
                            </Select>

                            <Typography.Text>Период: </Typography.Text>

                            <MonthPicker
                                value={store.period}
                                onChange={store.setPeriod}
                                disabled={false}
                            />
                        </Space>
                    </Space>
                </Row>
            )}

            <Row className="dp-row">

                <AttendanceTable
                    editStore={store.editStore}
                />

            </Row>

        </PageBorder>
    );
};

export default observer(AttendancePage);
