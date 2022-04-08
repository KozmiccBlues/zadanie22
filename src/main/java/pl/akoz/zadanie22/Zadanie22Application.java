package pl.akoz.zadanie22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zadanie22Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zadanie22Application.class, args);

        MessageService messageService = context.getBean(MessageService.class);
    }

}

