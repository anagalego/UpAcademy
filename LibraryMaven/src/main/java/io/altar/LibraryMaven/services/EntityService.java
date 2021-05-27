package io.altar.LibraryMaven.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.LibraryMaven.models.Entity_;
import io.altar.LibraryMaven.repositories.EntityRepository;

@Transactional
public abstract class EntityService<T extends EntityRepository<E>, E extends Entity_> {

	@Inject
	protected T repository;

	public E addEntity(E entity) {
		return repository.addEntity(entity);
	}

	public E getEntity(long id) {
		return repository.getEntity(id);
	}

	public E editEntity(E entity) {
		return repository.editEntity(entity);
	}

	public void removeEntity(long id) {
		repository.removeEntity(id);
	}
	
	public List<E> getAll() {
		return repository.getAll();
	}
	
	public List<Long> getAllIds() {
		return repository.getAllIds();
	}
	
	public long size() {
		return repository.size();
	}

	
	
	
	
	
	
	
}
