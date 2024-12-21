package ltr.org.questionlist.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class OpenApiConfiguration {
    private static final Set<String> DEFAULT_PRODUCES_CONSUMES =
            new HashSet<>(Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Questions List")
                        .description("Service used for Maintaining a list of Questions")
                        .version("v1")
                        .contact(new Contact()
                                .name("Default Contact") // Replace with actual contact details if needed
                                .url("https://www.example.com") // Replace with actual URL if needed
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }
}