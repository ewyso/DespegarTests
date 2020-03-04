package test.testPages;

import test.commons.Constants;
import test.commons.TestUtils;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchHotelPage extends TestUtils {

    @Override
    public String getMonthCalendar() {
        return Constants.XPATH_CALENDAR_DIA_HOTEL;
    }

    public void searchForHotel(String location){
        //btn hoteles
        $(By.xpath(Constants.XPATH_BTN_HOTELES)).click();
        $(By.xpath(Constants.XPATH_SEARCHBOX_HOTELES)).should(appear).should(visible);
        //input hotel
        $(By.xpath(Constants.XPATH_INPUT_HOTELES)).waitUntil(appear, Constants.cTIMEOUT).click();
        $(By.xpath(Constants.XPATH_INPUT_HOTELES)).setValue("").sendKeys(location);
        selectItemFromLi(Constants.XPATH_LIST_PAISES_HOTELES, location);
        $(By.xpath(Constants.XPATH_INPUT_HOTELES)).shouldHave(value(location));
    }

    public void selectDates(LocalDate fechaPartida, LocalDate fechaRegreso) throws ParseException {
        //Fechas ida
        $(By.xpath(Constants.XPATH_FECHA_VIAJE_HOTELES)).should(appear);
        $(By.xpath(Constants.XPATH_FECHA_VIAJE_HOTELES)).click();
        //date picker
        $(By.xpath(Constants.XPATH_DATEPICKER_HOTELES)).waitUntil(appear, Constants.cTIMEOUT);
        selectDayFromCalendar(convertDate(fechaPartida), Constants.XPATH_CALENDAR_HOTELES , Constants.XPATH_BTN_NEXT_HOTELES);
        selectDayFromCalendar(convertDate(fechaRegreso), Constants.XPATH_CALENDAR_HOTELES , Constants.XPATH_BTN_NEXT_HOTELES);
    }

    public void selectRoom(int cantidadAdultos, int cantidadMenores){
        //Habitacion
        $(By.xpath(Constants.XPATH_INPUT_HABITACION)).click();
        $(By.xpath(Constants.XPATH_PANEL_SELECCION_HABITACION)).should(appear);

        //adultos
        String adultQty = ($(By.xpath(Constants.XPATH_CANTIDAD_ADULTOS)).getValue());
        if(Integer.valueOf(adultQty).equals(1)){
            $(By.xpath(Constants.XPATH_ADD_ADULTO)).click();
        }
        //input validacion valor adultos
        $(By.xpath(Constants.XPATH_CANTIDAD_ADULTOS)).shouldHave(value(String.valueOf(cantidadAdultos)));

        if(cantidadMenores > 0){
            //input validacion valor menores
            for(int i=0; i < cantidadMenores;i++){
                $(By.xpath(Constants.XPATH_ADD_MENORES)).click();
            }
            $(By.xpath(Constants.XPATH_CANTIDAD_MENORES)).shouldHave(value(String.valueOf(cantidadMenores)));
            //select edad menores
            $(By.xpath(Constants.XPATH_SELECCION_EDAD_MENORES)).click();
            $(By.xpath(Constants.XPATH_OPCION_EDAD_MENORES)).should(appear);
            $(By.xpath(Constants.XPATH_OPCION_EDAD_MENORES)).click();
        }

        //boton aplicar
        $(By.xpath(Constants.XPATH_BTN_APPLICAR)).click();
    }


    public void sendHotelSearch(){
        $(By.xpath(Constants.XPATH_BTN_BUSCAR_HOTEL)).click();
    }

}
