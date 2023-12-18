import {UserAccountCriteria} from "api";
import SessionStorageModel from "app/logic/store/SessionStorageModel";
import {toJS} from "mobx";

export default class UserAccountCriteriaModel extends SessionStorageModel<UserAccountCriteria> {

    constructor() {
        super("dp-console-userAccounts-criteria", {});
    }

    toJson(): UserAccountCriteria {
        return {
            lastName: toJS(this.value.lastName),
            role: toJS(this.value.role),
            payAttention: toJS(this.value.payAttention)
        };
    }

}
