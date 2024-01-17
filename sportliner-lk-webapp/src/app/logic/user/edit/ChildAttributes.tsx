import {BranchOfficeItem, Child, PaymentType} from 'api';
import {action, makeObservable, observable, toJS} from 'mobx';

interface ChildAttributesValues {
    id?: string;
    lastName?: string;
    firstName?: string;
    patronymic?: string;
    birthdate?: string;
    branchOffice?: BranchOfficeItem;
    diagnosis?: string;
    notes?: string;
    numberClassesPerMonth?: number;
    tuitionBalance?: number;
    paymentType?: PaymentType;
}

export class ChildAttributes implements ChildAttributesValues {

    private readonly _id?: string;

    @observable
    private _lastName?: string;

    @observable
    private _firstName?: string;

    @observable
    private _patronymic?: string;

    @observable
    private _birthdate?: string;

    @observable
    private _branchOffice?: BranchOfficeItem;

    @observable
    private _diagnosis?: string;

    @observable
    private _notes?: string;

    @observable
    private _tuitionBalance?: number;

    @observable
    private _numberClassesPerMonth?: number;

    @observable
    private _paymentType?: PaymentType;

    constructor(values?: ChildAttributesValues) {
        this._id = values?.id;
        this._lastName = values?.lastName;
        this._firstName = values?.firstName;
        this._patronymic = values?.patronymic;
        this._birthdate = values?.birthdate;
        this._branchOffice = values?.branchOffice;
        this._diagnosis = values?.diagnosis;
        this._notes = values?.notes;
        this._numberClassesPerMonth = values?.numberClassesPerMonth;
        this._tuitionBalance = values?.tuitionBalance;
        this._paymentType = values?.paymentType;

        makeObservable(this);
    }

    get id(): string | undefined {
        return this._id;
    }

    get lastName(): string | undefined {
        return this._lastName;
    }

    get firstName(): string | undefined {
        return this._firstName;
    }

    get patronymic(): string | undefined {
        return this._patronymic;
    }

    get birthdate(): string | undefined {
        return this._birthdate;
    }

    get branchOffice(): BranchOfficeItem | undefined {
        return this._branchOffice;
    }

    get diagnosis(): string | undefined {
        return this._diagnosis;
    }

    get notes(): string | undefined {
        return this._notes;
    }

    get tuitionBalance(): number | undefined {
        return this._tuitionBalance;
    }

    get numberClassesPerMonth(): number | undefined {
        return this._numberClassesPerMonth;
    }


    get paymentType(): PaymentType | undefined {
        return this._paymentType;
    }

    @action.bound
    updateLastName(value?: string) {
        this._lastName = value;
    }

    @action.bound
    updateFirstName(value?: string) {
        this._firstName = value;
    }

    @action.bound
    updatePatronymic(value?: string) {
        this._patronymic = value;
    }

    @action.bound
    updateBirthdate(value?: string) {
        this._birthdate = value;
    }

    @action.bound
    updateBranchOffice(value?: BranchOfficeItem) {
        this._branchOffice = value;
    }

    @action.bound
    updateDiagnosis(value?: string) {
        this._diagnosis = value;
    }

    @action.bound
    updateNotes(value?: string) {
        this._notes = value;
    }

    @action.bound
    updateTuitionBalance(value?: number) {
        this._tuitionBalance = value;
    }

    @action.bound
    updateNumberClassesPerMonth(value?: number) {
        this._numberClassesPerMonth = value;
    }

    @action.bound
    updatePaymentType(value: PaymentType) {
        this._paymentType = value;
    }

    isValid(): boolean {
        return this._lastName != null
            && this._firstName != null
            && this._patronymic != null
            && this._birthdate != null
            && this._diagnosis != null
            && this._branchOffice != null
            && this._tuitionBalance != null
            && this._numberClassesPerMonth != null
            && this._paymentType != null;
    }

    toJson(): Child {
        return {
            id: toJS(this._id!),
            lastName: toJS(this._lastName!),
            firstName: toJS(this._firstName!),
            patronymic: toJS(this._patronymic!),
            birthdate: toJS(this._birthdate!),
            branchOffice: toJS(this._branchOffice!),
            diagnosis: toJS(this._diagnosis!),
            notes: toJS(this._notes!),
            tuitionBalance: toJS(this._tuitionBalance!),
            numberClassesPerMonth: toJS(this._numberClassesPerMonth!),
            paymentType: toJS(this._paymentType!)
        }
    }

}
