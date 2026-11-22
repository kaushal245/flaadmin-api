package com.webelement.flaadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FlaadminApplication {

	
	public static void main(String[] args) {

		SpringApplication.run(FlaadminApplication.class, args);

	}

}
