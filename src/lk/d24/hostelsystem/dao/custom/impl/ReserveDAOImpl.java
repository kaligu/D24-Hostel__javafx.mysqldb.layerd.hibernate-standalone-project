/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/11/2023
  @ Time         : 4:49 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.ReserveDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReserveDAOImpl implements ReserveDAO {

    @Override
    public void save(Reservation entity, Session session) {
        session.save(entity);
    }

    @Override
    public void update(Reservation entity, Session session) {
        session.update(entity);
    }

    @Override
    public boolean delete(Reservation entity, Session session) {
        return false;
    }

    @Override
    public Reservation findByPk(String pk, Session session) {
        return null;
    }

    @Override
    public boolean existByPk(String pk,Session session) {
        return false;
    }

    @Override
    public List<Reservation> viewAllReservations(Session session) {
        List<Reservation>  reservations= new ArrayList<>();
        String hql = "FROM Reservation";
        Query query = session.createQuery(hql);
        reservations=query.list();
        return reservations;
    }

    @Override
    public List<Reservation> viewActiveReservations(Session session) {
        List<Reservation> reservations = new ArrayList<>();
        String hql = "SELECT res FROM Reservation res WHERE res.date >= CURRENT_DATE";
        Query query = session.createQuery(hql);
        reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> viewNotpaidReservations(Session session) {
        List<Reservation> reservations = new ArrayList<>();
        String hql = "FROM Reservation res WHERE res.status LIKE '%Status:not%'";
        Query query = session.createQuery(hql);
        reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> viewAllReservedReservations(Session session) {
        List<Reservation> reservations = new ArrayList<>();
        String hql = "FROM Reservation res WHERE res.status LIKE '%Status:not%'";
        Query query = session.createQuery(hql);
        reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> findAllRoomExpireTodayReservations(Session session) {
        List<Reservation> reservations = new ArrayList<>();
        String hql = "FROM Reservation res WHERE res.date = CURRENT_DATE";
        Query query = session.createQuery(hql);
        reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> viewAllNotpaidReservationsStRoom(Session session) {
        List<Reservation> reservations = new ArrayList<>();
        String hql = "FROM Reservation res WHERE res.status LIKE '%Status:not%'";
        Query query = session.createQuery(hql);
        reservations = query.list();
        return reservations;
    }

    @Override
    public String getLastOrderID(Session session) {
        String id = null;
        String hql = "SELECT r.res_id FROM Reservation r ORDER BY r.res_id DESC";
        Query<String> query = session.createQuery(hql, String.class);
        query.setMaxResults(1);
        List<String> result = query.getResultList();
        if (!result.isEmpty()) {
            id = result.get(0);
        }else{
            id="null";
        }
        return id;
    }
}
