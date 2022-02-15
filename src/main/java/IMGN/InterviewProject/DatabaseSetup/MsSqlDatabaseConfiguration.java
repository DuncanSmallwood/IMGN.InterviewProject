package IMGN.InterviewProject.DatabaseSetup;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class MsSqlDatabaseConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource dataSource(){
        DataSourceBuilder msSqlConnection = DataSourceBuilder.create();
        msSqlConnection.url("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=IMGN")
                .username("sa")
                .password("Server2Admin");
        return msSqlConnection.build();
    }
}
