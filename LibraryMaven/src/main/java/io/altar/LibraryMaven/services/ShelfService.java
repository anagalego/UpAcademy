package io.altar.LibraryMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.repositories.ShelfRepository;
import io.altar.LibraryMaven.models.Shelf;


@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {

}
