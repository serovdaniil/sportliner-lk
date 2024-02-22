import {Button, Row, Space} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import TaskListTable from "./TaskListTable";
import {TaskListPageStore} from "./TaskListPageStore";
import {usePolling} from "../../../utils/Polling";
import {AppRoutes} from "../../../AppRoutes";
import {useNavigator} from "../../Navigator";

const PAGE_TITLE = "Список задач";

const TaskListPage: FC = () => {
    const [init, setInit] = useState(false);
    const navigator = useNavigator();
    const store: TaskListPageStore = useLocalObservable(() => new TaskListPageStore());

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
            });
        })();
    }, []);

    const createNewTask = () => {
        navigator.safeNavigate(AppRoutes.taskCreatePage.toUrl());
    };


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
                    <Button className="dp-button" type="primary" onClick={createNewTask}>Создать новую задачу</Button>
                </Space>
            )}
        >
            <Row className="dp-row">
                <TaskListTable
                    content={store.tasks}
                    // handleOnCreateTrialAttendance={async (trialAttendance) => await store.createTrialAttendance(trialAttendance)}
                />
            </Row>
        </PageBorder>
    );
};

export default observer(TaskListPage);
