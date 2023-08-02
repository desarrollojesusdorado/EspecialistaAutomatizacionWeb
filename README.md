# Pruebas WEB reto especialista automatizacion 

## Descripcion reto WEB:

Este reto consistirá en automatizar la página de Falabella, en donde debemos escoger 3 productos al azar cada uno de ellos con una cantidad aleatoria. Las validaciones están descritas al final del reto en el carrito.
En la siguiente página describiremos el proceso paso a paso de este pequeño flujo. 

Paso a paso:
-	Ingresar a la url https://www.falabella.com.co/falabella-co 
-	Dar click en No en el popup de Subscribirse
-	Dar clic en Menu
-	Escoger una categoría de tecnología y subcategoría portátil.
Nota: Las categorías son la primera columna de la izquierda, las subcategorías son los diferentes grupos de esa categoría ejemplo:  Categoría Tecnología, subcategorías Computación, TV y video, Smartwatch y accesorios, Fotografía, etc.
-	Seleccionar un elemento que sea portátil al azar (Por favor no quemar el nombre de un dispositivo). Debe ser portátil para que salga la opción de garantía.
-	Seleccionar una cantidad al azar, por favor tenga en cuenta el máximo de unidades que se ve en el artículo. Y dar clic en Agregar al carrito.
-	Seleccionar cualquier garantía (No seleccionar sin garantía extendida) y dar clic en seguir comprando.
-	Seleccione otra categoría y otra subcategoría al azar.
-	Adicione otro producto de la misma forma que se acabó de agregar el primer producto (cantidad aleatoria).
-	En el carrito de compras validar:
1.	La cantidad de objetos (Tener en cuenta que cada garantía cuenta como un ítem en el carrito).
2.	El valor Total de todos los productos agregados.
3.	Los artículos seleccionados deben aparecer aquí con sus respectivos precios.

### Tabla de contenido

