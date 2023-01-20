import diary.InvalidInputException;

import java.time.LocalDateTime;
import java.util.Objects;

import static diary.Validate.validateValue;


public abstract class Task {


    public enum TypeTask {

        PERSONAL(0),
        WORK(1);

        private final int number;

        TypeTask(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

    }

    private String title;
    private String description;
    private static Integer idCount = 0;
    private final Integer id;
    private LocalDateTime dateTask;
    private TypeTask typeTask;


    public Task(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        idCount++;
        id = idCount;
        this.title = validateValue(title);
        this.description = validateValue(description);
        this.dateTask = localDateTime;
        this.typeTask = typeTask;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTask() {
        return dateTask;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    @Override
    public String toString() {
        return id + ". " + typeTask + ": " + title + " (" + description + "), " + dateTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dateTask, task.dateTask) && typeTask == task.typeTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, id, dateTask, typeTask);
    }
}
