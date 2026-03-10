package hospital.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "hospital API",
        version = "1.0",
        description = "API para o sistema hospital"
    )
)
public class Swagger {

}
