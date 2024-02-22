import AttendancePage from "app/logic/attendance/AttendancePage";
import AuthenticationPage from 'app/logic/authentication/AuthenticationPage';
import SomethingWentWrongPage from 'app/logic/error/SomethingWentWrongPage';
import HomePage from 'app/logic/HomePage';
import {Authorities} from 'app/logic/store/Authorities';
import {PageMeta} from 'kit/navigation/PageMeta';
import BranchOfficeListPage from "./logic/branchOffice/list/BranchOfficeListPage";
import BranchOfficeEditPage from "./logic/branchOffice/edit/BranchOfficeEditPage";
import UserListPage from "./logic/user/list/UserListPage";
import UserEditPage from "./logic/user/edit/UserEditPage";
import ProfilePage from "./logic/profile/ProfilePage";
import ChildEditPage from "./logic/profile/child/ChildEditPage";
import AnalysisPage from "./logic/analysis/AnalysisPage";
import TrialAttendanceListPage from "./logic/attendance/trialAttendance/list/TrialAttendanceListPage";
import TrialAttendanceEditPage from "./logic/attendance/trialAttendance/edit/TrialAttendanceEditPage";
import TelegramApplicationListPage from "./logic/telegram/TelegramApplicationListPage";
import TaskListTable from "./logic/task/list/TaskListTable";
import TaskListPage from "./logic/task/list/TaskListPage";
import TaskEditPage from "./logic/task/edit/TaskEditPage";

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

    profilePage: new PageMeta<void>({
        path: '/profile',
        render: () => <ProfilePage/>,
        requiredAuthorities: Authorities.AUTHENTICATED
    }),

    childEditPage: new PageMeta<{ childId: string }>({
        path: '/profile/child/:childId',
        render: (props) => <ChildEditPage childId={props.params.childId!}/>,
        renderParameters: (object) => ({childId: object.childId}),
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

    userListPage: new PageMeta<void>({
        path: '/users',
        render: () => <UserListPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    userCreatePage: new PageMeta<void>({
        path: '/users/new',
        render: () => <UserEditPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    userEditPage: new PageMeta<{ userAccountId: string }>({
        path: '/users/:userAccountId',
        render: (props) => <UserEditPage userAccountId={props.params.userAccountId}/>,
        renderParameters: (object) => ({userAccountId: object.userAccountId}),
        requiredAuthorities: Authorities.TRAINER
    }),

    attendances: new PageMeta<void>({
        path: '/attendances',
        render: () => <AttendancePage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    trialAttendances: new PageMeta<void>({
        path: '/trialAttendances',
        render: () => <TrialAttendanceListPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    addTrialAttendances: new PageMeta<void>({
        path: '/trialAttendances/add',
        render: () => <TrialAttendanceEditPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    analysisPage: new PageMeta<void>({
        path: '/analysis',
        render: () => <AnalysisPage/>,
        requiredAuthorities: Authorities.ADMINISTRATIVE
    }),

    telegramBotApplicationPage: new PageMeta<void>({
        path: '/telegramBot/application',
        render: () => <TelegramApplicationListPage/>,
        requiredAuthorities: Authorities.ADMINISTRATIVE
    }),

    tasksPage: new PageMeta<void>({
        path: '/tasks',
        render: () => <TaskListPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    taskCreatePage: new PageMeta<void>({
        path: '/tasks/new',
        render: () => <TaskEditPage/>,
        requiredAuthorities: Authorities.TRAINER
    }),

    taskEditPage: new PageMeta<{ taskId: string }>({
        path: '/tasks/:taskId',
        render: (props) => <TaskEditPage id={props.params.taskId}/>,
        renderParameters: (object) => ({taskId: object.taskId}),
        requiredAuthorities: Authorities.TRAINER
    }),

    somethingWentWrongPage: new PageMeta<void>({
        path: '/error',
        render: () => <SomethingWentWrongPage/>,
        requiredAuthorities: Authorities.AUTHENTICATED
    }),

};
