import {Button, Card, Col, Row, Space, Typography} from 'antd';
import {ChildInfo} from 'api';
import {observer} from 'mobx-react';
import React, {FC} from 'react';
import {useNavigator} from "../Navigator";
import {AppRoutes} from "../../AppRoutes";

interface Props {
    children: ChildInfo[] | undefined;
}

const ChildrenDescriptionsPanel: FC<Props> = (props: Props) => {
    const navigator = useNavigator();

    if (!props.children) {
        return (<Space/>);
    }

    return (
        <Row className="dp-row">
            <Space direction={"vertical"}>
                <Typography.Title level={5}>Дети</Typography.Title>

                <Row gutter={{ xs: 8, sm: 16, md: 24, lg: 32 }}>
                    {props.children.map(it =>
                        <Col span={12}>
                            <Card title={it.fullName} bordered={true}>
                                <Button
                                    type="link"
                                    onClick={() => navigator.safeNavigate(AppRoutes.childEditPage.toUrl({childId: it.id}))}
                                >
                                    Подробнее
                                </Button>
                            </Card>
                        </Col>
                    )}
                </Row>
            </Space>
        </Row>
    )
};

export default observer(ChildrenDescriptionsPanel);
