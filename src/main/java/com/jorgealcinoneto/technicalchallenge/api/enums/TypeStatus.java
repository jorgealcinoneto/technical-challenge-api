package com.jorgealcinoneto.technicalchallenge.api.enums;

public enum TypeStatus {
	
	    ENABLED(0),
	    DISABLED(1);
	    
		private final Integer value;

		TypeStatus(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
}
