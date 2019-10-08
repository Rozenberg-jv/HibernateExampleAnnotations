package by.belhard.kolbun.examples.hibernateExample.dao;

import java.util.List;

public interface DaoInterface<T> {

	List<T> getAll();

	void save(T entity);

	T getOne(int id);
}
