import {Button, Row, Select, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import {AttendancePageStore} from "app/logic/attendance/AttendancePageStore";
import AttendanceTable from "app/logic/attendance/AttendanceTable";
import PageBorder from 'app/logic/border/PageBorder';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {branchOfficeItemStore} from "../store/Catalog/BranchOfficeItemStore";
import MonthPicker from "../../components/MonthPicker/MonthPicker";
import {useDirtyChecker} from "../dirtyCheck/DirtyChecker";
import AppNotification from "../notification/AppNotification";
import {confirmPageLeave} from "../dirtyCheck/ConfirmPageLeave";

interface Props {
}

const AttendancePage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState(false);
    const store: AttendancePageStore = useLocalObservable(() => new AttendancePageStore());
    const dirtyChecker = useDirtyChecker();

    const registerAttendancesInDirtyChecker = (): void => {
        dirtyChecker.deleteLast();

        dirtyChecker.register(() => ({
            currencyReturns: store.editStore.toJson(),
            branchOffice: store.branchOffice,
            period: store.period
        }));
    };

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
                registerAttendancesInDirtyChecker();
            });
        })();
    }, []);

    const onSave = async () => {
        await requestHandlerStore.requestWithBlockingUI(async () => {
            await store.save();

            dirtyChecker.commit();

            AppNotification.success('Изменения сохранены');
        })
    };

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
                </Space>
            )}
        >

            <Row className="dp-row">
                <Space direction={"vertical"}>

                    <Typography.Text>Фильтр</Typography.Text>

                    <Space direction={"horizontal"}>

                        {!store.isTrainer && (
                            <Space>
                                <Typography.Text>Филиал: </Typography.Text>

                                <Select
                                    value={store.branchOffice.id}
                                    onChange={async (value) => {
                                        if (!dirtyChecker.isDirty() || await confirmPageLeave()){
                                            const branchOffice = branchOfficeItemStore.getById(value);

                                            store.setBranchOffice(branchOffice);
                                            registerAttendancesInDirtyChecker();
                                        }

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
                            </Space>
                        )}

                        <Typography.Text>Период: </Typography.Text>

                        <MonthPicker
                            value={store.period}
                            onChange={store.setPeriod}
                            disabled={false}
                        />
                    </Space>
                </Space>
            </Row>

            <Row className="dp-row">

                <AttendanceTable
                    editStore={store.editStore}
                />

            </Row>

        </PageBorder>
    );
};

export default observer(AttendancePage);
