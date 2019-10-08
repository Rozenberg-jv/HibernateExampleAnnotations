package by.belhard.kolbun.examples.hibernateExample.dao;

import by.belhard.kolbun.examples.hibernateExample.HibernateUtils;
import by.belhard.kolbun.examples.hibernateExample.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao implements DaoInterface<Book> {

	private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	@Override
	public List<Book> getAll() {

		Session session = sessionFactory.openSession();

		List<Book> books = session.createQuery("from Book", Book.class).list();

		session.close();

		return books;
	}

	@Override
	public void save(Book book) {

		Session session = sessionFactory.openSession();

		session.save(book);

		session.close();
	}

	@Override
	public Book getOne(int id) {

		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, id);

		session.close();

		return book;
	}
}
