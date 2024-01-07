import {dirtyCheckerRegistry} from "app/App";
import DirtyChecker from "app/logic/dirtyCheck/DirtyChecker";
import DirtyCheckerContext from "app/logic/dirtyCheck/DirtyCheckerContext";
import React, {FC, PropsWithChildren, useEffect} from "react";

interface Props {
    value: DirtyChecker;
}

const DirtyCheckerContextProvider: FC<PropsWithChildren<Props>> = (props: PropsWithChildren<Props>) => {
    const dirtyChecker = props.value;
    const children = props.children;

    useEffect(() => {
        dirtyCheckerRegistry.add(dirtyChecker);
        return () => {
            dirtyCheckerRegistry.delete(dirtyChecker);
        };
    }, []);

    return (
        <DirtyCheckerContext.Provider value={dirtyChecker}>
            {children}
        </DirtyCheckerContext.Provider>
    );
};

export default DirtyCheckerContextProvider;
