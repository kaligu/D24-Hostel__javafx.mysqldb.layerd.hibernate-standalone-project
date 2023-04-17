/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:38 PM
*/
package lk.d24.hostelsystem.service.custom.impl;

import lk.d24.hostelsystem.dao.DAOFactory;
import lk.d24.hostelsystem.dao.DAOTypes;
import lk.d24.hostelsystem.dao.custom.RoomDAO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.service.custom.RoomService;
import lk.d24.hostelsystem.service.util.Convertor;
import lk.d24.hostelsystem.util.HbFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO;
    private final Convertor convertor;

    public RoomServiceImpl() {
        this.roomDAO = DAOFactory.getInstance().getDAO(DAOTypes.ROOM);
        this.convertor = new Convertor();
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        if( ! roomDAO.existByPk(roomDTO.getRoom_type_id() )) {
            try{
                roomDAO.save(convertor.toRoom(roomDTO) , session);
                transaction.commit();
                return true;
            }catch (HibernateException e){
                if(session!=null) {
                    transaction.rollback();
                }
                return false;
            }finally {
                session.close();
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        if( ! roomDAO.existByPk(roomDTO.getRoom_type_id() )) {
            try{
                roomDAO.update(convertor.toRoom(roomDTO) , session);
                transaction.commit();
                return true;
            }catch (HibernateException e){
                if(session!=null) {
                    transaction.rollback();
                }
                return false;
            }finally {
                session.close();
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            roomDAO.delete(convertor.toRoom(roomDTO) , session);
            transaction.commit();
            return true;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<RoomDTO> searchRoomByText(String text) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            return roomDAO.searchRoomByText(text,session).stream().map(room -> convertor.fromRoom(room)).collect(Collectors.toList());
        } catch (HibernateException e){

        }
        return null;
    }

    @Override
    public RoomDTO findByPk(String pk) {
        RoomDTO roomDTO = null;
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            roomDTO = convertor.fromRoom(roomDAO.findByPk(pk,session));
            return roomDTO;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return  roomDTO;
        }finally {
            session.close();
        }
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        try{
            roomDTOS = roomDAO.getAll(session).stream().map(room -> convertor.fromRoom(room)).collect(Collectors.toList());
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
