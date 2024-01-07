import {AttendanceEditStore} from "app/logic/attendance/AttendanceEditStore";
import {attendanceApi, branchOfficeApi} from "app/service/Apis";
import {action, makeObservable, observable} from 'mobx';
import {auth} from "../../App";
import {BranchOfficeItem} from "../../../api";
import {branchOfficeItemStore} from "../store/Catalog/BranchOfficeItemStore";

export class AttendancePageStore {

    private readonly _trainer: boolean;

    private _editStore: AttendanceEditStore;

    @observable
    private _branchOffice?: BranchOfficeItem;

    @observable
    private _period: string;

    constructor() {
        this._trainer = !auth.isAdmin;
        this._editStore = new AttendanceEditStore();
        this._period = "2023-12";
        // this.setupReactions();

        makeObservable(this);
    }

    get editStore(): AttendanceEditStore {
        return this._editStore;
    }

    get pageTitle(): string {
        if (this._branchOffice == null) {
            return "Посещаемость";
        }

        return "Посещаемость. ${branchOfficeName}"
            .replace("${branchOfficeName}", this._branchOffice.address);
    }

    get branchOffice(): BranchOfficeItem {
        return this._branchOffice!;
    }

    get period(): string {
        return this._period;
    }

    get isTrainer(): boolean {
        return this._trainer;
    }

    @action.bound
    async init(): Promise<void> {
        await branchOfficeItemStore.loadAvailable();

        if (this.isTrainer) {
            this._branchOffice = await branchOfficeApi.getBranchOfficeOfCurrentTrainer();
        } else {
            this._branchOffice = branchOfficeItemStore.available[0];
        }

        await this.loadData();
    }

    @action.bound
    async loadData(): Promise<void> {
        await this._editStore.loadData(this._branchOffice?.id!, this._period);
    }

    @action.bound
    setBranchOffice(branchOffice: BranchOfficeItem): void {
        this._branchOffice = branchOffice;
    }

    @action.bound
    setPeriod(period: string): void {
        this._period = period;
    }

    async save(): Promise<void> {
        await attendanceApi.saveAttendances({
            branchOfficeId: this._branchOffice?.id!,
            period: this.period,
            childAttendance: this.editStore.toJson()
        });
    }

    // setupReactions(): void {
    //     reaction(
    //         () => toJS({
    //             period: this.period,
    //             branchOffice: this.branchOffice
    //         }),
    //         async () => await this._editStore.loadData(this._branchOffice?.id!, this._period)
    //     );
    // }

}
