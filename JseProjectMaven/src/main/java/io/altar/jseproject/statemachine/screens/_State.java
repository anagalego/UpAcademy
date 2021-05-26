package io.altar.jseproject.statemachine.screens;

import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils;
import io.altar.jseproject.textinterface.TextInterface;

public abstract class _State {
		ScannerUtils sc = new ScannerUtils();
		ProductRepository pr = ProductRepository.getInstance();
		ShelfRepository sr = ShelfRepository.getInstance();
		TextInterface ti = new TextInterface();

		public abstract int show();
}
