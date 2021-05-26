package io.altar.jseproject.repositories;

import java.util.HashMap;
import java.util.Map;

import io.altar.jseproject.model.Entity;


public abstract class EntityRepository<T extends Entity> {

	private Map<Long, T> map = new HashMap<Long, T>();
	private long counter;
	
	private long next() {
		return ++counter;
	}	
	
	public long listed() {
		return counter;
	}
	
	public long addEntity(T t) {
		t.setId(next());
		map.put(t.getId(), t);
		return t.getId();
	}
	
	public void removeEntity(long id) {
		map.remove(id);
	}
	
	public T getEntity(long id) {
		return map.get(id);
	}
	
	public Map<Long, T> getMap() {
		return map;
	}
	
	public void printEntity() {
		System.out.print("\nID \tNAME \tPRICE ");
	}
	
}
