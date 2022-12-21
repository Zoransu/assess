import java.io.Serializable;

public class All implements Serializable {
    private String id;
    private String name;
    private String profession;
    private double course1;
    private double course2;
    private double course3;
    public All() {
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getCourse1() {
        return course1;
    }

    public void setCourse1(double course1) {
        this.course1 = course1;
    }

    public double getCourse2() {
        return course2;
    }

    public void setCourse2(double course2) {
        this.course2 = course2;
    }

    public double getCourse3() {
        return course3;
    }

    public void setCourse3(double course3) {
        this.course3 = course3;
    }
}
