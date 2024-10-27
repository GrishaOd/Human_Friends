import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.*;

public class Menu {

    private static List<Animal> animals = new ArrayList<>();  // Список всех животных
    private static int animalCount = 0;  // Счетчик животных

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Показать список команд животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Показать список животных по дате рождения");
            System.out.println("5. Выйти");
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Для захвата новой строки

            switch (choice) {
                case 1:
                    addAnimal(scanner);  // Добавление нового животного
                    break;
                case 2:
                    showAnimalCommands(scanner);  // Показать список команд животного
                    break;
                case 3:
                    trainAnimal(scanner);  // Обучить животное новой команде
                    break;
                case 4:
                    showAnimalsByBirthDate();  // Показать список животных по дате рождения
                    break;
                case 5:
                    exit = true;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // 1. Функция для добавления нового животного
    private static void addAnimal(Scanner scanner) {
        System.out.println("Выберите тип животного: 1. Собака 2. Кошка 3. Хомяк 4. Лошадь 5. Ослик 6. Верблюд");
        int animalType = scanner.nextInt();
        scanner.nextLine();  // Для захвата новой строки

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения (в формате ГГГГ-ММ-ДД): ");
        String dateStr = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате ГГГГ-ММ-ДД.");
            return;
        }

        Animal newAnimal = null;

        switch (animalType) {
            case 1:
                System.out.print("Введите породу собаки: ");
                String dogBreed = scanner.nextLine();
                System.out.print("Введите возраст собаки: ");
                int dogAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите профессию собаки: ");
                String occupation = scanner.nextLine();
                newAnimal = new Dog(name, birthDate, dogBreed, dogAge, occupation);
                break;
            case 2:
                System.out.print("Введите породу кошки: ");
                String catBreed = scanner.nextLine();
                System.out.print("Введите возраст кошки: ");
                int catAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Кошка кастрирована? (true/false): ");
                boolean neutered = scanner.nextBoolean();
                newAnimal = new Cat(name, birthDate, catBreed, catAge, neutered);
                break;
            case 3:
                System.out.print("Введите породу хомяка: ");
                String hamsterBreed = scanner.nextLine();
                System.out.print("Введите возраст хомяка: ");
                int hamsterAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите цвет хомяка: ");
                String hamsterColor = scanner.nextLine();
                newAnimal = new Hamster(name, birthDate, hamsterBreed, hamsterAge, hamsterColor);
                break;
            case 4:
                System.out.print("Введите породу лошади: ");
                String horseBreed = scanner.nextLine();
                System.out.print("Введите вес лошади: ");
                int horseWeight = scanner.nextInt();
                System.out.print("Введите скорость лошади: ");
                int horseSpeed = scanner.nextInt();
                newAnimal = new Horse(name, birthDate, horseBreed, horseWeight, horseSpeed);
                break;
            case 5:
                System.out.print("Введите породу ослика: ");
                String donkeyBreed = scanner.nextLine();
                System.out.print("Введите возраст ослика: ");
                int donkeyAge = scanner.nextInt();
                System.out.print("Введите вес ослика: ");
                int donkeyWeight = scanner.nextInt();
                newAnimal = new Donkey(name, birthDate, donkeyBreed, donkeyAge, donkeyWeight);
                break;
            case 6:
                System.out.print("Введите породу верблюда: ");
                String camelBreed = scanner.nextLine();
                System.out.print("Введите вес верблюда: ");
                int camelWeight = scanner.nextInt();
                newAnimal = new Camel(name, birthDate, camelBreed, camelWeight);
                break;
            default:
                System.out.println("Неверный тип животного.");
                return;
        }

        if (newAnimal != null) {
            animals.add(newAnimal);  // Добавляем животное в реестр
            animalCount++;
            System.out.println(newAnimal.getClass().getSimpleName() + " добавлено!");
        }
    }

    // 2. Показать список команд животного
    private static void showAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String animalName = scanner.nextLine();

        Animal foundAnimal = findAnimalByName(animalName);

        if (foundAnimal != null) {
            List<String> commands = foundAnimal.showInformation();
            if (!commands.isEmpty()) {
                System.out.println("Команды животного " + foundAnimal.getName() + ":");
                for (String command : commands) {
                    System.out.println("- " + command);
                }
            } else {
                System.out.println("У животного " + foundAnimal.getName() + " нет команд.");
            }
        } else {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    // 3. Обучить животное новой команде
    private static void trainAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String animalName = scanner.nextLine();

        Animal foundAnimal = findAnimalByName(animalName);

        if (foundAnimal != null) {
            System.out.print("Введите новую команду: ");
            String newCommand = scanner.nextLine();
            foundAnimal.addCommand(newCommand);
            System.out.println(foundAnimal.getName() + " обучено новой команде: " + newCommand);
        } else {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    // 4. Показать список животных по дате рождения
    private static void showAnimalsByBirthDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate));  // Сортировка по дате рождения
        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " - " + animal.getBirthDate());
        }
    }

    // Вспомогательная функция для поиска животного по имени
    private static Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}

