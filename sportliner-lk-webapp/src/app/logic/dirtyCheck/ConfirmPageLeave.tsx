import {Modal} from "antd";

export const confirmPageLeave = async (): Promise<boolean> => {
    return new Promise<boolean>((resolve) => {

        const modal = Modal.confirm({
            content: 'Are you sure? You have unsaved changes.',

            cancelText: 'Stay on page',
            onCancel: () => {
                modal.destroy();
                resolve(false);
            },

            okText: 'Leave page',
            onOk: () => {
                resolve(true);
            }
        });

    });

}
