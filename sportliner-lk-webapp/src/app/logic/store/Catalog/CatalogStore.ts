import {action, makeObservable, observable} from 'mobx';

export default class CatalogStore<T> {

    /**
     *  List of available entities
     */
    @observable
    available: T[] = [];

    private load: () => Promise<T[]>;

    constructor(load: () => Promise<T[]>) {
        this.load = load;
        makeObservable(this);
    }

    @action.bound
    async loadAvailable(): Promise<void> {
        this.available = await this.load();
    }

}
