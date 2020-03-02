package commons;

public class Constants {

    public static final String URL_DESPEGAR = "https://www.despegar.com.ar/";

    public static final String XPATH_ORIGEN = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-origin-container places-inline sbox-bind-error-flight-roundtrip-origin-empty']//div[@class='input-container']//input";
    public static final String XPATH_DESTINO = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-destination-container sbox-bind-error-flight-roundtrip-destination-empty sbox-bind-error-flight-roundtrip-equal-destination']//input";
    public static final String XPATH_DIV_FECHA_IDA = "//body[@product='flights']//div[@class='input-container sbox-bind-event-click-start-date']//input";
    public static final String XPATH_DIV_FECHA_VUELTA = ".//input[@class='input-tag sbox-checkout-date']";
    public static final String XPATH_BTN_BUSCAR_VUELO = "//div[@class='sbox-button -ml3-l -mt5-l']//div[@class='sbox-button-container']";
    public static final String XPATH_DIV_DATE_PICKER_ORIGEN = ".//div[@class='datepicker-flights-main']//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']";
    public static final String xPath_DivDatePicker_Destino = ".//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement]";
    public static final String XPATH_BTN_NEXT = ".//body//div[@class='datepicker-flights-main']//div[@class='_dpmg2--controls-next']";
    public static final String XPATH_DIV_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']";
    public static final String XPATH_CALENDAR_PICKER = "div[@class='datepicker-flights-main']//div[contains(@class, '_dpmg2--month _dpmg2--o-')]//div[@class='_dpmg2--month-title']";

    public static final String XPATH_BTN_FLIGHT = "//a[contains(@class,'shifu-3-button-circle FLIGHTS paint-circle')]";
    public static final String XPATH_LISTA_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']//ul";

    public final String nextMont = ".//div[@class='_dpmg2--controls-next']";
    public final String prevMont = ".//div[@class='_dpmg2--controls-prev']";

    public static final String XPATH_MAIN_DIV_FLIGHTS = "//div[@class='datepicker-flights-main']";

    public static final String XPATH_FLIGHT_PRICES_OPPORTUNITY = "//div[@class='main-content -show']//div[@id='clusters']//div[@class='eva-3-cluster-basic -eva-3-shadow-line-hover']";
    public static final String XPATH_FLIGHT_FINAL_PRICE = "//body[contains(@class,'show-phone')]/div[@id='flights-container-wrapper']//div[@class='main-content -show']//div[@id='clusters']//div[@class='eva-3-cluster-basic -eva-3-shadow-line-hover']//p[@class='item-fare fare-price']//span[@class='amount price-amount']";
            //"//div[@class='main-content -show']//div[@id='clusters']//div[@class='eva-3-cluster-basic -eva-3-shadow-line-hover']//p[@class='item-fare fare-price']//span[@class='amount price-amount']";

    public static final String XPATH_FLIGHT_PROGRESS_BAR = "//div[@class='header-container']//div[@class='progress-bar-background']//div[@class='progress-bar-content']";
}
