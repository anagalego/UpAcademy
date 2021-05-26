package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;



public class ProductRepository extends EntityRepository<Product> {

	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository() {}
	
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	public void printEntity() {
		super.printEntity();
		System.out.print("\tTAX \tDISCT \tSHELFS\n");
		getMap().forEach((k,v) -> v.printInfo());
	}
}
