import {ChildAttendance, ChildInfo} from "api";
import AttendanceModel from "app/logic/attendance/AttendanceModel";
import {attendanceApi, branchOfficeApi} from "app/service/Apis";
import RuntimeException from "app/service/exceptions/RuntimeException";
import {action, computed, makeObservable, observable} from 'mobx';

export class AttendanceEditStore {

    @observable
    private _children: ChildInfo[] = [];

    @observable
    private _attendances: Map<string, AttendanceModel[]> = new Map<string, AttendanceModel[]>();

    @observable
    private _branchOfficeId?: string;

    @observable
    private _period?: string;

    @observable
    private _schedules: Map<string, string[]> = new Map<string, string[]>();

    constructor() {
        makeObservable(this);
    }

    @computed
    get schedules(): Map<string, string[]> {
        return this._schedules;
    }

    @computed
    get children(): ChildInfo[] {
        return this._children;
    }

    @computed
    get branchOfficeId(): string {
        return this._branchOfficeId!;
    }

    @computed
    get period(): string {
        return this._period!;
    }

    @action.bound
    async loadData(branchOfficeId: string, period: string): Promise<void> {
        this._branchOfficeId = branchOfficeId;
        this._period = period;
        this._schedules = new Map<string, string[]>();

        this._children = await branchOfficeApi.getChildrenForBranchOffice({
            id: this.branchOfficeId
        });

        const schedules = await branchOfficeApi.getSchedulesForBranchOffice({
            id: this.branchOfficeId,
            period: this.period
        });

        Object.entries(schedules)
            .sort(([aDate, aTimes], [bDate, bTimes]) => aDate.localeCompare(bDate))
            .map(([date, times]) => this._schedules.set(date, times));

        this._children.map(it => {
            let childAttendances = [] as AttendanceModel[];

            Array.from(this._schedules.entries())
                .map(([date, times]) => {
                    const attendanceByDate = times.map(it => new AttendanceModel(date, it));

                    childAttendances = childAttendances.concat(attendanceByDate);
                })

            this._attendances.set(it.id, childAttendances);
        })

        const attendances = await attendanceApi.getAttendancesForBranchOffice({
            branchOfficeId: this.branchOfficeId,
            period: this.period
        });

        for (const attendance of attendances) {
            const childId = attendance.childId;

            attendance.attendances.map(it => {
                const attendanceModel = this.getAttendanceModel(childId, it.date, it.time)

                attendanceModel.setValue(true);
            });
        }
    }

    getAttendanceModel(childId: string, date: string, time: string): AttendanceModel {
        const result = this._attendances.get(childId)?.find(it => it.equals(date, time));
        if (result == null) {
            throw new RuntimeException(
                `Unknown attendance pair ${date}/${time}`
            );
        }
        return result;
    }

    toJson(): ChildAttendance[] {
        return Array.from(this._attendances.entries())
            .map(([childId, attendance]) => {

                const attendances = attendance
                    .filter(it => it.value)
                    .map(it => {
                        return {
                            date: it.date,
                            time: it.time
                        }
                    });

                return {
                    childId: childId,
                    attendances: attendances
                }
            })
            .filter(it => it.attendances.length !== 0)
    }
}
