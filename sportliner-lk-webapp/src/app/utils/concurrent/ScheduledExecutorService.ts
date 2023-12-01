interface ScheduledTaskExecutionListener {

    started: (task: ScheduledTask<unknown>) => void;

    completed: (task: ScheduledTask<unknown>) => void;

    cancelled: (task: ScheduledTask<unknown>) => void;

}

class ScheduledTask<T> {

    private readonly callback: () => Promise<T>;

    private readonly delay: number;
    private readonly periodic: boolean;

    private timeout: NodeJS.Timeout | undefined;

    private cancelled: boolean = false;

    private listeners: ScheduledTaskExecutionListener[] = [];

    constructor(callback: () => Promise<T>, delay: number, periodic: boolean) {
        this.callback = callback;

        this.delay = delay;
        this.periodic = periodic;
    }

    addListener(listener: ScheduledTaskExecutionListener) {
        this.listeners.push(listener);
    }

    isPeriodic() {
        return this.periodic;
    }

    cancel() {
        if (this.isCancelled()) {
            return;
        }

        if (this.timeout != null) {
            clearTimeout(this.timeout);
            this.timeout = undefined;
        }

        this.cancelled = true;
        this.notifyListeners(listener => listener.cancelled(this))
    }

    isCancelled() {
        return this.cancelled;
    }

    scheduleNextExecution() {
        this.timeout = setTimeout(() => this.run(), this.delay);
    }

    private async run(): Promise<void> {
        if (this.isCancelled()) {
            return;
        }

        try {
            this.notifyListeners(listener => listener.started(this))
            await this.callback();
        }
        finally {
            this.notifyListeners(listener => listener.completed(this))
        }
    }

    private notifyListeners(callback: (listener: ScheduledTaskExecutionListener) => void) {
        this.listeners.forEach(it => callback(it));
    }
}

export class ScheduledExecutorService {

    private readonly tasks: Set<ScheduledTask<unknown>> = new Set<ScheduledTask<unknown>>();

    private _shutdown: boolean = false;

    private readonly listener: ScheduledTaskExecutionListener = {
        started: (task) => {

        },
        completed: (task) => {
            if (task.isCancelled()) {
                this.remove(task);
            }

            if (task.isPeriodic()) {
                task.scheduleNextExecution();
            }
        },
        cancelled: (task) => {
            this.remove(task);
        }
    }

    scheduleOnce<T extends unknown>(callback: () => Promise<T>, delay: number) {
        this.enqueue(new ScheduledTask<any>(callback, delay, false));
    }

    schedulePeriodic<T>(callback: () => Promise<T>, delay: number) {
        this.enqueue(new ScheduledTask<any>(callback, delay, true));
    }

    shutdown() {
        this._shutdown = true;
        Array.from(this.tasks.values()).forEach(task => task.cancel())
    }

    isShutdown() {
        return this._shutdown;
    }

    private enqueue(task: ScheduledTask<unknown>) {
        if (this._shutdown) {
            throw new Error("Scheduled task rejected. Executor is shutdown.")
        }

        task.addListener(this.listener);

        this.tasks.add(task);

        task.scheduleNextExecution();
    }

    private remove(task: ScheduledTask<unknown>) {
        this.tasks.delete(task);
    }

}
