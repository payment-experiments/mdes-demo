package com.mastercard.api.demo.controller.form;

public class UpdatePanForm {

	private String pan;
	private String expDate;
	private String token;
	private String comment;
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public String getExpDate() {
		return this.expDate;
	}
	
	public void setExpDate(String exp){ 
		this.expDate = exp;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}