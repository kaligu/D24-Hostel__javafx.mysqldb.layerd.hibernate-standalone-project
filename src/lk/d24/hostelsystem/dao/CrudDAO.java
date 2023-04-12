/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:23 PM
*/
package lk.d24.hostelsystem.dao;

import lk.d24.hostelsystem.dto.ReserveDTO;
import org.hibernate.Session;

import java.io.Serializable;

public interface CrudDAO <T extends Serializable,ID extends Serializable> extends SuperDAO {
    boolean save(T entity , Session session);

    boolean update(T entity, Session session);

    boolean delete(T entity, Session session);

    T findByPk(ID pk, Session session) ;

    boolean existByPk(ID pk) ;
}
