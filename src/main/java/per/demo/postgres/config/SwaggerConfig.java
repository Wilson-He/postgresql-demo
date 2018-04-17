package per.demo.postgres.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * SwaggerConfig
 *
 * @author Wilson
 * @date 18-4-17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket petApi() {
        //<3>
        return new Docket(DocumentationType.SWAGGER_2)
                //<4>
                .select()
                //<5>
                .apis(RequestHandlerSelectors.any())
                //<6>
                .paths(PathSelectors.any())
                .build()//<7>
                //<8>
                .pathMapping("/")
                //<9>
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                //<10>
                                typeResolver.resolve(WildcardType.class)))
                //<11>
                .useDefaultResponseMessages(false)
                //<12>
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                //<13>
                                .responseModel(new ModelRef("Error"))
                                .build()))
                //<14>
                .securitySchemes(newArrayList(apiKey()))
                //<15>
                .securityContexts(newArrayList(securityContext()))
                //<21>
                .enableUrlTemplating(true)
                //<22>
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("someGlobalParameter")
                                .description("Description of someGlobalParameter")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .allowableValues(new AllowableListValues(newArrayList("access"),"String"))
                                .parameterAccess("access")
                                .build()))
                // <25>
//                .tags(new Tag("Pet Service", "All apis relating to pets"))
                //<26>
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

    @Autowired
    private TypeResolver typeResolver;

    private ApiKey apiKey() {
        //<16>
        return new ApiKey("mykey", "api_key", "header");
    }

    private SecurityContext securityContext() {
        //<17>
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        //<18>
        return newArrayList(
                new SecurityReference("mykey", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
        //<19>
        return SecurityConfigurationBuilder.builder()
                .clientId("test-app-client-id")
                .clientSecret("test-app-client-secret")
                .realm("test-app-realm")
                .appName("test-app")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }
}
