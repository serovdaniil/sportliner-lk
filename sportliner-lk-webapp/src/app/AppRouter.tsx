import {Modal} from "antd";
import {AppRunner} from "app/AppRunner";
import {observer} from 'mobx-react';
import React, {ReactNode, useEffect} from "react";
import {BrowserRouter, useLocation} from "react-router-dom";

const DestroyModalsHelper: React.FC = () => {

    const location = useLocation();

    const destroyModals = () => {
        Modal.destroyAll();
    }

    useEffect(() => {
        // close all modals on page change
        return () => destroyModals();
    }, [location.pathname]);

    return null;
};

interface Props {
    children: ReactNode;
}

const AppRouter: React.FC<Props> = ({children}: Props) => {
    return (
        <BrowserRouter basename={AppRunner.baseContextPath}>

            <DestroyModalsHelper/>

            {children}

        </BrowserRouter>
    );
};

export default observer(AppRouter);
