import {Button, Result} from 'antd';
import {Link} from 'react-router-dom';

const ForbiddenErrorPage: React.FC = () => (
    <>
        <Result
            status="403"
            title="403"
            subTitle="Извините, Вы не имеете прав для отображения данной страницы."
            extra={(
                <Button className="dp-button" type="primary">
                    <Link to="/">Вернуться на главную страницу</Link>
                </Button>
            )}
        />
    </>
);

export default ForbiddenErrorPage;
