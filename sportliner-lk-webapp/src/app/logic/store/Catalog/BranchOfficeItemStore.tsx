import {BranchOfficeItem} from 'api';
import {catalogApi} from 'app/service/Apis';
import {makeObservable} from 'mobx';
import CatalogStore from "./CatalogStore";

export default class BranchOfficeItemStore extends CatalogStore<BranchOfficeItem> {

    constructor() {
        super(async () => await catalogApi.getAvailableBranchOffices());
        makeObservable(this);
    }

    getById(id: string): BranchOfficeItem {
        const result: BranchOfficeItem | undefined = this.available.find(it => it.id === id);
        if (result == null) {
            throw new Error("Requested digipal strategy not found: " + id);
        }
        return result;
    }
}

export const branchOfficeItemStore = new BranchOfficeItemStore();
