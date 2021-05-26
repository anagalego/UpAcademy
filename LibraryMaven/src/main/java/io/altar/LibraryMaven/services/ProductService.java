package io.altar.LibraryMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.repositories.ProductRepository;
import io.altar.LibraryMaven.models.Product;


@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

	@Override
	protected String getAllEntities() {
		return Product.GET_PRODUCTS;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Product.GET_PRODUCTS_IDS;
	}

	@Override
	protected String getEntitiesCount() {
		return Product.GET_PRODUCT_COUNT;
	}

	

}
