package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.model.Shelf;

public class CreateShelf extends _State {
	@Override
	public int show() {
		if(!sr.getMap().isEmpty())sc.getText();
		System.out.println("\nPlease type a name for your SHELF:");
		String name = sc.getText();
		System.out.println("Your SHELF name is " + name + ".\nType its capacity:");
		int capacity = sc.getInt();
		System.out.println("Your SHELF capacity is " + capacity + ".\nType its daily price(€):");
		float price = sc.getFloat();
		System.out.println("Your SHELF price is " + price + ".");
		Shelf s = new Shelf(name, capacity, price);
		System.out.println("SHELF " + s.getName() + " added successfully.");
		sr.addEntity(s);
		sr.printEntity();		
		return 1;
	}
	
	
}
