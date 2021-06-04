package io.altar.LibraryMaven.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.models.Product;
import io.altar.LibraryMaven.models.Shelf;
import io.altar.LibraryMaven.repositories.ProductRepository;


@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

	
	
	
	@Override
	public String validateEntity(Product product) {
		String message = "";
		if(!validateTax(product.getTax())) message += "Insira um IVA válido: 9% | 12% | 13%\n";
		if(!validateDiscount(product.getDiscount())) message += "Insira um desconto válido: 0 - 90%\n"; 
		else { product.setFinalPrice(); message = "OK"; }
		return message;
	}
	
	public boolean validateTax(int i) {
		int[] validTax = {4, 5, 6, 9, 12, 13, 18, 22, 23};
		for(int j = 0; j < validTax.length; j++) {
			if(i == validTax[j]) return true;
		} return false;
	}
	
	public boolean validateDiscount(int i) {
		if(i < 0 || i >= 90) return false;
		return true;
	}
	
	
	public List<Product> getProductsWithDiscount() {
		return repository.getProductsWithDiscount();
	}
	
	public List<Product> getProductsWithDiscount(int value) {
		return repository.getProductsWithDiscount(value);
	}
	
	public void addShelf(Shelf shelf, long productId) {
		repository.getEntity(productId).getShelves().add(shelf);
	}
	
	public void clearShelves() {
		repository.getAll().forEach(e -> e.getShelves().clear());
	}
	
	public void clearShelves(long id) {
		Product p = repository.getEntity(id);
		p.getShelves().clear();
		repository.editEntity(p);
	}

			
}
