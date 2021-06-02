package io.altar.LibraryMaven.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.LibraryMaven.models.Shelf;
import io.altar.LibraryMaven.repositories.ShelfRepository;


@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {

	@Inject
	ProductService pS;
	
	public List<Shelf> getEmpty() {
		return repository.getEmpty();
	}
	
	public void emptyShelf() {
		repository.emptyShelf();
	}
	
	public String emptyShelf(long id) throws NullPointerException {
		try {
			repository.getEntity(id).setProduct(null);
			return "Shelf " + id + " esvaziada com sucesso!";
		} catch(NullPointerException e) {
			return id + " não existe. Escolha entre: " + repository.getAllIds();
		}
	}
	
	public void emptyShelfWithProduct(long id) {
		getShelvesWithProduct(id).forEach(e -> e.setProduct(null));
		pS.clearShelves(id);
	}	
	
	public List<Shelf> getShelvesWithProduct(long id) {
		return repository.getShelvesWithProduct(id);
	}
	
	public Shelf addProduct(long id, long productId) {
		Shelf s = repository.getEntity(id);
		s.setProduct(pS.getEntity(productId));
		return repository.editEntity(s);
	}
	
}
