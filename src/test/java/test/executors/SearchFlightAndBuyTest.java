package test.executors;

import test.commons.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.testPages.BuyFlightPage;
import test.testPages.SearchFlightPage;

import java.text.ParseException;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchFlightAndBuyTest {
    SearchFlightPage testSearchBuy;
    BuyFlightPage buyFlightPage;

    @Before
    public void init() {
        testSearchBuy = new SearchFlightPage();
        buyFlightPage = new BuyFlightPage();
        open(Constants.URL_DESPEGAR);
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().manage().window().maximize();
    }

    @After
    public void validate(){
        buyFlightPage.validateCheckOutPage();
        getWebDriver().close();
    }

    @Test
    public void searchFlightAndBuyTest(){

        try{
            testSearchBuy.selectFlightOption();
            testSearchBuy.selectOrigin("Mar del Plata");
            testSearchBuy.selectDestino("Bariloche");
            testSearchBuy.selectDates(LocalDate.of(2020,03,25),LocalDate.of(2020,04,03) );
            testSearchBuy.searchFlightBtn();
            testSearchBuy.validateTittle();
            buyFlightPage.selectMostExpensiveFlight();
            buyFlightPage.selectPaymentMethod();

        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
