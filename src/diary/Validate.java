package diary;

public class Validate {

    public static String validateValue(String value) throws InvalidInputException{
        if (value == null || value.isEmpty() || value.isBlank()){
            throw new InvalidInputException("Проверьте корректность ввода данных");
        }else {
            return value;
        }
    }

}
