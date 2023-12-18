export default class ObjectUtils {

    static removeUndefined<T extends {}>(obj: T): T {
        const newObj: T = {...obj};

        Object.keys(obj).forEach((key) => {
            if (obj[key as keyof T] === Object(obj[key as keyof T])) {
                newObj[key as keyof T] = this.removeUndefined(Object(obj[key as keyof T]));
            } else if (obj[key as keyof T] === undefined) {
                delete newObj[key as keyof T]
            }
        });
        return newObj;
    }

    static removeEmptyString<T extends {}>(obj: T): T {
        const newObj: T = {...obj};

        Object.keys(newObj).forEach((key) => {
            if (newObj[key as keyof T] === Object(newObj[key as keyof T])) {
                newObj[key as keyof T] = this.removeEmptyString(Object(newObj[key as keyof T]));
            } else if (newObj[key as keyof T] as unknown === '') {
                delete newObj[key as keyof T];
            }
        });
        return newObj;
    }

}
