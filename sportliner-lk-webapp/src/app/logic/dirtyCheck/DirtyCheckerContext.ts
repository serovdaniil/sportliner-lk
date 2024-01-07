import DirtyChecker from "app/logic/dirtyCheck/DirtyChecker";
import {createContext} from "react";

const DirtyCheckerContext = createContext<DirtyChecker>(new DirtyChecker());

export default DirtyCheckerContext;