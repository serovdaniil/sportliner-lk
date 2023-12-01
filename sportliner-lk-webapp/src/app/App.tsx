import 'antd/dist/antd.css';
import 'app/App.css';
import {AppRoutes} from 'app/AppRoutes';
import {AppRunner} from 'app/AppRunner';
import NotFoundErrorPage from 'app/logic/error/NotFoundErrorPage';
import SomethingWentWrongPage from 'app/logic/error/SomethingWentWrongPage';
import AuthStore from 'app/logic/store/AuthStore';
import RequestHandlerStore from 'app/logic/store/RequestHandlerStore';
import SessionStorageWorker from 'app/logic/store/SessionStorageWorker';
import {PageRouter} from 'kit/navigation/PageRouter';
import {observer} from 'mobx-react';
import 'normalize.css';
import 'nprogress/nprogress.css';
import {useEffect, useState} from 'react';
import ForbiddenErrorPage from "./logic/error/ForbiddenErrorPage";

export const requestHandlerStore = new RequestHandlerStore();
export const auth = new AuthStore();
export const sessionStorageWorker = new SessionStorageWorker();

const renderErrorOverlay = (is404: boolean, isSomethingWentWrong: boolean) => {

    // handle case with unavailable dynamic routes
    if (is404) {
        return <NotFoundErrorPage onBackHome={() => requestHandlerStore.resetErrors()}/>;
    }
    if (isSomethingWentWrong) {
        return <SomethingWentWrongPage onButton={() => requestHandlerStore.resetErrors()}/>;
    }
    return null;
};

/**
 * Root component
 */
const App: React.FC = () => {

    const [fullyInit, setFullyInit] = useState<boolean | null>(null);
    const loading = auth.initializing || (auth.authState.authenticated && !fullyInit);

    useEffect(() => {
        const removeErrorListeners = requestHandlerStore.setUnhandledErrorsProcessing();

        auth.setOnClear(() => {
            sessionStorageWorker.clear();
            AppRunner.reset();
        });

        return () => {
            removeErrorListeners();
        };
    }, []);

    useEffect(() => {
        (async () => {
            if (!auth.authState.authenticated) {
                return;
            }
            setFullyInit(true);
        })();
    }, [auth.authState.authenticated]);

    if (loading) {
        return <div/>;
    }

    return (
        <div className="App">
            {renderErrorOverlay(requestHandlerStore.is404, requestHandlerStore.isSomethingWentWrong)
                ?? (
                    <PageRouter
                        authStateProvider={() => auth.authState}
                        routes={AppRoutes}
                        renderNotFound={() => <NotFoundErrorPage/>}
                        renderForbidden={() => <ForbiddenErrorPage/>}
                    />
                )}
        </div>
    );
};

export default observer(App);
