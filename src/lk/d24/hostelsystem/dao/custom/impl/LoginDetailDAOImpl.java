/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/13/2023
  @ Time         : 12:19 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.LoginDetailDAO;
import lk.d24.hostelsystem.dto.LoginDetailDTO;
import lk.d24.hostelsystem.entity.LoginDetail;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class LoginDetailDAOImpl implements LoginDetailDAO {
    @Override
    public LoginDetail findByPk(Session session,String pk) {
        try {
            return (session.get(LoginDetail.class,pk));
        } catch (HibernateException e) {
            return  null;
        }
    }

    @Override
    public boolean update(Session session, LoginDetail entity) {
        try {
            session.update(entity);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }
}
