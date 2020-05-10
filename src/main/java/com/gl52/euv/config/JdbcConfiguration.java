//package com.gl52.euv.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
///**
// * 数据源jdbc配置类
// */
//@Configuration
////@PropertySource("classpath:/jdbc.properties")//加载指定配置文件
////@EnableConfigurationProperties(JdbcProperties.class)
//public class JdbcConfiguration {
////      @Autowired
////      private JdbcProperties jdbcproperties;
////    @Value("${jdbc.driverClassName}")
////    private String driverClassName;
////    @Value("${jdbc.url}")
////    private String url;
////    @Value("${jdbc.username}")
////    private String username;
////    @Value("${jdbc.password}")
////    private String password;
//    /**
//     * 实例化druid
//     */
////    @Bean
////    public DataSource getDataSource(){
////        DruidDataSource source =new DruidDataSource();
////        source.setPassword(this.password);
////        source.setUsername(this.username);
////        source.setUrl(this.url);
////        source.setDriverClassName(this.driverClassName);
////        return  source;
////    }
//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")// springboot 注解 只读application文件
//    public DataSource getDataSource(){
//        DruidDataSource source =new DruidDataSource();
//        return  source;
//    }
//}
