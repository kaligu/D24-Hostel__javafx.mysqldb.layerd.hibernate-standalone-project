/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 8:12 AM
*/
package lk.d24.hostelsystem.service.custom.impl;

import lk.d24.hostelsystem.dao.DAOFactory;
import lk.d24.hostelsystem.dao.DAOTypes;
import lk.d24.hostelsystem.dao.QueryDAO;
import lk.d24.hostelsystem.dao.custom.ReserveDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.service.custom.QueryService;
import lk.d24.hostelsystem.service.util.Convertor;
import lk.d24.hostelsystem.util.HbFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryServiceImpl implements QueryService {
    private final QueryDAO queryDAO;
    private final ReserveDAO reserveDAO;
    private final Convertor convertor;

    public QueryServiceImpl() {
        this.queryDAO = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
        this.reserveDAO = DAOFactory.getInstance().getDAO(DAOTypes.RESERVE);
        this.convertor = new Convertor();
    }
    @Override
    public List<qaRoomDTO> findAllAvailableRooms() {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        List<qaRoomDTO> roomDTOS = new ArrayList<>();
        try{
            roomDTOS = queryDAO.findAllAvailableRooms(session);
            transaction.commit();
            return roomDTOS;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return roomDTOS;
        }finally {
            session.close();
        }
    }


}
