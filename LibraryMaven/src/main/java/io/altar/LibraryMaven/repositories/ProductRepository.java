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
	
	@Override
	protected String getNamesOfEntity() {
		return Product.GET_PRODUCT_NAMES;
	}
	
	@Override
	protected String getGetTotalSalesOfEntity() {
		return Product.GET_PRODUCT_SALES;
	}
	
	@Override
	protected String getAveragePriceOfEntity() {
		return Product.GET_PRODUCT_AVERAGE_PRICE;
	}
	
	
	public List<Product> getProductsWithDiscount() {
		return entityManager.createNamedQuery("getProductsWithDiscount", Product.class).getResultList();
	}
	
	public List<Product> getProductsWithDiscount(int value) {
		return entityManager.createNamedQuery("getProductsWithDiscountX", Product.class).setParameter("value", value).getResultList();
	}
	
}