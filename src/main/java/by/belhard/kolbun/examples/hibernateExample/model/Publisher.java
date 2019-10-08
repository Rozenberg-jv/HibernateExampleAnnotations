package by.belhard.kolbun.examples.hibernateExample.model;

import lombok.Data;

import javax.persistence.*;

//@Entity
//@Data
//@Table(name = "publishers")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

}
