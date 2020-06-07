package com.mtheile.utils.simpleetl.target;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "targetEntityManagerFactory", transactionManagerRef = "targetTransactionManager", basePackages = { "com.lithodat.app" })
public class TargetDbConfig {

	private static final String CURRENT_SCHEMA = "public";

	@Bean(name = "targetDataSource")
	public DataSource dataSource() {
		// AWS ProdDatabase
		// return DataSourceBuilder.create().//
		// url("jdbc:postgresql://aad3vf18zd4ewc.chp07jsm0quq.eu-central-1.rds.amazonaws.com:5432/ebdb?currentSchema=" + CURRENT_SCHEMA).//
		// username("postgres").//
		// password("lithodat.com#asdf").//
		// build();

		return DataSourceBuilder.create().//
				url("jdbc:postgresql://localhost:5432/LithodatApp").//
				username("postgres").//
				password("mutzmutz").//
				build();

	}

	// from https://stackoverflow.com/questions/46574686/spring-boot-2-0-0-m4-hibernate-5-2-11-final-could-not-find-bean-of-type-entity/51305724
	// There is only one JpaBaseConfiguration implementation - HibernateJpaConfiguration, which is activated if there is only one DataSource candidate (or one is marked as @Primary)
	// so create EntityManagerFactoryBuilder in your configuration manually:
	@Bean(name = "targetEntityManagerFactoryBuilder")
	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	@Bean(name = "targetEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean targetEntityManagerFactory(
			@Qualifier("targetEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
			@Qualifier("targetDataSource") DataSource dataSource) {

		Map<String, String> properties = new HashMap<>();

		// see https://www.baeldung.com/spring-data-jpa-batch-inserts
		properties.put("hibernate.jdbc.batch_size", "100");
		// properties.put("hibernate.order_inserts", "true");

		properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");

		{// Without these 2 properties: java.sql.SQLFeatureNotSupportedException: Die Methode org.postgresql.jdbc.PgConnection.createClob() ist noch nicht implementiert.
			// Disable feature detection by this undocumented parameter. Check the org.hibernate.engine.jdbc.internal.JdbcServiceImpl.configure method for more details.
			properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
			// Because detection is disabled you have to set correct dialect by hand.
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		}

		return builder
				.dataSource(dataSource)
				.packages("com.mtheile.utils.simpleetl.target.domain")
				.persistenceUnit("target")
				.properties(properties)
				.build();
	}

	@Bean(name = "targetTransactionManager")
	public PlatformTransactionManager targetTransactionManager(
			@Qualifier("targetEntityManagerFactory") EntityManagerFactory targetEntityManagerFactory) {
		return new JpaTransactionManager(targetEntityManagerFactory);
	}

}