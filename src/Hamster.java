import java.util.Date;

public class Hamster extends Pet {
    private String breed;
    private int age;
    private String color;

    public Hamster(String name, Date birthDate, String breed, int age, String color) {
        super(name, birthDate, "Hamster");
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public String doCommand(String command) {
        return name + " (хомяк) выполняет команду: " + command;
    }

    public String getColor() {
        return color;
    }
}
