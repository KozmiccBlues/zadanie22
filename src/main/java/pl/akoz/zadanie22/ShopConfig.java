package pl.akoz.zadanie22;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class ShopConfig {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();

    }


}
