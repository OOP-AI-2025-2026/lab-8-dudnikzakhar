import ua.opnu.*;

public static void main(String[] args) {
    // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
    MyOptional<String> middleName = new MyOptional<>();
    System.out.println(middleName); // MyOptional[empty]
    System.out.println("isPresent: " + middleName.isPresent()); // false
    System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

    // 2. Заповнене значення (наприклад, логін користувача)
    MyOptional<String> username = new MyOptional<>("admin");
    System.out.println(username); // MyOptional[value=admin]
    System.out.println("isPresent: " + username.isPresent()); // true
    System.out.println("get(): " + username.get()); // "admin"
    System.out.println("orElse: " + username.orElse("guest")); // "admin"

    // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
    try {
        String test = middleName.get(); // має кинути IllegalStateException
        System.out.println("unexpected: " + test);
    } catch (IllegalStateException ex) {
        System.out.println("Очікуваний виняток: " + ex.getMessage());
    }

    // 4. Перевіримо, що конструктор не приймає null
    try {
        MyOptional<String> broken = new MyOptional<>(null);
        System.out.println("unexpected: " + broken);
    } catch (IllegalArgumentException ex) {
        System.out.println("Правильно не дозволив null: " + ex.getMessage());
    }

    // task 2
    System.out.println("\nTask2\n");

    List<BookData> books = new ArrayList<>();
    books.add(new BookData("Кайдашева сім'я", "Іван Нечуй-Левицький", 250, 1225.0)); // Рейтинг: 4.9
    books.add(new BookData("1984", "Джордж Орвелл", 200, 1000.0)); // Рейтинг: 5.0
    books.add(new BookData("Тигролови", "Іван Багряний", 220, 1078.0)); // Рейтинг: 4.9 (такий самий, як у Кайдашевої сім'ї)
    books.add(new BookData("Захар Беркут", "Іван Франко", 180, 846.0)); // Рейтинг: 4.7

    System.out.println("--- Список книг до сортування: ---");
    for (BookData book : books) {
        System.out.println(book);
    }

    Collections.sort(books);

    System.out.println("\n--- Список книг після сортування: ---");
    for (BookData book : books) {
        System.out.println(book);
    }

    // task 3
    System.out.println("\ntask3\n");
    Printer myPrinter = new Printer();
    Integer[] intArray = {1, 2, 3};
    String[] stringArray = {"Hello", "World"};
    myPrinter.printArray(intArray);
    myPrinter.printArray(stringArray);

    // task 4
    System.out.println("\ntask4\n");

    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Predicate<Integer> isEven = n -> n % 2 == 0;
    Integer[] evenNumbers = PredicateFilter.filter(numbers, isEven);
    System.out.println("Парні числа: " + Arrays.toString(evenNumbers));

    String[] words = {"олівець", "вода", "квіти", "дзеркало", "дельфін"};
    Predicate<String> WordsContainIPredicate = word -> word.contains("і");
    String[] WordsWithI = PredicateFilter.filter(words, WordsContainIPredicate);
    System.out.println("Слова, які містять літеру і: " + Arrays.toString(WordsWithI));

    // task 5
    System.out.println("\ntask5\n");

    String[] stringArrayContains = {"яблуко", "горіх", "морква"};
    System.out.println("Чи містить масив слово 'морква'? " + ContainsString.contains(stringArrayContains, "морква"));
    System.out.println("Чи містить масив слово 'кавун'? " + ContainsString.contains(stringArrayContains, "кавун"));

    System.out.println("Чи містить масив число 6? " + ContainsString.contains(numbers, 6));
    System.out.println("Чи містить масив число 70? " + ContainsString.contains(numbers, 70));

    // task 6
    System.out.println("\ntask6\n");
    GenericTwoTuple<String, Integer> ingredient =
            new GenericTwoTuple<>("Борошно", 500);
    System.out.println("Інгредієнт для рецепту: " + ingredient);

    GenericTwoTuple<String, Double> drink =
            new GenericTwoTuple<>("Лимонад", 1.5);
    System.out.println("Напій та об'єм: " + drink);

    GenericThreeTuple<String, String, Integer> dishInfo =
            new GenericThreeTuple<>("Яблучний пиріг", "Десерт", 350);
    System.out.println("Інформація про страву: " + dishInfo);

    System.out.println("\nНазва інгредієнта: " + ingredient.first);
    System.out.println("Його вага: " + ingredient.second + " грам");

    System.out.println("Тип страви: " + dishInfo.second);
    System.out.println("Калорійність на порцію: " + dishInfo.third + " ккал");
}
