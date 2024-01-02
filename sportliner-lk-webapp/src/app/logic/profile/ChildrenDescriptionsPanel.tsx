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
        <Row className="dp-row" gutter={16}>

            <Typography.Text>Дети</Typography.Text>

            <Row gutter={16}>
                {props.children.map(it =>
                    <Col span={8}>
                        <Card title={it.fullName} bordered={false}>
                            <Button
                                type="link"
                                onClick={() => navigator.safeNavigate(AppRoutes.childEditPage.toUrl({childId: it.id}))}
                            >
                                Изменить
                            </Button>
                        </Card>
                    </Col>
                )}
            </Row>
        </Row>
    )
};

export default observer(ChildrenDescriptionsPanel);
