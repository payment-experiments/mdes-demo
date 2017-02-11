package com.mastercard.api.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.demo.controller.form.SearchForm;
import com.mastercard.api.mdescustomerservice.Search;


@Controller
public class SearchController extends WebMvcConfigurerAdapter {

	@RequestMapping("/")
	public String home(Model model) throws Exception{
		SearchForm search = new SearchForm();
		search.setPan("5412345678901234");
		search.setShowDeleted(true);
		model.addAttribute("search", search);
		return "search";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String search(@ModelAttribute SearchForm search, Model model) throws Exception{
				
        RequestMap map = new RequestMap();
        
        map.set("SearchRequest.AccountPan", search.getPan());
        map.set("SearchRequest.ExcludeDeletedIndicator", String.valueOf(!search.getShowDeleted()) );
        map.set("SearchRequest.AuditInfo.UserId", "A1435477");
        map.set("SearchRequest.AuditInfo.UserName", "John Smith");
        map.set("SearchRequest.AuditInfo.Organization", "Any Bank");

        
        Search response = Search.create(map);
        model.addAttribute("search", search);
		model.addAttribute("account", response.get("SearchResponse.Accounts.Account[0]"));
		model.addAttribute("tokens", response.get("SearchResponse.Accounts.Account[0].Tokens.Token"));
		
		return "search";
	}
}
