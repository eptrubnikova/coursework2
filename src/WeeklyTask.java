import diary.InvalidInputException;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {

    public WeeklyTask(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        super(title, description, localDateTime, typeTask);
    }

    @Override
    public boolean repeatTask(LocalDateTime dateTime) {
        return getDateTask().getDayOfWeek().equals(dateTime.getDayOfWeek());

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
