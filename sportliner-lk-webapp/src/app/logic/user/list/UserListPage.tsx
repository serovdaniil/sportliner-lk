import {Button, Row, Space} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from 'app/logic/Navigator';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import UserListTable from "./UserListTable";
import {UserListPageStore} from "./UserListPageStore";
import {AppRoutes} from "../../../AppRoutes";

const PAGE_TITLE = "Список пользователей";

const UserListPage: FC = () => {
    const [init, setInit] = useState(false);
    const store: UserListPageStore = useLocalObservable(() => new UserListPageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
            });
        })();
    }, []);

    const createNewBranchOffice = () => {
        navigator.safeNavigate(AppRoutes.userCreatePage.toUrl());
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
                    <Button className="dp-button" type="primary" onClick={createNewBranchOffice}>Добавить нового пользователя</Button>
                </Space>
            )}
        >
            <Row className="dp-row">
                <UserListTable
                    content={store.users}
                    handleOnDelete={(id) => store.deleteBranchOffice(id)}
                />
            </Row>
        </PageBorder>
    );
};

export default observer(UserListPage);
