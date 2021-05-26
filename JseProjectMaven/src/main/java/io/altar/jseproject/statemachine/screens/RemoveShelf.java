package io.altar.jseproject.statemachine.screens;


public class RemoveShelf extends _State {

	@Override
	public int show() {
		int option;
		do {
			System.out.println(
					"\n\nPlease type the SHELF ID you want to remove:"
					+ "\nType 0 to go back.");
			ti.printShelves();
			option = sc.getInt();
			if(option == 0) ti.listShelves();
			else if(option > sr.listed()) System.out.println("\nSHELF " + option + " doesn't exist.");
		} while(option > sr.listed() || option == 0);
		sr.removeEntity(option);
		System.out.println("\nSHELF " + option + " was removed successfully.");
		return 2;
	}
}


