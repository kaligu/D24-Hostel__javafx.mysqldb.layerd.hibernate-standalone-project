/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:27 PM
*/
package lk.d24.hostelsystem.dao.custom;

import lk.d24.hostelsystem.dao.CrudDAO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String>{

    List<Student> searchStudentByText(String text , Session session);



}
