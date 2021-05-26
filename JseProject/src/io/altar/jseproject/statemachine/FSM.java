package io.altar.jseproject.statemachine;


import io.altar.jseproject.statemachine.screens._State;
import io.altar.jseproject.statemachine.screens.Start;
import io.altar.jseproject.statemachine.screens.ListShelves;
import io.altar.jseproject.statemachine.screens.ListProducts;
import io.altar.jseproject.statemachine.screens.Quit;
import io.altar.jseproject.statemachine.screens.CreateShelf;
import io.altar.jseproject.statemachine.screens.EditShelf;
import io.altar.jseproject.statemachine.screens.CheckShelf;
import io.altar.jseproject.statemachine.screens.RemoveShelf;
import io.altar.jseproject.statemachine.screens.CreateProduct;
import io.altar.jseproject.statemachine.screens.EditProduct;
import io.altar.jseproject.statemachine.screens.CheckProduct;
import io.altar.jseproject.statemachine.screens.RemoveProduct;
import io.altar.jseproject.statemachine.screens.EditShelfOptions;
import io.altar.jseproject.statemachine.screens.EditProductOptions;





public class FSM {
	
	private _State[] states = {
		new Start(), 			// State 0
		new ListShelves(), 		// State 1
		new ListProducts(), 	// State 2
		new Quit(), 			// State 3
		new CreateShelf(), 		// State 4
		new EditShelf(), 		// State 5
		new CheckShelf(),		// State 6
		new RemoveShelf(),		// State 7
		new CreateProduct(),	// State 8
		new EditProduct(),		// State 9
		new CheckProduct(),		// State 10
		new RemoveProduct(),	// State 11
		new EditShelfOptions(),	// State 12
		new EditProductOptions()// State 13
	};
	
	private int[][] transition = { 
		{ 1, 2, 3 }, 			// State 0 -> Start
		{ 4, 5, 6, 7, 0 }, 		// State 1 -> ListShelves
		{ 8, 9, 10, 11, 0 }, 	// State 2 -> ListProducts
		{ 0 }, 					// State 3 -> Quit
		{ 1 }, 					// State 4 -> CreateShelf
		{ 1 }, 					// State 5 -> EditShelf
		{ 1 }, 					// State 6 -> CheckShelf
		{ 1 }, 					// State 7 -> RemoveShelf
		{ 2 }, 					// State 8 -> CreateProduct
		{ 2 }, 					// State 9 -> EditProduct
		{ 2 }, 					// State 10 -> CheckProduct
		{ 2 }, 					// State 11 -> RemoveProduct
		{ 5 },					// State 12 -> EditShelfOptions
		{ 9 }					// State 13 -> EditProductOptions
	};
	

	private int current = 0;

	public void start() {
		while (true) {
			
			int option = states[current].show();

			if (current == 0 && option == 10) {
				return;
			}
			current = transition[current][option-1];
		}
	}
}

