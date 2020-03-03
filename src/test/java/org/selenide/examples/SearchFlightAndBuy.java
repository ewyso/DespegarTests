package org.selenide.examples;

import com.codeborne.selenide.Selenide;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import commons.Constants;
import commons.FlightsCommons;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchFlightAndBuy extends FlightsCommons {

    final String TITLE_FLIGHT_SEARCH = "Despegar . Resultados de Vuelos";
    final int TIMEOUT = 3000;

    String origen;
    String destino;
    String fechaPartida;
    String fechaRegreso;

        public void initParams(String dataOrign, String dataDestino, String partida, String regerso) {
        /*this.origen = dataOrign;
        this.destino = dataDestino;
        this.fechaPartida = partida;
        this.fechaRegreso = regerso;*/
    }


    public void paramTest(){
        this.origen = "Pinamar";
        this.destino = "Santiago de Chile";
        this.fechaPartida = "10 Marzo 2020";
        this.fechaRegreso = "3 Junio 2020";
    }

    @Test
    public void searchFlightWithParams() throws ParseException {

        paramTest();

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

        //Wait until web loads
        $(By.xpath(Constants.XPATH_FLIGHT_PROGRESS_BAR)).waitUntil(disappear, 30000);

        selectMostExpensiveFlight();

        //Select payment method
        selectPaymentMethod();
        //validate CheckOutPage
        validateCheckOutPage();


    }

    private void selectPaymentMethod() {
        //select card
        $(By.xpath(Constants.XPATH_DIV_TARJETA_CREDITO)).click();
        $(By.xpath(Constants.XPATH_DIV_BANCOS_TARJETA)).should(appear);
        //this items could be parameterized but they aren't in the requirement :)
        $(By.xpath(Constants.XPATH_BANCO_SANTANDER)).click();
        $(By.xpath(Constants.XPATH_TARJETA_VISA)).click();
        $(By.xpath(Constants.XPATH_UNA_CUOTA)).click();
        //************************************************************************/
        $(By.xpath(Constants.XPATH_DIV_BANCOS_TARJETA)).should(disappear);
    }

    private void validateCheckOutPage() {
        //Passengers
        $(By.xpath(Constants.XPATH_DIV_PASAJEROS)).should(visible);
        //Payment method
        $(By.xpath(Constants.XPATH_DIV_METODO_PAGO)).should(visible);
        //Invoice
        $(By.xpath(Constants.XPATH_DIV_FACTURA)).should(visible);
        //Contact info
        $(By.xpath(Constants.XPATH_DIV_INFO_CONTACTO)).should(visible);
    }

    @Override
    public String getMainDiv() {
        return Constants.XPATH_MAIN_DIV_FLIGHTS;
    }


    public void selectMostExpensiveFlight(){
        $(By.xpath(Constants.XPATH_DIV_COMPARATIVA_PRECIOS)).waitUntil(visible, TIMEOUT);
        //Scrolls to bottom to load all the page
        $(By.xpath(Constants.XPATH_DIV_FOOTER)).scrollIntoView(true);
        //Waits until spinner dissapear
        $(By.xpath(Constants.XPATH_DIV_SPINNER)).should(disappear);
        List <WebElement> allFlightPrices = $(By.xpath(".//*")).findElements(By.xpath(Constants.XPATH_SPAN_PRECIO_FINAL));
        $(By.xpath(Constants.XPATH_DIV_OPCION_VUELO)).scrollIntoView(true);

        BigDecimal bestPrice = new BigDecimal(0);
        for(int i=0; i < allFlightPrices.size(); i++){
           // List <WebElement> test = $(By.xpath(".//*")).findElements(By.xpath("//div[@id='flights-container']//div[@class='ux-flights-results']//div[@class='col -lg-9 -md-12 -sm-12 results-content-container']//div[@class='main-content -show']//items//div[@class='cluster-container COMMON']//div[@class='cluster-pricebox-container CLUSTER']//div[@class='fare-detail-items']//item-fare[@classes='fare-price']//span[@class='price-wrapper']//span[@class='amount price-amount']"));
            WebElement flightPrice = allFlightPrices.get(i);
            BigDecimal currentPrice = new BigDecimal(flightPrice.getText());
            if(currentPrice.compareTo(bestPrice) > 0){
                bestPrice = currentPrice;
            }
        }
        System.out.println("Mejor Precio " + bestPrice);
        //Click most expensive flight
        $(By.xpath(Constants.XPATH_BOTON_COMPRA.replace("*bestPrice*", String.valueOf(bestPrice)))).scrollIntoView(true).click();
        $(By.xpath(Constants.XPATH_DIV_MODAL_LOADER)).should(disappear);
    }





}
