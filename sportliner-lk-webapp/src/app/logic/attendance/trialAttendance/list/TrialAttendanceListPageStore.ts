import {action, makeObservable, observable} from 'mobx';
import {TrialAttendance} from "../../../../../api";
import {attendanceApi} from "../../../../service/Apis";

export class TrialAttendanceListPageStore {

    @observable
    private _trialAttendances?: TrialAttendance[];

    constructor() {
        makeObservable(this);
    }

    get trialAttendances(): TrialAttendance[] {
        return this._trialAttendances!;
    }

    @action.bound
    async init() {
        this._trialAttendances = await attendanceApi.getTrialAttendances();
    }

    @action.bound
    async confirmTrialAttendance(id: string): Promise<void> {
        await attendanceApi.confirmTrialAttendance({trialAttendanceId: id});

        await this.init();
    }

}
