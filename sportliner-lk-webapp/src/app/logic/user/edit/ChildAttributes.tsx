import {BranchOfficeItem, Child, PayingEntity, PaymentType, Tariff} from 'api';
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
    tariff?: Tariff;
    tuitionBalance?: number;
    paymentType?: PaymentType;
    benefits?: boolean;
    invoiceNumber?: string;
    payingEntity?: PayingEntity;
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
    private _tariff?: Tariff;

    @observable
    private _paymentType?: PaymentType;

    @observable
    private _benefits: boolean;

    @observable
    private _invoiceNumber?: string;

    @observable
    private _payingEntity?: PayingEntity;


    constructor(values?: ChildAttributesValues) {
        this._id = values?.id;
        this._lastName = values?.lastName;
        this._firstName = values?.firstName;
        this._patronymic = values?.patronymic;
        this._birthdate = values?.birthdate;
        this._branchOffice = values?.branchOffice;
        this._diagnosis = values?.diagnosis;
        this._notes = values?.notes;
        this._tariff = values?.tariff;
        this._tuitionBalance = values?.tuitionBalance;
        this._paymentType = values?.paymentType;
        this._benefits = values?.benefits || false;
        this._invoiceNumber = values?.invoiceNumber;
        this._payingEntity = values?.payingEntity;

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

    get tariff(): Tariff | undefined {
        return this._tariff;
    }


    get paymentType(): PaymentType | undefined {
        return this._paymentType;
    }


    get benefits(): boolean | undefined {
        return this._benefits;
    }


    get invoiceNumber(): string | undefined {
        return this._invoiceNumber;
    }

    get payingEntity(): PayingEntity | undefined {
        return this._payingEntity;
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
    updateTariff(value?: Tariff) {
        this._tariff = value;
    }

    @action.bound
    updatePaymentType(value: PaymentType) {
        this._paymentType = value;
    }

    @action.bound
    updateBenefits(value: boolean) {
        this._benefits = value;
    }

    @action.bound
    updateInvoiceNumber(value: string) {
        this._invoiceNumber = value;
    }

    @action.bound
    updatePayingEntity(value: PayingEntity) {
        this._payingEntity = value;
    }

    isValid(): boolean {
        return this._lastName != null
            && this._firstName != null
            && this._patronymic != null
            && this._birthdate != null
            && this._diagnosis != null
            && this._branchOffice != null
            && this._tuitionBalance != null
            && this._tariff != null
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
            tariff: toJS(this._tariff!),
            paymentType: toJS(this._paymentType!),
            invoiceNumber: toJS(this._invoiceNumber),
            benefits: toJS(this.benefits!),
            payingEntity: toJS(this._payingEntity!)
        }
    }

}
