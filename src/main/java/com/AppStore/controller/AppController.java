package com.AppStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import com.AppStore.entity.App;
import com.AppStore.entity.MyAppList;
import com.AppStore.service.AppService;
import com.AppStore.service.MyAppListService;

@Controller
public class AppController {
	@Autowired 
	AppService service;
	
	@Autowired
	MyAppListService myAppService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/app_register")
	public String AppRegister() {
		return "appRegister";
	}
	//Ask
	@GetMapping("/available_app")	
	public ModelAndView getAllApp() {
		List<App>list=service.getAllApp();
		return new ModelAndView("appList","app",list);
	}
	
	@PostMapping("/save")
	public String addApp(@ModelAttribute App b) {
		service.save(b);
		return "redirect:/available_app";
	}
	//Ask
	@GetMapping("/my_app")
	public String getAllMyApps(Model model)
	{
		List<MyAppList>list=myAppService.getAllMyApps();
		model.addAttribute("app",list);
		return "myApp";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		App b=service.getAppById(id);
		MyAppList mb=new MyAppList(b.getId(),b.getName(),b.getBrand(),b.getPrice());
		myAppService.saveMyApps(mb);
		return "redirect:/my_app";
	}
	
	@RequestMapping("/editApp/{id}")
	public String editApp(@PathVariable("id") int id,Model model) {
		App b=service.getAppById(id);
		model.addAttribute("app",b);
		return "AppEdit";
	}
	
	@RequestMapping("/deleteApp/{id}")
	public String deleteApp(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_app";
	}
	
	
	
}