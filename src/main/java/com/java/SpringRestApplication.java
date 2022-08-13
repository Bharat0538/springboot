package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);

		List<Integer> integers = Arrays.asList(10, 28, 77, 3, 118, 16);
		List<Integer> collect = integers.stream().filter(p -> String.valueOf(p).substring(0, 1).equals("1")).collect(Collectors.toList());
		System.out.println(collect);
	}

	//10,28,77,3,118,16




}
