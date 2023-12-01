import {useState} from "react";
import {NavigateFunction, useNavigate} from "react-router-dom";

class Navigator {

    private readonly _navigateFunction: NavigateFunction;

    constructor(navigateFunction: NavigateFunction) {
        this._navigateFunction = navigateFunction;
    }

    public safeNavigate(to: string | number): void {
        this.navigate(to);
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
    const [navigator] = useState<Navigator>(() => new Navigator(navigate));

    return navigator;
};