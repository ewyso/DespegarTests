package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class FlightsCommons {


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

    public String getActualDate(){
        Date originDate = new Date();
        LocalDate localDate = originDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();

        return String.valueOf(year) + "-" + (String.valueOf(month).length() > 1 ? String.valueOf(month) : "0" + String.valueOf(month));
    }

    public void selectFlightDay(String date) throws ParseException {

        String[] splittedDate = date.split(" ");
        String checkInDate = splittedDate[0];
        String checkInMonthYear = splittedDate[1] + splittedDate[2];
        String monthNumber = getMonthNumber(date);

        List<WebElement> elements = ($(By.xpath("//body")).findElements(By.xpath(Constants.XPATH_CALENDAR_PICKER)));

        for (int i=0; i < elements.size(); i++) {
            String calendarMonthYear = elements.get(i).getAttribute("textContent");

            //Selecting the month
            if(checkInMonthYear.equals(calendarMonthYear)){
                //Validate if correct calendar is present
                if(elements.get(i).isEnabled() && elements.get(i).isDisplayed()){
                    selectDate(checkInDate, monthNumber);
                    break;
                } else {
                    //switch to correct month
                    boolean isMonthEnabled = false;
                    while(!isMonthEnabled) {
                        $(By.xpath(Constants.XPATH_BTN_NEXT)).click();
                        if(elements.get(i).isEnabled() && elements.get(i).isDisplayed()){
                            isMonthEnabled = true;
                        }
                    }
                    //select date
                    selectDate(checkInDate, monthNumber);
                    break;
                }
            }

        }
    }

    public void selectDate(String checkInDate, String monthNumber) {
        List<WebElement> calendarDays =  $(By.xpath("//body")).findElements(By.xpath( getMainDiv() + "//div[@class='_dpmg2--months']//div[@data-month='2020-"+ monthNumber +"']//div[@class='_dpmg2--dates']//span[contains(@class,'--available')]//span[@class='_dpmg2--date-number']"));

        for(int j=0; j < calendarDays.size(); j++){
            //Select date
            if(calendarDays.get(j).getAttribute("textContent").equals(checkInDate) && calendarDays.get(j).isEnabled()){
                calendarDays.get(j).click();
                break;
            }
        }
    }

    //Implementhed by each one
    public String getMainDiv(){
        return "";
    }


}
