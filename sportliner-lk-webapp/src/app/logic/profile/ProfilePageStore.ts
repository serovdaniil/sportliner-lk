
import {observable} from 'mobx';
import {UserProfile} from "../../../api";
import {accountApi} from "../../service/Apis";

export class ProfilePageStore {

    @observable
    private _profile: UserProfile | undefined;

    async init() {
        this._profile = await accountApi.getCurrentUserProfile();
    }

    get profile(): UserProfile {
        return this._profile!;
    }

}
