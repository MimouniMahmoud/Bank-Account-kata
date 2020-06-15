package account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public static final DateTimeFormatter MM_DD_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String toDayAsString(){
        return today().format(MM_DD_YYYY);
    }

    protected LocalDate today(){
        return LocalDate.now();
    }
}
