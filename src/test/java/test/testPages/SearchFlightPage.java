package test.testPages;

import test.commons.Constants;
import test.commons.TestUtils;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchFlightPage extends TestUtils {

    final String TITLE_FLIGHT_SEARCH = "Despegar . Resultados de Vuelos";

    @Override
    public String getMonthCalendar() {
        return Constants.XPATH_FLIGHT_CALENDAR;
    }

    public void selectFlightOption(){
        $(By.xpath(Constants.XPATH_BTN_FLIGHT)).click();
    }

    public void selectOrigin(String origen){
        $(By.xpath(Constants.XPATH_ORIGEN)).waitUntil(appear, Constants.cTIMEOUT).click();
        $(By.xpath(Constants.XPATH_ORIGEN)).setValue("").sendKeys(origen);
        $(By.xpath(Constants.XPATH_DIV_CIUDADES)).waitUntil(appear, Constants.cTIMEOUT);
        selectItemFromLi(Constants.XPATH_LISTA_CIUDADES, origen);
        $(By.xpath(Constants.XPATH_ORIGEN)).shouldHave(value(origen));
    }

    public void selectDestino(String destino){
        $(By.xpath(Constants.XPATH_DESTINO)).setValue("").sendKeys(destino);
        $(By.xpath(Constants.XPATH_DIV_CIUDADES)).waitUntil(appear, Constants.cTIMEOUT);
        selectItemFromLi(Constants.XPATH_LISTA_CIUDADES, destino);
        $(By.xpath(Constants.XPATH_DESTINO)).shouldHave(value(destino));
    }


    public void selectDates(LocalDate fechaPartida, LocalDate fechaRegreso) throws ParseException {
        //Dates
        $(By.xpath(Constants.XPATH_DIV_FECHA_IDA)).click();
        $(By.xpath(Constants.XPATH_DIV_DATE_PICKER_ORIGEN)).waitUntil(appear, Constants.cTIMEOUT);

        selectDayFromCalendar(convertDate(fechaPartida), Constants.XPATH_CALENDAR_PICKER_FLIGHTS, Constants.XPATH_BTN_NEXT);
        selectDayFromCalendar(convertDate(fechaRegreso), Constants.XPATH_CALENDAR_PICKER_FLIGHTS, Constants.XPATH_BTN_NEXT);
    }

    public void searchFlightBtn(){
        $(By.xpath(Constants.XPATH_BTN_BUSCAR_VUELO)).click();
        $(By.xpath(Constants.XPATH_FLIGHT_PROGRESS_BAR)).waitUntil(disappear, Constants.cHIGH_TIMEOUT);
    }

    public void validateTittle(){
        $("title").shouldHave(attribute("text", TITLE_FLIGHT_SEARCH));
    }

    @Override
    public String getMainDiv() {
        return Constants.XPATH_MAIN_DIV_FLIGHTS;
    }

}
