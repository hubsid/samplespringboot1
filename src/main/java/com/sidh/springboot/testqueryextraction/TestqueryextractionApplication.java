package com.sidh.springboot.testqueryextraction;

import com.sidh.springboot.testqueryextraction.properties.CustomProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
@EnableConfigurationProperties(CustomProperty.class)
public class TestqueryextractionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(TestqueryextractionApplication.class, args);
	}

}
