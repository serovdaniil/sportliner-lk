import DirtyChecker from "app/logic/dirtyCheck/DirtyChecker";

export default class DirtyCheckerRegistry {

    private readonly _registry: Set<DirtyChecker> = new Set([]);

    add(dirtyChecker: DirtyChecker): void {
        this._registry.add(dirtyChecker);
    }

    delete(dirtyChecker: DirtyChecker): void {
        this._registry.delete(dirtyChecker);
    }

    clear(): void {
        this._registry.forEach(it => {
            it.clear();
        });
        this._registry.clear();
    }

}