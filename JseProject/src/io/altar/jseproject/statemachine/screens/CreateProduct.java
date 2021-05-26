package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.model.Product;
 
public class CreateProduct extends _State {

	@Override
	public int show() {	
		if(!pr.getMap().isEmpty())sc.getText();
		System.out.println("\nPlease type a name for your PRODUCT:");
		String name = sc.getText();
		System.out.println("Your PRODUCT name is " + name + ".\nType its tax(%):");
		float tax = sc.getOption(6, 13, 23);
		System.out.println("Your PRODUCT tax is " + tax + "%.\nType its price(€):");
		float tempP = sc.getFloat();
		float price = tempP*tax/100 + tempP;		
		System.out.println("Your PRODUCT price is " + price + "€.\nType its discount(%):");
		float discount = sc.getFloat();
		System.out.println("Your PRODUCT discount is " + discount + "%.");
		Product p = new Product(name, tax, price, discount);
		System.out.println("Your PRODUCT " + p.getName() + " added successfully.");
		pr.addEntity(p);
		pr.printEntity();
		return 1;
	}
	
}
