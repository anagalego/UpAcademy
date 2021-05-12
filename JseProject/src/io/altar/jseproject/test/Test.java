package io.altar.jseproject.test;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class Test {

	public static void main(String[] args) {
		/*
		Product p1 = new Product("Mil Folhas", "Ana", 10.0f);
		Product p2 = new Product("Mil Folhas", "Ana", 10.0f);
		Product p3 = new Product("Mil Folhas", "Ana", 10.0f);
		Product p4 = new Product("Mil Folhas", "Ana", 10.0f);		
		Shelf s1 = new Shelf("My Shelf");
		s1.addProducts(p1, p2, p3, p4);
		s1.removeProducts(p1, p2);
		s1.printInfo();
		s1.printBooks();
		*/
		
		
		
		TextInterface ti = new TextInterface();		
		ti.start();
		String name = ti.getText();		
		ti.printInfo("Hello, " + name + ".");
		ti.menu1();
		ti.selectMenu1();
		
		
		

	}

}
