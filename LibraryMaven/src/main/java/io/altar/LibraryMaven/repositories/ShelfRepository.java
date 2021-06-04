package io.altar.LibraryMaven.repositories;

import java.util.List;

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
	
	@Override
	protected String getNamesOfEntity() {
		return Shelf.GET_SHELF_NAMES;
	}
	
	@Override
	protected String getGetTotalSalesOfEntity() {
		return Shelf.GET_SHELF_SALES;
	}
	
	@Override
	protected String getAveragePriceOfEntity() {
		return Shelf.GET_SHELF_AVERAGE_PRICE;
	}
	
	public List<Shelf> getEmpty() {
		return entityManager.createNamedQuery("getEmpty", Shelf.class).getResultList();
	}
	
	public void emptyShelf() {
		entityManager.createNamedQuery("emptyAllShelves").getResultList();		
	}
	
	public void emptyShelf(long id) {
		entityManager.createNamedQuery("emptyShelfById").setParameter("id", id).getResultList();		
	}
	
	public List<Shelf> getShelvesWithProduct(long id) {
		return entityManager.createNamedQuery("getShelvesWithProduct", Shelf.class).setParameter("id", id).getResultList();
	}
	
}
