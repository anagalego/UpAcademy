package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class EditShelf extends _State {
	@Override
	public int show() {
		int option;
		do {
			System.out.println(
					"\n\nPlease type the SHELF ID you want to edit:"
					+ "\nType 0 to go back.");
			sr.printEntity();
			option = sc.getInt();
			if(option == 0) return 1;
			else if(option > sr.listed()) System.out.println("\nSHELF " + option + " doesn't exist.");
		} while(option > sr.listed() || option == 0);
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
				pr.printEntity();
				Product newProduct;
				long productId;
				do {
					productId = sc.getLong(pr.listed());
					newProduct = pr.getEntity(productId);
					newProduct.addToShelves(s.getId());;
				} while(newProduct == null);
				break;
			case 5:
				return 1;
			}
		} while(attr != 5);
		System.out.println("\nSHELF " + option + " was edited successfully.");
		return 1;
	}

}
