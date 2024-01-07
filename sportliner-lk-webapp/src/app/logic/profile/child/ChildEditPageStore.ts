import {Attendance, ChildProfile} from "api";
import {accountApi, attendanceApi} from 'app/service/Apis';

export default class ChildEditPageStore {

    private readonly _childId: string;

    private _child: ChildProfile;

    private _attendances: Attendance[];


    constructor(childId: string) {
        this._childId = childId;
    }

    async init() {
        this._child = await accountApi.getChildTargetAccount({id: this._childId});
        this._attendances = await attendanceApi.getAttendancesForChild({childId: this._childId});
    };

    get child(): ChildProfile {
        return this._child;
    }

    get attendances(): Attendance[] {
        return this._attendances;
    }

    async save() {
        await accountApi.updateChildTargetAccount({
            id: this._childId,
            childProfile: this.child
        })
    };
}
