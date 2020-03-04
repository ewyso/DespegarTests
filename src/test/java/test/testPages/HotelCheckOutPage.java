package test.testPages;

import test.commons.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class HotelCheckOutPage {

    public void filterHotels() {
        //checkbox 5 estrellas
        $(By.xpath(Constants.XPATH_FILTRO_CATEGORIA_HOTEL)).waitUntil(appear, Constants.cTIMEOUT);
        $(By.xpath(Constants.XPATH_FILTRO_CATEGORIA_HOTEL)).scrollIntoView(true);
        $(By.xpath(Constants.XPATH_FILTRO_CATEGORIA_HOTEL)).click();
        $(By.xpath(Constants.XPATH_FULL_SPINNER_LOADER)).waitUntil(disappear, Constants.cTIMEOUT);
    }

    public void validateHotelPage() {
        $(By.xpath(Constants.XPATH_SPINER_LOADER)).waitUntil(disappear, Constants.cTIMEOUT);
        //lista hoteles
        $(By.xpath(Constants.XPATH_LISTA_HOTELES)).waitUntil(appears, Constants.cTIMEOUT);
    }

    public void selectCheapestHotel() {
        List<WebElement> hotelPrices = $(By.xpath(".//*")).findElements(By.xpath(Constants.XPATH_PRECIO_POR_NOCHE));

        BigDecimal lowerPrice = null;
        for(int i = 0; i < hotelPrices.size(); i++){
            String test = hotelPrices.get(i).getAttribute("textContent").replace("$","").trim();
            BigDecimal htlPrice =  new BigDecimal(test);

            if(lowerPrice == null){
                lowerPrice = htlPrice;
            } else {
                lowerPrice = lowerPrice.min(htlPrice);
            }

        }
        //Click detail btn
        $(By.xpath(Constants.XPATH_BTN_DETALLES_HOTEL.replace("*lowerPrice*", String.valueOf(lowerPrice)))).click();
        //switch to window and waits
        switchTo().window(1);
    }

    public void validateRooms(){
        $(By.xpath(Constants.XPATH_LISTA_HABITACIONES)).should(visible);
        $(By.xpath(Constants.XPATH_LISTA_HABITACIONES)).scrollIntoView(true);
    }

}
