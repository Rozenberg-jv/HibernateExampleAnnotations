package by.belhard.kolbun.examples.hibernateExample;

import by.belhard.kolbun.examples.hibernateExample.model.Author;
import by.belhard.kolbun.examples.hibernateExample.model.Book;
import by.belhard.kolbun.examples.hibernateExample.model.BookFormat;
import by.belhard.kolbun.examples.hibernateExample.services.LibraryService;

import java.util.Date;

public class Main {

	private static final LibraryService service = new LibraryService();

	public static void main(String[] args) {

		System.out.println("\n\n########################################\n\n");

		Book book = new Book();
		book.setFormat(BookFormat.A3);
		book.setPublicationDate(new Date());
		book.setTitle("Winnie the Pooh");

		Author author1 = new Author();
		author1.setName("A.A. Milne");

		Author author2 = new Author();
		author2.setName("Chr.R. Milne");

		service.addNewBook(book, author1, author2);

		System.out.println(service.getAllBooks());
		System.out.println(service.getAllAuthors());

	}
}
