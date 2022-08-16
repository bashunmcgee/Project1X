package com.BabyBoomer.Bean;

import java.util.HashMap;
import java.util.Map;

import com.Kiss.constant.Categories;

public class Member extends Account{
	
	private double totalMoney;
	private MemberListedItems list;
	private Map<Categories, MemberListedItems> budget;
	private Categories category;



	public Member(String firstname, String lastname, String username, String email, String password, String mobile) throws Exception {
		super(firstname, lastname, username, email, password, mobile);

		list = new MemberListedItems();
		budget = new HashMap<Categories, MemberListedItems>();
		
		
	}

	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}


	
	
	@Override
	public String toString() {
		return "Member [ TotalFunds = " + totalMoney + ", list = " + list + "]";
	}

	public MemberListedItems getList() {
		return list;
	}




	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	
	
	
	
	
	
}
