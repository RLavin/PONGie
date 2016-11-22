package com.ironyard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Raul on 11/9/16.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public Docket matchApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("match-api")
                .apiInfo(matchapiInfo())
                .select()
                .paths(regex("/rest/match.*"))
                .build()
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }

    @Bean
    public Docket playerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("player-api")
                .apiInfo(playerapiInfo())
                .select()
                .paths(regex("/rest/player.*"))
                .build()
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }


    private ApiInfo matchapiInfo() {
        return new ApiInfoBuilder()
                .title("PingPong Matches API with Swagger")
                .description("Create your Match here")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Raul Lavin")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
    private ApiInfo playerapiInfo() {
        return new ApiInfoBuilder()
                .title("PingPong Players API with Swagger")
                .description("Create your Player here")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Raul Lavin")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
}
