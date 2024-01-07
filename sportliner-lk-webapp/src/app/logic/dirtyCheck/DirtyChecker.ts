import DirtyCheckerContext from "app/logic/dirtyCheck/DirtyCheckerContext";
import {addBeforeUnloadListener} from "app/utils/WindowUtils";
import jsonStringify from "quick-stable-stringify";
import {useContext, useEffect, useState} from "react";

export default class DirtyChecker {

    private _dirtyValueKey: number = 0;

    private readonly _registry: Map<number, DirtyCheckerValue> = new Map<number, DirtyCheckerValue>();

    constructor() {
        addBeforeUnloadListener(this.handleBeforeUnloadEvent.bind(this));
    }

    get isDirty(): boolean {
        Array.from(this._registry.values()).map(it => console.log(it))
        return Array.from(this._registry.values()).some(it => it.isDirty);
    }

    register(provider: DirtyCheckerValueProvider): number {
        this._dirtyValueKey = this.generateKey();

        this._registry.set(this._dirtyValueKey, new DirtyCheckerValue(provider));

        return this._dirtyValueKey;
    }

    commit(provider: DirtyCheckerValueProvider): void {
        this._registry.set(this._dirtyValueKey, new DirtyCheckerValue(provider));
    }

    delete(key: number): boolean {
        return this._registry.delete(key);
    }

    deleteLast(): boolean {
        const key = this._dirtyValueKey;

        this._dirtyValueKey = key === 0 ? key : key - 1;

        return this._registry.delete(key);
    }

    clear(): void {
        this._registry.clear();
    }

    private generateKey(): number {
        const registry = this._registry;

        if (registry.size === 0) {
            return 1;
        }

        return Math.max(...Array.from(registry.keys())) + 1;
    }

    private handleBeforeUnloadEvent(e: BeforeUnloadEvent) {
        if (this.isDirty) {
            e.preventDefault();
            e.returnValue = '';
        }
    }
}

type DirtyCheckerValueProvider = () => object;

class DirtyCheckerValue {

    private readonly _initialValue: object;
    private readonly _provider: DirtyCheckerValueProvider;

    constructor(provider: DirtyCheckerValueProvider) {
        this._initialValue = provider();
        this._provider = provider;
    }

    get isDirty(): boolean {
        return jsonStringify(this._initialValue) !== jsonStringify(this._provider());
    }

}

export const useDirtyChecker = () => {

    interface State {
        valueProvider: DirtyCheckerValueProvider | null
    }

    const dirtyChecker = useContext<DirtyChecker>(DirtyCheckerContext);
    const [state, setState] = useState<State>(() => ({valueProvider: null}));

    useEffect(() => {
        const provider = state.valueProvider;
        let key: number | undefined;

        if (provider != null) {
            key = dirtyChecker.register(provider);
        }

        return () => {
            if (key != null) {
                dirtyChecker.delete(key);
            }
        }
    }, [state]);

    const register = (provider: DirtyCheckerValueProvider): void => {
        setState({
            valueProvider: provider
        });
    };

    const commit = (): void => {
        const provider = state.valueProvider;
        if (provider != null) {
            dirtyChecker.commit(provider);
        }
    };

    const deleteLast = (): void => {
        dirtyChecker.deleteLast();
    };

    const isDirty = (): boolean => dirtyChecker.isDirty;

    return {
        register,
        commit,
        deleteLast,
        isDirty
    }
};
