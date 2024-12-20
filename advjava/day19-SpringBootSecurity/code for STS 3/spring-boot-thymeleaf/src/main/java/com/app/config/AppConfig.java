package com.app.config;


import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class AppConfig {

  @Bean
  public LocaleResolver localeResolver() {
      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
      localeResolver.setDefaultLocale(Locale.ENGLISH);
      return localeResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
      // Defaults to "locale" if not set
      localeChangeInterceptor.setParamName("localeData");
      return localeChangeInterceptor;
  }


}
