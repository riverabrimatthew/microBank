package com.login.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.entity.User;
import com.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new User());
		return mav;
	}
	
	@PostMapping("/home")
	public String login(@ModelAttribute("user")User user, Model model) {
		User userPass = loginService.login(user.getUsername(),user.getPassword());
		if(Objects.nonNull(userPass)) {			
			model.addAttribute("accountnumber", userPass.getAccountnumber());
			model.addAttribute("username",userPass.getUsername());
			model.addAttribute("contactnumber", userPass.getContactnumber());
			model.addAttribute("creationdate", userPass.getCreationdate());
			model.addAttribute("totalbalance", userPass.getTotalbalance());			
			return "index";
		}else {
			return "redirect:/";
		}
	}
	
    @PostMapping("/logout")
    public String logoutDo()
    {    
        return "redirect:/";
    }
}
