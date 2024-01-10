import {AuthInfo, AuthResponse, AuthResponseStatus} from 'api';
import {sessionStorageWorker} from "app/App";
import {authApi} from 'app/service/Apis';
import {AuthState} from 'kit/security/AuthState';
import {action, computed, makeObservable, observable, runInAction} from 'mobx';
import {Authorities} from "./Authorities";

interface Tokens {
    accessToken: string;
    expiresAt: number;
}

interface State {
    info: AuthInfo;
    tokens: Tokens;
    sessionTimeout: number;
}

/**
 * Store fot access token and refresh token
 */
export default class AuthStore {

    @observable.ref
    state: State | null = null;

    @observable
    initializing: boolean | null = null;

    onClear = () => {
    };

    constructor() {
        makeObservable(this);

        this.init();
    }

    @action
    setOnClear(callBack: () => void) {
        this.onClear = callBack;
    }

    @action
    async init(): Promise<void> {
        this.setInitializing(true);

        const hasRt = !!localStorage.getItem('rt');

        try {
            if (hasRt) {
                const response = await authApi.refresh();
                this.authenticated(response);
            }
        }
        catch (e) {
            // skip any errors
            this.clear();
        }
        finally {
            this.setInitializing(false);
        }
    }

    @action
    async refresh(): Promise<boolean> {
        if (this.state === null) {
            return false;
        }

        try {
            const response = await authApi.refresh();
            this.authenticated(response);
            return true;
        }
        catch (e) {
            this.clear();
            return false;
        }
        finally {
            sessionStorageWorker.clearAutoLogout();
        }
    }

    /**
     * Set access token and refresh token
     */
    @action
    authenticated(response: AuthResponse): void {
        if (response.status !== AuthResponseStatus.SUCCESS) {
            throw new Error('Invalid status');
        }

        this.state = {
            info: response.info!,
            tokens: {
                accessToken: response.token!.accessToken,
                expiresAt: new Date(Date.now() + 1000 * response.token!.expiresIn).getTime(),
            },
            sessionTimeout: response.sessionTimeout
        };

        localStorage.setItem('rt', String(true));
    }

    /**
     * Remove tokens
     */
    @action
    async logout(): Promise<void> {
        try {
            await authApi.logout({automatic: false});
        }
        finally {
            sessionStorageWorker.clearAutoLogout();
            this.clear();
        }
    }

    clear(): void {
        runInAction(() => {
            this.state = null;
            localStorage.removeItem('rt');
        });

        this.onClear();
    }

    @computed
    get isTokenExists(): boolean {
        return this.state !== null;
    }

    @computed
    get userInfo(): AuthInfo | null {
        return this.state?.info ?? null;
    }

    @computed
    get accessToken(): string | null {
        return this.state?.tokens.accessToken ?? null;
    }

    @computed
    get isAuth(): boolean{
        return this.state != null;
    }

    @computed
    get authState(): AuthState {
        if (this.state == null) {
            return AuthState.anonymous();
        }

        return AuthState.authenticated(this.state.info.authorities);
    }

    @computed
    get isParent(): boolean {
        return this.state != null && this.state.info.authorities.includes(Authorities.PARENT);
    }

    @computed
    get isTrainer(): boolean {
        return this.state != null && this.state.info.authorities.includes(Authorities.TRAINER);
    }

    @computed
    get isAdmin(): boolean {
        return this.state != null && this.state.info.authorities.includes(Authorities.ADMINISTRATIVE);
    }

    private isExpired(): boolean {
        return this.state != null && this.state.tokens.expiresAt <= Date.now();
    }

    @action
    private setInitializing(initializing: boolean) {
        this.initializing = initializing;
    }

}
