import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Validator {

    private static Validator instance;

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public Validator() {

    }

    public boolean fileIsExist(String date) {
        Path path = Paths.get(date);
        return Files.exists(path);
    }

    public boolean checkDateFormat(String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            Date checkDate = dateFormat.parse(date);
            return false;
        } catch (ParseException e) {
            System.out.println("Wrong date format!");
        }
        return true;
    }

    public boolean checkTimeFormat(String time) {
        try {
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
            timeFormat.parse(time);
            return false;
        }
        catch (DateTimeParseException e) {
            System.out.println("Wrong time format!");
        }
        return true;
    }
}
