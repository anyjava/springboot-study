package dev.anyjava.springboot.test.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbUnitConfig {

    /**
     * 이부분은 설정 해도 되고 안해도 됨, multiDataSource 일때는 필요
     * @return
     */
    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean config = new DatabaseConfigBean();
        config.setAllowEmptyFields(true);
        return config;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource dataSource) {
        final DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection = new DatabaseDataSourceConnectionFactoryBean();
        dbUnitDatabaseConnection.setDataSource(dataSource);
        dbUnitDatabaseConnection.setDatabaseConfig(dbUnitDatabaseConfig());
        return dbUnitDatabaseConnection;
    }
}
