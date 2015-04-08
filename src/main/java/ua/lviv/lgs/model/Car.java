package ua.lviv.lgs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue
	@Column(name = "car_id")
	private Long id;
	@Column(name = "model")
	private String model;
	@Column
	private double price;

	@ManyToMany
	@JoinTable(name = "cars_engine", joinColumns = { @JoinColumn(name = "car_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "engine_id") })
	private Set<Engine> engine;

	//
	// @ManyToOne
	// @JoinColumn(name = "engine_id")
	// private Engine engine;
	//
	// @ManyToMany
	// @JoinTable(name = "cars_engines", joinColumns = { @JoinColumn(name =
	// "car_id") }, inverseJoinColumns = { @JoinColumn(name = "engine_id") })
	// private Set<Engine> engines;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String model, Set<Engine> engine, double price) {
		super();
		this.model = model;
		this.engine = engine;
		this.price = price;
		this.engine = new HashSet<Engine>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", engine=" + ", price="
				+ price + "]";
	}

	public Set<Engine> getEngine() {
		return engine;
	}

	public void setEngine(Set<Engine> engine) {
		this.engine = engine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
