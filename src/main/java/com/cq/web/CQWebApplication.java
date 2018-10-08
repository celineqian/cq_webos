package com.cq.web;


import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class CQWebApplication {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CQWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CQWebApplication.class, args);
		logger.debug("启动成功");
	}
}