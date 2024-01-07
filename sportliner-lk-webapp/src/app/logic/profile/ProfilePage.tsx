import {requestHandlerStore} from 'app/App';
import LoadingBlock from 'app/components/LoadingBlock/LoadingBlock';
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
        >

            <ProfileDescriptionsPanel profile={profile}/>

            <ChildrenDescriptionsPanel children={profile.children}/>

        </PageBorder>
    );
};

export default observer(ProfilePage);
