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

export const passwordValidator = (): Rule => ({
    validator(rule, value: string): Promise<void> | void {
        if (value == null || value.length == 0) {
            return Promise.resolve();
        }

        if (!/^[\x21-\x7E]+$/.test(value)) {
            return reject('Value contains not allowed chars');
        }

        if (value.length < 8) {
            return reject('Minimal length of the field is 8');
        }

        if (value.length > 20) {
            return reject('Maximal length of the field is 20');
        }

        if (!/\d/.test(value)) {
            return reject('Value should contain at least 1 digit');
        }

        if (!/[a-z]/.test(value)) {
            return reject('Value should contain at least 1 lowercase letter');
        }

        if (!/[A-Z]/.test(value)) {
            return reject('Value should contain at least 1 uppercase letter');
        }

        return Promise.resolve();
    },
});

export const timeRequired = (message = 'Поле обязательно'): Rule => ({
    required: true,
    message,
    validator(rule, value: any | undefined): Promise<void> | void {
        const time = value.format('HH:mm');

        if (time && time.trim().length > 0) {
            return Promise.resolve();
        }

        return reject(message ?? 'Поле обязательно');
    },
});

export const emailValidator = (message?: string): Rule => ({
    validator(rule, value: string | undefined): Promise<void> | void {
        if (!value) {
            return reject(message ?? 'Пожалуйста, введите корректный email');
        }
        // eslint-disable-next-line max-len
        const emailRegExp = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        const isEmailValid = emailRegExp.test(String(value).toLowerCase());

        if (!isEmailValid) {
            return reject(message ?? 'Пожалуйста, введите корректный email');
        }

        return Promise.resolve();
    },
});

export const usernameValidator = (): Rule => ({
    validator(rule, value: string): Promise<void> | void {
        if (value == null) {
            return reject('Логин должен содержать от 5 до 20 символов');
        }

        if (value.length < 5 || value.length > 20) {
            return reject('Логин должен содержать от 5 до 20 символов');
        }
        if (!/^[A-Za-z0-9._-]+$/.test(value)) {
            return reject('Логин должен содержать только латинские буквы, цифры и символы. - _');
        }

        return Promise.resolve();
    },
});

export const trueValidator = (value: () => boolean, message?: string): Rule => ({
    validator(): Promise<void> | void {
        if (value() === true) {
            return Promise.resolve();
        }

        return reject(message ?? 'Ожидалось true');
    },
});

export const phoneValidator = (message?: string): Rule => ({
    validator(rule, value: string | undefined): Promise<void> | void {
        if (!value) {
            return reject(message ?? 'Пожалуйста, введите корректный телефонный номер');
        }

        const emailRegExp = /^\+375 \((17|29|33|44|25)\) [0-9]{3}-[0-9]{2}-[0-9]{2}$/;
        const isEmailValid = emailRegExp.test(String(value).toLowerCase());

        if (!isEmailValid) {
            return reject(message ?? 'Пожалуйста, введите корректный телефонный номер');
        }

        return Promise.resolve();
    },
});

export const minValueValidator = (minValue: number, message?: string): Rule => ({
    validator(rule, value: string | undefined): Promise<void> | void {
        if (value == null) {
            return Promise.resolve();
        }

        if (Number(value) < minValue) {
            return reject(message ?? `Минимальное значение для данного поля ${minValue}`);
        }

        return Promise.resolve();
    },
});

export const maxValueValidator = (maxValue: number, message?: string): Rule => ({
    validator(rule, value: string | undefined): Promise<void> | void {
        if (value == null) {
            return Promise.resolve();
        }

        if (Number(value) > maxValue) {
            return reject(message ?? `Максимальное значение для данного поля ${maxValue}`);
        }

        return Promise.resolve();
    },
});

