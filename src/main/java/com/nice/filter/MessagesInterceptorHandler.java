package com.nice.filter;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessagesInterceptorHandler implements WebMvcConfigurer   {
	/**
	 * 国际化拦截器
	 */
	private LocaleChangeInterceptor lci = null;
	
	/**
	 * 国际化解析器。注意，这个Bean Name要为localeResolver
	 * @return slr
	 */
	@Bean(name="localeResolver")
	public LocaleResolver initLocaleResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		//默认国际化区域
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return slr;
	}
	
	/**
	 * 创建国际化拦截器
	 * @return lci
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		if(lci != null) {
			return lci;
		}
		lci = new LocaleChangeInterceptor();
		//设置参数名
		lci.setParamName("language");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		InterceptorRegistration ir = registry.addInterceptor(localeChangeInterceptor());
//		ir.addPathPatterns("/il8n/*");
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	

}
