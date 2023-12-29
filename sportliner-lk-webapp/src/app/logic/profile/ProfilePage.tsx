import {Button, Space} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from 'app/components/LoadingBlock/LoadingBlock';
import {useNavigator} from "app/logic/Navigator";
import ProfileDescriptionsPanel from 'app/logic/profile/ProfileDescriptionsPanel';
import {ProfilePageStore} from 'app/logic/profile/ProfilePageStore';

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import PageBorder from "../border/PageBorder";
import ChildrenDescriptionsPanel from "./ChildrenDescriptionsPanel";

const PAGE_TITLE = "Профиль";

const ProfilePage: FC = () => {
    const [init, setInit] = useState(false);
    const store = useLocalObservable(() => new ProfilePageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();
                setInit(true);
            });
        })();
    }, []);

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

    const profile = store.profile;

    return (
        <PageBorder
            title={PAGE_TITLE}
            content={(
                <Space style={{float: 'right'}}>
                    <Button
                        className="dp-button"
                        onClick={() => navigator.safeNavigate(-1)}
                    >
                        Назад
                    </Button>
                </Space>
            )}
        >

            <ProfileDescriptionsPanel profile={profile}/>

            <ChildrenDescriptionsPanel children={profile.children}/>

        </PageBorder>
    );
};

export default observer(ProfilePage);
