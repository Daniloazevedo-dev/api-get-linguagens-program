package br.com.fiap.linguagens.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact()
            .name("Get Linguagens Programação")
            .url("https://github.com/Daniloazevedo-dev/api-get-linguagens-program");

    @Bean
    public OpenAPI javaSpringwebfluxOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Linguagens")
                        .contact(DEFAULT_CONTACT)
                        .description("Projeto para treinamento.")
                        .version(getClass().getPackage().getImplementationVersion())
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
