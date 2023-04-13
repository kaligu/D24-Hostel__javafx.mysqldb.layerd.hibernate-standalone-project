/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/11/2023
  @ Time         : 4:48 PM
*/
package lk.d24.hostelsystem.service.custom.impl;

import lk.d24.hostelsystem.dao.DAOFactory;
import lk.d24.hostelsystem.dao.DAOTypes;
import lk.d24.hostelsystem.dao.QueryDAO;
import lk.d24.hostelsystem.dao.custom.ReserveDAO;
import lk.d24.hostelsystem.dao.custom.RoomDAO;
import lk.d24.hostelsystem.dao.custom.StudentDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import lk.d24.hostelsystem.service.custom.ReserveService;
import lk.d24.hostelsystem.service.util.Convertor;
import lk.d24.hostelsystem.util.HbFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReserveServiceimpl implements ReserveService {
    private final StudentDAO studentDAO;
    private final RoomDAO roomDAO;
    private final ReserveDAO reserveDAO;
    private final Convertor convertor;
    private Session session;
    private Transaction transaction;

    public ReserveServiceimpl() {
        this.studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
        this.roomDAO= DAOFactory.getInstance().getDAO(DAOTypes.ROOM);
        this.reserveDAO = DAOFactory.getInstance().getDAO(DAOTypes.RESERVE);
        this.convertor = new Convertor();
    }
    @Override
    public boolean saveReservation(ReserveDTO reserveDTO) {
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        Student student= new Student();
        Room room = new Room();
        student = studentDAO.findByPk(reserveDTO.getStudentID(), session);
        room=roomDAO.findByPk(reserveDTO.getRoomID(),session);
        Reservation reservation  =new Reservation(
                reserveDTO.getRes_id(),
                reserveDTO.getDate(),
                student,
                room,
                reserveDTO.getStatus()
        );

        try{
            reserveDAO.save(reservation , session);
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
    public List<ReserveDTO> viewAllReservations() {
        List<ReserveDTO> reserveDTOS=new ArrayList<>();
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            for(Reservation reservation:reserveDAO.viewAllReservations(session))
            reserveDTOS.add(new ReserveDTO(reservation.getRes_id(),reservation.getDate(),reservation.getStudent().getStudent_id(),reservation.getRoom().getRoom_type_id(),reservation.getStatus()));
            transaction.commit();
            return reserveDTOS;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return reserveDTOS;
        }finally {
            session.close();
        }
    }

    @Override
    public List<ReserveDTO> viewActiveReservations() {
        List<ReserveDTO> reserveDTOS=new ArrayList<>();
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            for(Reservation reservation:reserveDAO.viewActiveReservations(session))
                reserveDTOS.add(new ReserveDTO(reservation.getRes_id(),reservation.getDate(),reservation.getStudent().getStudent_id(),reservation.getRoom().getRoom_type_id(),reservation.getStatus()));
            transaction.commit();
            return reserveDTOS;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return reserveDTOS;
        }finally {
            session.close();
        }
    }

    @Override
    public List<ReserveDTO> viewNotpaidReservations() {
        List<ReserveDTO> reserveDTOS=new ArrayList<>();
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            for(Reservation reservation:reserveDAO.viewNotpaidReservations(session))
                reserveDTOS.add(new ReserveDTO(reservation.getRes_id(),reservation.getDate(),reservation.getStudent().getStudent_id(),reservation.getRoom().getRoom_type_id(),reservation.getStatus()));
            transaction.commit();
            return reserveDTOS;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return reserveDTOS;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(ReserveDTO reserveDTO) {
        session=null;
        transaction=null;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        Student student= new Student();
        Room room = new Room();
        student = studentDAO.findByPk(reserveDTO.getStudentID(), session);
        room=roomDAO.findByPk(reserveDTO.getRoomID(),session);
        Reservation reservation  =new Reservation(
                reserveDTO.getRes_id(),
                reserveDTO.getDate(),
                student,
                room,
                reserveDTO.getStatus()
        );

        try{
            reserveDAO.update(reservation , session);
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
}
