package ua.lviv.lgs.helpers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.lviv.lgs.HibernateUtil;

public class GenericDBHelper<T> {
	private Class<T> typeOfClass;

	public GenericDBHelper(Class<T> typeOfClass) {
		this.typeOfClass = typeOfClass;
	}

	public void save(T type) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(type); // save to DB
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public T get(Long numberOfId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		T result = (T) session.get(typeOfClass, numberOfId);
		session.close();
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<T> cars = (List<T>) session.createQuery(" FROM " + typeOfClass.getSimpleName()).list();
		session.close();
		return cars;
	}
}
