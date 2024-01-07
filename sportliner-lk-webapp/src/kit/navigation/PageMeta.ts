import {Authority} from 'kit/security/AuthState';
import * as React from 'react';
import {generatePath, Location, Params} from 'react-router';

export type RouteComponentProps = {
    location: Location;
    params: Readonly<Params>;
};

export type RouteRenderer = (props: RouteComponentProps) => React.ReactElement;

export interface PageMetaConfig<PageObject extends unknown = void, PagePathTemplate extends string = string> {

    path: PagePathTemplate;

    render: RouteRenderer;

    renderParameters?: (value: PageObject) => Params;

    requiredAuthorities?: Authority | Authority[];

}

export type PageRouteCollection = {

    authPage: PageMeta<void>,

    homePage: PageMeta<void>,

    profilePage:PageMeta<void>

    [K: string]: PageMeta<any>

}

export class PageMeta<T extends unknown, PathTemplate extends string = string> {

    private readonly config: PageMetaConfig<T, PathTemplate>;

    constructor(config: PageMetaConfig<T, PathTemplate>) {
        this.config = config;
    }

    get path(): string {
        return this.config.path;
    }

    get requiredAuthorities(): Authority[] {
        const val = this.config.requiredAuthorities;
        if (val == null) {
            return [];
        }
        if (Array.isArray(val)) {
            return val;
        }
        return [val];

    }

    toUrl(object?: T): string {
        const params = object != null ? this.config.renderParameters!(object) : {};
        return this.renderUrl(params);
    }

    render(props: RouteComponentProps): React.ReactElement {
        return this.config.render(props);
    }

    renderUrl(params: Params) {
        return generatePath(this.config.path, params as any);
    }

}
