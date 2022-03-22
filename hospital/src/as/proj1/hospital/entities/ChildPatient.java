package as.proj1.hospital.entities;

public class ChildPatient extends AbstractPatient {
    protected ChildPatient(String name, int age) {
        super(name, age);

        if(age >= 18) {
            throw new IllegalArgumentException("Child patient can't be more than 17 years old");
        }
    }
}
