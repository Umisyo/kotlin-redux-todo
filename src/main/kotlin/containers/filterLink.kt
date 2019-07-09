package main.kotlin.containers

import main.kotlin.actions.SetVisibilityFilter
import main.kotlin.components.Link
import main.kotlin.enums.VisibilityFilter
import main.kotlin.reducers.State
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.LinkProps
import redux.WrapperAction

interface FilterLinkProps: RProps {
    var filter: VisibilityFilter
}

private interface LinkStateProps: RProps {
    var active: Boolean
}

private interface LinkDispathcProps: RProps {
    var onClick: () -> Unit
}

val filterLink: RClass<FilterLinkProps> =
    rConnect<State, SetVisibilityFilter, WrapperAction, FilterLinkProps, LinkStateProps, LinkDispathcProps, LinkProps>(
            { state, ownProps ->
                active = state.visibilityFilter == ownProps.filter
            },
            {dispatch, ownProps ->
                onClick = { dispatch(SetVisibilityFilter(ownProps.filter))}
            }
    )(Link::class.js.unsafeCast<RClass<LinkProps>>())
