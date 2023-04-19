/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:27 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.StudentDAO;
import lk.d24.hostelsystem.dto.ReserveDTO;
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
        try {
            return session.get(Student.class,pk);

        } catch (HibernateException e) {
            return  null;
        }
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

    @Override
    public List<String> getAllStudentIds(Session session) {
        List<String> idList = new ArrayList<>();
        String hql = "SELECT s.student_id FROM Student s";
        Query query = session.createQuery(hql);
        idList = query.list();
        return idList;
    }

    @Override
    public String getLastStudentID(Session session) {
        String id = null;
        String hql = "SELECT r.student_id FROM Student r ORDER BY r.student_id DESC";
        Query<String> query = session.createQuery(hql, String.class);
        query.setMaxResults(1);
        List<String> result = query.getResultList();
        if (!result.isEmpty()) {
            id = result.get(0);
        }else{
            id="null";
        }
        return id;
    }
}
