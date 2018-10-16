package net.beiyi.bean;

public class User {

    private Long id;

    private String name;

    private int age;

    private String info;

    public User() {
    }

    public User(Long id, String name, int age, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return info;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
