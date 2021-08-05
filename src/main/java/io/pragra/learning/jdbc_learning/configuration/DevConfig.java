package io.pragra.learning.jdbc_learning.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DevConfig {
DataSource dataSource= DataSourceBuilder.create().url("jdbc:h2:mem:appdb").username("sa").build();

}
