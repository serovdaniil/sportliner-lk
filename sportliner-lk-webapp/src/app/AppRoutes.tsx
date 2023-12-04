import AuthenticationPage from 'app/logic/authentication/AuthenticationPage';
import SomethingWentWrongPage from 'app/logic/error/SomethingWentWrongPage';
import HomePage from 'app/logic/HomePage';
import {Authorities} from 'app/logic/store/Authorities';
import {PageMeta} from 'kit/navigation/PageMeta';
import BranchOfficeListPage from "./logic/branchOffice/list/BranchOfficeListPage";
import BranchOfficeEditPage from "./logic/branchOffice/edit/BranchOfficeEditPage";

export const AppRoutes = {

    authPage: new PageMeta<void>({
        path: '/login',
        render: () => <AuthenticationPage/>,
    }),

    homePage: new PageMeta<void>({
        path: '/home',
        render: () => <HomePage/>,
        requiredAuthorities: Authorities.AUTHENTICATED
    }),

    branchOfficeListPage: new PageMeta<void>({
        path: '/branchOffices',
        render: () => <BranchOfficeListPage/>,
        requiredAuthorities: Authorities.ADMINISTRATIVE
    }),

    branchOfficeCreatePage: new PageMeta<void>({
        path: '/branchOffices/new',
        render: () => <BranchOfficeEditPage/>,
        requiredAuthorities: Authorities.ADMINISTRATIVE
    }),

    branchOfficeEditPage: new PageMeta<{ branchOfficeId: string }>({
        path: '/branchOffices/:branchOfficeId',
        render: (props) => <BranchOfficeEditPage branchOfficeId={props.params.branchOfficeId}/>,
        renderParameters: (object) => ({branchOfficeId: object.branchOfficeId}),
        requiredAuthorities: Authorities.ADMINISTRATIVE
    }),

    somethingWentWrongPage: new PageMeta<void>({
        path: '/error',
        render: () => <SomethingWentWrongPage/>,
        requiredAuthorities: Authorities.AUTHENTICATED
    }),

};
