import moment from 'moment';

const YEAR_MONTH_REGEXP = /^(\d{4})-(0[1-9]|1[012])$/;

/**
 * Utility class for working with dates
 */
export default class DateUtils {

    /**
     * DD.MM.YYYY
     */
    public static formatDateLocalShort(date: Date | null | undefined): string {
        return date != null ? moment(date).local().format('DD.MM.YYYY') : '';
    }

    /**
     * DD.MM.YYYY HH:mm
     */
    public static formatDateLocalWithTime(date: Date | null | undefined): string {
        return date != null ? moment(date).local().format('DD.MM.YYYY HH:mm') : '';
    }

    /**
     * DD.MM.YYYY HH:mm:ss
     */
    public static formatDateLocalWithTimeSeconds(date: Date | null | undefined): string {
        return date != null ? moment(date).local().format('DD.MM.YYYY HH:mm:ss') : '';
    }

    /**
     * monthName
     */
    public static formatLocalMonth(period: string): string {
        return period != null ? moment(period).local().format('MMMM') : '';
    }

    /**
     * [monthName] YYYY
     */
    public static formatLocalMonthYear(period: string): string {
        return period != null ? moment(period).local().format('MMMM YYYY') : '';
    }

    /**
     * Converting a date to a format YYYY-MM
     */
    public static convertToYearMonth(date: string): string {
        return date != null ? moment(date).local().format('YYYY-MM') : '';
    }

    public static extractYear(yearMonth: string): number {
        return Number.parseInt(DateUtils.parseYearMonth(yearMonth)[1], 10);
    }

    public static extractMonth(yearMonth: string): number {
        return Number.parseInt(DateUtils.parseYearMonth(yearMonth)[2], 10);
    }

    public static createYearMonth(year: number, month: number): string {
        return `${year}-${month < 10 ? "0" + month : month}`;
    }

    /**
     * If previousQuantity parameter = 1, then method return (period + 1 month)
     * Example:
     * addMonths('2021-05', 1) => 2021-06
     * addMonths('2021-05', 6) => 2021-11
     * addMonths('2021-05', -2) => 2021-03
     */
    static addMonths(yearMonth: string, monthsToAdd: number): string {
        const match = DateUtils.parseYearMonth(yearMonth);

        if (match == null) {
            throw new Error(`Invalid YearMonth value: ${yearMonth}`);
        }

        const year = Number.parseInt(match[1], 10);
        const month = Number.parseInt(match[2], 10);

        const monthsCount = 12 * year + (month - 1) + monthsToAdd;

        const newYear = Math.floor(monthsCount / 12);
        const newMonth = (monthsCount % 12) + 1;

        return `${newYear}-${(newMonth < 10 ? '0' : '') + newMonth}`;
    }

    /**
     * @param s string to test
     * @return true if string represent a valid year-month (YYYY-MM)
     */
    static isValidYearMonth(s: string) {
        return s.match(YEAR_MONTH_REGEXP) != null;
    }

    /**
     * Compares two year months
     *
     * @param leftYearMonth left year month
     * @param rightYearMonth right year month
     * @return 1 - if (left > right), -1 - if (left < right), 0 - if (left == right)
     */
    static compare(leftYearMonth: string, rightYearMonth: string): number {
        const leftMatch = DateUtils.parseYearMonth(leftYearMonth);
        const rightMatch = DateUtils.parseYearMonth(rightYearMonth);

        const leftYear = Number.parseInt(leftMatch[1], 10);
        const leftMonth = Number.parseInt(leftMatch[2], 10);

        const rightYear = Number.parseInt(rightMatch[1], 10);
        const rightMonth = Number.parseInt(rightMatch[2], 10);

        const leftMonthsCount = 12 * leftYear + leftMonth;
        const rightMonthsCount = 12 * rightYear + rightMonth;

        if (leftMonthsCount > rightMonthsCount) {
            return 1;
        }
        if (leftMonthsCount < rightMonthsCount) {
            return -1;
        }

        return 0;
    }

    private static parseYearMonth(yearMonth: string): RegExpMatchArray {
        const result = yearMonth.match(YEAR_MONTH_REGEXP);

        if (result == null) {
            throw new Error(`Invalid YearMonth value: ${yearMonth}`);
        }

        return result;
    }
}
