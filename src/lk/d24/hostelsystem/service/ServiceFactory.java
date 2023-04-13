/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 9:38 PM
*/
package lk.d24.hostelsystem.service;

import lk.d24.hostelsystem.dao.custom.impl.ReserveDAOImpl;
import lk.d24.hostelsystem.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }

    public <T> T getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case STUDENT:
                return (T)new StudentServiceImpl();
            case ROOM:
                return (T)new RoomServiceImpl();
            case RESERVE:
                return (T)new ReserveServiceimpl();
            case QUERY:
                return (T)new QueryServiceImpl();
            case LOGINDETAIL:
                return (T)new LoginDetailServiceImpl();
            default:
                return null;
        }
    }
}
