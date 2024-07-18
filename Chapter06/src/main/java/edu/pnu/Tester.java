package edu.pnu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tester {
	
	
//	@GetMapping("/Hello")
//	public void hello() {
//		// /WEB-INF/board/Hello.jsp
//	}
	
//	@GetMapping("/hello")
//	public ModelAndView hello(String name) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",name);
//		mv.setViewName("hello");
//		
//		return mv;
//	}
//	@GetMapping("/hello")
//	public String hello(String name , Model model) {
//		model.addAttribute("name",name);
//		return "hello";
//	}
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting","Hello 타임리프");
	}
}
