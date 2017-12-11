package com.hbsis.bookstore.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "", "/" })
public class HomeIndexControllerImpl {
	
	  /*@RequestMapping("/home")
	    String home(ModelMap modal) {
	        modal.addAttribute("title","CRUD Example");
	        return "index";
	    }*/
	 
	    @RequestMapping("/partials/{page}")
	    String partialHandler(@PathVariable("page") final String page) {
	        return page;
	    }
	
	 @RequestMapping("/home")
	 public String home() {
	  return "index";
	 }

}
