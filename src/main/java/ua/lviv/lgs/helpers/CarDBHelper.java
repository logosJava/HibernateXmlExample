package ua.lviv.lgs.helpers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.lviv.lgs.HibernateUtil;
import ua.lviv.lgs.model.Car;

public class CarDBHelper {
	
	
	
	public static void saveCar(Car car) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(car); //save to DB
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<Car> getAllCars() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Car> cars = (List<Car>) session.createQuery("SELECT r1 FROM Car r1 WHERE r1.hp = 40").list();
		session.close();
		return cars;
	}
	
	
	public static Car getCar(Long numberOfId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Car car =  (Car) session.get(Car.class, numberOfId);
		session.close();
		return car;
	}
	
}
