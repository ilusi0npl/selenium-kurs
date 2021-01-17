package date.picker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    //Format daty DatePickera po wybraniu/wpisaniu daty np. 06/31/2018
    private static final String DATE_PICKER_DATE_FORMAT = "MM/dd/yyyy";

    //Format daty tytułu DatePickera (Miesiąc i rok) np. July 2018
    private static final String DATE_PICKER_TITLE_DATE_FORMAT = "MMMM yyyy";

    //Metoda najpierw parsuje datę w formie Stringu. Następnie zwraca datę w formie obiektu LocalDate, by ostatecznie zwrócić dzień miesiąca z daty
    protected static int getDayFromDate(String date) {
        LocalDate localDate = DateHelper.parseDate(date, DATE_PICKER_DATE_FORMAT);
        int dayOfMonth = localDate.getDayOfMonth();
        return dayOfMonth;
    }

    //Metoda wylicza różnicę pomiędzy aktualnie wybraną datą w Date Pickerze, a datą którą chcemy wybrać
    protected static long getDateDifferenceInMonths(String actualTitleDate, String dateToSelect) {
        LocalDate actualLocalDate = parseDate(actualTitleDate, DATE_PICKER_DATE_FORMAT);
        LocalDate dateToSelectLocalDate = parseDate(dateToSelect, DATE_PICKER_TITLE_DATE_FORMAT);

        long differenceOfMonths = YearMonth.from(dateToSelectLocalDate).until(actualLocalDate, ChronoUnit.MONTHS);
        return differenceOfMonths;
    }

    //Metoda służy do parsowania daty w formacie String (w zadanym formacie) na datę o typie LocalDate
    private static LocalDate parseDate(String dateToParse, String dateFormat) {
        DateFormat dateFormatCurrent = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date parsedDate = null;
        try {
            parsedDate = dateFormatCurrent.parse(dateToParse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalStateException("There was an exception while parsing date: " + dateFormat);
        }
        return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


}