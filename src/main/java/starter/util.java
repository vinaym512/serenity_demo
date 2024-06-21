package starter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class util {
    
    public static String get_date(String input){
        String[] parts = input.split(" ");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
        LocalDate calculated_date = currentDate.plusDays(Integer.parseInt(parts[0]));
        String date_str = calculated_date.format(formatter).toString();
        return date_str;
    }
}
