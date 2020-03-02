package org.selenide.examples;

import commons.Constants;
import commons.FlightsCommons;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchFlightWithParams extends FlightsCommons {

    final String TITLE_FLIGHT_SEARCH = "Despegar . Resultados de Vuelos";
    final int TIMEOUT = 3000;

    String origen;
    String destino;
    String fechaPartida;
    String fechaRegreso;

    public void initParams(String dataOrign, String dataDestino, String partida, String regerso){
        this.origen = dataOrign;
        this.destino = dataDestino;
        this.fechaPartida = partida;
        this.fechaRegreso = regerso;
    }

   /* @Before
    public void setUp() {

    }*/

    @Test
    public void searchFlightWithParams() throws ParseException {

        open(Constants.URL_DESPEGAR);
        getWebDriver().manage().window().maximize();

        //Tipo de busqueda
        $(By.xpath(Constants.XPATH_BTN_FLIGHT)).click();

        //Origen
        $(By.xpath(Constants.XPATH_ORIGEN)).waitUntil(appear, TIMEOUT).click();
        $(By.xpath(Constants.XPATH_ORIGEN)).setValue("").sendKeys(origen);
        $(By.xpath(Constants.XPATH_DIV_CIUDADES)).waitUntil(appear, TIMEOUT);
        selectItemFromLi(Constants.XPATH_LISTA_CIUDADES, origen);
        $(By.xpath(Constants.XPATH_ORIGEN)).shouldHave(value(origen));

        //Destino
        $(By.xpath(Constants.XPATH_DESTINO)).setValue("").sendKeys(destino);
        $(By.xpath(Constants.XPATH_DIV_CIUDADES)).waitUntil(appear, TIMEOUT);
        selectItemFromLi(Constants.XPATH_LISTA_CIUDADES, destino);
        $(By.xpath(Constants.XPATH_DESTINO)).shouldHave(value(destino));

        //Fechas
        $(By.xpath(Constants.XPATH_DIV_FECHA_IDA)).click();
        $(By.xpath(Constants.XPATH_DIV_DATE_PICKER_ORIGEN)).waitUntil(appear, TIMEOUT);

        //validar si pudo seleccionar y no supera el limite maximo de dias
        selectFlightDay(fechaPartida);
        selectFlightDay(fechaRegreso);

        //Click search btn
        $(By.xpath(Constants.XPATH_BTN_BUSCAR_VUELO)).click();

        //Validate Tests
        $("title").shouldHave(attribute("text", TITLE_FLIGHT_SEARCH));

    }

    @Override
    public String getMainDiv() {
        return Constants.XPATH_MAIN_DIV_FLIGHTS;
    }

}
