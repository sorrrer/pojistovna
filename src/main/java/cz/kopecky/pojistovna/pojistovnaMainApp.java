package cz.kopecky.pojistovna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class pojistovnaMainApp {
    public static void main(String[] args) {
        SpringApplication.run(pojistovnaMainApp.class, args);

    }
}
