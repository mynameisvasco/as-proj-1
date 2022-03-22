package as.proj1.hospital.entities;

public abstract class AbstractPatient {
    protected final String name;
    protected final int age;


    protected AbstractPatient(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
