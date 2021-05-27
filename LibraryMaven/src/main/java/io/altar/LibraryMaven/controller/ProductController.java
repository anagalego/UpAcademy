package io.altar.LibraryMaven.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.models.Product;
import io.altar.LibraryMaven.repositories.ProductRepository;
import io.altar.LibraryMaven.services.ProductService;

@RequestScoped
@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository, Product> {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addEntity(Product product) {
		product.setFinalPrice();
		return service.addEntity(product);
	}
}
