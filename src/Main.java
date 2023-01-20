import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            MyDiary.addTask(scanner);
                            break;
                        case 2:
                            MyDiary.deleteTask(scanner);
                            break;
                        case 3:
                            MyDiary.findAllTasksByDate(scanner);
                            break;
                        case 4:
                            MyDiary.printAllTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }


    private static void printMenu() {
        System.out.println(
                " 1. Добавить задачу \n" +
                        " 2. Удалить задачу \n" +
                        " 3. Получить задачу на указанный день \n" +
                        " 4. Получить все созданные задачи \n" +
                        " 0. Выход"
        );
    }
}