package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;
 
public class EditProduct extends _State {

	@Override
	public int show() {
		int option;
		do {
			System.out.println(
					"\n\nPlease type the PRODUCT ID you want to edit:"
					+ "\nType 0 to go back.");
			ti.printProducts();
			option = sc.getInt();
			if(option == 0) return 3;
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
				ti.printShelves();
				long id;
				do {
					id = sc.getLong(pr.listed());
					p.addToShelves(id);					
				} while(id == 0);
				break;
			case 6:
				ti.listProducts();
				break;
			}
		} while(attr != 5);
		System.out.println("\nPRODUCT " + option + " was edited successfully.");
		return 1;
	}

}
