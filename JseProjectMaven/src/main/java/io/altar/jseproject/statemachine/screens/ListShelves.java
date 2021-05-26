package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.textinterface.ScannerUtils;

public class ListShelves extends _State {

	@Override
	public int show() {
		ScannerUtils sc = new ScannerUtils();
		System.out.println(
			"\nPlease select an option:\n"
			+ "\n1: Create Shelf"
			+ "\n2: Edit Shelf"
			+ "\n3: Check Shelf"
			+ "\n4: Remove Shelf"
			+ "\n5: Go Back\n");
		return sc.getInRange(1, 5);
	}

}

