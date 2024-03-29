import {BarChartOutlined, HomeOutlined, PicLeftOutlined, ScheduleOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Menu} from 'antd';
import {auth} from 'app/App';
import {AppRoutes} from 'app/AppRoutes';
import {useNavigator} from "app/logic/Navigator";
import {PageMeta} from 'kit/navigation/PageMeta';
import * as React from 'react';
import {CSSProperties} from 'react';
import {useLocation} from "react-router-dom";

interface MenuItem {
    id: string;
    title: string;
    page: PageMeta<void>;
    pageUrl: string;
    icon?: React.ReactNode;
    group?: MenuGroup;
    style?: CSSProperties,
}

interface MenuGroup {
    id: string;
    title: string;
    page?: PageMeta<void>;
    pageUrl?: string;
    icon?: React.ReactNode;
    style?: CSSProperties,
    items: MenuItem[];
}

class MenuModel {

    private readonly groups: MenuGroup[];

    private readonly visibilityChecker: (item: MenuItem) => boolean;

    private get visibleItems(): MenuItem[] {
        return this.visibleGroups.flatMap((group) => [...group.items]);
    }

    constructor(groups: MenuGroup[], visibilityChecker: (item: MenuItem) => boolean) {
        this.groups = groups;
        this.visibilityChecker = visibilityChecker;
    }

    get visibleGroups(): MenuGroup[] {
        const someItemVisible = (group: MenuGroup): boolean => group.items.some((item) => this.visibilityChecker(item));
        const groupPageExist = (group: MenuGroup): boolean => !!group.page;

        const filteredGroups = this.groups.filter((group) => someItemVisible(group) || groupPageExist(group));

        const groupsWithFilteredItems = filteredGroups.map(
            (group) => ({...group, items: group.items.filter((item) => this.visibilityChecker(item))}),
        );

        return groupsWithFilteredItems;
    }

    getItemByPath(path: string): MenuItem | undefined {
        const candidates = this.visibleItems
            .filter((it) => path.startsWith(it.page.toUrl()))
            .sort((a, b) => b.page.toUrl().length - a.page.toUrl().length);

        return candidates.length > 0 ? candidates[0] : undefined;
    }

}

export const MainMenu: React.FC = () => {
    const navigator = useNavigator();
    const location = useLocation();
    const currentPath = location.pathname;

    const masterDataItems: MenuItem[] = [
        {
            id: 'profile',
            title: 'Профиль',
            page: AppRoutes.profilePage,
            pageUrl: AppRoutes.profilePage.toUrl(),
            icon: <HomeOutlined/>
        },
        {
            id: 'branchOffices',
            title: 'Список филиалов',
            page: AppRoutes.branchOfficeListPage,
            pageUrl: AppRoutes.branchOfficeListPage.toUrl(),
            icon: <PicLeftOutlined/>
        },
        {
            id: 'users',
            title: 'Список пользователей',
            page: AppRoutes.userListPage,
            pageUrl: AppRoutes.userListPage.toUrl(),
            icon: <UserOutlined/>
        },
        {
            id: 'attendances',
            title: 'Посещаемость',
            page: AppRoutes.attendances,
            pageUrl: AppRoutes.attendances.toUrl(),
            icon: <ScheduleOutlined/>
        },
        {
            id: 'tasks',
            title: 'Задачи',
            page: AppRoutes.tasksPage,
            pageUrl: AppRoutes.tasksPage.toUrl(),
            icon: <ScheduleOutlined/>
        },
        {
            id: 'trialAttendances',
            title: 'Пробные занятия',
            page: AppRoutes.trialAttendances,
            pageUrl: AppRoutes.trialAttendances.toUrl(),
            icon: <ScheduleOutlined/>
        },
        {
            id: 'telegramBotApplications',
            title: 'Заявки из Telegram',
            page: AppRoutes.telegramBotApplicationPage,
            pageUrl: AppRoutes.telegramBotApplicationPage.toUrl(),
            icon: <ScheduleOutlined/>
        },
        {
            id: 'analysis',
            title: 'Анализ посещаемости',
            page: AppRoutes.analysisPage,
            pageUrl: AppRoutes.analysisPage.toUrl(),
            icon: <BarChartOutlined/>
        }
    ];

    const groups: MenuGroup[] = [
        {
            id: 'regularData',
            title: '',
            items: masterDataItems
        }
    ];

    const itemVisibilityChecker = (item: MenuItem) => (
        auth.authState.hasAuthorities(item.page.requiredAuthorities)
    );

    const mainMenuModel = new MenuModel(groups, itemVisibilityChecker);

    const selectedItem = mainMenuModel.getItemByPath(currentPath);
    const selectedKeys = selectedItem ? [selectedItem.id] : [];

    const renderMenuItem = (item: MenuItem) => (
        <Menu.Item
            key={item.id}
            style={item.style}
        >
            <Button
                onClick={() => navigator.safeNavigate(item.pageUrl)}
                className="dp-menu_link ant-menu-title-content"
                icon={item.icon}
                style={{color: "#000000"}}
            >
                {item.title}
            </Button>
        </Menu.Item>
    );

    const renderMenuGroup = (group: MenuGroup) => {
        return (

            group.items.map((item) => renderMenuItem(item))

        );

    };

    return (
        <Menu mode="horizontal" theme="light" style={{backgroundColor: "#ffaa00", overflowY: "hidden"}}
              selectedKeys={selectedKeys} className="dp-sider_menu">
            {mainMenuModel.visibleGroups.map((group) => renderMenuGroup(group))}
        </Menu>
    );
};
