import {UserAccount, UserRole} from 'api';
import {action, makeObservable, observable, toJS} from 'mobx';
import {ChildAttributes} from "./ChildAttributes";
//
// interface UserAttributesValues {
//     id?: string;
//     username?: string;
//     password?: string;
//     passwordMustBeChanged?: boolean;
//     role?: UserRole;
//     email?: string;
//     phone?: string;
//     lastName?: string;
//     firstName?: string;
//     patronymic?: string;
//     payAttention?: boolean;
//     reason?: string;
//     children: Child[];
//     createTimestamp?: Date;
//     updateTimestamp?: Date
//     loginTimestamp?: Date;
// }

export class UserAttributes {

    private readonly _id?: string;
    private readonly _updateTimestamp?: Date;
    private readonly _createTimestamp?: Date;
    private readonly _loginTimestamp?: Date;

    @observable
    private _username?: string;

    @observable
    private _email?: string;

    @observable
    private _firstName?: string;

    @observable
    private _lastName?: string;

    @observable
    private _password?: string;

    @observable
    private _passwordMustBeChanged: boolean;

    @observable
    private _patronymic?: string;

    @observable
    private _payAttention: boolean;

    @observable
    private _phone?: string;

    @observable
    private _reason?: string;

    @observable
    private _role?: UserRole;

    @observable
    private _children: ChildAttributes[];

    constructor(values?: Partial<UserAccount>) {
        this._id = values?.id;
        this._createTimestamp = values?.createTimestamp;
        this._loginTimestamp = values?.loginTimestamp;
        this._updateTimestamp = values?.updateTimestamp;
        this._username = values?.username;
        this._password = values?.password;
        this._passwordMustBeChanged = values?.passwordMustBeChanged || false;
        this._lastName = values?.lastName;
        this._firstName = values?.firstName;
        this._patronymic = values?.patronymic;
        this._role = values?.role;
        this._email = values?.email;
        this._phone = values?.phone;
        this._payAttention = values?.payAttention || false;
        this._reason = values?.reason;
        this._children = values?.children?.map(it => new ChildAttributes(it)) || [];

        makeObservable(this);
    }

    get username(): string | undefined {
        return this._username;
    }

    @action.bound
    public setUsername(value: string | undefined) {
        this._username = value;
    }

    get id(): string | undefined {
        return this._id;
    }

    get updateTimestamp(): Date | undefined {
        return this._updateTimestamp;
    }

    get createTimestamp(): Date | undefined {
        return this._createTimestamp;
    }

    get loginTimestamp(): Date | undefined {
        return this._loginTimestamp;
    }

    get email(): string | undefined {
        return this._email;
    }

    @action.bound
    public setEmail(value: string | undefined) {
        this._email = value;
    }

    get firstName(): string | undefined {
        return this._firstName;
    }

    @action.bound
    public setFirstName(value: string | undefined) {
        this._firstName = value;
    }

    get lastName(): string | undefined {
        return this._lastName;
    }

    @action.bound
    public setLastName(value: string | undefined) {
        this._lastName = value;
    }

    get password(): string | undefined {
        return this._password;
    }

    @action.bound
    public setPassword(value: string | undefined) {
        this._password = value;
    }

    get passwordMustBeChanged(): boolean {
        return this._passwordMustBeChanged;
    }

    @action.bound
    public setPasswordMustBeChanged(value: boolean) {
        this._passwordMustBeChanged = value;
    }

    get patronymic(): string | undefined {
        return this._patronymic;
    }

    @action.bound
    public setPatronymic(value: string | undefined) {
        this._patronymic = value;
    }

    get payAttention(): boolean {
        return this._payAttention;
    }

    @action.bound
    public setPayAttention(value: boolean) {
        this._payAttention = value;
    }

    get phone(): string | undefined {
        return this._phone;
    }

    @action.bound
    public setPhone(value: string | undefined) {
        this._phone = value;
    }

    get reason(): string | undefined {
        return this._reason;
    }

    @action.bound
    public setReason(value: string | undefined) {
        this._reason = value;
    }

    get role(): UserRole | undefined {
        return this._role;
    }

    @action.bound
    public setRole(value: UserRole | undefined) {
        this._role = value;
    }

    get children(): ChildAttributes[] {
        return this._children;
    }

    @action.bound
    public setChildren(value: ChildAttributes[]) {
        this._children = value;
    }

    @action.bound
    public addChild() {
        this._children.push(new ChildAttributes());
    }

    @action.bound
    public deleteChild(index: number) {
        this._children.splice(index, 1);
    }

    toJson(): UserAccount {
        return {
            id: toJS(this._id!),
            username: toJS(this._username!),
            password: toJS(this._password!),
            passwordMustBeChanged: toJS(this._passwordMustBeChanged!),
            role: toJS(this._role!),
            email: toJS(this._email!),
            phone: toJS(this._phone!),
            lastName: toJS(this._lastName!),
            firstName: toJS(this._firstName!),
            patronymic: toJS(this._patronymic!),
            payAttention: toJS(this._payAttention!),
            reason: toJS(this._reason!),
            children: toJS(this._children.map(it => it.toJson())),
            createTimestamp: toJS(this._createTimestamp!),
            loginTimestamp: toJS(this._loginTimestamp!),
            updateTimestamp: toJS(this._updateTimestamp!)
        }
    }

}
