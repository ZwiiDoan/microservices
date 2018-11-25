package per.duyd.training.microservices.licensingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope/*
This annotation will only reload the custom Spring properties you have in your application configuration.
Items such as your database configuration that are used by Spring Data won’t be reloaded.
To perform the refresh, you can hit the http://<yourserver>:8080/refresh endpoint.
*/
public class LicensingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LicensingServiceApplication.class, args);
    }
}
