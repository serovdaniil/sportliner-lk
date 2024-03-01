import {Button, Checkbox, Collapse, Form, Row, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from "app/logic/Navigator";

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {ApplicationSettingsPageStore} from "./ApplicationSettingsPageStore";
import PriceTable from "./PriceTable";
import AppNotification from "../notification/AppNotification";

const {Panel} = Collapse;

interface Props {
}

const ApplicationSettingsPage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState(false);
    const store: ApplicationSettingsPageStore = useLocalObservable(() => new ApplicationSettingsPageStore());
    const navigator = useNavigator();
    const [form] = Form.useForm();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.loadDate();

                setInit(true);
            });
        })();
    }, []);

    const goBack = () => {
        navigator.safeNavigate(-1);
    }

    const onSave = async () => {
        await store.save();

        AppNotification.success('Изменения сохранены');
    }

    if (!init) {
        return (
            <PageBorder
                title={store.pageTitle}
                isLoading
            >
                <LoadingBlock/>
            </PageBorder>
        );
    }

    return (
        <PageBorder
            title={store.pageTitle}
            content={(
                <Space style={{float: 'right'}}>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={onSave}
                        style={{background: '#0f2d77'}}
                    >
                        Сохранить
                    </Button>
                    <Button
                        className="dp-button"
                        type="primary"
                        onClick={goBack}
                        style={{background: '#0f2d77'}}
                    >
                        Назад
                    </Button>
                </Space>
            )}
        >
            <Row justify="space-between" className="dp-row">
                <Space direction={"vertical"}>
                    <Typography.Title level={5}>Настройки системы оплат</Typography.Title>

                    <Form
                        form={form}
                        autoComplete="off"
                        layout="horizontal"
                        initialValues={{
                            name: store.paymentSettings.usePrevPrice,
                        }}
                    >
                        <Form.Item
                            name="usePrevPrice"
                            label="Использовать предыдущий прайс:"
                        >
                            <Checkbox
                                checked={store.paymentSettings.usePrevPrice}
                                onChange={event => store.paymentSettings.usePrevPrice = event.target.checked}
                            />
                        </Form.Item>
                    </Form>
                    <Collapse accordion style={{width: "35vw"}}>

                        <Panel
                            header={'Текущая стоимость занятий'}
                            key={'currentPrice'}
                        >

                            <PriceTable
                                content={store.paymentSettings.currentPrice!}
                                onUpdatePrice={store.updateCurrentPrice}
                            />

                        </Panel>

                        <Panel
                            header={'Предыдущая стоимость занятий'}
                            key={'prevPrice'}
                        >

                            <PriceTable
                                content={store.paymentSettings.prevPrice!}
                                onUpdatePrice={store.updatePrevPrice}
                            />

                        </Panel>

                    </Collapse>

                </Space>

            </Row>

        </PageBorder>
    );
};

export default observer(ApplicationSettingsPage);
