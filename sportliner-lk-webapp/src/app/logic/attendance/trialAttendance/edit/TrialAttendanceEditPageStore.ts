import {BranchOfficeItem, ChildProfile, TrialAttendance} from "api";
import {attendanceApi, catalogApi, usersApi} from 'app/service/Apis';
import {action, observable, runInAction} from "mobx";
import {UserAttributes} from "../../../user/edit/UserAttributes";

export default class TrialAttendanceEditPageStore {

    @observable
    private _trialAttendance: Partial<TrialAttendance>;

    @observable
    private _branchOffices: BranchOfficeItem[] = [];

    constructor() {
        this._trialAttendance = {};
    }

    @action.bound
    async init(): Promise<void> {
        this._branchOffices = await catalogApi.getAvailableBranchOffices();
    }

    get trialAttendance(): Partial<TrialAttendance> {
        return this._trialAttendance;
    }


    get branchOffices(): BranchOfficeItem[] {
        return this._branchOffices;
    }

    async save() {
        await attendanceApi.createTrialAttendances({
            trialAttendance: {
                id: this._trialAttendance.id!,
                telegramUsername: this._trialAttendance.telegramUsername,
                branchOffice: this._trialAttendance.branchOffice!,
                name: this._trialAttendance.name!,
                phone: this._trialAttendance.phone!,
                diagnosis: this._trialAttendance.diagnosis!,
                date: this._trialAttendance.date!,
                status: this._trialAttendance.status!
            }
        })
    };
}
