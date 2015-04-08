package ua.lviv.lgs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Engine {
	@Id
	@GeneratedValue
	@Column(name = "engine_id")
	private Long id;
	@Column
	private double volume;
	@Column(name = "horse_power")
	private int hp;
	@Enumerated(EnumType.STRING)
	private FuelType type;
	@ManyToMany(mappedBy="engine")
	private Set<Car> car;

	// @OneToOne
	// @JoinColumn(name = "car_id")
	// private Car carField;.

	// @ManyToMany(mappedBy = "engines",fetch = FetchType.EAGER)
	// private Set<Car> cars;
	// @OneToMany(mappedBy = "engine",fetch = FetchType.EAGER)
	// private Set<Car> cars;

	public Engine() {
	}

	public Engine(double volume, int hp, FuelType type) {
		super();
		this.volume = volume;
		this.hp = hp;
		this.type = type;
		this.car= new HashSet<Car>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public FuelType getType() {
		return type;
	}

	public void setType(FuelType type) {
		this.type = type;
	}

	// public Set<Car> getCars() {
	// return cars;
	// }
	//
	// public void setCars(Set<Car> cars) {
	// this.cars = cars;
	// }

	@Override
	public String toString() {
		return "Engine +" + "id = " + id + " [ volume=" + volume + ", hp=" + hp
				+ ", type=" + type + "]";
	}

	public Set<Car> getCar() {
		return car;
	}

	public void setCar(Set<Car> car) {
		this.car = car;
	}
}
