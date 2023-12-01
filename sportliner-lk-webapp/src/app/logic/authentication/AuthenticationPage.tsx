import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Form, Image, Input, InputRef, Modal, Row, Space, Typography} from 'antd';
import {AuthResponse, AuthResponseStatus} from 'api';
import {AuthCredentials} from 'api/models/AuthCredentials';
import {auth, sessionStorageWorker} from 'app/App';
import backgroundImage from 'app/assets/auth-background.jpg';
import {requiredValidator} from 'app/logic/Validators';
import ValidateItemState from 'app/model/ValidateItemState';
import {authApi} from 'app/service/Apis';
import AuthenticationException from "app/service/exceptions/AuthenticationException";
import {observer} from 'mobx-react';
import React, {useState} from 'react';

/**
 * Authentication page
 */
const AuthenticationPage: React.FC = () => {
    const [modal, modalContext] = Modal.useModal();
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
                errorMessage: 'User with such login and password not found',
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

            {modalContext}

            {step === 'login' && loginForm}

        </Space>
    );
};

export default observer(AuthenticationPage);