* [Pre-requisitos](#pre-requisitos)
* [Instalación](#instalación)
* [Arquitectura del proyecto](#arquitectura-del-proyecto)
* [Ejecutando las pruebas](#ejecutando-las-pruebas)
* [Buenas Practicas](#buenas-practicas)
* [Construido con️](#construido-con)
* [Versionado](#versionado)
* [Autores](#autores)


## Pre-requisitos

Antes de realizar la descarga o cloncacion del proyecto es importante:

```
- Tener instalado un IDE ya sea Eclipse o Intellij.
- Tener instalado en los pluging para el IDE Cucumber para java, Gherkin.
- Tener instalado en el equipo el JDK de java.
- Preferible tener intalado en el equipo Gradle con su respectiva variable de entorno.
```

## Instalación

Para realizar la clonación del proyecto es importante considerar los siguientes pasos:

```
- Crear una carpeta donde quieras almacenar el proyecto.
- Abrir la consola Git Bash y ejecutar el siguiente comando: "https://github.com/desarrollojesusdorado/EspecialistaAutomatizacionWeb.git"
- Abrir el IDE ya sea Intellij ó Eclipse y realizar la importación del proyecto.
```
## Arquitectura del proyecto

La arquitectura principal del proyecto es con el framework screenplay y consta de las siguientes capas:

`![texto cualquiera por si no carga la imagen](https://miro.medium.com/max/2400/1*FKa85Y68iyd-mYSY4bYsPA.png)`

### Capas Principales

**Features:** En esta capa se escriben los archivos .feature, estos describen las características y escenarios a probar haciendo uso del lenguaje Gherkin.

**Runners:** Contiene los archivos runner encargados de ejecutar los escenarios de la feature. Se usan las anotaciones @RunWhit() @CucumberOptions() para especificar qué ejecutar y cómo hacerlo.

**Step Definitions:** Gestiona los code snippets de los steps definidos con las palabras Given, When, Then en los escenarios de los archivos .feature

**Tasks:** Esta clase contiene las clases que son el corazón del patrón de screenplay=Las tareas. Las tareas son acciones de alto nivel que definen un conjunto de interacciones en el lenguaje de negocio.

**Interactions:** Se encargan de las interacciones con la interfaz de usuario.Muchas interacciones ya fueron desarrolladas y se encuentran disponibles gracias a las librerías de screenplay y de serenity BDD. Ejemplo: Open, Click, Enter, Hit, SelectFromOptions.

**Questions:** Esta capa gestiona los Asserts o verificaciones de las pruebas las cuales son el fin ultimo de las mismas, ya que con estas capturamos la información de la interfaz que puede ser usada. Text,Value, Visibility.


### Capas Transversales

**Utils:** Contiene clases con los métodos unitarios que pueden ser utilizados libremente por otras clases del proyecto como: Conversores, Waits, verificadores.

**Exceptions:** Esta es una capa muy importante que tiene como objetivo dar manejo a los errores que pueden presentarse en la aplicación. Es una capa sensible al negocio y particular a cada proyecto.

## Ejecutando las pruebas

Para la ejecucion de los test automatizados es necesario identificar lo siguiente:

- Buscar en la ruta src/test/resources/features el .feature que deseemos ejecutar e identificar el runners asociado donde se encuetra configurado el .feature para su ejecución.

Para la ejecución de los runners podemos utilizar el siguiente comando:

```
gradle clean test --tests *AgregarProductosFalabellaRunner* aggregate --info
```

### Reporte de serenity:

Despues de ejecutado el comando anterior desde la consola ubicar el archivo index.html en la ruta target\site\serenity y abrirlo con el navegador de tu preferencia para mirar el detalle del test ejecutado.

### **Nota:**

Tambien puedes realizar la ejecución del runners desde el IDE ya sea Intellij o Eclipse, pero no vas a tener un reporte de serenity completo, por eso te recomiendo ejecutarlo desde la consola ya sea del IDE o del CMD para tener un reporte mas completo y donde puedas encontrar el index.html.

## Buenas Practicas

Al momento de codificar para el nombramiento de clases, metodos, variables y constantes se recomienda:

**Clases:**

Para el nombramiento de las clases se debera seguir la convención CamelCase por ejemplo:

```
public class VerificarTarifas {
}
```

**Metodos:**

Los métodos deben ser verbos, en mayúsculas y minúsculas, con la primera letra de cada palabra interna (a partir de la segunda) en mayúscula:

```
   public void queJesusIngresaALaPaginaDeDxHotels() {
}
```
**Variables:**

Los nombres de las variables deben ser cortos pero significativos.

- No debería comenzar con un guión bajo (‘_’) o caracteres, como por ejemplo, un signo de dólar ‘$’.
- Debe ser mnemotécnico, es decir, diseñado para indicar al observador casual la intención de su uso.
- Se deben evitar los nombres de variable de un carácter, excepto para variables temporales.
- Los nombres comunes para las variables temporales son: i, j, k, m y n para enteros; c, d y e para los caracteres.

```
    private String fechaIngreso;
    private String fechaSalida;
    private String numHabitaciones;
```
**Variables constantes en java:**

Debería estar todo en mayúsculas con palabras separadas por guiones bajos (“_”).

```
public static final String URL_PAGINA  = "https://js.devexpress.com/Demos/DXHotels/#home";
```

## Construido con

_Las tecnologias o herramientas usadas para la construccion del proyecto son:_

* [Screenplay](https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html) - El framework usado.
* [Gradle](https://docs.gradle.org/current/userguide/userguide.html) - Manejador de dependencias.
* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/getting-started.html) - Usado para generación de reportes para ver informes y detalle de las pruebas.
* [Gherkin](https://cucumber.io/docs/gherkin/reference/) - Redaccion de pasos para la ejecucion de nuestras pruebas.
* [Cucumber](https://cucumber.io/docs/installation/java/) - Metodos construidos en java que vincula a uno o mas pasos de Gherkin.
* [Junit](https://cucumber.io/docs/cucumber/api/#running-cucumber) - Usamos Junit para ejecutar nuestros escenarios en gherkin.
* [Git](https://git-scm.com/docs/gittutorial) - Esta es nuestra herramienta de versionamiento para el codigo generado.
* [Serenity Rest Assured](https://serenity-bdd.github.io/theserenitybook/latest/serenity-rest.html) - Esta es nuestra herramienta para la automatización de nuestros servicios.

## Versionado

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/tu/proyecto/tags).

## Autores

_En construcción_
