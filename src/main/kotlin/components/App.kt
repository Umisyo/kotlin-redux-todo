package main.kotlin.components

import main.kotlin.containers.addTodo
import main.kotlin.containers.visibleTodoList
import react.RBuilder
import react.dom.br
import react.dom.div
import react.dom.h1
import react.router.dom.browserRouter
import react.router.dom.navLink
import react.router.dom.route
import react.router.dom.switch

private const val TODO_LIST_PATH = "/todolist"

fun RBuilder.app() =
        browserRouter {
            switch {
                route("/", exact = true) {
                    div {
                        h1 { + "Kotlin React + Router-Dom + React-Redux + React-Router Example" }
                    }
                    navLink(TODO_LIST_PATH) {
                        + "Go to todo list"
                    }
                }
                route(TODO_LIST_PATH) {
                    div {
                        addTodo {}
                        visibleTodoList {}
                        footer()
                        br { }
                        navLink("/") {
                            + "Go Back"
                        }
                    }
                }
            }
        }
