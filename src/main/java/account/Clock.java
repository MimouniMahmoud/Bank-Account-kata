package account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String toDayAsString(){
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
