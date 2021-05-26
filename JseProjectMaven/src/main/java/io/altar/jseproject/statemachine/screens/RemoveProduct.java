package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.repositories.ProductRepository;
 
public class RemoveProduct extends _State {

	@Override
	public int show() {
		ProductRepository pr = ProductRepository.getInstance();	
		return 2;
	}

}
