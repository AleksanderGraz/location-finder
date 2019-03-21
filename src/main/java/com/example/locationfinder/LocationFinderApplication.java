package com.example.locationfinder;

import com.example.locationfinder.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class LocationFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationFinderApplication.class, args);
	}

}
