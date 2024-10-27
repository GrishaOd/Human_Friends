import java.util.Date;

public class Horse extends PackAnimal {
    private String breed;
    private int weight;
    private int speed;

    public Horse(String name, Date birthDate, String breed, int weight, int speed) {
        super(name, birthDate, "Horse");
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
    }

    public String doCommand(String command) {
        return name + " (лошадь) выполняет команду: " + command;
    }

    public int getSpeed() {
        return speed;
    }
}

