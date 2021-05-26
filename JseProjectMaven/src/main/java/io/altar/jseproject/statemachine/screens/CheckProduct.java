package io.altar.jseproject.statemachine.screens;
 
public class CheckProduct extends _State {

	@Override
	public int show() {
		ti.listProducts();
		return 3;
	}

}
