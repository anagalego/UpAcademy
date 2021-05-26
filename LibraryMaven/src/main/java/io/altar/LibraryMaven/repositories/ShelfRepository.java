package io.altar.LibraryMaven.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.LibraryMaven.models.Shelf;


@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> {

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

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
