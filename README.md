<h1 align="center">RETO 3️⃣ <a href="https://github.com/tu-usuario/reto-3-gestion-biblioteca" target="blank">
DEVSENIOR</a></h1> <h3 align="center"> Sistema de Gestión de Biblioteca 📚 con Pruebas Unitarias en Java </h3>


- Este proyecto consiste en una aplicación de consola diseñada para gestionar una biblioteca, permitiendo la administración de libros, usuarios y préstamos. Su objetivo es garantizar la calidad y 
fiabilidad del código mediante la implementación de pruebas unitarias con JUnit 5 y Mockito.


A través de este desarrollo, se aplican principios de diseño de software, como la separación de responsabilidades, y se refuerza la importancia de las pruebas unitarias para validar el correcto funcionamiento 
del sistema.



### 📂 Estructura del Proyecto

Este proyecto tiene una estructura básica sin depender de Maven u otras herramientas de gestión de dependencias.

test: Pruebas unitarias.

`BookServiceTest.java`: Pruebas para BookService.

`UserServiceTest.java`: Pruebas para UserService.

`LoanServiceTest.java`: Pruebas para LoanService.

lib: Almacena las librerías externas utilizadas (JUnit 5 y Mockito).

bin: Guarda los archivos binarios generados tras la compilación del código.

### 📋 Requerimientos Funcionales

Gestión de Libros:

Agregar un libro con ID, título y autor.

Obtener un libro mediante su ID.

Gestión de Usuarios:

Crear un usuario con ID y nombre.

Gestión de Préstamos:

Prestar un libro a un usuario, registrando la fecha del préstamo.

Obtener todos los préstamos de un usuario específico.

### 🛠️ Tecnologías Utilizadas

`Java`: Lenguaje de programación principal.

`JUnit 5`: Framework para pruebas unitarias.

`Mockito`: Framework para simular dependencias en pruebas unitarias.

### 🧪 Pruebas Unitarias
Se implementaron pruebas unitarias para validar los siguientes aspectos del sistema:

Validar la adición de un libro.

Validar la recuperación de un libro por ID.

### 👤 Autor del Proyecto
 - Johan David Tovar Acevedo


`Validar la creación de un usuario.`

`Validar el préstamo de un libro a un usuario.`

`Validar la consulta de préstamos por usuario.`
