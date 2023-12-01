export const addBeforeUnloadListener = (beforeUnloadHandler: (e: BeforeUnloadEvent) => void): void => {
    window.addEventListener('beforeunload', beforeUnloadHandler);
};

/**
 * Checks if nothing selected on the page
 *
 * Useful in cases, when user tried to select some text in active element (for example row of table)
 */
export const isNothingSelectedOnPage = (): boolean => window.getSelection()?.toString() === '';
