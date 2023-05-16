package com.marketingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@Controller
public class LeadController {
	
	@Autowired
	public LeadRepository leadRepository;
	
	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead"; 
	
	}
	
	@RequestMapping("/saveLead")
   public String saveLead (@ModelAttribute("lead") Lead lead, ModelMap modelmap) {
		
		leadRepository.save(lead);
		
		System.out.println(lead.getId());
		System.out.println(lead.getEmail());
		System.out.println(lead.getFirstname());
		System.out.println(lead.getLastname());
		System.out.println(lead.getMobile());
		
		modelmap.addAttribute("msg","lead saved");
		return "show_lead";
	}
}
