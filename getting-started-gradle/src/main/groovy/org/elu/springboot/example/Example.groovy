package org.elu.springboot.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class Example {

	@RequestMapping('/')
	def home() {
		return 'Hello World!'
	}

	static void main(String[] args) {
		SpringApplication.run Example, args
	}
}
