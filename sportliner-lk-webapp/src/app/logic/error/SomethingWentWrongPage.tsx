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
        title={props.title ?? 'Ошибка'}
        subTitle={props.subTitle ?? 'Извините, что-то пошло не так.'}
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
                    Перезагрузить
                </Button>

                <Button
                    className="dp-button"
                    type="primary"
                    onClick={props.onButton}
                >
                    <Link to="/">Вернуться на главную</Link>
                </Button>
            </>
        )}
    />
);

export default SomethingWentWrongPage;
