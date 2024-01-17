import {Button, Row, Space} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from 'app/logic/Navigator';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import TrialAttendanceListTable from "./TrialAttendanceListTable";
import {TrialAttendanceListPageStore} from "./TrialAttendanceListPageStore";
import {AppRoutes} from "../../../../AppRoutes";

const PAGE_TITLE = "Список регистраций на пробное занятие";

const TrialAttendanceListPage: FC = () => {
    const [init, setInit] = useState(false);
    const store: TrialAttendanceListPageStore = useLocalObservable(() => new TrialAttendanceListPageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
            });
        })();
    }, []);

    const addNewTrialAttendance = () => {
        navigator.safeNavigate(AppRoutes.addTrialAttendances.toUrl());
    };

    if (!init) {
        return (
            <PageBorder
                title={PAGE_TITLE}
                isLoading
            >
                <LoadingBlock/>
            </PageBorder>
        );
    }

    return (
        <PageBorder
            title={PAGE_TITLE}
            content={(
                <Space style={{float: 'right'}}>
                    <Button className="dp-button" type="primary" onClick={addNewTrialAttendance}>Добавить новую
                        заявку</Button>
                </Space>
            )}
        >
            <Row className="dp-row">
                <TrialAttendanceListTable
                    content={store.trialAttendances}
                    handleOnConfirm={(id) => store.confirmTrialAttendance(id)}
                />
            </Row>
        </PageBorder>
    );
};

export default observer(TrialAttendanceListPage);
