package by.belhard.kolbun.examples.hibernateExample;

import by.belhard.kolbun.examples.hibernateExample.model.Author;
import by.belhard.kolbun.examples.hibernateExample.model.Book;
import by.belhard.kolbun.examples.hibernateExample.model.Publisher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import static org.hibernate.cfg.AvailableSettings.*;

import java.util.Properties;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	private HibernateUtils() {

	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties properties = new Properties();
				properties.put(DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(URL, "jdbc:mysql://localhost:3306/library?serverTimezone=UTC");
				properties.put(USER, "root");
				properties.put(PASS, "root");
				properties.put(DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				properties.put(SHOW_SQL, "false");
//				properties.put(SHOW_SQL, "true");
				properties.put(HBM2DDL_AUTO, "update");
				properties.put(FORMAT_SQL, "true");
				configuration.setProperties(properties);

				configuration.addAnnotatedClass(Book.class);
				configuration.addAnnotatedClass(Author.class);
//				configuration.addAnnotatedClass(Publisher.class);

				ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(registry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}
}
