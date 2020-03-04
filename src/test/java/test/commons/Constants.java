package test.commons;

public class Constants {

    public static final String URL_DESPEGAR = "https://www.despegar.com.ar/";

    //Time
    public static final int cTIMEOUT = 5000;
    public static final int cHIGH_TIMEOUT = 30000;

    //Search Flight
    public static final String XPATH_ORIGEN = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-origin-container places-inline sbox-bind-error-flight-roundtrip-origin-empty']//div[@class='input-container']//input";
    public static final String XPATH_DESTINO = "//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-destination-container sbox-bind-error-flight-roundtrip-destination-empty sbox-bind-error-flight-roundtrip-equal-destination']//input";
    public static final String XPATH_DIV_FECHA_IDA = "//body[@product='flights']//div[@class='input-container sbox-bind-event-click-start-date']//input";
    public static final String XPATH_BTN_BUSCAR_VUELO = "//div[@class='sbox-button -ml3-l -mt5-l']//div[@class='sbox-button-container']";
    public static final String XPATH_DIV_DATE_PICKER_ORIGEN = ".//div[@class='datepicker-flights-main']//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']";
    public static final String XPATH_BTN_NEXT = ".//body//div[@class='datepicker-flights-main']//div[@class='_dpmg2--controls-next']";
    public static final String XPATH_DIV_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']";
    public static final String XPATH_CALENDAR_PICKER_FLIGHTS = "div[@class='datepicker-flights-main']//div[contains(@class, '_dpmg2--month _dpmg2--o-')]//div[@class='_dpmg2--month-title']";
    public static final String XPATH_BTN_FLIGHT = "//a[contains(@class,'shifu-3-button-circle FLIGHTS paint-circle')]";
    public static final String XPATH_LISTA_CIUDADES = "//body[@product='flights']//div[@class='ac-wrapper -desktop -show']//div[@class='ac-container']//div[@class='ac-group-container']//ul";
    public static final String XPATH_MAIN_DIV_FLIGHTS = "//div[@class='datepicker-flights-main']";
    public static final  String XPATH_FLIGHT_CALENDAR = "//div[@class='_dpmg2--months']//div[@data-month='2020-*monthNumber*']//div[@class='_dpmg2--dates']//span[contains(@class,'--available')]//span[@class='_dpmg2--date-number']";

    //Buy Flight
    public static final String XPATH_DIV_COMPARATIVA_PRECIOS = "//div[@class='results-cluster-container -skeleton -show']//div[@class='tabs-container']";
    public static final String XPATH_DIV_FOOTER = "//body//div[@class='eva-3-row footer-links-container -fluid -no-gutter']";
    public static final String XPATH_SPAN_PRECIO_FINAL = "//div[@id='flights-container']//div[@class='ux-flights-results']//div[@class='col -lg-9 -md-12 -sm-12 results-content-container']//div[@class='main-content -show']//items//div[@class='cluster-container COMMON']//div[@class='cluster-pricebox-container CLUSTER']//div[@class='fare-detail-items']//item-fare[@classes='fare-price']//span[@class='price-wrapper']//span[@class='amount price-amount']";
    public static final String XPATH_DIV_OPCION_VUELO = ".//body//div[@id='clusters']//div[@class='eva-3-cluster-basic -eva-3-shadow-line-hover']";
    public static final String XPATH_BOTON_COMPRA = "//div//span[@class='fare-wrapper -eva-3-p-md']//span[contains(text(), *bestPrice*)]/ancestor::*[@class='cluster-pricebox-container CLUSTER']//buy-button";

    //Hotel CheckOut
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
    public static final String XPATH_SPINER_LOADER = "//div[@id='pageLoader']//div[@class='loader-container']//div[@class='spinner-dot']";
    public static final String XPATH_FULL_SPINNER_LOADER = "//div[@id='fullLoader']//div[@class='hf-spinner-loader']";

