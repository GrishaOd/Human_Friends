import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Animal {
    protected String name;
    protected Date birthDate;
    protected List<String> commands;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public List<String> showInformation() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}