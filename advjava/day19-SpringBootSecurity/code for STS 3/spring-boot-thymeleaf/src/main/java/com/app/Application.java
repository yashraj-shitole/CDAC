package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class Application implements WebMvcConfigurer{
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;

	public static void main(String[] args) {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("lang/messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		System.out.println(messageSource.getMessage("hello", null, Locale.ENGLISH));
		SpringApplication.run(Application.class, args);
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor);
	}

}
