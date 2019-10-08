package by.belhard.kolbun.examples.hibernateExample.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	/*@ManyToMany(fetch = FetchType.EAGER)
	private List<Book> bookList = new ArrayList<>();*/

}
