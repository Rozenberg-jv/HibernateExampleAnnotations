package by.belhard.kolbun.examples.hibernateExample.services;

import by.belhard.kolbun.examples.hibernateExample.dao.AuthorDao;
import by.belhard.kolbun.examples.hibernateExample.dao.BookDao;
import by.belhard.kolbun.examples.hibernateExample.model.Author;
import by.belhard.kolbun.examples.hibernateExample.model.Book;

import java.util.Arrays;
import java.util.List;

public class LibraryService {

	private final AuthorDao authorDao;

	private final BookDao bookDao;

	public LibraryService() {

		this.authorDao = new AuthorDao();
		this.bookDao = new BookDao();
	}

	public List<Book> getAllBooks() {

		return bookDao.getAll();
	}

	public List<Author> getAllAuthors() {

		return authorDao.getAll();
	}

	public void addNewBook(Book book, Author... authors) {

		for (Author author : authors) {

			authorDao.save(author);
		}

		book.getAuthorList().addAll(Arrays.asList(authors));

		bookDao.save(book);
	}
}
