import {Button, Result} from 'antd';
import {Link} from 'react-router-dom';

interface NotFoundErrorPageProps {
    onBackHome?: () => void;
}

const NotFoundErrorPage: React.FC<NotFoundErrorPageProps> = (props: NotFoundErrorPageProps) => (
    <>
        <Result
            status="404"
            title="404"
            subTitle="Sorry, the page you visited does not exist."
            extra={(
                <Button className="dp-button" type="primary" onClick={props.onBackHome}>
                    <Link to="/">Back Home</Link>
                </Button>
            )}
        />
    </>
);

export default NotFoundErrorPage;
