package com.springbook.biz;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	UserVO vo = new UserVO();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		vo.setId("test");
		vo.setPassword("123");
		
		
		UserVO user = userService.getUser(vo);
		model.addAttribute("id", user.getId());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("name", user.getName());
		model.addAttribute("role", user.getRole());
		
		System.out.println("Home id :" + user.getId());
		
		
//		UserVO user = userService.getUser(vo);
//		model.addAttribute("id", user.getId());
//		model.addAttribute("pass", user.getPassword());
//		model.addAttribute("name", user.getName());
//		model.addAttribute("role", user.getRole());
//		
//		System.out.println("Home id :" + user.getId());
		
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home";
	}
	
}
