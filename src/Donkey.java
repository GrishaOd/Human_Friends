import java.util.Date;

public class Donkey extends PackAnimal {
    private String breed;
    private int age;
    private int weight;

    public Donkey(String name, Date birthDate, String breed, int age, int weight) {
        super(name, birthDate, "Donkey");
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String doCommand(String command) {
        return name + " (ослик) выполняет команду: " + command;
    }

    public int getAge() {
        return age;
    }
}
