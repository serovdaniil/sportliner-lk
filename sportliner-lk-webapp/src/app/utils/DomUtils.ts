/**
 * Checks if event was fired within interactive child of event's current target.
 *
 * Useful in cases, when parent element has click handler and some children has click handlers.
 * This method allows to prevent easily processing click handler on parent, if event was fired within child handler.
 * And the benefit is that is does not require implementing propagation stopping for each interactive child element.
 *
 * @param e event
 * @return true - if event fired within interactive child of current target
 */
export const isEventFromInteractiveChild = (e: React.UIEvent): boolean => {
    const currentTarget = e.currentTarget;

    let el: Element | null = e.target as Element;
    while (el !== currentTarget && el !== null) {

        const tagName = el.tagName.toLowerCase();
        if (tagName === 'a' || tagName === 'button' || tagName === 'input') {
            return true;
        }

        el = el.parentElement;
    }

    return false;
};
