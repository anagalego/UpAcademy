package io.altar.jseproject.statemachine.screens;

public class Quit extends _State {

	@Override
	public int show() {
		System.out.println("Goodbye!");
		return 1;
	}

}