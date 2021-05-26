package io.altar.jseproject.statemachine.screens;

public class Start extends _State {

	@Override
	public int show() {
			System.out.println(
				"\nPlease select an option:\n"
				+ "\n1: List Shelfs"
				+ "\n2: List Products"
				+ "\n3: Quit\n");
		return sc.getInRange(1, 3);
	}

}

