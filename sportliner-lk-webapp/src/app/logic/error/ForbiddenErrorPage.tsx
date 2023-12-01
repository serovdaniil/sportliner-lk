import {Button, Result} from 'antd';
import {Link} from 'react-router-dom';

const ForbiddenErrorPage: React.FC = () => (
    <>
        <Result
            status="403"
            title="403"
            subTitle="Sorry, you are not authorized to access this page."
            extra={(
                <Button className="dp-button" type="primary">
                    <Link to="/">Back Home</Link>
                </Button>
            )}
        />
    </>
);

export default ForbiddenErrorPage;
