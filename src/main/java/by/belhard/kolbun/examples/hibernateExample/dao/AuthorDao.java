package by.belhard.kolbun.examples.hibernateExample.dao;

import by.belhard.kolbun.examples.hibernateExample.HibernateUtils;
import by.belhard.kolbun.examples.hibernateExample.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao implements DaoInterface<Author> {

	private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	@Override
	public List<Author> getAll() {

		Session session = sessionFactory.openSession();

		List<Author> authors = session.createQuery("from Author", Author.class).list();

		session.close();

		return authors;
	}

	@Override
	public void save(Author author) {

		Session session = sessionFactory.openSession();

		session.save(author);

		session.close();
	}

	@Override
	public Author getOne(int id) {

		Session session = sessionFactory.openSession();

		Author author = session.get(Author.class, id);

		session.close();

		return author;
	}
}
