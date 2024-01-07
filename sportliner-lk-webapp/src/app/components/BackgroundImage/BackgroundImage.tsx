import {Image} from 'antd';
import React from 'react';

interface BackgroundImageProps {
    /**
     * Background image source
     */
    src: string;

    /**
     * Displayed text provided the source is not available
     */
    alt?: string;
}

const BackgroundImage: React.FC<BackgroundImageProps> = (props: BackgroundImageProps) => (
    <Image
        preview={false}
        src={props.src}
        alt={props.alt && ''}
        className="dp-background-image"
    />
);

export default BackgroundImage;
