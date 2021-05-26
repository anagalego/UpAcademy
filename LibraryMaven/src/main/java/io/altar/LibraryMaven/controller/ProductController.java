package io.altar.LibraryMaven.controller;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.models.Product;
import io.altar.LibraryMaven.repositories.ProductRepository;
import io.altar.LibraryMaven.services.ProductService;

@RequestScoped
@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository, Product> {

}
