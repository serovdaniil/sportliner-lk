import {Row, Spin} from 'antd';

interface LoadingBlockProps {

}

const LoadingBlock: React.FC<LoadingBlockProps> = (props: LoadingBlockProps) => (
    <Row
        justify="center"
        align="middle"
        style={{height: '100%', flex: 1}}
    >
        <Spin size="large"/>
    </Row>
);

export default LoadingBlock;