    //Search Hotel
    public static final String XPATH_BTN_HOTELES = "//div[@class='header-products-container']//i[@class='shifu-icon-product shifu-3-icon-hotels']";
    public static final String XPATH_SEARCHBOX_HOTELES = "//div[@id='searchbox-sbox-box-hotels']";
    public static final String XPATH_INPUT_HOTELES = "//div[@class='home-ui-searchbox-container home-box-mb']//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox-places -mr3-l']//div[@class='sbox-input-container']//div[@class='input-container']//input";
            //"//input[@placeholder='Ingresá una ciudad, alojamiento o atracción']";
    //"//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-3-input sbox5-3-validation -top-right -lg -icon-left']//div[@class='input-container']//input[contains(@placeholder, 'ciudad')]";
    //"//div[@class='home-ui-searchbox-container home-box-mb']//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox-places -mr3-l']//div[@class='input-container']//input";
    public static final String XPATH_INPUT_PAIS_HOTELES = "//div[@class='sbox-places -mr3-l']//div[@class='input-container']//input";
    public static final String XPATH_LIST_PAISES_HOTELES = "//div[@class='ac-wrapper -desktop -facet -show']//div[@class='ac-container']//ul";
    public static final String XPATH_FECHA_VIAJE_HOTELES = "//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox-ui-container sbox-hotels-container']//div[@class='input-container sbox-checkin-date-container']";
    public static final String XPATH_DATEPICKER_HOTELES = "//div[@class='sbox-ui-datepicker-container']//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']";
    public static final String XPATH_CALENDAR_HOTELES = "//div[contains(@class,'_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show')]//div[contains(@class, '_dpmg2--month _dpmg2--o-')]//div[@class='_dpmg2--month-title']";
    public static final String XPATH_BTN_NEXT_HOTELES = "//div[@class='sbox-ui-datepicker-container']//div[@class='_dpmg2--controls-next']";
    public static final String XPATH_INPUT_HABITACION = "//div[@class='sbox-ui-container sbox-hotels-container']//div[@class='sbox-row sbox-distribution-picker-wrapper sbox-distribution-picker-wrapper']//div[@class='input-container']";
    public static final String XPATH_PANEL_SELECCION_HABITACION = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']";
    public static final String XPATH_CANTIDAD_ADULTOS = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//input";
    public static final String XPATH_ADD_ADULTO = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[@class='steppers-icon-right sbox-3-icon-plus']";
    public static final String XPATH_ADD_MENORES = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[@class='steppers-icon-right sbox-3-icon-plus']";
    public static final String XPATH_CANTIDAD_MENORES = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//input";
    public static final String XPATH_SELECCION_EDAD_MENORES = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='select-container']";
    public static final String XPATH_OPCION_EDAD_MENORES = "//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemBlock__itemRows']//div[@class='select-container']//option[@value='12']";
    public static final String XPATH_BTN_APPLICAR = "//div[@class='_pnlpk-panel__footer -medium-down-to-lg']//a[@class='_pnlpk-apply-button sbox-3-btn-ghost _pnlpk-panel__button--link-right -md']";
    public static final String XPATH_BTN_BUSCAR_HOTEL = "//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox-button-container']//a[@class='sbox-3-btn -primary -md sbox-search']";
    public static final String XPATH_LISTA_HOTELES = "//div[@id='hotels-view-container']//div[@id='list']";
    public static final String XPATH_FILTRO_CATEGORIA_HOTEL = "//div[@id='mainContainer']//ul[@class='hf-filters-recommended eva-3-dropdown']//ul[@class='hf-dropdown-subcontent-wrapper dropdown-subcontent']//span[@data-ga-el='stars-5']//label/i";
    public static final String XPATH_PRECIO_POR_NOCHE = "//span[@class='tooltip-container -eva-3-shadow-1']//hs-pricebreak[@class='hydrated']//div[@class='per-night']//span[contains(text(), '$')]";
    public static final String XPATH_BTN_DETALLES_HOTEL = "//div[@class='per-night']//span[contains(text(), '*lowerPrice*')]/ancestor::*[@class='hf-prices-container col -sm-12']//em[@class='btn-text']";
    public static final String XPATH_LISTA_HABITACIONES = "//div[@class='eva-3-container hf-rooms-container']//div[@id='hf-rooms-new']";
    public static final String XPATH_CALENDAR_DIA_HOTEL = "//div[contains(@class,'_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show')]//div[@class='_dpmg2--months']//div[@data-month='2020-*monthNumber*']//div[@class='_dpmg2--dates']//span[contains(@class,'--available')]//span[@class='_dpmg2--date-number']";

}
