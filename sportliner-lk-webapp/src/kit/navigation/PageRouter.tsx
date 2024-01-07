import {PageMeta, PageRouteCollection} from "kit/navigation/PageMeta";
import {AuthState} from "kit/security/AuthState";
import React, {FC} from "react";
import {Navigate, Path, Route, Routes, useLocation, useParams} from "react-router-dom";

const redirectTo = (to: Path, fromPath?: Path) => {
    return <Navigate to={to} state={fromPath}/>;
};

const toPath = (page: PageMeta<void>): Path => {
    const relativeUrl = page.toUrl();

    /* split/extract path, query and hash */
    const match = relativeUrl.match(/([^?#]*)(\?[^#]*)?(#.*)?/);

    if (match == null) {
        throw new Error("Failed to split URL: " + relativeUrl);
    }

    return {pathname: match[1], search: match[2] ?? "", hash: match[3] ?? ""};
};

interface RouteElementProps {
    route: PageMeta<void>;
    authStateProvider: () => AuthState;
    authPage: PageMeta<void>;
    homePage: PageMeta<void>;
    renderForbidden: () => React.ReactElement;
}

const RouteElement: FC<RouteElementProps> = (props: RouteElementProps) => {
    const location = useLocation();
    const params = useParams();

    const authState = props.authStateProvider();
    const route = props.route;
    const authPage = props.authPage;
    const isAuthPage = route === authPage;

    // handle special case
    // if already authenticated => redirect from authPage to target or home page
    if (isAuthPage && authState.authenticated) {
        const targetPath = location.state?.fromPath ?? toPath(props.homePage);

        return redirectTo(targetPath);
    }

    // has all required authorities => render page
    if (authState.hasAuthorities(route.requiredAuthorities)) {
        return route.render({location, params});
    }

    // missing some required authorities & authenticated => access forbidden
    if (authState.authenticated) {
        return props.renderForbidden();
    }

    // otherwise, prompt to authenticate
    return redirectTo(toPath(props.authPage), location);
};

export interface PageRouterProps {
    authStateProvider: () => AuthState,
    routes: PageRouteCollection,
    renderNotFound: () => React.ReactElement,
    renderForbidden: () => React.ReactElement,
}

export const PageRouter: React.FC<PageRouterProps> = (props: PageRouterProps) => {
    const homePage = props.routes.homePage;

    const renderRoute = (route: PageMeta<any>) => {
        return (
            <Route
                key={route.path}
                path={route.path}
                element={(
                    <RouteElement
                        route={route}
                        authStateProvider={props.authStateProvider}
                        authPage={props.routes.authPage}
                        homePage={props.routes.profilePage}
                        renderForbidden={props.renderForbidden}
                    />
                )}
            />
        );
    };

    return (
        <Routes>

            {Object.keys(props.routes).map(it => (renderRoute(props.routes[it])))}

            <Route path="/" element={redirectTo(toPath(homePage))}/>

            <Route path="*" element={props.renderNotFound()}/>

        </Routes>
    );
};
