package io.altar.LibraryMaven.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product update(Product product) {
		product.setFinalPrice();
		return service.editEntity(product);
	}
	
	@GET
	@Path("discount")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsWithDiscount() {
		return service.getProductsWithDiscount();
	}
	
	@GET
	@Path("discount/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsWithDiscount(@PathParam("value") int value) {
		return service.getProductsWithDiscount(value);
	}	
	
}
