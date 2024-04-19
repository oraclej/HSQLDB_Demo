package ir.oraclej.hsqlDemo;

public class PersonEntity {
    private int id;
    private String name;
    private String family;
    private int age;

    public PersonEntity() {
    }

    public PersonEntity(int id, String name, String family, int age) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.age = age;
    }

    public PersonEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
