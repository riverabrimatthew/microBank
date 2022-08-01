package com.login.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.login.entity.User;
import com.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new User());
		return mav;
	}
	@PostMapping("/home")
	public String login(@ModelAttribute("user")User user, Model model) {
		User oauthUser = loginService.login(user.getUsername(),user.getPassword());
		if(Objects.nonNull(oauthUser)) {
			
			model.addAttribute("accountnumber", oauthUser.getAccountnumber());
			model.addAttribute("username",oauthUser.getUsername());
			model.addAttribute("contactnumber", oauthUser.getContactnumber());
			model.addAttribute("creationdate", oauthUser.getCreationdate());
			model.addAttribute("totalbalance", oauthUser.getTotalbalance());
			
			return "index";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/transactionHistory")
	public String getAllTransaction(Model model) {
		String transacList = restTemplate.getForObject("http://localhost:1020//transactionHistory", String.class);
		model.addAttribute("transacList", transacList);
		return "trnscHistory";
	}
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
        return "redirect:/";
    }
}
