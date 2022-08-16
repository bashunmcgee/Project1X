package com.Kiss.constant;

public enum Categories {

	MedicalBills, Festivities, Phone, AutoInsurance, BoatInsurance, Vacation, Groceries, Rent, School, UnExpectedBills, HealthBills, Books, ChildSupport;
	
	
	
	private String type;
	
	
	
	public String getType() {
		return type;
	}




	Categories() {	
		
	}
	public void setType(String type) {
		this.type = type;
	}
}
