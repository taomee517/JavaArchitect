//package org.demo.webflux.config;
//
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//
//import static io.r2dbc.spi.ConnectionFactoryOptions.*;
//
///**
// * @author 罗涛
// * @title DatabaseConfiguration
// * @date 2020/12/16 14:50
// */
//@Configuration
//@EnableR2dbcRepositories
//public class DatabaseConfiguration extends AbstractR2dbcConfiguration {
//
//    @Override
//    public ConnectionFactory connectionFactory() {
//        ConnectionFactory connectionFactory = ConnectionFactories.get(
//                builder().option(DRIVER, "mysql")
//                        .option(HOST, "localhost")
//                        .option(PORT, 3306)
//                        .option(USER, "root")
//                        .option(PASSWORD, "123456")
//                        .option(DATABASE, "db_webflux")
//                        .build());
//        return connectionFactory;
//    }
//}
