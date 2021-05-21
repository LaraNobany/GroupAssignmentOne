package Classes;

public class Courses {
    private String CourseName;
    private String StudentInrolled;

    public Courses() {
    }

    public Courses(String courseName, String studentInrolled) {
        CourseName = courseName;
        StudentInrolled = studentInrolled;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getStudentInrolled() {
        return StudentInrolled;
    }

    public void setStudentInrolled(String studentInrolled) {
        StudentInrolled = studentInrolled;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "CourseName='" + CourseName + '\'' +
                ", StudentInrolled='" + StudentInrolled + '\'' +
                '}';
    }
}
