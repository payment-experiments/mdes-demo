package com.mastercard.api.demo.controller.form;

public class SearchForm {

	private String pan;
	private Boolean showDeleted;
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public Boolean getShowDeleted() {
		return this.showDeleted;
	}
	
	public void setShowDeleted(Boolean show){ 
		this.showDeleted = show;
	}
}