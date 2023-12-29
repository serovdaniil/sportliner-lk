import {LogoutOutlined, UserOutlined} from '@ant-design/icons';
import {Avatar, Button, Divider, Dropdown, Image, Layout, Menu, Row, Space, Typography} from 'antd';
import {auth} from 'app/App';
import logo from 'app/assets/logo.png';
import {MainMenu} from 'app/logic/border/MainMenu';
import {useNavigator} from 'app/logic/Navigator';
import {observer} from 'mobx-react';
import NProgress from 'nprogress';
import React, {useEffect} from 'react';
import {AppRoutes} from "../../AppRoutes";

NProgress.configure({showSpinner: false});

interface AuthorizedPageHeaderProps {
    isLoading: boolean;
    content: React.ReactNode;
    dependsOnPeriod: boolean;
}

/**
 * Authorized page header
 */
const PageHeader: React.FC<AuthorizedPageHeaderProps> = (props: AuthorizedPageHeaderProps) => {

    const navigator = useNavigator();

    const logout = async () => {
        await auth.logout();

    };


    const dropDown = (
        <Menu>
            <Menu.Item
                key="1"
                onClick={logout}
                icon={<LogoutOutlined/>}
            >
                <Typography.Text>Выйти из личного кабинета</Typography.Text>
            </Menu.Item>
            <Menu.Item
                key="2"
                onClick={() => navigator.safeNavigate(AppRoutes.profilePage.toUrl())}
                icon={<LogoutOutlined/>}
            >
                <Typography.Text>Профиль</Typography.Text>
            </Menu.Item>
        </Menu>
    );

    useEffect(() => {
        if (props.isLoading && !NProgress.isStarted()) {
            NProgress.start();
        } else if (!props.isLoading) {
            NProgress.done();
        }

        return () => {
            NProgress.done();
        };
    }, [props.isLoading]);

    return (
        <Layout.Header className="dp-header" id="dp-header" style={{zIndex: 1000}}>
            <Row justify="space-between" style={{width: '100%'}}>
                <Row align="middle">
                    <Image src={logo} preview={false}/>
                </Row>

                <Typography.Title level={1} style={{color: '#013A7B'}}>
                    Личный кабинет Sportliner
                </Typography.Title>

                <Space>
                    {auth.isAuth && (
                        <Dropdown overlay={dropDown} trigger={['click']} placement="bottomCenter">
                            <div title={auth.userInfo?.username}>
                                <Space align="center" className="dp-hover">

                                    <Typography.Text className="dp-regular-text">
                                        {auth.userInfo?.firstName}
                                        &nbsp;
                                        {auth.userInfo?.lastName}
                                    </Typography.Text>

                                    <Avatar icon={<UserOutlined/>} alt={auth.userInfo?.username}/>
                                </Space>
                            </div>
                        </Dropdown>
                    )}

                </Space>

                <Space align="center"/>

            </Row>

            <Divider style={{margin: 0}}/>

            {props.content}

            <MainMenu/>
        </Layout.Header>
    );
};

export default observer(PageHeader);
