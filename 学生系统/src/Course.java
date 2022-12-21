import java.io.Serializable;

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
        CourseGrade = courseGrade;
    }

    public Course(String course, double courseGrade) {
        Course = course;
        CourseGrade = courseGrade;
    }

    public Course() {
    }
}
