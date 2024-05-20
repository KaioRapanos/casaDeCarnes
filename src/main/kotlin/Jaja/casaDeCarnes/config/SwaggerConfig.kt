package Jaja.casaDeCarnes.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("JajaCasaDeCarnes-public")
            .pathsToMatch("/api/v1/produtos/**","/api/v1/pedidos/**")
            .build()
    }
}
