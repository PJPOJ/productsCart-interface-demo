package model;

import java.util.ArrayList;

import model.discounts.FreeCupDiscount;
import model.discounts.ICanApplyDiscount;
import model.discounts.PercentDiscount;

public class Program {

	public static ArrayList<Product> getSampleProducts() {
		ArrayList<Product> products = new ArrayList<Product>();

		for (int i = 1; i <= 5; i++) {
			products.add(new Product("Product " + i, i * 25));
		}

		return products;
	}

	public static Cart getSampleCart() {
		Cart cart = new Cart();
		for (Product p : getSampleProducts()) {
			cart.getItems().add(new CartItem(p));
		}
		return cart;
	}

	public static void printCart(Cart cart) {

		System.out.println("=========================================");
		System.out.println("|Nazwa produktu\t|Cena\t|Cena promocyjna|");
		System.out.println("-----------------------------------------");
		for (CartItem item : cart.getItems()) {
			System.out.println("|" + item.getProduct().getName() + "\t|"
					+ item.getProduct().getPrice() + "\t|"
					+ item.getCurrentPrice() + "\t\t|");

			System.out.println("-----------------------------------------");
		}

		System.out.println("Suma: " + cart.totalPriceOfProducts());
		System.out.println("Suma po promocji: "
				+ cart.totalPriceOfDiscountedProducts());
	}

	public static void main(String[] args) {
		ICanApplyDiscount percentDiscount = new PercentDiscount(0.2);
		ICanApplyDiscount freeCupDiscount = new FreeCupDiscount();
		
		Cart cart = getSampleCart();
		cart.applyDiscount(freeCupDiscount);
		cart.applyDiscount(percentDiscount);
		printCart(cart);
		
	}
}













