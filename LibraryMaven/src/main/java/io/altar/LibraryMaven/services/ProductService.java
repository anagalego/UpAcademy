package io.altar.LibraryMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.repositories.ProductRepository;
import io.altar.LibraryMaven.models.Product;


@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {


}
