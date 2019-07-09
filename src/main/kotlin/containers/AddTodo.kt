package main.kotlin.containers

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onSubmitFunction
import main.kotlin.actions.AddTodo
import main.store
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*
import react.redux.rConnect
import redux.WrapperAction

class AddTodo(props: RProps) : RComponent<RProps, RState>(props) {
    private val inputRef = createRef<HTMLInputElement>()
    override fun RBuilder.render() {
        div {
            form {
                attrs.onSubmitFunction = {event ->
                    event.preventDefault()
                    inputRef.current!!.let {
                        if (it.value.trim().isNotEmpty()) {
                            store.dispatch(AddTodo(it.value))
                            it.value = ""
                        }
                    }
                    input(type = InputType.text) {
                        ref = inputRef
                    }
                    button(type = ButtonType.submit) {
                        + "Add Todo"
                    }
                }
            }
        }
    }
}

val addTodo: RClass<RProps> =
        rConnect<AddTodo, WrapperAction>()(main.kotlin.containers.AddTodo::class.js.unsafeCast<RClass<RProps>>())