package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.dao.token.TokenDaoImpl;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Factory
public class MybatisFactory {

    private final DataSource dataSource;

    public MybatisFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    SqlSessionFactory sqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("co.anbora.labs.claro.data.repository");

        return new SqlSessionFactoryBuilder().build(configuration);
    }

    @Bean
    @Singleton
    TokenDao provideTokenDao(SqlSessionFactory sessionFactory) {
        return new TokenDaoImpl(sessionFactory);
    }

}
