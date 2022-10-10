# Test Automation WebServices Challenge

## Requerimientos:
- Tomando como referencia lo
documentado en este swagger:
https://petstore.swagger.io/ 
- Agregar una mascota realizando un
POST al path /v2/pet.
- Realizar un GET /v2/pet/{petId} para
obtener una mascota existente.
- Modificar una mascota existente
mediante PUT al path /v2/pet.
- En todos los casos validar:
Status code esperado.
Schema del response.

## Escenarios en el Feature:
- Create a Pet
- Get a Pet
- Update a Pet

## Datos Técnicos:
- Java 11
- RestAssured
- TestNg
- Cucumber
- Allure (Report)

## Ejecución por Terminal:
- Test: mvn clean test / mvn test
- Reporte: mvn allure:serve (Opcional)

## Estructura:
1. Main: 

    1.1 com.challenge.config 

    1.1.1 ConfigPage: 
    - Contiene los parámetros iniciales de configuración. 

    1.2 LoggerPage:
    - Manejo de Logger (Log4j) para registrar el proceso.

    1.3 PropertiesPage:
    - Manejo de las propiedades de ejecución como Url, Id (random por ejecución), bodys.

    1.2 com.challenge.process

    //Los procesos son manejados por separados pero en ejecución son dependientes

    1.2.1 CreatePetProcess: 
    - Métodos para la creación de la Pet vía POST
    
    1.2.2 GetPetProcess: 
    - Métodos para la obtención de la Pet vía GET
    
    1.2.3 UpdatePetProcess: 
    - Métodos para la modificación de la Pet vía PUT
    
2. Test:

    2.1 com.challenge.defs

    //Pasos en la ejecución del proceso. Asociados a los Scenarios del Feature

    2.1.1 CreatePetTest: métodos para la ejecución del Create Pet
    
    2.1.2 GetPetTest: métodos para la ejecución del Get Pet
    
    2.1.3 UpdateTest: métodos para la ejecución del Update Pet
    
    2.2. RunCucumberTest.java
    Definición del ejecutable (Cucumber + TestNg)

## Escenarios
* src/test/resources/scenarios.feature contiene los Escenarios del Feature en Gherkin.
Estan ordenados debido a la dependencia de los pasos previos para su ejecución,
para evitar empezar un nuevo proceso en los casos que se requiere una Pet previamente
registrada (Id). Para este test, cada ejecución propone un Id nuevo. A pesar de esta
dependencia, los test se ejecutan por separado en cada feature, preservando en memoria
el Id utilizados durante la creación de la Pet.

## Reportes:
Se pueden obtener reportes de dos maneras:
1. Allure: mvn allure:serve una vez terminada la ejecución del test. Este reporte
muestra cada escenario ejecutado e incluye los logs del Request y Response de cada proceso.
2. Cucumber Report: reporte por defecto, es posible encontrarlo en la carpeta Target del proyecto.
No incluye Logs.

## Logs:
Están configurados para registrar los procesos de la ejecución. Se registran en dos archivos,
automation.log y automation.error según el status de los que se ha registrado. Se almacenan por día
en un archivo comprimido a fin de almacenar los registros.
