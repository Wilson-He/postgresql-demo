package per.demo.postgres.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * RoutingConfig
 *
 * @author Wilson
 * @date 18-5-8
 */
@Configuration
public class RoutingConfig {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(StudentHandler studentHandler) {
        return route(RequestPredicates.GET("/list/student").and(accept(APPLICATION_JSON)), studentHandler::listStudent)
                .andRoute(RequestPredicates.GET("/page/student/flux").and(accept(APPLICATION_JSON)), studentHandler::pageStudent);
    }
}
