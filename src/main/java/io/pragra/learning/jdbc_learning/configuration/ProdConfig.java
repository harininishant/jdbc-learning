package io.pragra.learning.jdbc_learning.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class ProdConfig {
    /*
    Connecting to MySQL Using the JDBC driverClassName("com.mysql.cj.jdbc.Driver")
     DataSource object represents. An alternative to the DriverManager facility,
     a DataSource object is the preferred means of getting a connection
     */

    @Bean
    public DataSource dataSource(){
    return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
            .username("produser").password("produser").url("jdbc:mysql://localhost:3306/proddb").build();
}
//
//    DataSource dataSource =  DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
//          .username("produser").password("produser").url("jdbc:mysql://localhost:3306/proddb").build();
//

}// the @Bean anotation is needed when the prod profile is not mentioned in yml.
// howveer we can omit that if we have yml page
