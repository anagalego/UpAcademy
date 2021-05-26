package io.altar.LibraryMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.repositories.ShelfRepository;
import io.altar.LibraryMaven.models.Shelf;


@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {

	@Override
	protected String getAllEntities() {
		return Shelf.GET_SHELVES;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Shelf.GET_SHELVES_IDS;
	}

	@Override
	protected String getEntitiesCount() {
		return Shelf.GET_SHELF_COUNT;
	}
	
}
