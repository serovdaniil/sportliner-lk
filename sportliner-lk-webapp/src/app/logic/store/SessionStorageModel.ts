import {action, makeObservable, observable} from "mobx";

export default abstract class SessionStorageModel<T extends object> {

    private readonly _key: string;
    private readonly _defaultValue: T;

    @observable
    protected _value: T;

    protected constructor(key:string, defaultValue: T) {
        this._key = key;
        this._defaultValue = defaultValue;

        this._value = this._defaultValue;

        makeObservable(this);
    }

    get value(): T {
        return this._value;
    }

    @action.bound
    setValue(value: T) {
        this._value = value;
    }

    get isEmpty(): boolean {
        const values: string[] = Object.values(this.value);

        if (values.length === 0) {
            return true;
        }

        return values.every((value) => {
            if (value == null) {
                return true;
            }

            return typeof value !== "object"
                ? value.trim().length === 0
                : Object.values(value).length === 0;
        });
    }

}
