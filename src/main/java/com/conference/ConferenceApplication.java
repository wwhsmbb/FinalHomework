package com.conference;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication(scanBasePackages = "com.conference")
@MapperScan("com.conference.mapper")
public class ConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}
	
	@Bean
	public PageHelper getPageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("params", "count=countSql");
		properties.setProperty("pageSizeZero", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}
