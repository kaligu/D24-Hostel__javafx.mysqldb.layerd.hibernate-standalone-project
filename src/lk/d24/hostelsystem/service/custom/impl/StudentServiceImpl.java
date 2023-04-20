/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 9:41 PM
*/
package lk.d24.hostelsystem.service.custom.impl;

import lk.d24.hostelsystem.dao.DAOFactory;
import lk.d24.hostelsystem.dao.DAOTypes;
import lk.d24.hostelsystem.dao.custom.StudentDAO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.service.custom.StudentService;
import lk.d24.hostelsystem.service.exception.DuplicateException;
import lk.d24.hostelsystem.service.util.Convertor;
import lk.d24.hostelsystem.util.HbFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;
    private final Convertor convertor;

    public StudentServiceImpl() {
        this.studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
        this.convertor = new Convertor();
    }


    @Override
    public boolean saveStudent(StudentDTO studentDTO){
        boolean bool = false;
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            if( ! studentDAO.existByPk(studentDTO.getStudent_id(),session )) {
                studentDAO.save(convertor.toStudent(studentDTO) , session);
                transaction.commit();
                bool=true;
            }else{
                bool=false;
                throw new DuplicateException("This Student already saved.");
            }
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            bool=false;
        }finally {
            session.close();
            return bool;
        }
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        boolean bool=false;
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            studentDAO.update(convertor.toStudent(studentDTO) , session);
            transaction.commit();
            bool=true;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            bool=false;
        }finally {
            session.close();
            return bool;
        }
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        try{
            studentDAO.delete(convertor.toStudent(studentDTO) , session);
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
    public List<StudentDTO> searchStudentByText(String text) {
        List<StudentDTO> studentDTOList =new ArrayList<>();
        Session session= HbFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            studentDTOList = studentDAO.searchStudentByText(text,session).stream().map(student -> convertor.fromStudent(student)).collect(Collectors.toList());
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
        }finally {
            session.close();
            return studentDTOList;
        }
    }

    @Override
    public List<String> getAllStudentIds() {
        List<String> stringList = new ArrayList<>();
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            stringList =  studentDAO.getAllStudentIds(session);
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
        }finally {
            session.close();
        }
        return stringList;
    }

    @Override
    public StudentDTO findByPk(String pk) {
        StudentDTO studentDTO = null;
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();

        try{
            studentDTO = convertor.fromStudent(studentDAO.findByPk(pk,session));
            return studentDTO;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return  studentDTO;
        }finally {
            session.close();
        }
    }

    @Override
    public String getLastStudentID() {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        String id="null";
        try{
            id= studentDAO.getLastStudentID(session);
            transaction.commit();
            return id;
        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            return id;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean existsByPk(String pk) {
        Session session;
        Transaction transaction;
        session= HbFactoryConfiguration.getInstance().getSession();
        transaction=session.beginTransaction();
        boolean exists=true;

        try{
            exists= studentDAO.existByPk(pk,session);

        }catch (HibernateException e){
            if(session!=null) {
                transaction.rollback();
            }
            throw new DuplicateException("Error checking for existence of primary key: " );

        }finally {
            session.close();
        }
        System.out.println(exists);
        return exists;
    }


}
