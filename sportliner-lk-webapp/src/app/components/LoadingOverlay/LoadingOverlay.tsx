import {Spin} from 'antd';

interface LoadingOverlayProps {
    isVisible: boolean;
}

const LoadingOverlay: React.FC<LoadingOverlayProps> = (props: LoadingOverlayProps) => (
    <div hidden={!props.isVisible}>
        <div className="dp-overlay-background"/>
        <div className="dp-overlay_spinner-container">
            <Spin size="large"/>
        </div>
    </div>
);

export default LoadingOverlay;
