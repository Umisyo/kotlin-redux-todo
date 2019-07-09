package main.kotlin.components

import react.RBuilder
import react.dom.div
import react.dom.span

fun RBuilder.footer() =
        div {
            span { +"Show: " }
        }