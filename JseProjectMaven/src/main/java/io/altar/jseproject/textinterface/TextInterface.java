package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	
	ScannerUtils sc = new ScannerUtils();
	ShelfRepository sr = ShelfRepository.getInstance();
	ProductRepository pr = ProductRepository.getInstance();
			
	public void start() {
		int option;
		do {
			System.out.println(
				"\nPlease select an option:\n"
				+ "\n1: List Shelfs"
				+ "\n2: List Products"
				+ "\n3: Quit\n");
			option = sc.getInt(3);
			switch(option) {
			case 1:
				listShelves();
				break;
			case 2:
				listProducts();
				break;
			case 3:
				System.out.println("GoodBye!");
				break;
			}
		} while(option != 3);
	}
	
	public void listShelves() {
		int option;
		do {
			System.out.println(
				"\nPlease select an option:\n"
				+ "\n1: Create Shelf"
				+ "\n2: Edit Shelf"
				+ "\n3: Check Shelf"
				+ "\n4: Remove Shelf"
				+ "\n5: Go Back\n");
			option = sc.getInt(5);
			switch(option) {
			case 1:
				createShelf();
				break;
			case 2:
				editShelf();
				break;
			case 3:
				checkShelf();
				break;
			case 4:
				removeShelf();
				break;
			case 5:
				start();
				break;
			}
		} while(option != 5);
	}
		
	public void createShelf() {
		Shelf s;
		do {
			sc.getText();
			System.out.println("\nPlease type a name for your SHELF:");
			String name = sc.getText();
			System.out.println("Your SHELF name is " + name + ".\nType its capacity:");
			int capacity = sc.getInt();
			System.out.println("Your SHELF capacity is " + capacity + ".\nType its daily price(€):");
			float price = sc.getFloat();
			System.out.println("Your SHELF price is " + price + ".");
			s = new Shelf(name, capacity, price);
		} while(s == null);
		System.out.println("\nYour SHELF " + s.getName() + " was created successfully.");
		sr.addEntity(s);
		printShelves();
		listShelves();
	}

	public void editShelf() {
		int option;
		long listed = sr.listed();
		do {
			System.out.println(
					"\n\nPlease type the SHELF ID you want to edit:"
					+ "\nType 0 to go back.");
			printShelves();
			option = sc.getInt();
			if(option == 0) listShelves();
			else if(option > listed) System.out.println("\nSHELF " + option + " doesn't exist.");
		} while(option > listed || option == 0);
		Shelf s = sr.getEntity(option);
		int attr;
		do {
			System.out.println(
				"\nEdit SHELF " + option + ":\n"
				+ "\n1: Name"
				+ "\n2: Daily Fee"
				+ "\n3: Capacity"
				+ "\n4: Product"
				+ "\n5: Go Back\n");
			attr = sc.getInt(5);
			switch(attr) {
			case 1:
				System.out.println("\nEnter new name:");
				String newName;
				do {
					newName = sc.getText();
					s.setName(newName);
				} while(newName == null);
				break;
			case 2:
				System.out.println("\nEnter new fee:");
				float newFee;
				do {
					newFee = sc.getFloat();
					s.setPrice(newFee);
				} while(newFee == 0);
				break;
			case 3:
				System.out.println("\nEnter new capacity:");
				int newCapacity;
				do {
					newCapacity = sc.getInt();
					s.setCapacity(newCapacity);
				} while(newCapacity == 0);
				break;
			case 4:
				System.out.println("\nSelect PRODUCT:");
				printProducts();
				Product newProduct;
				long productId;
				do {
					productId = sc.getLong(pr.listed());
					newProduct = pr.getEntity(productId);
					newProduct.addToShelves(s.getId());;
				} while(newProduct == null);
				break;
			case 5:
				listShelves();
				break;
			}
		} while(attr != 5);
		System.out.println("\nSHELF " + option + " was edited successfully.");
	}
	
	public void removeShelf() {
		int option;
		long listed = sr.listed();
		do {
			System.out.println(
					"\n\nPlease type the SHELF ID you want to remove:"
					+ "\nType 0 to go back.");
			printShelves();
			option = sc.getInt();
			if(option == 0) listShelves();
			else if(option > listed) System.out.println("\nSHELF " + option + " doesn't exist.");
		} while(option > listed || option == 0);
		sr.removeEntity(option);
		System.out.println("\nSHELF " + option + " was removed successfully.");
	}

	public void checkShelf() {
		printShelves();
	}
	
	public void printShelves() {
		System.out.println("\nID \tNAME \tPRICE \tCAPACITY");
		sr.getMap().forEach((k,v) -> v.printInfo());
	}
	
	public void printShelf(long id) {
		System.out.println("\nID \tNAME \tPRICE \tCAPACITY");
		sr.getEntity(id).printInfo();
	}
	
	public void listProducts() {
		int option;
		do {
			System.out.println(
				"\nPlease select an option:\n"
				+ "\n1: Create Product"
				+ "\n2: Edit Product"
				+ "\n3: Check Product"
				+ "\n4: Remove Product"
				+ "\n5: Go Back");
			option = sc.getInt(5);
			switch(option) {
			case 1:
				createProduct();
				break;
			case 2:
				removeProduct();
				break;
			case 3:
				checkProduct();
				break;
			case 4:
				editProduct();
				break;
			case 5:
				start();
				break;
			}
		} while(option != 5);
	}
			
	public void createProduct() {
		Product p;
		do {
			sc.getText();
			System.out.println("\nPlease type a name for your PRODUCT:");
			String name = sc.getText();
			System.out.println("Your PRODUCT name is " + name + ".\nType its tax(%):");
			float tax = sc.getFloat();
			System.out.println("Your PRODUCT tax is " + tax + ".\nType its price(€):");
			float price = sc.getFloat();
			System.out.println("Your PRODUCT price is " + price + ".\nType its discount(%):");
			float discount = sc.getFloat();
			System.out.println("Your PRODUCT discount is " + discount + ".");
			p = new Product(name, tax, price, discount);
		} while(p == null);
		System.out.println("\n\nYour PRODUCT " + p.getName() + " was added successfully.");
		pr.addEntity(p);
		printProducts();
	}
	
	public void removeProduct() {
		int option;
		long listed = pr.listed();
		do {
			System.out.println(
					"\n\nPlease type the PRODUCT ID you want to remove:"
					+ "\nType 0 to go back.");
			printProducts();
			option = sc.getInt();
			if(option == 0) listProducts();
			else if(option > listed) System.out.println("\nPRODUCT " + option + " doesn't exist.");
		} while(option > listed || option == 0);
		pr.removeEntity(option);
		System.out.println("\nPRODUCT " + option + " was removed successfully.");
	}
	
	public void checkProduct() {
		printProducts();
	}
	
	public void editProduct() {
		int option;
		do {
			System.out.println(
					"\n\nPlease type the PRODUCT ID you want to edit:"
					+ "\nType 0 to go back.");
			printProducts();
			option = sc.getInt();
			if(option == 0) listProducts();
			else if(option > pr.listed()) System.out.println("\nPRODUCT " + option + " doesn't exist.");
		} while(option > pr.listed() || option == 0);
		Product p = pr.getEntity(option);
		int attr;
		do {
			System.out.println(
				"\nEdit PRODUCT " + option + ":\n"
				+ "\n1: Name"
				+ "\n2: Price"
				+ "\n3: Tax"
				+ "\n4: Discount"
				+ "\n5: Add to Shelves"
				+ "\n6: Go Back\n");
			attr = sc.getInt(6);
			switch(attr) {
			case 1:
				System.out.println("\nEnter new name:");
				String newName;
				do {
					newName = sc.getText();
					p.setName(newName);
				} while(newName == null);
				break;
			case 2:
				System.out.println("\nEnter new price:");
				float newPrice;
				do {
					newPrice = sc.getFloat();
					p.setPrice(newPrice);
				} while(newPrice == 0);
				break;
			case 3:
				System.out.println("\nEnter new tax:");
				float newTax;
				do {
					newTax = sc.getFloat();
					p.setTax(newTax);
				} while(newTax == 0);
				break;
			case 4:
				System.out.println("\nEnter new discount:");
				float newDiscount;
				do {
					newDiscount = sc.getFloat();
					p.setDiscount(newDiscount);
				} while(newDiscount == 0);
				break;
			case 5:
				System.out.println("\nSelect SHELF/S:");
				printShelves();
				long[] newShelves;
				long id;
				do {
					id = sc.getLong(pr.listed());
					/*
					String[] shelvesIds = sc.getText().split(" ");
					newShelves = Arrays.stream(shelvesIds)
							.filter(v -> v.chars().allMatch(Character::isDigit))
							.map(Long::parseLong)
							.toArray(long[]::new);
					*/
					p.addToShelves(id);
					
				} while(id == 0);
				break;
			case 6:
				listProducts();
				break;
			}
		} while(attr != 5);
		System.out.println("\nPRODUCT " + option + " was edited successfully.");
	}
	
	public void printProducts() {
		System.out.println("ID \tNAME \tPRICE \tTAX \tDISCT \tSHELVES");
		pr.getMap().forEach((k,v) -> v.printInfo());
	}
	
	
	
	
	
	
	
	
}
