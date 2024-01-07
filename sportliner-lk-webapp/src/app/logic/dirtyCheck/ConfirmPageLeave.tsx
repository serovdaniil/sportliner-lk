import {Modal} from "antd";

export const confirmPageLeave = async (): Promise<boolean> => {
    return new Promise<boolean>((resolve) => {

        const modal = Modal.confirm({
            content: 'Вы уверены? У вас есть несохраненные изменения.',

            cancelText: 'Оставаться на странице',
            onCancel: () => {
                modal.destroy();
                resolve(false);
            },

            okText: 'Покинуть страницу',
            onOk: () => {
                resolve(true);
            }
        });

    });

}
