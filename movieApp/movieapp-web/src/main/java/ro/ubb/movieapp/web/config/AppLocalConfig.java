package ro.ubb.movieapp.web.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.ubb.movieapp.core.config.JPAConfig;

@Configuration
@ComponentScan({"ro.ubb.movieapp.core"})
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),
})
public class AppLocalConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}