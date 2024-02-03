import {useEffect, useState} from 'react';

const DEFAULT_PERIOD = 3000;

export const usePolling = (callback: () => Promise<unknown>, period: number = DEFAULT_PERIOD) => {

    interface State {
        timeout?: NodeJS.Timeout;
        cancel?: boolean;
    }

    const [state, setState] = useState<State>({});

    useEffect(() => {
        state.cancel = false;

        const tick = async () => {
            if (state.cancel) {
                return;
            }

            try {
                await callback();
            } finally {
                scheduleNext();
            }
        };

        const scheduleNext = () => {
            if (state.cancel) {
                return;
            }

            state.timeout = setTimeout(tick, period);
        }

        scheduleNext();

        return () => {
            state.cancel = true;
            if (state.timeout != null) {
                clearTimeout(state.timeout)
            }
        };
    }, []);
};
