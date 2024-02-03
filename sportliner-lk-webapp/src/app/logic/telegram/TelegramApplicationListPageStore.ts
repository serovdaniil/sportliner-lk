import {action, makeObservable, observable} from 'mobx';
import {TelegramBotApplication, TrialAttendance} from "../../../api";
import {attendanceApi, telegramApi} from "../../service/Apis";

export class TelegramApplicationListPageStore {

    @observable
    private _telegramBotApplications?: TelegramBotApplication[];

    constructor() {
        makeObservable(this);
    }

    get telegramBotApplications(): TelegramBotApplication[] {
        return this._telegramBotApplications!;
    }

    @action.bound
    async init() {
        this._telegramBotApplications = await telegramApi.getTelegramApplications();
    }

    @action.bound
    async createTrialAttendance(trialAttendance: TrialAttendance ) {
        await attendanceApi.createTrialAttendances({trialAttendance: trialAttendance})
    }

}
