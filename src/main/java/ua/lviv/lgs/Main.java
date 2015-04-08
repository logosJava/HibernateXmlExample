package ua.lviv.lgs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.lviv.lgs.helpers.GenericDBHelper;
import ua.lviv.lgs.model.Car;
import ua.lviv.lgs.model.Engine;
import ua.lviv.lgs.model.FuelType;

public class Main {
	static GenericDBHelper<Engine> helper = new GenericDBHelper<Engine>(
			Engine.class);
	static GenericDBHelper<Car> carHelper = new GenericDBHelper<Car>(Car.class);

	public static void main(String[] args) {
		
//		Engine engine = new Engine(1.5, 211, FuelType.GAS);
//		helper.save(engine);
		List<Engine> all = helper.getAll();
		Car car = new Car("BMW", null, 3000);
		car.getEngine().addAll(all);
		carHelper.save(car);
//		Car car = carHelper.get(1L);
//		carHelper.save(car);
//		Engine engine1 = new Engine(1.444, 2222, FuelType.GAS);
//		helper.save(engine1);
//		//Engine engine = helper.get(1L);
//		HashSet<Engine> hashSet = new HashSet<Engine>();
//		hashSet.add(engine);
//		hashSet.add(engine1);
		//System.out.println(car);
	//	Engine engine = helper.get(1L);
		//Set<Car> cars = engine.getCars();
		// CarDBHelper.saveCar(new Car("BMW", 200, 1.6, 25000));
		// List<Car> allCars = CarDBHelper.getAllCars();
		// System.out.println(CarDBHelper.getCar(2L));
		 HibernateUtil.getSessionFactory().close();
	}
}
