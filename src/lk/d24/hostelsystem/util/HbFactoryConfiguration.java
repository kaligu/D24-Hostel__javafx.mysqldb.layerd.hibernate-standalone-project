package lk.d24.hostelsystem.util;

import lk.d24.hostelsystem.entity.LoginDetail;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class HbFactoryConfiguration {

    private static HbFactoryConfiguration hbFactoryConfiguration;
    private SessionFactory sessionFactory;

    private HbFactoryConfiguration(){
        Configuration configuration = new Configuration();
        Properties p = new Properties();
        try {
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("lk/d24/hostelsystem/hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.setProperties(p);

        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(LoginDetail.class);

        sessionFactory = configuration.buildSessionFactory();
    }
    public static HbFactoryConfiguration getInstance(){
        return (hbFactoryConfiguration == null) ? hbFactoryConfiguration = new HbFactoryConfiguration() : hbFactoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
