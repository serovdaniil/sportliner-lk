import {useContext, useState} from "react";
import {NavigateFunction, useNavigate} from "react-router-dom";
import DirtyCheckerContext from "./dirtyCheck/DirtyCheckerContext";
import DirtyChecker from "./dirtyCheck/DirtyChecker";
import {Modal} from "antd";

class Navigator {

    private readonly _navigateFunction: NavigateFunction;
    private readonly _dirtyChecker: DirtyChecker;

    constructor(navigateFunction: NavigateFunction, dirtyCheckerStore: DirtyChecker) {
        this._navigateFunction = navigateFunction;
        this._dirtyChecker = dirtyCheckerStore;
    }

    public safeNavigate(to: string | number): void {
        if (!this._dirtyChecker.isDirty) {
            this.navigate(to);
        }
        else {
            const modal = Modal.confirm({
                content: 'Вы уверены? У вас есть несохраненные изменения.',
                cancelText: 'Оставаться на странице',
                onCancel: () => {
                    modal.destroy();
                },
                okText: 'Покинуть страницу',
                onOk: () => {
                    this.navigate(to);
                }
            });
        }
    }

    private navigate(to: string | number): void {
        if (typeof to === "string") {
            this._navigateFunction(to);
        }
        else {
            this._navigateFunction(to);
        }
    }
}

export const useNavigator = (): Navigator => {
    const navigate = useNavigate();
    const dirtyChecker = useContext(DirtyCheckerContext);
    const [navigator] = useState<Navigator>(() => new Navigator(navigate, dirtyChecker));

    return navigator;
};
