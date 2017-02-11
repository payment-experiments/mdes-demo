package com.mastercard.api.demo.config;

import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.demo.controller.SearchController;


@Configuration
public class MastercardApiConfiguration {

	public MastercardApiConfiguration() throws Exception {
		String consumerKey = "RpamjIaeNu6P_f_ucLr7UebzBD1tgr1AYLLfT57Yccf4212c!2111ea70323d4828a70a39dabdcfabea0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
        String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
        String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
        InputStream is = SearchController.class.getResourceAsStream("/mdes-customerservice-1486586740-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
        ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
        ApiConfig.setSandbox(true);     // For production: use ApiConfig.setSandbox(false);
	}
}
