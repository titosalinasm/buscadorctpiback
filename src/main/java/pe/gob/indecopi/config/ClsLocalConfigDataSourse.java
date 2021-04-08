package pe.gob.indecopi.config;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("local")
@Configuration
@EnableTransactionManagement
public class ClsLocalConfigDataSourse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//CTPI

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.driverClassName}")
	private String dbDriverClassName;

	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	//OIN

	@Value("${spring.datasource.url2}")
	private String datasourceUrl2;

	@Value("${spring.datasource.driverClassName2}")
	private String dbDriverClassName2;

	@Value("${spring.datasource.username2}")
	private String dbUsername2;

	@Value("${spring.datasource.password2}")
	private String dbPassword2;

	
	
	@Primary
	@Bean(destroyMethod = "")	
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(datasourceUrl);
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(destroyMethod = "")
	@Qualifier("dataSourceOIN")
	public DataSource dataSourceOIN() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(datasourceUrl2);
		dataSource.setDriverClassName(dbDriverClassName2);
		dataSource.setUsername(dbUsername2);
		dataSource.setPassword(dbPassword2);
		return dataSource;
	}

	@Bean(name = "transactionManagerOIN")
	DataSourceTransactionManager transactionManagerSEL(@Qualifier("dataSourceOIN") DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}

}
