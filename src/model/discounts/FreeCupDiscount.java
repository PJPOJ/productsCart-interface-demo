package model.discounts;

import model.Cart;
import model.CartItem;
import model.Product;

public class FreeCupDiscount implements ICanApplyDiscount{

	public boolean canApplyDiscount(Cart cart){
		return cart.totalPriceOfProducts()>200;
	}
	
	public void applyDiscount(Cart cart){
		Product extraCup = new Product("Extra Cup", 0);
		cart.getItems().add(new CartItem(extraCup));
	}

}
