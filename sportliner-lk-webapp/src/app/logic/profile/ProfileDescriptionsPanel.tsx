import {Button, Descriptions, Divider, Row, Space, Typography} from 'antd';
import DescriptionsItem from 'antd/es/descriptions/Item';
import {UserProfile} from 'api';
import {changePasswordInModal} from 'app/logic/profile/ChangePasswordForm';
import {observer} from 'mobx-react';
import React, {FC} from 'react';

interface Props {
    profile: UserProfile;
}

const ProfileDescriptionsPanel: FC<Props> = (props: Props) => {
    const profile = props.profile;

    const handleChangePassword = () => {
        changePasswordInModal(profile);
    }

    return (
        <Row className="dp-row">

            <Space direction={"vertical"}>
                <Typography.Text>Персональные данные</Typography.Text>
                <Descriptions size={"small"} layout={"vertical"} column={2} style={{width: 500}}>

                    <DescriptionsItem label="Логин">{profile.username}</DescriptionsItem>

                    <DescriptionsItem label="Пароль">
                        <Space>
                            <Typography.Text>*********</Typography.Text>
                            <Divider type={"vertical"}/>
                            <Button type="link" onClick={handleChangePassword}>Изменить пароль</Button>
                        </Space>
                    </DescriptionsItem>

                    <DescriptionsItem
                        label="Имя">{profile.lastName} {profile.firstName} {profile.patronymic}</DescriptionsItem>

                    <DescriptionsItem label="Email">{profile.email}</DescriptionsItem>

                    <DescriptionsItem label="Контактный телефон">{profile.phone}</DescriptionsItem>

                </Descriptions>
            </Space>
        </Row>
    )
};

export default observer(ProfileDescriptionsPanel);
