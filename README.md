# AUTO_FRONT_POM_FACTORY

Proyecto de automatización E2E de interfaz para SistemaTickets, implementado con el patrón POM (Page Object Model) + Page Factory y Serenity BDD.

Aplicación base automatizada: https://github.com/AlexRieger47/SistemaTickets

## Stack Tecnológico

- Java 17
- Gradle Wrapper 9.4.0
- Serenity BDD 4.2.1
- Cucumber (vía serenity-cucumber)
- JUnit Platform
- Selenium WebDriver (vía Serenity)
- AssertJ
- Patrón: POM + Page Factory (@FindBy)

## Estructura del Proyecto

~~~text
src/test/
├── java/
│   ├── pages/
│   │   ├── login/LoginPage.java
│   │   ├── tickets/CreateTicketPage.java
│   │   ├── tickets/TicketListPage.java
│   │   └── components/NavBarComponent.java
│   ├── stepdefinitions/
│   │   ├── LoginSteps.java
│   │   └── CreateTicketSteps.java
│   ├── runner/CucumberTestSuite.java
│   └── utils/TestData.java
└── resources/
    ├── features/frontend/login_create_ticket.feature
    └── junit-platform.properties
~~~

## Flujo de Prueba Automatizado

1. Abrir la página de login de SistemaTickets.
2. Iniciar sesión con credenciales válidas de prueba.
3. Verificar que se visualiza la lista de tickets.
4. Navegar al formulario de creación de ticket.
5. Completar título y descripción.
6. Enviar el ticket.
7. Verificar que el ticket creado aparece en la lista.

## Prerrequisitos

Antes de ejecutar las pruebas, asegúrate de cumplir lo siguiente:

- Java 17 instalado y configurado. Si usas VS Code, define también `JAVA17_HOME` apuntando al JDK 17.
- Google Chrome instalado.
- SistemaTickets clonado y ejecutándose localmente con Docker Compose.

~~~bash
git clone https://github.com/AlexRieger47/SistemaTickets.git
cd SistemaTickets
docker-compose build
docker-compose up
~~~

- Frontend disponible en: http://localhost:5173
- Servicios backend:
	- users-service en el puerto 8003
	- ticket-service en el puerto 8000
- Debe existir un usuario de prueba registrado manualmente antes de ejecutar los tests (precondición única):
	1. Abrir http://localhost:5173/register
	2. Crear un usuario con las credenciales definidas en src/test/java/utils/TestData.java (por defecto: sofkiano@sofka.com / 12345678)
	3. Esta configuración se realiza una sola vez

## Comandos de Ejecución

Ejecución de pruebas en modo headed (por defecto, recomendado para demo):

~~~bash
./gradlew clean test
# Windows
./gradlew.bat clean test
~~~

Ejecución de pruebas en modo headless (recomendado para CI/desarrollo):

~~~bash
./gradlew clean test -DHEADLESS_MODE=true
# Windows
./gradlew.bat clean test -DHEADLESS_MODE=true
~~~

Generación del reporte de Serenity después de las pruebas:

~~~bash
./gradlew aggregate
# Windows
./gradlew.bat aggregate
~~~

Ubicación del reporte:

~~~text
target/site/serenity/index.html
~~~

## Configuración

- Las credenciales de prueba se pueden modificar en src/test/java/utils/TestData.java
- El navegador y la URL base se configuran en serenity.conf
- La configuración de reportes Serenity está en build.gradle
- El proyecto está configurado para ejecutarse con Java 17 y con el wrapper real incluido en el repositorio.

## VS Code y Java 17

Si VS Code intenta importar el proyecto con Java 25, el problema no es el código sino el JDK con el que el IDE arranca Gradle.

1. Instala o verifica un JDK 17.
2. Define la variable de entorno `JAVA17_HOME` con la ruta del JDK 17.
3. Reinicia VS Code.
4. Ejecuta el comando `Java: Clean Java Language Server Workspace`.
5. Ejecuta el comando `Java: Import Java Projects in Workspace`.

Ejemplo de ruta en Windows:

~~~powershell
$env:JAVA17_HOME = 'C:\Program Files\Java\jdk-17'
~~~

Si quieres dejarlo persistente en Windows, configúralo en las variables de entorno del sistema o del usuario.

## Referencia de la Aplicación Base

> Este proyecto automatiza la UI de [SistemaTickets](https://github.com/AlexRieger47/SistemaTickets), un sistema de gestión de tickets desarrollado como parte del programa AI-Native-Entry de Sofka. La aplicación debe estar en ejecución local antes de correr estas pruebas.

## Autor

Alexander David Molina Rieger
