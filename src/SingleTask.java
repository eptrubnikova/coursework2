import diary.InvalidInputException;

import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{


    public SingleTask(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        super(title, description, localDateTime, typeTask);
    }

    @Override
    public boolean repeatTask(LocalDateTime dateTime) {
        return getDateTask().toLocalDate().equals(dateTime.toLocalDate());
    }

    @Override
    public String toString() {
        return  super.toString() + ", Задача однократная";
    }
}
