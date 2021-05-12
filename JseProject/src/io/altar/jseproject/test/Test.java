package io.altar.jseproject.test;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class Test {

	public static void main(String[] args) {
		
		Product p1 = new Product("Mil Folhas", 6, 10.00f, 10.0f);
		Product p2 = new Product("Mil Folhas", 6, 10.00f, 10.0f);
				
		Shelf s1 = new Shelf("My Shelf", 1, 15.00f);
		Shelf s2 = new Shelf("My Shelf", 1, 15.00f);
		Shelf s3 = new Shelf("My Shelf", 1, 15.00f);
		Shelf s4 = new Shelf("My Shelf", 1, 15.00f);
		
		
		p1.addToShelves(s1, s2, s3);
		p1.removeFromShelves(s1);
		p1.printInfo();
		
		
		TextInterface ti = new TextInterface();		
		ti.start();
		String name = ti.getText();		
		ti.printInfo("Hello, " + name + ".");
		ti.menu1();
		ti.selectMenu1();
		
		
		

	}

}
