/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/11/2023
  @ Time         : 4:49 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.ReserveDAO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.entity.Reservation;
import org.hibernate.Session;

public class ReserveDAOImpl implements ReserveDAO {

    @Override
    public boolean save(Reservation entity, Session session) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Reservation entity, Session session) {
        return false;
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
    public boolean existByPk(String pk) {
        return false;
    }

}
