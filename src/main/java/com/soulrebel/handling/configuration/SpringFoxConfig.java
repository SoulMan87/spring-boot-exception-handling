package com.soulrebel.handling.configuration;

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
public class SpringFoxConfig {

    @Value("${soulrebel.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI api() {

        var devServer = new Server ();
        devServer.setUrl (devUrl);
        devServer.setDescription ("Server URL in Development environment");

        Contact contact = new Contact ();
        contact.email ("jonathanhinestroza87@gmail.com");
        contact.setName ("Jonathan");
        contact.setUrl ("https://github.com/SoulMan87");

        License license = new License ().name ("MIT License").url ("https://choosealicense.com/licenses/mit/");

        Info info = new Info ()
                .title ("Tutorial's Api")
                .version ("1.0")
                .contact (contact)
                .description ("API that exposes certain endpoints of tutorials.")
                .termsOfService ("https://github.com/SoulMan87")
                .license (license);
        return new OpenAPI ().info (info).servers (List.of (devServer));
    }
}
