import java.util.Date;

public class Dog extends Pet {
    private String breed;
    private int age;
    private String occupation;

    public Dog(String name, Date birthDate, String breed, int age, String occupation) {
        super(name, birthDate, "Dog");
        this.breed = breed;
        this.age = age;
        this.occupation = occupation;
    }

    public String doCommand(String command) {
        return name + " выполняет команду: " + command;
    }
}

