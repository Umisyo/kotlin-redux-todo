package main.kotlin.reducers

import main.kotlin.entities.Todo
import main.kotlin.enums.VisibilityFilter
import main.kotlin.util.combineReducers

data class State(
        val todos: Array<Todo> = emptyArray(),
        val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL
)

fun combinedReducers() = combineReducers(
        mapOf(
                State::todos to::todos,
                State::visibilityFilter to ::visibilityFilter
        )
)