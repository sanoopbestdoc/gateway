package gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;

@SpringBootApplication
public class Application {

    @Value("${url.bmh}")
    private String bmhUrl;

    @Value("${url.hrn}")
    private String hrnUrl;

    @Value("${url.hrnqms}")
    private String hrnQMSUrl;

    @Value("${url.ni-otc}")
    private String niotcUrl;

    @Value("${url.prms}")
    private String prmsUrl;

    @Value("${url.daya}")
    private String dayaUrl;

    @Value("${url.dev}")
    private String bmhDevUrl;

    @Value("${url.hrndev}")
    private String hrnDev;

    @Value("${url.dharmagiri}")
    private String dharmagiriUrl;

    @Value("${url.armcdev}")
    private String armcDev;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/bmh/**")
                        .filters(
                                f -> f.stripPrefix(1).prefixPath(URI.create(bmhUrl).getPath())
                        )
                        .uri(bmhUrl))
                .route(p -> p
                        .path("/hrn/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(hrnUrl))
                .route(p -> p
                        .path("/hrnqms/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(hrnQMSUrl))
                .route(p -> p
                        .path("/ni-otc/**")
                        .filters(
                                f -> f.stripPrefix(1).addRequestHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0cmVhdHdlbGwiLCJ1c2VySWQiOiJNRVNVcWRzcXgxT1J5bnhzVVBuMlp5RDlwa2gzYzVyM2lVJTJCd005TjMlMkZIdVVCWHBUJTJGVlJ6YnJaJTJCWUs0ZUE4Nm5YSmNtTjJDenFHeHVUVUQ1dXFFaDZnJTNEJTNEIiwicm9sZSI6ImJlc3Rkb2MifQ.HtAlojH554FkqVUJsw5mVSfJvKeqmT5QcK_o2EsmigpqmLOfhoDwPn23LRit0U10FCYww619tZltRvbgpwjTAA")

                        )
                        .uri(niotcUrl))
                .route(p -> p
                        .path("/prms/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(prmsUrl))
                .route(p -> p
                        .path("/daya/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(dayaUrl))
                .route(p -> p
                        .path("/dev/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(bmhDevUrl))
                .route(p -> p
                        .path("/hrndev/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(hrnDev))
                .route(p -> p
                        .path("/dharmagiri/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(dharmagiriUrl))
                .route(p -> p
                        .path("/armcdev/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri(armcDev))
                .build();
    }


//    @Bean
//    public CorsConfiguration corsConfiguration(RoutePredicateHandlerMapping routePredicateHandlerMapping) {
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues(); Arrays.asList(HttpMethod.OPTIONS, HttpMethod.PUT, HttpMethod.GET, HttpMethod.DELETE, HttpMethod.POST) .forEach(m -> corsConfiguration.addAllowedMethod(m)); corsConfiguration.addAllowedOrigin("*"); routePredicateHandlerMapping.setCorsConfigurations(new HashMap<String, CorsConfiguration>() {{ put("/*", corsConfiguration); }}); return corsConfiguration;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
