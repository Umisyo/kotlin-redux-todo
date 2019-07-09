package main.kotlin.reducers

import main.kotlin.actions.SetVisibilityFilter
import main.kotlin.enums.VisibilityFilter
import redux.RAction

fun visibilityFilter(
        state: VisibilityFilter = VisibilityFilter.SHOW_ALL,
        action: RAction
): VisibilityFilter = when (action) {
    is SetVisibilityFilter -> action.filter
    else -> state
}