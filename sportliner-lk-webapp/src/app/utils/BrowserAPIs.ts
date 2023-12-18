import AppNotification from 'app/logic/notification/AppNotification';

export const copyToClipboard = (text: string, message?: string): void => {
    navigator.clipboard.writeText(text);

    AppNotification.info(message ?? 'Скопировано');
};

export default copyToClipboard;
