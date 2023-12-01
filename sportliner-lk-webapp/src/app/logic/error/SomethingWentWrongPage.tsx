import {Button, Result} from 'antd';
import {Link} from 'react-router-dom';

interface SomethingWentWrongPageProps {
    title?: string;
    subTitle?: string;
    onButton?: () => void;
}

const SomethingWentWrongPage: React.FC<SomethingWentWrongPageProps> = (props: SomethingWentWrongPageProps) => (
    <Result
        status={500}
        title={props.title ?? 'Error'}
        subTitle={props.subTitle ?? 'Sorry, something went wrong.'}
        extra={(
            <>
                <Button
                    className="dp-button"
                    type="primary"
                    onClick={() => {
                        location.reload();
                        props.onButton && props.onButton();
                    }}
                >
                    Reload
                </Button>

                <Button
                    className="dp-button"
                    type="primary"
                    onClick={props.onButton}
                >
                    <Link to="/">Back home</Link>
                </Button>
            </>
        )}
    />
);

export default SomethingWentWrongPage;
