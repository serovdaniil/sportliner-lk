import {CloseOutlined, DeleteTwoTone} from '@ant-design/icons';
import {Modal, Tooltip} from 'antd';
import AppNotification from 'app/logic/notification/AppNotification';
import React from "react";

interface Props<T> {
    target: T;
    executeDelete: (target: T) => Promise<void>;
    message?: string;
    hideSuccessNotification?: boolean;
}

const DeleteActionButton = <T extends unknown>(props: Props<T>) => {

    const executeDelete = (target: T) => {
        (async () => {
            await props.executeDelete(target);

            if (props.hideSuccessNotification) {
                return;
            }

            AppNotification.success(props.message || 'Запись удалена');
        })();
    };

    const confirmDelete = (proceed: () => void) => {
        Modal.confirm({
            title: 'Вы действительно хотите удалить данную запись?',
            closeIcon: <CloseOutlined/>,
            closable: true,
            className: 'dp-modal_small',
            okText: 'Удалить',
            onOk: proceed
        });
    };

    const onClick = () => {
        const target = props.target;

        confirmDelete(() => executeDelete(target))
    }

    return (
        <>
            <Tooltip title="Удалить">
                <a onClick={() => onClick()}>
                    <DeleteTwoTone twoToneColor="red"/>
                </a>
            </Tooltip>
        </>
    );
};

export default DeleteActionButton;