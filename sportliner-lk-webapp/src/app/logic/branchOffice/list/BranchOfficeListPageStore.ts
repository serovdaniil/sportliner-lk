import {action, makeObservable, observable} from 'mobx';
import {BranchOfficeListItem} from "../../../../api";
import {branchOfficeApi} from "../../../service/Apis";

export class BranchOfficeListPageStore {

    @observable
    private _branchOffices?: BranchOfficeListItem[];

    constructor() {
        makeObservable(this);
    }

    get branchOffices(): BranchOfficeListItem[] {
        return this._branchOffices!;
    }

    @action.bound
    async init() {
        this._branchOffices = await branchOfficeApi.getBranchOffices();
    }

    @action.bound
    async deleteBranchOffice(id: string): Promise<void> {
        await branchOfficeApi.deleteBranchOffice({id: id});

        await this.init();
    }

}
