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
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(basePackages= "restroom.repository.myapp",
        entityManagerFactoryRef= "myappEntityManagerFactory",
        transactionManagerRef= "myappTransactionManager")
public class MyappDataSourceConfiguration {
    
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.myapp")
    public DataSourceProperties myappDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.myapp.configuration")
    public DataSource myappDataSource() {
        return myappDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    
    @Primary
    @Bean(name= "myappEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean myappEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(myappDataSource())
                .packages("restroom.data")
                .build();
    }
    
    @Primary
    @Bean
    public PlatformTransactionManager myappTransactionManager(
            final @Qualifier("myappEntityManagerFactory") LocalContainerEntityManagerFactoryBean myappEntityManagerFactory) {
        return new JpaTransactionManager(myappEntityManagerFactory.getObject());
    }
}
