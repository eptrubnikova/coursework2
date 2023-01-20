import diary.InvalidInputException;

import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable{

    public DailyTask(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        super(title, description, localDateTime, typeTask);
    }

    @Override
    public boolean repeatTask(LocalDateTime dateTime) {
        return getDateTask().toLocalDate().equals(dateTime.toLocalDate());

    }
}
