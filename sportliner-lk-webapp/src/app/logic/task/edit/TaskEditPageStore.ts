import {Task, UserAccountItem} from "api";
import {catalogApi, taskApi} from 'app/service/Apis';
import {action, observable} from "mobx";

export default class TaskEditPageStore {

    private readonly _id?: string;

    @observable
    private _task: Partial<Task>;

    private _employees: UserAccountItem[] = [];

    constructor(id?: string) {
        this._id = id;
        this._task = {};
    }

    @action.bound
    async init(): Promise<void> {
        if (this._id != null) {
            this._task = await taskApi.getTaskById({id: this._id});
        }

        this._employees = await catalogApi.getEmployees();
    }

    get task(): Partial<Task> {
        return this._task;
    }

    get employees(): UserAccountItem[] {
        return this._employees;
    }

    async save() {
        const task = {
            id: this.task.id!,
            name: this.task.name!,
            description: this.task.description!,
            assignee: this.task.assignee!,
            reporter: this.task.reporter!,
            status: this.task.status!
        };

        if (this._id == null) {
            await this.create(task);
        } else {
            await this.update(this._id, task);
        }
    };

    async create(task: Task) {
        await taskApi.createTask({
            task: task
        })
    };

    async update(id: string, task: Task) {
        await taskApi.updateTask({
            id: id,
            task: task
        })
    };

}
