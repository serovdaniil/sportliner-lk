import {Rule} from 'antd/lib/form';

const reject = (msg: string) => Promise.reject(new Error(msg));

export const requiredValidator = (message = 'Поле обязательно'): Rule => ({required: true, message});

export const requiredWithTrimValidator = (message = 'Поле обязательно'): Rule => ({
    required: true,
    message,
    validator(rule, value: string | undefined): Promise<void> | void {
        if (value && value.trim().length > 0) {
            return Promise.resolve();
        }

        return reject(message ?? 'Поле обязательно');
    },
});
