import controller.StudentController;
import model.Student;
import view.AddStudentPage;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        new AddStudentPage(studentController);
        Student s = new Student("Hoang Kim Khai",25 ,"12A3", 12);
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO students(full_name, age, class_name,grade) VALUES");
        builder.append(" (");
        builder.append("'").append(s.getName()).append("'");
        builder.append(",");
        builder.append(String.valueOf(s.getAge()));
        builder.append(",");
        builder.append("'").append(s.getClassName()).append("'");
        builder.append(",");
        builder.append(String.valueOf(s.getGrade()));
        builder.append(")");
        System.out.println(builder);
    }
}
