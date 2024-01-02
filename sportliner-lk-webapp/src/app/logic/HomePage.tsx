import {Button, Space, Typography} from 'antd';
import AuthorizedBorder from 'app/logic/border/PageBorder';

const HomePage: React.FC = () => (
    <AuthorizedBorder
        content={
            <Space direction={'horizontal'}>

            </Space>
        }
    >
        <Typography.Title level={1} style={{color: '#013A7B'}}>
            Личный кабинет Sportliner
        </Typography.Title>

    </AuthorizedBorder>
);

export default HomePage;
