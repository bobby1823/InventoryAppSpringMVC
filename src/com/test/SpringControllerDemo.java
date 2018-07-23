package com.test;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringControllerDemo {

	@RequestMapping("/")
	public String controller() {
		return "demoHtml";
	}
	
	@RequestMapping("showForm")
	public String showForm() {
		return "helloWorld";
	}
	
	@RequestMapping("/processForm")
	public String processForm(/*HttpServletRequest request, Model model*/) {
		
		return "process-FormOne";
	}
}
