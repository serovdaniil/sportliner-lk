import {action, makeObservable, observable} from 'mobx';
import {UserAccountListItem} from "../../../../api";
import {usersApi} from "../../../service/Apis";

export class UserListPageStore {

    @observable
    private _users?: UserAccountListItem[];

    constructor() {
        makeObservable(this);
    }

    get users(): UserAccountListItem[] {
        return this._users!;
    }

    @action.bound
    async init() {
        this._users = await usersApi.getUsers();
    }

    @action.bound
    async deleteBranchOffice(id: string): Promise<void> {
        await usersApi.deleteUser({id: id});

        await this.init();
    }

}
