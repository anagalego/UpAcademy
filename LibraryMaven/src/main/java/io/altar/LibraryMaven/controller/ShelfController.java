package io.altar.LibraryMaven.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.LibraryMaven.models.Shelf;
import io.altar.LibraryMaven.repositories.ShelfRepository;
import io.altar.LibraryMaven.services.ShelfService;

@RequestScoped
@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf> {
	
	
}
