package com.mastercard.api.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.mdescustomerservice.Transactions;


@Controller
public class TransactionController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String transaction(@RequestParam String token, Model model) throws Exception{
				
		RequestMap map = new RequestMap();
        map.set("TransactionsRequest.TokenUniqueReference", token);
        map.set("TransactionsRequest.AuditInfo.UserId", "A1435477");
        map.set("TransactionsRequest.AuditInfo.UserName", "John Smith");
        map.set("TransactionsRequest.AuditInfo.Organization", "Any Bank");
        map.set("TransactionsRequest.AuditInfo.Phone", "5555551234");
        
        Transactions response = Transactions.create(map);
        model.addAttribute("token",token);
        model.addAttribute("response", response.get("TransactionsResponse"));
        model.addAttribute("transactions", response.get("TransactionsResponse.Transactions.Transaction"));
		return "transactions";
	}
}
