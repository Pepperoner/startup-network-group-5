package ua.goit.java.startup.config;



//import org.hibernate.SessionFactory;
//import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("ua.goit.java.startup")
//@PropertySource("classpath:app.properties")
@EnableJpaRepositories("ua.goit.java.startup.dao")
public class DataConfig {


    private static final String PROP_DATABASE_DRIVER = "db.driver";
    //private static final String PROP_DATABASE_PA = "db.driver";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";

    @Resource
    private Environment env;

    /*   @Bean(destroyMethod = "close")
       public BasicDataSource dataSourceBean(){
           BasicDataSource basicDataSource = new BasicDataSource();
           basicDataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
           basicDataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
           //basicDataSource.setPassword(password);
           basicDataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
           return basicDataSource;
       }

   */
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/startap");
        dataSource.setUsername("root");
        //dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        return dataSource;
    }

/*    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        //set database connections
        bean.setDataSource(dataSource);
        //set where to scan @Table entity
        bean.setPackagesToScan("com.dimas.entity");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        bean.setHibernateProperties(properties);


        return  bean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        return  new HibernateTransactionManager(sessionFactory);
    }

*/
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        //System.out.println("LocalContainerEntityManagerFactoryBean++++++++++++++++++++++++++++++++++++++++++++++++++++ 1");
        entityManagerFactoryBean.setDataSource(dataSource());
        //System.out.println("LocalContainerEntityManagerFactoryBean++++++++++++++++++++++++++++++++++++++++++++++++++++ 2");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
       // System.out.println("LocalContainerEntityManagerFactoryBean++++++++++++++++++++++++++++++++++++++++++++++++++++ 3");
        entityManagerFactoryBean.setPackagesToScan("ua.goit.java.startup.dto");
        //System.out.println("LocalContainerEntityManagerFactoryBean++++++++++++++++++++++++++++++++++++++++++++++++++++ 4");

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
       // System.out.println("LocalContainerEntityManagerFactoryBean++++++++++++++++++++++++++++++++++++++++++++++++++++ 5");
        return entityManagerFactoryBean;
    }


    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }





    private Properties getHibernateProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        return properties;
    }


}

