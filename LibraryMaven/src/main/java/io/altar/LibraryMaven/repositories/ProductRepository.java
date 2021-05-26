package io.altar.LibraryMaven.repositories;


import javax.enterprise.context.ApplicationScoped;

import io.altar.LibraryMaven.models.Product;



@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> {

	
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

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