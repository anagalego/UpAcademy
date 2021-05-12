package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class TextInterface {
	
	private Scanner sc = new Scanner(System.in);
	
	private static List<Shelf> shelves = new ArrayList<>();	
	public static void addShelf(Shelf shelf) { shelves.add(shelf); }
	public static List<Shelf> getShelves() { return shelves; }

	private static List<Product> products = new ArrayList<>();	
	public static void addBook(Product product) { products.add(product); }
	public static List<Product> getBooks() { return products; }
	
	public void start() { System.out.println("Hello, what's your name?"); }
	
	public void end() { System.out.println("Come again!"); }
	
	public String getText() { return sc.nextLine(); }
	public int getInt() {
		do {
			if(sc.hasNextInt()) return sc.nextInt();
			else {
				System.out.println("Let's try again:");
				sc.nextLine(); }
		} while (true);
	}
	public float getFloat() {
		do {
			if(sc.hasNextFloat()) return sc.nextFloat();
			else {
				System.out.println("Let's try again:");
				sc.nextLine(); }
		} while (true);
	}
	
	public void printInfo(Object info) { System.out.println(info); }
	
	public void menu1() { System.out.println("Please select an option:\n\n1: Create Shelf\n2: Create Book\n3: List Shelfs\n4: List Books\n5: Quit"); }
	
	public int selectMenu1() {
		int i = getInt();
		while(i > 5) {
			System.out.println("Let's try again:");
			i = getInt();
		}
		switch(i) {
		case 1:
			createShelfMenu();
			createShelf();
			goBack();
			yesNo();
			return 1;
		case 2:
			createProductMenu();
			createProduct();
			goBack();
			yesNo();
			return 1;
		case 3:
			listShelves();
			goBack();
			yesNo();
			return 3;
		case 4:
			listProducts();
			goBack();
			yesNo();
			boolean b = yesNo();
			System.out.println(b);
			return 4;
		case 5:
			end();
			return 5;
		default: return 0;
		}
	}
	
	public void createShelfMenu() { System.out.println("\nPlease type a name for your SHELF:"); }	
	public void createShelf() {
		String name = getText();
		while(name.length() == 0) {
			if(name == null) System.out.println("\nLet's try again:");
			name = getText();
		}
		System.out.println("Your SHELF name is " + name + ".\nType its capacity:");
		int capacity = getInt();
		while(capacity == 0) {
			System.out.println("Let's try again:");
			capacity = getInt();
		}
		System.out.println("Your SHELF capacity is " + capacity + ".\nType its daily price(€):");
		float price = getFloat();
		while(price == 0) {
			System.out.println("Let's try again:");
			price = getFloat();
		}
		System.out.println("Your SHELF price is " + price + ".");
		Shelf s = new Shelf(name, capacity, price);
		addShelf(s);
		System.out.println("\nYour SHELF " + name + " was added successfully.");
		printShelfHead();
		s.printInfo();
	}
	
	public void createProductMenu() { System.out.println("\nPlease type a name for your PRODUCT:"); }	
	public void createProduct() {
		String name = getText();
		while(name.length() == 0) {
			if(name == null) System.out.println("\nLet's try again:");
			name = getText();
		}
		System.out.println("Your PRODUCT name is " + name + ".\nType its TAX(%):");
		float tax = getFloat();
		while(tax == 0) {
			System.out.println("Let's try again:");
			tax = getFloat();
		}
		System.out.println("Your PRODUCT author is " + tax + "\nType its price(€):");
		float pvp = getFloat();
		while(pvp == 0) {
			System.out.println("Let's try again:");
			pvp = getFloat();
		}
		System.out.println("Your PRODUCT price is " + pvp + ".\nType its discount(%):");
		float discount = getFloat();
		while(discount == 0) {
			System.out.println("Let's try again:");
			discount = getFloat();
		}
		System.out.println("Your PRODUCT discount is " + discount + ".");
		Product p = new Product(name, tax, pvp, discount);
		addBook(p);
		System.out.println("\nYour PRODUCT " + name + " was added successfully.");
		printProductHead();
		p.printInfo();
	}
	
	public void listShelves() { printShelfHead(); printShelves(); }	
	public static void printShelves() { shelves.forEach(s -> s.printInfo()); }
	
	public void listProducts() { printProductHead(); printProducts(); }
	public static void printProducts() { products.forEach(s -> s.printInfo()); }
		
	public static void goBack() { System.out.println("Do you want to go back?\n(Y/N)"); }	
	public boolean yesNo() {
		String option = getText();
		boolean b = false;
		while(option.length() == 0) {
			if(option.equals("Y")) {
					System.out.println("\nLet'go back.");
					b = true; }
				else if(option.equals("N")) {
					System.out.println("\nLet'stay right here.");
					b = false; }
				option = getText();		
		}
		return b;
	}
	
	public static void printProductHead() { System.out.println("PRODUCT:ID \t NAME \t PRICE \t TAX \t DISCOUNT \t SHELVES"); }
	public static void printShelfHead() { System.out.println("SHELF:ID \t NAME \t CAPACITY \t DAILY PRICE"); }

	
	
	
	
	
}
