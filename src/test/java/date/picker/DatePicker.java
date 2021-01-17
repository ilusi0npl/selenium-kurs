package date.picker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static date.picker.DateHelper.getDateDifferenceInMonths;
import static date.picker.DateHelper.getDayFromDate;


public class DatePicker {

    @FindBy(css = "a.ui-datepicker-prev")
    private WebElement prevArrow;

    @FindBy(css = "a.ui-datepicker-next")
    private WebElement nextArrow;

    @FindBy(css = "div.ui-datepicker-title")
    private WebElement currentMonthTitle;

    @FindBy(css = "a.ui-state-default")
    private List<WebElement> listOfDays;

    @FindBy(id = "datepicker")
    private WebElement datePickerField;

    public DatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Metoda służy od ukazania(otwarcia) DatePickera
    public void openDatePicker() {
        datePickerField.click();
    }

    //Metoda służy do wybrania daty w DatePickerze
    public void setDate(String dateToSelect) {
        String currentMonthFromDatePicker = currentMonthTitle.getText();
        long differenceBetweenMonths = getDateDifferenceInMonths(dateToSelect, currentMonthFromDatePicker);
        int dayToSet = getDayFromDate(dateToSelect);

        selectMonth(differenceBetweenMonths);
        selectDay(dayToSet);
    }

    //Metoda zwraca wybraną wartość w DatePickerze
    public String getSelectedDate() {
        return datePickerField.getAttribute("value");
    }

    //Metoda z listy WebElementów dni wybiera dzień, który odpowiada wybranemu dniowi z parametru metody np. 31
    private void selectDay(int dayToSet) {
        for (WebElement dayToSelect : listOfDays) {
            if (Integer.parseInt(dayToSelect.getText()) == dayToSet) {
                dayToSelect.click();
                break;
            }
        }
    }

    //Metoda na podstawie parametru differenceBetweenMonths przechodzi do miesiąca w przyszłości lub przeszłości
    // Klikając na strzałkę w prawo lub lewo, tyle razy ile wynosi wartość parametru differenceBetweenMonths
    private void selectMonth(long differenceBetweenMonths) {
        WebElement arrowToClick = selectArrow(differenceBetweenMonths);

        //Ponieważ wartość differenceBetweenMonths może być ujemna, zamieniamy ją na wartość absolutną (dodatnią)
        differenceBetweenMonths = Math.abs(differenceBetweenMonths);

        for (int month = 0; month < differenceBetweenMonths; month++) {
            arrowToClick.click();
        }
    }

    //Metoda wybiera strzałkę do kliknięcia na podstawie parametru differenceBetweenMonths
    private WebElement selectArrow(long differenceBetweenMonths) {
        WebElement arrowToClick = null;

        if (differenceBetweenMonths >= 0) {
            arrowToClick = nextArrow;
        } else {
            arrowToClick = prevArrow;
        }
        return arrowToClick;
    }


}