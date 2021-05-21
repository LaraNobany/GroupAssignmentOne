package Classes;

public class Student {
    private String Name;
    private String Email;
    private int Phone;
    private String Gender;
    private String University;

    public Student() {
    }

    public Student(String name, String email, int phone, String gender, String university) {
        Name = name;
        Email = email;
        Phone = phone;
        Gender = gender;
        University = university;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone=" + Phone +
                ", Gender='" + Gender + '\'' +
                ", University='" + University + '\'' +
                '}';
    }
}
