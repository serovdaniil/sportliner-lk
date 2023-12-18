import {BranchOfficeItem, UserAccount} from 'api';
import {catalogApi, usersApi} from 'app/service/Apis';
import {action, computed, makeObservable, observable} from 'mobx';
import DataValidationException from "../../../service/exceptions/DataValidationException";
import {UserAttributes} from "./UserAttributes";

export class UserEditPageStore {

    private _userAccountId: string | undefined;

    @observable
    private _userAccount: UserAttributes;

    private _branchOffices: BranchOfficeItem[] = [];

    constructor() {
        this._userAccount = new UserAttributes({});

        makeObservable(this);
    }

    @computed
    get userAccount(): UserAttributes {
        return this._userAccount;
    }

    @computed
    get branchOffices(): BranchOfficeItem[] {
        return this._branchOffices;
    }

    @action.bound
    async init(userAccountId?: string): Promise<void> {
        if (userAccountId != null) {
            const userAccount = await usersApi.getUserAccount({id: userAccountId});

            this._userAccount = new UserAttributes(userAccount);
        }

        this._userAccountId = userAccountId;
        this._branchOffices = await catalogApi.getAvailableBranchOffices();
    }

    public async save(userAccount: UserAccount) {
        let childrenIsValid = this.userAccount.children.length === 0 ? true : false;

        this.userAccount.children.map(it => childrenIsValid = it.isValid());

        if (!childrenIsValid) {
            throw new DataValidationException("Пожалуйста, проверьте введенные данные")
        }

        if (this._userAccountId == null) {
            await this.create(userAccount);
        } else {
            await this.update(userAccount);
        }
    }

    private async create(userAccount: UserAccount) {
        await usersApi.createUser(
            {
                userAccount: this.userAccount.toJson()
            }
        );
    }

    private async update(userAccount: UserAccount) {
        await usersApi.updateUserAccount(
            {
                id: this._userAccountId!,
                userAccount: this.userAccount.toJson()
            }
        );
    }

}
