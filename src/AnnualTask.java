import diary.InvalidInputException;

import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repeatable{

    public AnnualTask(String title, String description, LocalDateTime localDateTime, TypeTask typeTask) throws InvalidInputException {
        super(title, description, localDateTime, typeTask);
    }

    @Override
    public boolean repeatTask(LocalDateTime dateTime) {
        return getDateTask().getYear() == dateTime.getYear();
    }
}
