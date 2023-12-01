export class AppRunner {

    static readonly baseContextPath = process.env.PUBLIC_URL!;

    static readonly appName: string = process.env.REACT_APP_NAME!;
    static readonly appVersion: string = process.env.REACT_APP_VERSION!;
    static readonly appApiBasePath: string = process.env.REACT_APP_BASE_API_URL!;

    static readonly devMode: boolean = process.env.NODE_ENV === "development";

    static reset() {
        window.location.href = AppRunner.baseContextPath;
    }

    static reload() {
        window.location.reload();
    }
}
