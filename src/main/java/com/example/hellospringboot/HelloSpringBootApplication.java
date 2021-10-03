package com.example.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

	@RestController
	@RequestMapping("hello/nation")
	class Controller {

		@GetMapping
		public List<Nation> getAllNations() {
			return List.of(
					new Nation("The United States"),
					new Nation("Việt Nam"),
					new Nation("Australia"),
					new Nation("The United Kingdom")
			);
		}

		@GetMapping("/asian")
		public List<Nation> getAsianNations() {
			return List.of(
					new Nation("Singapore"),
					new Nation("Việt Nam"),
					new Nation("Thái Lan"),
					new Nation("Indonesia")
			);
		}
	}

	class Nation {
		private final String name;

		public Nation(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
