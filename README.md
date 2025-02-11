# Star Java Wars

Star Java Wars es un servicio basado en Spring Boot que proporciona una API para gestionar información sobre naves y personajes en un universo inspirado en Star Wars. Está diseñado para ser fácilmente extensible y probar con JUnit.

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Despliegue** para conocer como desplegar el proyecto.

### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

- **Java 21** o superior (JDK)
- **Maven**
- **MongoDB** para la base de datos
- **Lombok** para reducir la verbosidad del código
- **IDE** como **IntelliJ IDEA** o **Eclipse** para trabajar en el código

### Instalación 🔧

1. **Clona el repositorio** en tu máquina local:

    ```
    git clone https://github.com/tu-usuario/starjavawars.git
    ```

2. **Accede al directorio del proyecto**:

    ```
    cd starjavawars
    ```

3. **Construye el proyecto** usando Maven:

    - Con Maven:

        ```
        mvn clean install
        ```

4. **Ejecuta la aplicación** para iniciar el servidor:

    - Con Maven:

        ```
        mvn spring-boot:run
        ```
   La aplicación estará disponible en `http://localhost:8080`.

5. **Prueba la API**:

    Utiliza herramientas como **Postman** o **cURL** para interactuar con la API. Ejemplo de cómo hacer el post de scan:

    ```
    POST http://localhost:8080/radar
    ```

## Ejecutando las pruebas ⚙️

1. **Ejecutar las pruebas unitarias**:

    - Con Maven:

        ```
        mvn test
        ```

## Despliegue 📦

_Para hacer el despliegue de la aplicación en un entorno de producción, sigue los siguientes pasos:_

1. **Prepara la aplicación para producción**: Asegúrate de que todos los archivos de configuración (como `application.properties`) estén correctamente configurados para el entorno de producción, especialmente la conexión a la base de datos.

2. **Sube el archivo WAR o JAR a tu servidor**.

3. **Ejecuta la aplicación en el servidor**:

    ```
    java -jar starjavawars-1.0.0.jar
    ```

## Construido con 🛠️

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework para construir aplicaciones Java con facilidad
* [JUnit](https://junit.org/) - Framework para pruebas unitarias
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [MongoDB](https://www.mongodb.com/try/download/community) - Base de datos NoSQL utilizada para almacenar la información
* [Lombok](https://projectlombok.org/) - Librería utilizada para reducir la verbosidad del código y manejar de forma automática getter, setters, toString, entre otros

## Autores ✒️

* **Javier Herranz** - (https://github.com/JavierHerranz3)

