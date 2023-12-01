import {AppRunner} from "app/AppRunner";

test('test app name', () => {
    const appName = AppRunner.appName;

    expect(appName).toBe("Sportliner-lk")
});
