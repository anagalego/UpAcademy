package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;

public class CreateShelf extends _State {
	@Override
	public int show() {
		Shelf s;
		do {
			System.out.println("\nPlease type a name for your SHELF:");
			String name = sc.getText();
			System.out.println("Your SHELF name is " + name + ".\nType its capacity:");
			int capacity = sc.getInt();
			System.out.println("Your SHELF capacity is " + capacity + ".\nType its daily price(€):");
			float price = sc.getFloat();
			System.out.println("Your SHELF price is " + price + ".");
			s = new Shelf(name, capacity, price);
		} while(s == null);
		System.out.println("SHELF " + s.getName() + " added successfully.");
		sr.addEntity(s);
		ti.printShelves();		
		return 1;
	}
}
