import {notification} from 'antd';
import {ArgsProps} from 'antd/lib/notification';

/**
 * Class for displaying system notifications.
 */
export default class AppNotification {

    static error(message: string): void {
        const notificationSettings: ArgsProps = {
            message,
            placement: 'bottomRight',
        };

        notification.error(notificationSettings);
    }

    static info(message: string): void {
        const notificationSettings: ArgsProps = {
            message,
            placement: 'bottomRight',
        };

        notification.info(notificationSettings);
    }

    static success(message: string): void {
        const notificationSettings: ArgsProps = {
            message,
            placement: 'bottomRight',
        };

        notification.success(notificationSettings);
    }

    static remove(): void {
        notification.destroy();
    }

}
