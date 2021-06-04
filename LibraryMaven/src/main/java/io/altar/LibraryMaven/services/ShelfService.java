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
	
	@Override
	public String validateEntity(Shelf shelf) {
		String message = "";
		if(!validateCapacity(shelf.getCapacity())) message += "Insira uma capacidade válida: 0 ou 1\n";
		if(!validatePrice(shelf.getPrice())) message += "Insira um preço válido: 1,00 - 100,00€\n"; 
		else message = "OK";
		return message;
	}
	
	public boolean validateCapacity(int i) {
		if(i == 0 || i == 1) return true;
		return false;
	}
	
	public boolean validatePrice(float f) {
		if(f >= 1f && f <= 100f) return true;
		return false;
	}
	
	public List<Shelf> getEmpty() {
		return repository.getEmpty();
	}
	
	public void emptyShelf() {
		repository.getAll().forEach(e -> e.setProduct(null));
		pS.clearShelves();
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
		pS.addShelf(s, productId);
		return repository.editEntity(s);
	}
	
	public boolean validateAttribute(String attr) {
		switch(attr) {
		case "name": case "price": case "product.id": return true;
		default: return false;
		}
	}
}
