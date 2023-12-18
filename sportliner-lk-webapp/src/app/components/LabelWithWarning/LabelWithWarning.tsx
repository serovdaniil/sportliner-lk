import {WarningTwoTone} from '@ant-design/icons';
import {Typography} from 'antd';

interface LabelWarnProps {
    isWarn: boolean;
    text: string;
    warnText: string;
}

const LabelWarn: React.FC<LabelWarnProps> = (props: LabelWarnProps) => (
    <>
        {props.isWarn ? (
            <>
                <WarningTwoTone/>
                &nbsp;
                <Typography.Text>{props.warnText}</Typography.Text>
            </>
        ) : (
            <Typography.Text>{props.text}</Typography.Text>
        )}
    </>
);

export default LabelWarn;
