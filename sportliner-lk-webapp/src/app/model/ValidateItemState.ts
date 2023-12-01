import {ValidateStatus} from 'antd/lib/form/FormItem';

export default interface ValidateItemState {
    status: ValidateStatus,
    errorMessage: string | null
};
