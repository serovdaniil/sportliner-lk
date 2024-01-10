import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Form, Input, InputRef, Row, Space, Typography} from 'antd';
import {AuthResponse, AuthResponseStatus, LoginWithChangePasswordRequest} from 'api';
import {AuthCredentials} from 'api/models/AuthCredentials';
import {auth, sessionStorageWorker} from 'app/App';
import backgroundImage from 'app/assets/auth-background.jpg';
import {passwordValidator, requiredValidator} from 'app/logic/Validators';
import ValidateItemState from 'app/model/ValidateItemState';
import {authApi} from 'app/service/Apis';
import AuthenticationException from "app/service/exceptions/AuthenticationException";
import {observer} from 'mobx-react';
import React, {useState} from 'react';
import BackgroundImage from "../../components/BackgroundImage/BackgroundImage";

/**
 * Authentication page
 */
const AuthenticationPage: React.FC = () => {
    const [form] = Form.useForm();
    const passwordRef = React.createRef<InputRef>();
    const [step, setStep] = React.useState('login');
    const [creds, setCreds] = React.useState<AuthCredentials>({
        username: '',
        password: '',
    });

    const [authResponseStatus, setAuthResponseStatus] = useState<ValidateItemState>({
        status: '',
        errorMessage: null,
    });

    const resetToStep = (stepId: string) => {
        setStep(stepId);
        setAuthResponseStatus({status: '', errorMessage: null});
    };

    const handleError = (error: AuthenticationException) => {
        if (step === 'login') {
            form.setFieldsValue({password: undefined});
            passwordRef.current!.focus();
        }

        if (error instanceof AuthenticationException) {
            setAuthResponseStatus({
                status: 'error',
                errorMessage: 'Пользователь с таким логином и паролем не найден',
            });
        }
    };

    const sendAuthRequest = async (authCredentials: AuthCredentials) => {
        try {
            const response: AuthResponse = await authApi.login({
                authCredentials: {
                    username: authCredentials.username,
                    password: authCredentials.password,
                },
            });

            if (response.status === AuthResponseStatus.SUCCESS) {
                auth.authenticated(response);
                sessionStorageWorker.clearAutoLogout();
            }

            if (response.status === AuthResponseStatus.MUST_CHANGE_PASSWORD) {
                setCreds(authCredentials);
                resetToStep('changePassword');
            }
        } catch (response: any) {
            if (response instanceof AuthenticationException) {
                await handleError(response);
            } else {
                throw response;
            }
        }
    };

    const sendPasswordChange = async (data: { newPassword: string, newPasswordConfirm: string }) => {
        setAuthResponseStatus({
            status: '',
            errorMessage: null,
        });

        if (data.newPassword !== data.newPasswordConfirm) {
            setAuthResponseStatus({
                status: 'error',
                errorMessage: 'Passwords don’t match',
            });
            return;
        }

        try {
            const request: LoginWithChangePasswordRequest = {
                authChangePassword: {
                    username: creds.username,
                    oldPassword: creds.password,
                    newPassword: data.newPassword,
                },
            };
            const response: AuthResponse = await authApi.loginWithChangePassword(request);

            if (response.status === AuthResponseStatus.SUCCESS) {
                auth.authenticated(response);
            }
        } catch (response: any) {
            if (response instanceof AuthenticationException) {
                await handleError(response);
            } else {
                throw response;
            }
        }
    };

    const highlightFields = () => {
        setAuthResponseStatus({
            status: 'error',
            errorMessage: null,
        });
    };

    const loginForm = (
        <Form
            form={form}
            name="normal_login"
            className="dp-auth-form"
            onFinish={sendAuthRequest}
            onFinishFailed={highlightFields}
            autoComplete="off"
        >
            <Space direction="vertical">
                <Row justify="center">
                </Row>

                <Form.Item
                    name="username"
                    validateStatus={authResponseStatus.status}
                    rules={[requiredValidator()]}
                >
                    <Input
                        prefix={<UserOutlined className="site-form-item-icon"/>}
                        placeholder="Username"
                        autoComplete="username"
                        autoFocus
                    />
                </Form.Item>

                <Form.Item
                    name="password"
                    validateStatus={authResponseStatus.status}
                    help={authResponseStatus.errorMessage}
                    rules={[requiredValidator()]}
                >
                    <Input.Password
                        ref={passwordRef}
                        prefix={<LockOutlined className="site-form-item-icon"/>}
                        placeholder="Password"
                        autoComplete="current-password"
                    />
                </Form.Item>

                {sessionStorageWorker.checkIfWasAutoLogout() && (
                    <Typography.Text style={{color: "#ff4d4f"}}>
                        You've been logged out due to inactivity.
                    </Typography.Text>
                )}

                <Form.Item className="login-button">
                    <Button
                        className="dp-button"
                        type="primary"
                        htmlType="submit"
                        style={{width: '100%'}}
                    >
                        Log in
                    </Button>
                </Form.Item>
            </Space>
        </Form>
    );

    const changePasswordForm = (
        <Form
            form={form}
            name="normal_login"
            className="dp-auth-form"
            onFinish={sendPasswordChange}
            onFinishFailed={highlightFields}
            autoComplete="off"
        >

            <Space
                align="center"
                direction="vertical"
            >

                <p>Вы должны определить свой новый пароль</p>

            </Space>

            <Input
                name="username"
                value={creds?.username}
                style={{display: 'none'}}
                hidden
            />

            <Form.Item
                name="newPassword"
                validateStatus={authResponseStatus.status}
                rules={[requiredValidator(), passwordValidator()]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    placeholder="Новый пароль"
                    autoComplete="new-password"
                    autoFocus
                />
            </Form.Item>

            <Form.Item
                name="newPasswordConfirm"
                validateStatus={authResponseStatus.status}
                help={authResponseStatus.errorMessage}
                rules={[requiredValidator()]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    placeholder="Повторите новый пароль"
                    autoComplete="new-password"
                />
            </Form.Item>

            <Form.Item className="login-button">
                <Button
                    className="dp-button"
                    type="primary"
                    htmlType="submit"
                    style={{width: '50%'}}
                >
                    Войти
                </Button>
                <Button
                    className="dp-button"
                    type="default"
                    htmlType="button"
                    style={{width: '50%'}}
                    onClick={() => resetToStep('login')}
                >
                    Вернуться
                </Button>
            </Form.Item>
        </Form>
    );

    return (
        <Space
            style={{
                justifyContent: 'center',
                minHeight: '100vh',
                minWidth: '100vw',
            }}
            direction="vertical"
            align="center"
        >

            <Space>
                <BackgroundImage src={backgroundImage}/>
            </Space>

            {step === 'login' && loginForm}
            {step === 'changePassword' && changePasswordForm}

        </Space>
    );
};

export default observer(AuthenticationPage);
