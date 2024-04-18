package com.bitcafe.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {
    @Value("${swagger.version}")
    private String swaggerVersion;

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("bearerAuth");
        Info info = new Info()
                .title("Bitcafe API")
                .version(swaggerVersion)
                .description("매장 검색, 상품 선택 및 주문 서비스의 API 입니다.");

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", securityScheme))
                .security(Arrays.asList(securityRequirement))
                .info(info);
    }
}