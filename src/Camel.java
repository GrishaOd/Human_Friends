import java.util.Date;

public class Camel extends PackAnimal {
    private String breed;
    private int weight;

    public Camel(String name, Date birthDate, String breed, int weight) {
        super(name, birthDate, "Camel");
        this.breed = breed;
        this.weight = weight;
    }

    public String doCommand(String command) {
        return name + " (верблюд) выполняет команду: " + command;
    }
}
