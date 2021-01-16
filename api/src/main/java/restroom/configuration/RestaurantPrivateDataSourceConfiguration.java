/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author PepCarmona
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= "restroom.repository.restaurantPrivate",
        entityManagerFactoryRef= "restaurantPrivateEntityManagerFactory",
        transactionManagerRef= "restaurantPrivateTransactionManager")
public class RestaurantPrivateDataSourceConfiguration {
    
    @Bean
    @ConfigurationProperties("spring.datasource.restaurant-private")
    public DataSourceProperties restaurantPrivateDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    @ConfigurationProperties("spring.datasource.restaurant-private.configuration")
    public DataSource restaurantPrivateDataSource() {
        return restaurantPrivateDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    
    @Bean(name= "restaurantPrivateEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean restaurantPrivateEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(restaurantPrivateDataSource())
                .packages("restroom.data")
                .build();
    }
    
    @Bean
    public PlatformTransactionManager restaurantPrivateTransactionManager(
            final @Qualifier("restaurantPrivateEntityManagerFactory") LocalContainerEntityManagerFactoryBean restaurantPrivateEntityManagerFactory) {
        return new JpaTransactionManager(restaurantPrivateEntityManagerFactory.getObject());
    }
}
