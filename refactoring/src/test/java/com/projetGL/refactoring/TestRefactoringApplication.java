package com.projetGL.refactoring;

import org.springframework.boot.SpringApplication;

public class TestRefactoringApplication {

	public static void main(String[] args) {
		SpringApplication.from(RefactoringApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
