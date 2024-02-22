import {action, makeObservable, observable} from 'mobx';
import {Task} from "../../../../api";
import {taskApi} from "../../../service/Apis";

export class TaskListPageStore {

    @observable
    private _tasks?: Task[];

    constructor() {
        makeObservable(this);
    }

    get tasks(): Task[] {
        return this._tasks!;
    }

    @action.bound
    async init() {
        this._tasks = await taskApi.findAll();
    }

}
