package br.com.zup.orange.samplesec

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloResource {

    @GetMapping("/hello")
    fun hello(authentication: Authentication) = "Hello, ${authentication.name}"
}