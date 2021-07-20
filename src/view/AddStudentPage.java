package view;

import controller.StudentController;
import model.Student;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddStudentPage extends JFrame {
    StudentController studentController;

    public AddStudentPage(StudentController studentController) {
        this.studentController = studentController;
        this.setSize(new Dimension(600, 800));
        this.setLayout(new FlowLayout());
        AddStudentPanel addStudentPanel = new AddStudentPanel();
        this.add(new TextField("Student Page                                  "));
        this.add(addStudentPanel);
        JTextArea display = new JTextArea();

        JButton addStudentButton = new JButton("Add student");
        JButton viewStudent = new JButton("View all students");
        this.add(addStudentButton);
        this.add(viewStudent);
        this.add(display);
        this.setVisible(true);
        addStudentButton.addActionListener(e -> {
            String name = addStudentPanel.getName();
            int age = addStudentPanel.getAge();
            String class_name = addStudentPanel.getClassName();
            int grade = addStudentPanel.getGrade();
            Student s = new Student(name, age, class_name, grade);
            studentController.addStudent(s);
        });
        viewStudent.addActionListener(e -> {
            ResultSet rs = studentController.getStudents();
            String fi = "";
            try {
                while (rs.next()) {
                    String s = rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3);
                    fi = fi + "\n" +s;
                }
                display.setText(fi);
            } catch (Exception f) {
                System.out.println(f);
            }
        });
    }

    class AddStudentPanel extends JPanel {
        TextField name;
        TextField age;
        TextField className;
        TextField grade;

        public AddStudentPanel() {
            this.setSize(new Dimension(200, 400));
            this.setLayout(new GridLayout(4, 2));
            name = new TextField();
            age = new TextField();
            className = new TextField();
            grade = new TextField();
            TextField nameArea = new TextField("Name");
            TextField ageArea = new TextField("Age");
            TextField gradeArea = new TextField("Grade");
            TextField classNameArea = new TextField("Class name");
            this.add(nameArea);
            this.add(name);
            this.add(ageArea);
            this.add(age);
            this.add(classNameArea);
            this.add(className);
            this.add(gradeArea);
            this.add(grade);
        }

        public String getName() {
            return name.getText();
        }

        public int getAge() {
            return Integer.parseInt(this.age.getText());
        }

        public String getClassName() {
            return this.className.getText();
        }

        public int getGrade() {
            return Integer.parseInt(this.grade.getText());
        }
    }
}
