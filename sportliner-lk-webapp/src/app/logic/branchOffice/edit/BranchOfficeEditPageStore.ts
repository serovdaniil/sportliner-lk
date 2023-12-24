import {BranchOffice, ClassSchedule, DayOfWeek, UserAccountItem} from 'api';
import {branchOfficeApi} from 'app/service/Apis';
import {action, computed, makeObservable, observable} from 'mobx';

export class BranchOfficeEditPageStore {

    private _branchOfficeId: string | undefined;

    @observable
    private _branchOffice: BranchOffice | undefined;

    @observable
    private _dayToClassSchedules: Map<DayOfWeek, ClassSchedule[]> = new Map<DayOfWeek, ClassSchedule[]>([
        [DayOfWeek.MONDAY, []],
        [DayOfWeek.TUESDAY, []],
        [DayOfWeek.WEDNESDAY, []],
        [DayOfWeek.THURSDAY, []],
        [DayOfWeek.FRIDAY, []],
        [DayOfWeek.SATURDAY, []],
        [DayOfWeek.SUNDAY, []]
    ]);

    constructor() {
        makeObservable(this);
    }

    get branchOffice(): BranchOffice | undefined {
        return this._branchOffice;
    }

    @computed
    get classSchedules(): Map<DayOfWeek, ClassSchedule[]> {
        return this._dayToClassSchedules;
    }

    @action.bound
    async init(branchOfficeId?: string): Promise<void> {
        if (branchOfficeId != null) {
            const branchOffice = await branchOfficeApi.getBranchOffice({id: branchOfficeId});

            this._branchOffice = branchOffice;
            if (branchOffice.classSchedules) {
                branchOffice.classSchedules.forEach(it => {
                    this.addClassSchedule(it.day, it.time, it.trainer);
                })
            }
        }

        this._branchOfficeId = branchOfficeId;
    }

    public getClassSchedulesByDay(day: DayOfWeek): ClassSchedule[] {
        return this._dayToClassSchedules.get(day)!;
    }

    public getClassSchedules(): ClassSchedule[] {
        let classSchedules = [] as ClassSchedule[];

        Object.values(DayOfWeek).map((day) => {
            const schedules = this._dayToClassSchedules.get(day)!;

            classSchedules = classSchedules.concat(schedules)
        })

        return classSchedules;
    }

    @action.bound
    public addClassSchedule(day: DayOfWeek, time: string, trainer: UserAccountItem) {
        const classSchedules = this._dayToClassSchedules.get(day)!.slice();
        const index = classSchedules.findIndex((it => it.time === time));

        if (index !== -1) {
            classSchedules.splice(index, 1);
        }

        classSchedules.push({day: day, time: time, trainer: trainer});
        this._dayToClassSchedules.set(day, classSchedules);
    }

    @action.bound
    public deleteClassSchedule(day: DayOfWeek, index: number) {
        const schedules: ClassSchedule[] = this._dayToClassSchedules.get(day)!.slice();

        schedules.splice(index, 1);

        this._dayToClassSchedules.set(day, schedules);
    }

    public async save(branchOffice: BranchOffice) {
        const classSchedules = this.getClassSchedules();

        if (this._branchOfficeId == null) {
            await this.create({...branchOffice, classSchedules: classSchedules});
        } else {
            await this.update({...branchOffice, classSchedules: classSchedules});
        }
    }

    private async create(branchOffice: BranchOffice) {
        await branchOfficeApi.createBranchOffice(
            {
                branchOffice: branchOffice
            }
        );
    }

    private async update(branchOffice: BranchOffice) {
        await branchOfficeApi.updateBranchOffice(
            {
                id: this._branchOfficeId!,
                branchOffice: branchOffice
            }
        );
    }

}
