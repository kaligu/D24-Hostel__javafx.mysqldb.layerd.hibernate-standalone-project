/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:16 PM
*/
package lk.d24.hostelsystem.dao;

import lk.d24.hostelsystem.dao.custom.impl.QueryDAOImpl;
import lk.d24.hostelsystem.dao.custom.impl.ReserveDAOImpl;
import lk.d24.hostelsystem.dao.custom.impl.RoomDAOImpl;
import lk.d24.hostelsystem.dao.custom.impl.StudentDAOImpl;
import net.bytebuddy.asm.Advice;

import java.sql.Connection;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public static DAOFactory getInstance(){
        return daoFactory==null? (daoFactory=new DAOFactory()) : daoFactory;
    }

    public <T> T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return (T)new StudentDAOImpl();
            case ROOM:
                return (T)new RoomDAOImpl();
            case RESERVE:
                return (T)new ReserveDAOImpl();
            case QUERY:
                return (T)new QueryDAOImpl();
            default:
                return null;
        }
    }
}
