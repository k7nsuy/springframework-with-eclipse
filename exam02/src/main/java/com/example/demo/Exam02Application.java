package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.controller",
	"com.example.security",
	"com.example.aop"}) //@Cntroller, @Service, @Component위치
@MapperScan({"com.example.mapper"}) //@Mapper의 위치 설정
public class Exam02Application {

	public static void main(String[] args) {
		SpringApplication.run(Exam02Application.class, args);
	}

}