import java.util.Date;

public class Cat extends Pet {
    private String breed;
    private int age;
    private boolean neutered;

    public Cat(String name, Date birthDate, String breed, int age, boolean neutered) {
        super(name, birthDate, "Cat");
        this.breed = breed;
        this.age = age;
        this.neutered = neutered;
    }

    public String doCommand(String command) {
        return name + " выполняет команду: " + command;
    }
}

