package com.template.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("Dados.Api")
    private String dadosApi;

    @Value("Api.dados")
    private String Apidados;

    @Bean
    public OpenAPI myOpenApi(){
        Server devServer = new Server();
        devServer.setUrl(dadosApi);
        devServer.setDescription("Server URL em Ambiente de desenvolvimento");

        Server prodServer = new Server();
        prodServer.setUrl(Apidados);
        prodServer.setDescription("Server URL em Ambiente de produção");

        Contact contact = new Contact();
        contact.setEmail("laura.napora@dbserver.com.br");
        contact.setName("DbServer");
        contact.setUrl("https://www.dbserver.com.br");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Template Management API")
                .version("1.0")
                .contact(contact)
                .description("Esta api fornece acesso aos endpoints do template").termsOfService("https://www.fakedoc.com")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}