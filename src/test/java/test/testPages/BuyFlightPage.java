package test.testPages;

import test.commons.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BuyFlightPage {

    public void selectMostExpensiveFlight(){
        $(By.xpath(Constants.XPATH_DIV_COMPARATIVA_PRECIOS)).waitUntil(visible, Constants.cTIMEOUT);
        //Scrolls to bottom to load all the page
        $(By.xpath(Constants.XPATH_DIV_FOOTER)).scrollIntoView(true);
        //Waits until spinner dissapear
        $(By.xpath(Constants.XPATH_DIV_SPINNER)).should(disappear);
        List<WebElement> allFlightPrices = $(By.xpath(".//*")).findElements(By.xpath(Constants.XPATH_SPAN_PRECIO_FINAL));
        $(By.xpath(Constants.XPATH_DIV_OPCION_VUELO)).scrollIntoView(true);

        BigDecimal bestPrice = new BigDecimal(0);
        for(int i=0; i < allFlightPrices.size(); i++){
            WebElement flightPrice = allFlightPrices.get(i);
            BigDecimal currentPrice = new BigDecimal(flightPrice.getText());
            if(currentPrice.compareTo(bestPrice) > 0){
                bestPrice = currentPrice;
            }
        }

        //Click most expensive flight
        $(By.xpath(Constants.XPATH_BOTON_COMPRA.replace("*bestPrice*", String.valueOf(bestPrice)))).scrollIntoView(true).click();
        $(By.xpath(Constants.XPATH_DIV_MODAL_LOADER)).waitUntil(disappear, Constants.cHIGH_TIMEOUT);
    }

    public void selectPaymentMethod() {
        //select card
        $(By.xpath(Constants.XPATH_DIV_TARJETA_CREDITO)).should(appear);
        $(By.xpath(Constants.XPATH_DIV_TARJETA_CREDITO)).click();
        $(By.xpath(Constants.XPATH_DIV_BANCOS_TARJETA)).should(appear);
        //this items could be parameterized but they aren't in the requirement :)
        $(By.xpath(Constants.XPATH_BANCO_SANTANDER)).click();
        $(By.xpath(Constants.XPATH_TARJETA_VISA)).click();
        $(By.xpath(Constants.XPATH_UNA_CUOTA)).click();
        //************************************************************************/
        $(By.xpath(Constants.XPATH_DIV_BANCOS_TARJETA)).should(disappear);
    }

    public void validateCheckOutPage() {
        //Passengers
        $(By.xpath(Constants.XPATH_DIV_PASAJEROS)).should(visible);
        //Payment method
        $(By.xpath(Constants.XPATH_DIV_METODO_PAGO)).should(visible);
        //Invoice
        $(By.xpath(Constants.XPATH_DIV_FACTURA)).should(visible);
        //Contact info
        $(By.xpath(Constants.XPATH_DIV_INFO_CONTACTO)).should(visible);
    }

}
