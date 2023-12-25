import {action, makeObservable, observable} from "mobx";

export default class AttendanceModel {

    private readonly _date: string;

    private readonly _time: string;

    @observable
    private _value: boolean = false;

    constructor(date: string, time: string) {
        this._date = date;
        this._time = time;

        makeObservable(this);
    }

    get date(): string {
        return this._date;
    }

    get time(): string {
        return this._time;
    }

    get value(): boolean {
        return this._value;
    }

    @action.bound
    setValue(value: boolean) {
        this._value = value;
    }

    equals(date: string, time: string) {
        return this._date === date
            && this._time === time;
    }
}
