package dao;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    Connection con;
    Statement stmt;

    public StudentDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql_student", "root", "root");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Querying failed");

            System.out.println(e);
        }
    }

    public ResultSet getStudent() {
        try {
            ResultSet rs = stmt.executeQuery("select * from students");
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO students(full_name, age, class_name,grade) VALUES" +
                " (" +
                "'" + s.getName() + "'" +
                "," +
                String.valueOf(s.getAge()) +
                "," +
                "'" + s.getClassName() + "'" +
                "," +
                String.valueOf(s.getGrade()) +
                ")";
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Student adding failed");
        }
    }
}
