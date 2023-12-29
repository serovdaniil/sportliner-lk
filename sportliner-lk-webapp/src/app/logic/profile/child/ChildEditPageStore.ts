import {ChildProfile} from "api";
import {accountApi} from 'app/service/Apis';

export default class ChildEditPageStore {

    private _childId?: string;

    private _child?: ChildProfile;

    async init(childId: string) {
        this._childId = childId;

        this._child = await accountApi.getChildTargetAccount({id: childId});
    };


    get child(): ChildProfile {
        return this._child!;
    }

    async save() {
        await accountApi.updateChildTargetAccount({
            id: this._childId!,
            childProfile: this.child!
        })
    };
}
