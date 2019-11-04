package com.jorgealcinoneto.technicalchallenge.api.enums;

public enum TypeGender {
	
	MALE("m"),
	FEMALE("f");
	
	private final String description;
	
	private TypeGender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
}
