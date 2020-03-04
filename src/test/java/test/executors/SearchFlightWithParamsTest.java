package test.executors;

import test.commons.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.testPages.SearchFlightPage;

import java.text.ParseException;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchFlightWithParamsTest {

    SearchFlightPage testSearch;

    @Before
    public void init() {
        testSearch = new SearchFlightPage();
        open(Constants.URL_DESPEGAR);
        getWebDriver().manage().window().maximize();
    }

    @After
    public void validate(){
        testSearch.validateTittle();
        getWebDriver().close();
    }

    @Test
    public void searchFlightTest(){

        try{
            testSearch.selectFlightOption();
            testSearch.selectOrigin("Pinamar");
            testSearch.selectDestino("Santiago de Chile");
            testSearch.selectDates(LocalDate.of(2020,03,25),LocalDate.of(2020,04,03) );
            testSearch.searchFlightBtn();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
