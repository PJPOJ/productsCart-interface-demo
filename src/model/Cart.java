package model;

import java.util.ArrayList;

import model.discounts.FreeCupDiscount;
import model.discounts.ICanApplyDiscount;
import model.discounts.PercentDiscount;

public class Cart {

	private ArrayList<CartItem> items = new ArrayList<CartItem>();
	
	public double totalPriceOfProducts(){
		double sum = 0;
		for(CartItem item : items){
			sum+=item.getProduct().getPrice();
		}
		return sum;
	}
	
	public double totalPriceOfDiscountedProducts(){
		double sum = 0;
		
		for(CartItem item : items){
			sum+=item.getCurrentPrice();
		}
		
		return sum;
	}
	
	public ArrayList<CartItem> getItems(){
		return items;
	}

	public void applyDiscount(ICanApplyDiscount discount){
		if(discount.canApplyDiscount(this))
			discount.applyDiscount(this);
	}
	
	
	
}
