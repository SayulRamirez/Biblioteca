# APLICACIÓN PARA PRESTAMO DE LIBROS


La aplicación se realizó como un proyecto personal utilizando Java y con la ayuda 
JPA para la conexión con la base de datos MySQL para el manejo de los prestamos
en una biblioteca, se incorporo una interfaz de usuario con swing muy sencilla para ilustrar 
un poco de las funcionalidades que tiene el proyecto.

___
## :exclamation: Acerca de la aplicación

El tiempo que me tomo construir la aplicación fue de una semana y lo que se realizó 
para llevarla a cabo fue:

1. :thought_balloon: Entender los antecedentes de una libreria hipótetica que en resumen la biblioteca
llevaba los registros de los prestamos en bitacoras, siendo muchas de ellas y repitiendo
mucha información como eran los datos de los alumno.
2. Posteriormente se analizó la problematica mediante diagramas de flujo para así poder 
diseñar una buena lógica del negocio.
3. :page_facing_up: Se definierón los datos que debiamos manejar, los más relevantes.
4. :page_facing_up: Por último se definirón las reglas de negocio para posteriormente pasar al desarrollo 
las interfaces del usuario.

___

## :question: Cuáles fueron las tecnologias utilizadas.

`JAVA` para el desarrollo de toda la aplicación. 

`LIBRERIA SWING` para la interfaz de usuario.

`JPA` con la implementación de `HIBERNATE` para la persistencia de los datos.
* Se utilizó el `EntityManager` para tener estandarizada la aplicación.
* Se implemento el patron `SINGLETON` y así tener una sola instancia del *EntityManager*

`MYSQL` como gestor de base de datos.
* Con la ayuda de *MySQL* se crearón *stored procedure* para realizar consultas más específicas.

`MAVEN` para la gestión e inyeccion de dependencias.

`GIT` para el control de la aplicación.

___

## Funciones de la aplicación.

* :mortar_board: Autenticar que el alumno este registrado en el sistema de la biblioteca.

![Autenticación del alumno]() 

* :confused: Estado del alumno
  1. Estado de los prestamos (si tiene o no activos).  
  2. Estado de las multas (si tiene o no).
  3. Actualizar las multas (si ya expiro).

![Estado del alumno]()

* :speech_balloon: Cosulta de libros por:
  1. Apellido del autor.
  2. Nombre del autor.
  3. Titulo del libro.

![Consulta de libros]()

* :speech_balloon: Consulta del prestamo de un libro para consultar cuando estara disponible 
en caso de que no se encuentre por:
   1. Id del libro.
   2. Titulo del libro.

![Consulta del prestamo del libro]()

* :blue_book: Realizar el prestamo del libro.
  1. No se realizará el prestamo si el alumno no esta registrado en el sistema.
  2. No se realizará el prestamo si el alumno tiene multas activas.
  3. Solo se realizara el prestamo si el alumno no otro prestamo o multa.

![Realizar prestamo]()

* :green_book: Devolución del libro.
  1. Si lo devuelve con tres días de retrazó se aplicara una multa automaticamente.
  2. Igualmente se aplicara si se retrasa más de tres días pero la multa será mayor.
  3. Y si se entrega en mal estado se aplicara la multa mayor.
  4. En caso contrario se hará la devolución sin problema y el alumno podrá solicitar otro prestamo

![Devolición del libro]()







