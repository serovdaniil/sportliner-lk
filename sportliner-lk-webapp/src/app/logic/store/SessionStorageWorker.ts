class SessionStorageWorker<T extends SessionStorageData> {

    sessionStorageSupported: boolean;

    constructor() {
        this.sessionStorageSupported = typeof window['sessionStorage'] !== 'undefined' && window['sessionStorage'] != null;
    }

    private checkSessionStorageSupport() {
        if (!this.sessionStorageSupported) {
            throw new Error('session storage is not supported');
        }
    }

    // {@key: any} is hack for dynamic pages
    // Its better to use {@key: keyof T}
    setItemByKey<K extends any, V extends T[keyof T]>(key: K, value: V): void {
        this.checkSessionStorageSupport();
        sessionStorage.setItem(String(key), JSON.stringify(value));
    }

    isItemExist(key: keyof T): boolean {
        this.checkSessionStorageSupport();
        return !!sessionStorage.getItem(String(key));
    }

    getItemByKey<K extends keyof T, V extends T[K]>(key: K): V | null {
        this.checkSessionStorageSupport();
        return JSON.parse(String(sessionStorage.getItem(String(key))));
    }

    // {@key: any} is hack for dynamic pages
    // Its better to use {@key: keyof T}
    getItemOrDefault<K extends any, V extends T[keyof T]>(key: K, defaultValue: V): V {
        if (this.isItemExist(key as keyof T)) {
            return this.getItemByKey(key as keyof T)!;
        }
        return defaultValue;
    }

    // {@key: any} is hack for dynamic pages
    // Its better to use {@key: keyof T}
    removeItemByKey(key: any): void {
        this.checkSessionStorageSupport();
        sessionStorage.removeItem(String(key));
    }

    clear(): void {
        this.checkSessionStorageSupport();

        const autoLogout = this.getAutoLogout();

        sessionStorage.clear();

        if (autoLogout != null) {
            this.setAutoLogout(autoLogout);
        }
    }

    setAutoLogout(timestamp: number): void {
        this.checkSessionStorageSupport();

        sessionStorage.setItem("autoLogout", String(timestamp));
    }

    clearAutoLogout(): void {
        this.checkSessionStorageSupport();

        sessionStorage.removeItem("autoLogout");
    }

    checkIfWasAutoLogout(): boolean {
        this.checkSessionStorageSupport();

        return this.getAutoLogout() != null;
    }

    private getAutoLogout(): number | null {
        this.checkSessionStorageSupport();

        const value = sessionStorage.getItem("autoLogout");
        return value != null ? Number(value) : null;
    }

}

export default SessionStorageWorker;

type PageSize = {
    pageSize: number;
};

type CurrentPage = {
    currentPage: number;
}

/**
 * Available sessionStorage items of {@link SessionStorageData}
 * Keys of {@link SessionStorageData} is a sessionStorage  items keys
 * Value of {@link SessionStorageData} is a sessionStorage items values
 */
export type SessionStorageData = {}
