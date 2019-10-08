package by.belhard.kolbun.examples.hibernateExample.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	@Enumerated(EnumType.STRING)
	private BookFormat format;

	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Author> authorList = new ArrayList<>();

}
