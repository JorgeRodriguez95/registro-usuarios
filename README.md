# Registro de Usuarios

_Pequeño ejercicio realizado con Spring Boot donde se disponibiliza una api rest que permite el registro de usuarios más unas cuantas validaciones. Se persiste la data por medio de h2 y se hace uso de jpa. Se genera un JWT que tiene una duración de 5 minutos configurable._

## Comenzando 🚀

_La forma más simple es utilizar algún framework que tenga Spring Boot o algún plugin instalado. De cualquier manera la instrucción básica es importar el proyecto como uno existente y utilizar el botón de ejecución por defecto que se asocia al proyecto. Además para un entendimiento más simple, se adjunta un diagrama en resources._


### Herramientas 📋

* Intellij IDEA
* Maven
* H2 + JPA
* Java 17
* Mockito

## Ejecutando las pruebas ⚙️

_Una vez tengamos el proyecto corriendo, debemos dirigirnos por defecto a localhost:8080/swagger-ui-custom.html, url que contiene el swagger del proyecto.
De forma adicional se desplegó usando la herramienta Heroku. Por lo consiguiente ahora se podrá acceder a las url desde el navegador siguiendo la dirección https://registro-usuarios-api.herokuapp.com/swagger-ui/index.html y registrar usuarios por medio de https://registro-usuarios-api.herokuapp.com/user-registration/save._

