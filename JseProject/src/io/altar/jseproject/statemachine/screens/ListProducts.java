package io.altar.jseproject.statemachine.screens;


public class ListProducts extends _State {

	@Override
	public int show() {
		System.out.println(
			"\nPlease select an option:\n"
			+ "\n1: Create Product"
			+ "\n2: Edit Product"
			+ "\n3: Check Product"
			+ "\n4: Remove Product"
			+ "\n5: Go Back\n");
		return sc.getInRange(1, 5);
	}

}
