import {Button, Row, Select, Space, Typography} from 'antd';
import {requestHandlerStore} from 'app/App';
import LoadingBlock from "app/components/LoadingBlock/LoadingBlock";
import PageBorder from 'app/logic/border/PageBorder';
import {useNavigator} from "app/logic/Navigator";

import {observer, useLocalObservable} from 'mobx-react';
import React, {FC, useEffect, useState} from 'react';
import {branchOfficeItemStore} from "../store/Catalog/BranchOfficeItemStore";
import {AnalysisPageStore} from "./AnalysisPageStore";
import LocalDatePicker from "../../components/LocalDatePicker/LocalDatePicker";
import ColumnChart from "../../components/Chart/ColumnChart";

interface Props {
}

const AnalysisPage: FC<Props> = (props: Props) => {
    const [init, setInit] = useState(false);
    const store: AnalysisPageStore = useLocalObservable(() => new AnalysisPageStore());
    const navigator = useNavigator();

    useEffect(() => {
        (async () => {
            await requestHandlerStore.initializePage(async () => {
                await store.init();

                setInit(true);
            });
        })();
    }, []);

    const goBack = () => {
        navigator.safeNavigate(-1);
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

                    <Typography.Text>Фильтр</Typography.Text>
                    <Space direction={"horizontal"} className={"dp-filter"}>


                        <Typography.Text>Филиал: </Typography.Text>

                        <Select
                            value={store.branchOffice?.id}
                            onChange={(value) => {
                                const branchOffice = branchOfficeItemStore.getById(value);

                                store.setBranchOffice(branchOffice);
                            }}
                            style={{maxWidth: '30vw'}}
                        >
                            {branchOfficeItemStore.available.map((branchOffice) => {
                                return (
                                    <Select.Option
                                        key={branchOffice.id}
                                        value={branchOffice.id}
                                    >
                                        {branchOffice.address}
                                    </Select.Option>
                                )
                            })}
                        </Select>


                        <Typography.Text>Дата: </Typography.Text>

                        <LocalDatePicker
                            placeholder={"Дата"}
                            value={store.date}
                            onChange={value => store.setDate(value)}
                        />

                    </Space>
                </Space>
            </Row>

            <Row className="dp-row">
                <Space direction={"vertical"}>
                    <Space direction={"vertical"}>
                        <Typography.Title level={5}>
                            Средняя посещаемость занятий в день: {store.averageAttendance}
                        </Typography.Title>

                        <Typography.Title level={5}>
                            Общей количество детей: {store.countAttendances()}
                        </Typography.Title>
                    </Space>

                    <Space direction={"vertical"}>
                        <Typography.Title level={5}> Количество посещений: </Typography.Title>

                        <ColumnChart
                            items={Array.from(store.attendanceByTime.entries())
                                .map(([time, count]) => {
                                    return {
                                        name: time,
                                        value: count
                                    }
                                })
                            }
                        />
                    </Space>
                </Space>
            </Row>

        </PageBorder>
    );
};

export default observer(AnalysisPage);
