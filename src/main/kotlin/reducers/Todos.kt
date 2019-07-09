package main.kotlin.reducers

import main.kotlin.actions.AddTodo
import main.kotlin.actions.ToggleTodo
import main.kotlin.entities.Todo
import redux.RAction

fun todos(state: Array<Todo> = emptyArray(), action: RAction): Array<Todo> = when (action) {
    is AddTodo -> state + Todo(action.id, action.text, false)
    is ToggleTodo -> state.map {
        if (it.id == action.id) {
            it.copy(completed = !it.completed)
        } else {
            it
        }
    }.toTypedArray()
        else -> state
    }
