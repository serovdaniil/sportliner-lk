import {analysisApi} from "app/service/Apis";
import {action, makeObservable, observable, reaction, toJS} from 'mobx';
import {AnalysisData, BranchOfficeItem} from "../../../api";
import {branchOfficeItemStore} from "../store/Catalog/BranchOfficeItemStore";

export class AnalysisPageStore {

    @observable
    private _analysisData?: AnalysisData;

    @observable
    private _branchOffice?: BranchOfficeItem;

    @observable
    private _date?: string;

    constructor() {
        this.setupReactions();

        makeObservable(this);
    }

    get pageTitle(): string {
        if (this._branchOffice == null) {
            return "Анализ посещаемости";
        }

        return "Анализ посещаемости. ${branchOfficeName}"
            .replace("${branchOfficeName}", this._branchOffice.address);
    }

    get analysisData(): AnalysisData | undefined {
        return this._analysisData;
    }

    get branchOffice(): BranchOfficeItem | undefined {
        return this._branchOffice!;
    }

    get date(): string | undefined {
        return this._date;
    }

    get averageAttendance(): number {
        if (this._analysisData == null) {
            throw new Error("Analysis data wasn't initialized yet");
        }

        return this._analysisData.averageAttendance;
    }

    get attendanceByTime(): Map<string, number> {
        if (this._analysisData == null) {
            throw new Error("Analysis data wasn't initialized yet");
        }

        return new Map<string, number>(Object.entries(this._analysisData.attendanceByTime));
    }

    countAttendances(): number {
        if (this._analysisData == null) {
            throw new Error("Analysis data wasn't initialized yet");
        }

        let count = 0;

        this.attendanceByTime
            .forEach((attendances, time) => {
                count = count + attendances
            });

        return count;
    }

    @action.bound
    async init(): Promise<void> {
        await branchOfficeItemStore.loadAvailable();

        this._branchOffice = branchOfficeItemStore.available[0];

        const date = new Date();
        this._date = [
            date.getFullYear(),
            this.padTo2Digits(date.getMonth() + 1),
            this.padTo2Digits(date.getDate()),
        ].join('-');

        await this.loadDate();
    }

    @action.bound
    async loadDate(): Promise<void> {
        this._analysisData = await analysisApi.analysisDayAtBranchOffice({
            branchOfficeId: this._branchOffice!.id,
            date: this.date!
        })
    }

    @action.bound
    setBranchOffice(branchOffice: BranchOfficeItem): void {
        this._branchOffice = branchOffice;
    }

    @action.bound
    setDate(date: string | undefined): void {
        this._date = date!;
    }

    setupReactions(): void {
        reaction(
            () => toJS({
                branchOffice: this.branchOffice,
                date: this.date
            }),
            async () => await this.loadDate()
        )
    }

    private padTo2Digits(num: number) {
        return num.toString().padStart(2, '0');
    }

}
