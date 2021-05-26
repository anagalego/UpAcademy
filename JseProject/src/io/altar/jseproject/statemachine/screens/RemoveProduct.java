package io.altar.jseproject.statemachine.screens;
 
public class RemoveProduct extends _State {

	@Override
	public int show() {
		int option;
		long listed = pr.listed();
		do {
			System.out.println(
					"\n\nPlease type the PRODUCT ID you want to remove:"
					+ "\nType 0 to go back.");
			pr.printEntity();
			option = sc.getInt();
			if(option == 0) return 1;
			else if(option > listed) System.out.println("\nPRODUCT " + option + " doesn't exist.");
		} while(option > listed || option == 0);
		pr.removeEntity(option);
		System.out.println("\nPRODUCT " + option + " was removed successfully.");
		return 1;
	}

}
