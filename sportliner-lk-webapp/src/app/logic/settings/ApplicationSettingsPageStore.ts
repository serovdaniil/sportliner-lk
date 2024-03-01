import {settingsApi} from "app/service/Apis";
import {action, computed, makeObservable, observable, toJS} from 'mobx';
import {PaymentSettings, PriceItemType} from "../../../api";

export class ApplicationSettingsPageStore {

    @observable
    private _paymentSettings: Partial<PaymentSettings>;

    constructor() {
        this._paymentSettings = {};

        makeObservable(this);
    }

    get pageTitle(): string {
        return "Настройки приложения";
    }

    @computed
    get paymentSettings(): Partial<PaymentSettings> {
        return this._paymentSettings;
    }

    @action.bound
    updateCurrentPrice(type: PriceItemType, value: number, benefits: boolean): void {
        this._paymentSettings.currentPrice?.forEach(it => {
            if (it.type === type) {
                if (benefits) {
                    it.benefitsPrice = value;
                } else {
                    it.normalPrice = value;
                }
            }
        })
    }

    @action.bound
    updatePrevPrice(type: PriceItemType, value: number, benefits: boolean): void {
        this._paymentSettings.prevPrice?.forEach(it => {
            if (it.type === type) {
                if (benefits) {
                    it.benefitsPrice = value;
                } else {
                    it.normalPrice = value;
                }
            }
        })
    }

    @action.bound
    async loadDate(): Promise<void> {
        this._paymentSettings = await settingsApi.getPaymentSettings();
    }

    async save(): Promise<void> {
        await settingsApi.updatePaymentSettings({
            paymentSettings: {
                usePrevPrice: this.paymentSettings.usePrevPrice!,
                currentPrice: this.paymentSettings.currentPrice!,
                prevPrice: this.paymentSettings.prevPrice!
            }
        });
    }

}
