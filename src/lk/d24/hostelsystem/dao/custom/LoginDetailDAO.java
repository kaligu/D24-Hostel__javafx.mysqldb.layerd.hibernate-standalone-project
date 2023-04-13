/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/13/2023
  @ Time         : 12:19 PM
*/
package lk.d24.hostelsystem.dao.custom;

import lk.d24.hostelsystem.dto.LoginDetailDTO;
import lk.d24.hostelsystem.entity.LoginDetail;
import org.hibernate.Session;

public interface LoginDetailDAO {
    LoginDetail findByPk(Session session, String pk);

    boolean update(Session session,LoginDetail entity);
}
