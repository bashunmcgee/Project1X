package com.BabyBoomer.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Shooting to List a Description In items and List the Cost of Each Item
 * @author JuanMcGee
 *
 */
public class MemberListedItems {

	
	private List<String> listItemDescrption;
	private List<Double> listItemCost;
	
	

	public MemberListedItems() {
		super();
		listItemDescrption = new ArrayList<String>();
		listItemCost = new ArrayList<Double>();
	}

	public List<String> getListItemDescrption() {
		return listItemDescrption;
	}

	public void addListItemDescrption(String item) {
		this.listItemDescrption.add(item);
	}

	public List<Double> getListItemCost() {
		return listItemCost;
	}



	public void addListItemCost(Double item) {
		this.listItemCost.add(item);
	}
	
	
	public static void main(String[] args) {
		
		
		MemberListedItems list = new MemberListedItems();
		list.addListItemCost(250.00);
		list.addListItemDescrption("insurance");
		System.out.println(list.toString());
	}
	@Override
	public String toString() {
		return "Member Items [listItemDescrption=" + listItemDescrption + ", listItemCost=" + listItemCost + "]";
	}
	
	
	
}
