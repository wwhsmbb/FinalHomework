package com.conference.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.ConferenceMenu;
import com.conference.entity.ConferenceUser;
import com.conference.service.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService loginService;	
	
	@GetMapping("/login")
	public ModelAndView view(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(String loginName,String loginPwd,ModelAndView modelAndView,HttpSession session) {
		ConferenceUser user = loginService.loginUser(loginName, loginPwd);
		ConferenceEmployee employee = loginService.loginEmployee(loginName, loginPwd);
		if(user!=null) {
			session.setAttribute("user", user);
			modelAndView.addObject("user", user);
			modelAndView.setViewName("index");
		}else if(employee!=null) {
			session.setAttribute("employee", employee);
			modelAndView.addObject("employee", employee);
			modelAndView.setViewName("employeeIndex");
		}else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}	
	
	@PostMapping("/queryListMenu")
	public List<ConferenceMenu> queryListMenu(String userId){
		List<ConferenceMenu> menu = loginService.queryListMenu(userId);
		return menu;
	}
	
	@PostMapping("/findListMenu")
	public List<ConferenceMenu> findListMenu(String employeeSno){
		List<ConferenceMenu> menu = loginService.findListMenu(employeeSno);
		return menu;
	}
}
