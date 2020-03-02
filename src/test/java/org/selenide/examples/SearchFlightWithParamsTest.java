package org.selenide.examples;

import commons.Constants;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;

public class SearchFlightWithParamsTest {

    @Test
    public void searchFlightTest(){

        SearchFlightWithParams test = new SearchFlightWithParams();
        try {
            test.initParams("Pinamar", "Santiago de Chile", "10 Marzo 2020", "3 Junio 2020");
            test.searchFlightWithParams();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
