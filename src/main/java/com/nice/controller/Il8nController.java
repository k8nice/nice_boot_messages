package com.nice.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/il8n")
public class Il8nController {
	
	/**
	 * 注入国际化消息接口对象
	 */
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/page")
	public String page(HttpServletRequest request) {
			Locale locale = LocaleContextHolder.getLocale();
			String msg = messageSource.getMessage("msg", null,locale);
			request.setAttribute("msg", msg);
			request.setAttribute("locale", locale);
			System.out.println("msg = " + msg);
			//返回视图
			return "il8n/internationalization";
	}
}
