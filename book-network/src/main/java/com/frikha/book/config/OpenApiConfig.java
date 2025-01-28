package com.frikha.book.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Omar Frikha",
                        email = "omar.frikha96@gmail.com",
                        url = "https://omar.com"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "OpenApi specification - Omar Frikha",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8088/api/v1"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://omar-server.com"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth" // reference to the security scheme
                )
        }
)
@SecurityScheme(
        name = "bearerAuth", // same name as the security requirement
        description = "JWT auth description",
        scheme = "bearer", // type of the security scheme bearer token
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}