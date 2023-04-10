/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 9:46 PM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.service.SuperService;

import java.util.List;

public interface StudentService extends SuperService {
    boolean saveStudent(StudentDTO studentDTO);

    boolean updateStudent(StudentDTO studentDTO);

    boolean deleteStudent(StudentDTO studentDTO);

    List<StudentDTO> searchStudentByText(String text);
}
