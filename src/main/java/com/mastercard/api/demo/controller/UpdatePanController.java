package com.mastercard.api.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.demo.controller.form.SearchForm;
import com.mastercard.api.demo.controller.form.UpdatePanForm;
import com.mastercard.api.mdescustomerservice.TokenUpdate;


@Controller
public class UpdatePanController extends WebMvcConfigurerAdapter {
	
	
	@RequestMapping(value = "/update-pan", method = RequestMethod.GET)
	public String home(Model model) throws Exception{
		
		UpdatePanForm form = new UpdatePanForm();
		form.setComment("");
		form.setExpDate("");
		form.setPan("");
		form.setToken("");
		
		model.addAttribute("form", form);
		
		return "update-pan";
	}
	
	@RequestMapping(value = "/update-pan", method = RequestMethod.POST)
	public String updatePan(@ModelAttribute UpdatePanForm form, Model model) throws Exception{
       
        RequestMap map = new RequestMap();
		map.set("TokenUpdateRequest.TokenUniqueReference", form.getToken());
		map.set("TokenUpdateRequest.NewAccountPan", form.getPan());
		map.set("TokenUpdateRequest.ExpirationDate", form.getExpDate());
		map.set("TokenUpdateRequest.AccountPanSequenceNumber", "1");
		map.set("TokenUpdateRequest.UpdateWalletProviderIndicator", "1");
		map.set("TokenUpdateRequest.CommentText", "Confirmed cardholder identity.");
		map.set("TokenUpdateRequest.AuditInfo.UserId", "A1435477");
		map.set("TokenUpdateRequest.AuditInfo.UserName", "John Smith");
		map.set("TokenUpdateRequest.AuditInfo.Organization", "Any Bank");
		map.set("TokenUpdateRequest.AuditInfo.Phone", "5555551234");

		TokenUpdate response = TokenUpdate.create(map);
		model.addAttribute("response", response.get("TokenUpdateResponse"));
		
		return "update-pan-confirmation";
	}

}
