# DespegarTests
Challenge despegar

Tecnologias utilizadas
- Java 8
- Selenide (lib Selenium)
- Maven

El challenge se realizo utilizando como base Java 8 y la libreria Selenide debido a los beneficios que presenta para manejar peticiones ajax.

Dentro del codigo se pueden encontrar las siguientes soluciones para ejecutar los tests:
- SearchFlightWithParamsTest --> Test Case 1:
Realizar una búsqueda de un vuelo en donde se le pueda pasar por parámetros
los datos de origen, destino, fecha de partida y fecha de regreso. Validar que al
completar el formulario y buscar el vuelo se obtiene como resultado una nueva
página con diferentes opciones de vuelo.

- SearchFlightAndBuyTest --> Test Case 2:
Realizar una búsqueda similar a la primer prueba y dentro de la lista de vuelos
seleccionar el vuelo que tenga el precio más alto de la primer pestaña de
resultados (no ordenar la lista de resultados). Verificar que al seleccionar la
opción "Comprar" se redirecciona a una nueva página. Validar que en la nueva
página esté visible los sectores pasajeros, forma de pago, datos para la emisión
de la factura e información de contacto.

- SearchHotelPageTest --> Test Case 3:
Realizar una búsqueda de un hotel en Montevideo (Uruguay) en donde se tome
como fecha de ingreso al hotel la fecha del Sistema +10 días y que la estadía
sea de 3 noches, reservando una habitación para 2 adultos y un menor de 12
años de edad. Verificar que se obtenga como resultado una nueva página en
donde se visualiza una lista de hoteles disponibles.
  ○ En la nueva página seleccionar los hoteles de 5 estrellas y dentro de la
    nueva lista obtenida seleccionar el hotel que tenga el menor valor por
    noche y ver el detalle del mismo. Validar que se obtenga una nueva
    pestaña y que en la misma esté presente el sector de habitaciones
    disponibles.
    
La funcionalidad especifica de cada test case se encuentra sobre dentro del paquete test.testPages con el nombre de la pagina base segun corresponda

Todas las validaciones que están pedidas en los test cases están hechas con la libreria selenide, por lo cual los asserts de validacion son los siguientes:
- shouldHave(value/attribute(valorEsperado))
- waitUntil(visible/appear/dissapear)
- should(visible/appear/dissapear)

Documentacion selenide: https://selenide.org/documentation/selenide-vs-selenium.html



En caso de no compilar el proyecto instalar dependencias con mvn ejecutando mvn clean install desde la consola de comandos

Evidencia ejecucion sobre driver de Google Chrome
![Evidencia ejecucion](https://i.imgur.com/xdx4a48.png)
