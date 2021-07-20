package controller;

import dao.StudentDAO;
import model.Student;

import java.sql.ResultSet;

public class StudentController {
    StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAO();
    }

    public void addStudent(Student s) {
        studentDAO.addStudent(s);
    }

    public ResultSet getStudents() {
        return studentDAO.getStudent();
    }
}
