import java.util.ArrayList;
import java.util.Date;

public class PackAnimal extends Animal {
    private String type;
    private static int counter = 0;

    public PackAnimal(String name, Date birthDate, String type) {
        super(name, birthDate);
        this.type = type;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public void addAnimal(Animal animal) {
        // Реализация добавления животного
    }

    public ArrayList<Animal> showAnimals() {
        // Реализация показа списка животных
        return new ArrayList<>();
    }
}