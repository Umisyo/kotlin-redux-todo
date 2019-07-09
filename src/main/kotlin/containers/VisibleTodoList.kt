package main.kotlin.containers

import main.kotlin.actions.ToggleTodo
import main.kotlin.components.TodoList
import main.kotlin.components.TodoListProps
import main.kotlin.entities.Todo
import main.kotlin.enums.VisibilityFilter
import main.kotlin.reducers.State
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import redux.WrapperAction

private fun getVisibleTodos(todos: Array<Todo>, filter: VisibilityFilter): Array<Todo> = when (filter) {
    VisibilityFilter.SHOW_ALL -> todos
    VisibilityFilter.SHOW_ACTIVE -> todos.filter { !it.completed }.toTypedArray()
    VisibilityFilter.SHOW_COMPLETED -> todos.filter { it.completed }.toTypedArray()
}

private interface TodoListStateProps: RProps {
    var todos: Array<Todo>
}

private interface TodoListDispatchProps: RProps {
    var toggleTodo: (Int) -> Unit
}

val visibleTodoList: RClass<RProps> =
        rConnect<State, ToggleTodo, WrapperAction, RProps, TodoListStateProps, TodoListDispatchProps, TodoListProps>(
                { state, _ ->
                    todos = getVisibleTodos(state.todos, state.visibilityFilter)
                },
                { dispatch, _ ->
                    toggleTodo = { dispatch(ToggleTodo(it))}
                }
        )(TodoList::class.js.unsafeCast<RClass<TodoListProps>>())