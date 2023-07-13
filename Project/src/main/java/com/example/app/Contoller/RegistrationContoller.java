package com.example.app.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.WebServiceCall.WebService;

@Controller
public class RegistrationContoller {
	private String registerResp = "";
	private String loginResp = "";

	@GetMapping("/home")
	public ModelAndView register() {
		return new ModelAndView("registerPage");
	}

	@PostMapping("/register")
	public String home(@RequestBody String registrationDetails) {
		ResponseEntity<String> response = new WebService().serviceCall(registrationDetails);
		registerResp = response.getBody();
		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println(registerResp);
			return registerResp;
		} else {
			System.out.println("Error: " + response.getStatusCode());
			return null;
		}
	}

	@GetMapping("/signin")
	public ModelAndView authLogin() {
		return new ModelAndView("loginPage");
	}

	@PostMapping("/auth/signin")
	public String loginApi(@RequestBody String loginDetails) {
		ResponseEntity<String> loginResponse = new WebService().loginServicecall(loginDetails);
		
		loginResp = loginResponse.getBody();
		System.out.println(loginResp);
		return loginResp;
	}

	@RequestMapping("/addcode")
	public ModelAndView addCode() {
		return new ModelAndView("responsePage");
	}

}
