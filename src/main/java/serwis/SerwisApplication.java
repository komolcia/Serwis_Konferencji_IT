package serwis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import serwis.service.UzytkownikServiceImpl;

@SpringBootApplication
public class SerwisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SerwisApplication.class, args);

    }
    @Bean
    public CommandLineRunner setUpApp(@Autowired UzytkownikServiceImpl uzytkownikService) {

        return (args) -> uzytkownikService.makeKonferencja();
    }

}
