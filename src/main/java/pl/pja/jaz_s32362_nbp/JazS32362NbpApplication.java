package pl.pja.jaz_s32362_nbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080", description = "NBP Service")})
@SpringBootApplication
public class JazS32362NbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JazS32362NbpApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("NBP Service")
				.version("1.0")
				.description("Service for fetching average exchange rates from the NBP service")
				.contact(new Contact().name("s32362").email("s32362@pjwstk.edu.pl"))
				.termsOfService("Terms of Service")
				.license(new License().name("MIT License").url("https://opensource.org/licenses/MIT")));
	}
}
