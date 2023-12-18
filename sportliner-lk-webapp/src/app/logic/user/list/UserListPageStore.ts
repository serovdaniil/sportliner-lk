import {action, makeObservable, observable, reaction} from 'mobx';
import {UserAccountListItem} from "../../../../api";
import {usersApi} from "../../../service/Apis";
import UserAccountCriteriaModel from "./UserAccountCriteriaModel";
import ObjectUtils from "../../../utils/ObjectUtils";

export class UserListPageStore {

    @observable
    private _users?: UserAccountListItem[];

    readonly criteriaModel: UserAccountCriteriaModel;

    constructor() {
        this.criteriaModel = new UserAccountCriteriaModel();

        makeObservable(this);

        this.setupReactions();
    }

    get users(): UserAccountListItem[] {
        return this._users!;
    }

    @action.bound
    async init() {
        this._users = await usersApi.getUsers(ObjectUtils.removeUndefined(ObjectUtils.removeEmptyString({
            criteria: this.criteriaModel.toJson(),
        })));
    }

    @action.bound
    async deleteBranchOffice(id: string): Promise<void> {
        await usersApi.deleteUser({id: id});

        await this.init();
    }

    setupReactions(): void {
        reaction(
            () => this.criteriaModel.toJson(),
            async () => await this.init()
        );
    }

}
