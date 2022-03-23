package br.com.surveyapp.surveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SurveyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyappApplication.class, args);
	}

}
