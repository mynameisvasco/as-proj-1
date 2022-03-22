package as.proj1.hospital.entities;

public class AdultPatient extends AbstractPatient {
    public AdultPatient(String name, int age) {
        super(name, age);

        if(age <= 18) {
            throw new IllegalArgumentException("Adult patient can't be less than 18 years old");
        }
    }
}
