/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:27 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.d24.hostelsystem.dao.custom.StudentDAO;
import lk.d24.hostelsystem.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity, Session session) {
        try {
            if (session.save(entity) != null) {
                return true;
            } else {
                return false;
            }
        }catch(HibernateException e){
            return false;
        }
    }

    @Override
    public boolean update(Student entity, Session session) {
        try {
            session.update(entity);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Student entity, Session session) {
        try {
            session.delete(entity);
            return true;

        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public Student findByPk(String pk, Session session) {
        return null;
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public List<Student> searchStudentByText(String text, Session session) {
        List<Student> studentList = new ArrayList<>();

        String hql = "FROM Student E WHERE E.id like '%"+text+"%' or E.name like '%"+text+"%'";
        Query query = session.createQuery(hql);
        studentList=query.list();
        return studentList;
    }
}
