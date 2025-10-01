package service;

import dao.StudentDAO;
import model.Student;
import java.util.List;

public class StudentService {
    
    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) throws Exception {

        if(student.getAge() <= 0) {
            throw new Exception("Age must be greater than 0");
        }

        studentDAO.insert(student);
    }

    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAll();
    }

    public void updateStudent(Student student) throws Exception {
        if(student.getAge() <= 0) {
            throw new Exception("Age must be greater than 0");
        }

        studentDAO.update(student);
    }

    public void deleteStudent(int id) throws Exception {
        studentDAO.delete(id);
    }
}
