import java.io.Serializable;
import java.util.ArrayList;

public class Stud implements Serializable {
    private String id;
    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }
    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }

    private String name;
    private String profession;
    ArrayList<Course> coursesList = new ArrayList<>();
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Stud() {
    }

    public Stud(String id, String name,String profession) {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(ArrayList<Course> coursesList){
        for (int i = 0; i < coursesList.size(); i++) {
            System.out.println(coursesList.get(i).getCourse()+"  :"+coursesList.get(i).getCourseGrade());
        }
    }
    public void toString(ArrayList<Course> coursesList) {
        String an = "Stud{" +
                "学号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 专业='" + profession + '\'';
        System.out.println(an);
        show(coursesList);

    }
}
