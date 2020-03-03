package commons;

public class Constants {

    public static final String URL_DESPEGAR = "https://www.despegar.com.ar/";

    //Flight select
    public static final String XPATH_ORIGEN = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-origin-container places-inline sbox-bind-error-flight-roundtrip-origin-empty']//div[@class='input-container']//input";
    public static final String XPATH_DESTINO = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-destination-container sbox-bind-error-flight-roundtrip-destination-empty sbox-bind-error-flight-roundtrip-equal-destination']//input";
    public static final String XPATH_DIV_FECHA_IDA = "//body[@product='flights']//div[@class='input-container sbox-bind-event-click-start-date']//input";
    public static final String XPATH_BTN_BUSCAR_VUELO = "//div[@class='sbox-button -ml3-l -mt5-l']//div[@class='sbox-button-container']";
    public static final String XPATH_DIV_DATE_PICKER_ORIGEN = ".//div[@class='datepicker-flights-main']//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']";
    public static final String XPATH_BTN_NEXT = ".//body//div[@class='datepicker-flights-main']//div[@class='_dpmg2--controls-next']";
    public static final String XPATH_DIV_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']";
    public static final String XPATH_CALENDAR_PICKER = "div[@class='datepicker-flights-main']//div[contains(@class, '_dpmg2--month _dpmg2--o-')]//div[@class='_dpmg2--month-title']";

    public static final String XPATH_BTN_FLIGHT = "//a[contains(@class,'shifu-3-button-circle FLIGHTS paint-circle')]";
    public static final String XPATH_LISTA_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']//ul";
    public static final String XPATH_MAIN_DIV_FLIGHTS = "//div[@class='datepicker-flights-main']";

    //Flight selection
    public static final String XPATH_DIV_COMPARATIVA_PRECIOS = "//div[@class='results-cluster-container -skeleton -show']//div[@class='tabs-container']";
    public static final String XPATH_DIV_FOOTER = "//body//div[@class='eva-3-row footer-links-container -fluid -no-gutter']";
    public static final String XPATH_SPAN_PRECIO_FINAL = "//div[@id='flights-container']//div[@class='ux-flights-results']//div[@class='col -lg-9 -md-12 -sm-12 results-content-container']//div[@class='main-content -show']//items//div[@class='cluster-container COMMON']//div[@class='cluster-pricebox-container CLUSTER']//div[@class='fare-detail-items']//item-fare[@classes='fare-price']//span[@class='price-wrapper']//span[@class='amount price-amount']";
    public static final String XPATH_DIV_OPCION_VUELO = ".//body//div[@id='clusters']//div[@class='eva-3-cluster-basic -eva-3-shadow-line-hover']";
    public static final String XPATH_BOTON_COMPRA = "//div//span[@class='fare-wrapper -eva-3-p-md']//span[contains(text(), *bestPrice*)]/ancestor::*[@class='cluster-pricebox-container CLUSTER']//buy-button";

    //CheckOut
    public static final String XPATH_DIV_PASAJEROS = "//div[@class='eva-3-card -eva-3-shadow-line travelers frame']";
    public static final String XPATH_DIV_METODO_PAGO = "//div[@class='eva-3-card -eva-3-shadow-line frame payment-method with-legal-conditions']";
    public static final String XPATH_DIV_FACTURA = "//div[@class='eva-3-card -eva-3-shadow-line invoice-container frame']//div[@class='invoice-component']";
    public static final String XPATH_DIV_INFO_CONTACTO = "//div[@class='eva-3-card -eva-3-shadow-line frame contact-info ng-touched ng-pristine ng-invalid']";
    public static final String XPATH_DIV_TARJETA_CREDITO = "//div[@class='card-slot']//div[@class='header -eva-3-p-md']";
    public static final String XPATH_DIV_BANCOS_TARJETA = "//div[@class='payment-option-selector-wrap']";
    public static final String XPATH_BANCO_SANTANDER = "//h5[contains(text(),'Santander')]";
    public static final String XPATH_TARJETA_VISA = "//h5[contains(text(),'Visa')]";
    public static final String XPATH_UNA_CUOTA = "//span[contains(text(),'1 pago')]";

    //Progress
    public static final String XPATH_FLIGHT_PROGRESS_BAR = "//div[@class='header-container']//div[@class='progress-bar-background']//div[@class='progress-bar-content']";
    public static final String XPATH_DIV_SPINNER = "//div[@class='loader-container']//div[@class='loader-spinner']";
    public static final String XPATH_DIV_MODAL_LOADER = "div[@class='loader-modal-content']";
}
