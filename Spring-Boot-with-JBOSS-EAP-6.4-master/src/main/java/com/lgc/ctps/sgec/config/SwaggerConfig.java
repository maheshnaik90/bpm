package com.lgc.ctps.sgec.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Portal CTPS")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {
		return or(regex("/questions.*"), 
				regex("/companies.*"),
				regex("/question-types.*"),regex("/sample.*")); 
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SGEC API")
				.description("Sistema de Gerenciamento de Equipamentos Críticos")
				.termsOfServiceUrl("http://portalctps/sgec")
				.license("Landmark License") 
				.version("1.0")
				.build();
	}
}