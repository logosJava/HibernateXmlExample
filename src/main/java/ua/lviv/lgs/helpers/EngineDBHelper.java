package ua.lviv.lgs.helpers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.lviv.lgs.HibernateUtil;
import ua.lviv.lgs.model.Engine;

public class EngineDBHelper {

	public static void saveEngine(Engine engine) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(engine); // save to DB
		session.getTransaction().commit();
		session.close();
	}
}
