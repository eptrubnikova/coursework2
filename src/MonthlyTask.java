import diary.InvalidInputException;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {

    public MonthlyTask(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        super(title, description, localDateTime, typeTask);
    }

    @Override
    public boolean repeatTask(LocalDateTime dateTime) {
        return getDateTask().getMonth().equals(dateTime.getMonth());

    }
}
