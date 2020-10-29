package com.example.demo;

import com.sun.tools.jdeprscan.scan.Scan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.*"})
public class FinalQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}

}
