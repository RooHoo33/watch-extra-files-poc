package dev.roohoo

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class ExampleController {

    @Get
    fun first(): String {
        return "Hello World"
    }

    @Get("/extras")
    fun extras(): String {
        return Example.getMessage()
    }
}