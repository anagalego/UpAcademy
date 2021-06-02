package io.altar.LibraryMaven.repositories;


import java.util.List;

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
	
	public List<String> getProductNames() {
		return entityManager.createNamedQuery("getProductNames", String.class).getResultList();
	}
		
	public List<Product> getProductsWithDiscount() {
		return entityManager.createNamedQuery("getProductsWithDiscount", Product.class).getResultList();
	}
	
	public List<Product> getProductsWithDiscount(int value) {
		return entityManager.createNamedQuery("getProductsWithDiscountX", Product.class).setParameter("value", value).getResultList();
	}
	
	public double getProductSales() {
		return entityManager.createNamedQuery("getProductSales", Double.class).getSingleResult();
	}
}