package io.altar.LibraryMaven.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.altar.LibraryMaven.models.Entity_;

@Transactional
public abstract class EntityRepository<T extends Entity_> {

	@PersistenceContext(unitName = "database")
	protected EntityManager entityManager;
	
	protected abstract Class<T> getEntityClass();

	public T addEntity(T entity) {
		return entityManager.merge(entity);
	}

	public T getEntity(long id) {
		return entityManager.find(getEntityClass(), id);
	}

	public T editEntity(T entity) {
		return entityManager.merge(entity);
	}

	public void removeEntity(long id) {
		T entity = getEntity(id);
		if(entity != null) {
			entityManager.remove(entity);
		}
	}
	

	protected abstract String getAllEntities();
	public List<T> getAll() {
		return entityManager.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	
	protected abstract String getAllEntitiesIds();
	public List<Long> getAllIds() {
		return entityManager.createNamedQuery(getAllEntitiesIds(), Long.class).getResultList();
	}
	
	protected abstract String getEntitiesCount();
	public long size() {
		return entityManager.createNamedQuery(getEntitiesCount(), Long.class).getSingleResult();
	}
	
	protected abstract String getNamesOfEntity();
	public List<String> getNames() {
		return entityManager.createNamedQuery(getNamesOfEntity(), String.class).getResultList();
	}
	
	protected abstract String getGetTotalSalesOfEntity();
	public double getTotalSales() {
		return entityManager.createNamedQuery(getGetTotalSalesOfEntity(), Double.class).getSingleResult();
	}
	
	protected abstract String getAveragePriceOfEntity();
	public double getAveragePrice() {
		return entityManager.createNamedQuery(getAveragePriceOfEntity(), Double.class).getSingleResult();
	}
	
}