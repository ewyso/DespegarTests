package test.executors;

import test.commons.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.testPages.HotelCheckOutPage;
import test.testPages.SearchHotelPage;

import java.text.ParseException;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchHotelPageTest {

    SearchHotelPage searchHotel;
    HotelCheckOutPage htlCheckOut;

    @Before
    public void init() {
        searchHotel = new SearchHotelPage();
        htlCheckOut = new HotelCheckOutPage();
        open(Constants.URL_DESPEGAR);
        getWebDriver().manage().window().maximize();
    }

    @After
    public void validate(){
        htlCheckOut.validateRooms();
        getWebDriver().close();
    }

    @Test
    public void searchHotel(){

        LocalDate fechaSalida = LocalDate.now().plusDays(10);
        LocalDate fechaRegreso = fechaSalida.plusDays(3);

        try {
            searchHotel.searchForHotel("Montevideo, Uruguay");
            searchHotel.selectDates(fechaSalida, fechaRegreso);
            searchHotel.selectRoom(2,1);
            searchHotel.sendHotelSearch();
            htlCheckOut.validateHotelPage();
            htlCheckOut.filterHotels();
            htlCheckOut.selectCheapestHotel();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
