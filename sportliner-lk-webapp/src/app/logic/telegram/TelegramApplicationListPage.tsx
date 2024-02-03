import {Row, Space} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import TelegramApplicationListTable from "./TelegramApplicationListTable";
import {TelegramApplicationListPageStore} from "./TelegramApplicationListPageStore";
import {usePolling} from "../../utils/Polling";

const PAGE_TITLE = "Список заявок из TelegramBot";

const TelegramApplicationListPage: FC = () => {
    const [init, setInit] = useState(false);
    const store: TelegramApplicationListPageStore = useLocalObservable(() => new TelegramApplicationListPageStore());

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
            });
        })();
    }, []);

    usePolling(async () => await store.init())

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
                </Space>
            )}
        >
            <Row className="dp-row">
                <TelegramApplicationListTable
                    content={store.telegramBotApplications}
                    handleOnCreateTrialAttendance={async (trialAttendance) => await store.createTrialAttendance(trialAttendance)}
                />
            </Row>
        </PageBorder>
    );
};

export default observer(TelegramApplicationListPage);
