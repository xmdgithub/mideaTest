package package1.something.practice;

public class student {
    private String sid;
    private String name;
    private int age;
    private String from;

    public student() {
    }

    public student(String sid, String name, int age, String from) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.from = from;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
