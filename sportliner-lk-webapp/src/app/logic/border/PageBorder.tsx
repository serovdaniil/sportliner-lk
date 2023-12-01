import {Typography} from 'antd';
import Layout, {Content} from 'antd/lib/layout/layout';
import {requestHandlerStore} from 'app/App';
import LoadingOverlay from 'app/components/LoadingOverlay/LoadingOverlay';
import PageHeader from 'app/logic/border/PageHeader';
import AuthorizedPageHeader from 'app/logic/border/PageHeader';
import {observer} from 'mobx-react';
import React, {PropsWithChildren} from 'react';

type PageBorderProps = {
    className?: string;
    title?: React.ReactNode;
    isLoading?: boolean;
    hiddenContentBeforeLoading?: boolean;
    content?: React.ReactNode;
    dependsOnPeriod?: boolean;
};

/**
 * Authorized page template
 */
const PageBorder: React.FC<PropsWithChildren<PageBorderProps>> = ({
    className,
    title,
    isLoading = false,
    hiddenContentBeforeLoading = false,
    children,
    content,
    dependsOnPeriod = false
}: PropsWithChildren<PageBorderProps>) => (
    <Layout className={className} style={{minHeight: '100vh'}}>

        <LoadingOverlay
            isVisible={requestHandlerStore.isRequestWithBlockingUIProcess}
        />
            <PageHeader
                isLoading={isLoading}
                dependsOnPeriod={dependsOnPeriod}
                content={(
                    <div className="dp-subheader" hidden={!title}>
                        {typeof title === 'string' ? (
                            <Typography.Title
                                level={4}
                                style={{marginBottom: 0, display: 'inline-block'}}
                            >
                                {title}
                            </Typography.Title>
                        ) : (title)}
                        {content}
                    </div>
                )}
            />
            <Content className="dp-content-block">

                <div className="dp-content">

                    {hiddenContentBeforeLoading ? !isLoading && children : children}
                </div>
            </Content>

    </Layout>
);

export default observer(PageBorder);
