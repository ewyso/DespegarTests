package test.commons;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class TestUtils {

    //returns the number of certain month
    public String getMonthNumber(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es","ES"));
        Date parsedDate = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedDate);
        //months starts in 0
        int month = cal.get(Calendar.MONTH) + 1;

        return month >= 1 ? String.valueOf("0" + String.valueOf(month)) : String.valueOf(month);
    }

    public void selectItemFromLi(String xpathItem, String itemToSelect){
        WebElement countryUL= $(By.xpath(xpathItem));;
        List<WebElement> countriesList=countryUL.findElements(By.tagName("li"));
        for (WebElement li : countriesList) {
            if (li.getText().contains(itemToSelect)) {
                li.click();
            }
        }
    }

    public void selectDayFromCalendar(String date, String calendar, String nextBtn) throws ParseException {

        String[] splittedDate = date.split(" ");
        String checkInDate = splittedDate[0].startsWith("0") ? splittedDate[0].substring(1) : splittedDate[0];
        String checkInMonthYear = StringUtils.capitalize(splittedDate[1]) + splittedDate[2];
        String monthNumber = getMonthNumber(date);

        List<WebElement> elements = ($(By.xpath("//body")).findElements(By.xpath(calendar)));

        for (int i=0; i < elements.size(); i++) {
            String calendarMonthYear = elements.get(i).getAttribute("textContent");

            //Selecting the month
            if(checkInMonthYear.equals(calendarMonthYear)){
                //Validate if correct calendar is present
                if(elements.get(i).isEnabled() && elements.get(i).isDisplayed()){
                    selectDate(checkInDate, monthNumber, getMonthCalendar());
                    break;
                } else {
                    //switch to correct month
                    boolean isMonthEnabled = false;
                    while(!isMonthEnabled) {
                        $(By.xpath(nextBtn)).click();
                        if(elements.get(i).isEnabled() && elements.get(i).isDisplayed()){
                            isMonthEnabled = true;
                        }
                    }
                    //select date
                    selectDate(checkInDate, monthNumber, getMonthCalendar());
                    break;
                }
            }

        }
    }

    public void selectDate(String checkInDate, String monthNumber, String monthCalendar) {

        List<WebElement> calendarDays =  $(By.xpath("//body")).findElements(By.xpath( getMainDiv() + monthCalendar.replace("*monthNumber*", monthNumber.toString())));
        for(int j=0; j < calendarDays.size(); j++){
            //Select date
            if(calendarDays.get(j).getAttribute("textContent").equals(checkInDate) && calendarDays.get(j).isEnabled()){
                calendarDays.get(j).click();
                break;
            }
        }
    }

    public String convertDate(LocalDate date){

        Locale spanish = new Locale("es", "ES");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", spanish);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd MMMM yyyy", spanish);
        LocalDate ld = LocalDate.parse(date.toString(), dtf);
        String stringDate = dtf2.format(ld);

        return stringDate;
    }

    //Implementhed by each one
    public String getMainDiv(){ return "//*"; }
    public String getMonthCalendar() { return ""; }

}
