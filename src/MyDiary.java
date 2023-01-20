import diary.InvalidInputException;
import diary.Validate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MyDiary {

    private static final Map<Integer, Repeatable> tasks = new HashMap<>();

    public static void addTask(Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.println("Введите заголовок задачи: ");
            String title = Validate.validateValue(scanner.nextLine());
            System.out.println("Введите описание зачади: ");
            String description = Validate.validateValue(scanner.nextLine());
            System.out.println("Введите дату задачи в формате dd.mm.yyyy hh:mm - ");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime dateTask = LocalDateTime.parse(scanner.nextLine(), format);
            System.out.println("Определите тип задачи: 0 - личная, 1 - рабочая");
            Task.TypeTask typeTask = Task.TypeTask.values()[scanner.nextInt()];
            System.out.println("Частота повтора задачи: 0 - однократная, 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная, 4 - ежегодная");
            int repeatability = scanner.nextInt();

            System.out.println("Задача создана");
            setTaskConditions(repeatability, title, description, dateTask, typeTask);

            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Repeatable setTaskConditions(int repeatability, String title, String description, LocalDateTime localDateTime, Task.TypeTask typeTask) throws InvalidInputException {
        Repeatable task = null;
        return switch (repeatability) {
            case 0 -> {
                SingleTask singleTask = new SingleTask(title, description, localDateTime, typeTask);
                tasks.put(singleTask.getId(), singleTask);
                yield singleTask;
            }
            case 1 -> {
                DailyTask dailyTask = new DailyTask(title, description, localDateTime, typeTask);
                tasks.put(dailyTask.getId(), dailyTask);
                yield dailyTask;
            }
            case 2 -> {
                WeeklyTask weeklyTask = new WeeklyTask(title, description, localDateTime, typeTask);
                tasks.put(weeklyTask.getId(), weeklyTask);
                yield weeklyTask;
            }
            case 3 -> {
                MonthlyTask monthlyTask = new MonthlyTask(title, description, localDateTime, typeTask);
                tasks.put(monthlyTask.getId(), task);
                yield task;
            }
            case 4 -> {
                AnnualTask annualTask = new AnnualTask(title, description, localDateTime, typeTask);
                tasks.put(annualTask.getId(), task);
                yield task;
            }
            default -> null;
        };
    }

    public static void printAllTasks() {
        for (Repeatable task : tasks.values()) {
            System.out.println(task);
        }
    }

    public static void deleteTask(Scanner scanner) {
        System.out.println("Введите id задачи: ");
        int id = scanner.nextInt();
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            System.out.println("Задача под номером " + id + " удалена");
        } else {
            System.out.println("Выберите задачу из списка актуальных задач");
        }
    }

    private static List<Repeatable> findDateTask(LocalDate date) {
        List<Repeatable> allTasks = new ArrayList<>();
        for (Repeatable task : tasks.values()) {
            if (task.repeatTask(date.atStartOfDay())) {
                allTasks.add(task);
            }
        } return allTasks;
    }

    public static void findAllTasksByDate(Scanner scanner) {
        System.out.println("Введите дату в формате dd.MM.yyyy");
        String date = scanner.next();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateTime = LocalDate.parse(date, format);
        List<Repeatable> tasksByDate = findDateTask(dateTime);
        System.out.println("На " + dateTime + " запланировано: ");
        for (Repeatable task : tasksByDate) {
            System.out.println(task);
        }
    }
}
