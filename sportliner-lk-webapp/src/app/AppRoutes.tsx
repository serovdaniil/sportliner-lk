import AuthenticationPage from 'app/logic/authentication/AuthenticationPage';
import SomethingWentWrongPage from 'app/logic/error/SomethingWentWrongPage';
import HomePage from 'app/logic/HomePage';
import {Authorities} from 'app/logic/store/Authorities';
import {PageMeta} from 'kit/navigation/PageMeta';

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

    somethingWentWrongPage: new PageMeta<void>({
        path: '/error',
        render: () => <SomethingWentWrongPage/>,
        requiredAuthorities: Authorities.AUTHENTICATED
    }),

};
