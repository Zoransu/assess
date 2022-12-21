import java.io.Serializable;
import java.util.InputMismatchException;

public class Course implements Serializable {
    private String Course;
    private double CourseGrade;

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public double getCourseGrade() {
        return CourseGrade;
    }

    public void setCourseGrade(double courseGrade) {
        if(courseGrade<0||courseGrade>100){
            throw new InputMismatchException();
        }
        CourseGrade = courseGrade;
    }

    public Course(String course, double courseGrade) {
        Course = course;
        CourseGrade = courseGrade;
    }

    public Course() {
    }
}
