package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.repositories.ShelfRepository;

public class CheckShelf extends _State {

	@Override
	public int show() {	
		ti.listShelves();
		return 2;
	}

}

