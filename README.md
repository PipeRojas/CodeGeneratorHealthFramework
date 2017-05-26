# CodeGeneratorHealthFramework

![Logo ECI](http://www.escuelaing.edu.co/uploads/descargables/1193_logo_horizontal.jpg)

# **MANUAL DE USO DE PLATAFORMA GENÉRICA PARA EL DESARROLLO DE APLICACIONES DE E-HEALTH Y M-HEALTH**

## **INTRODUCCIÓN**

En este documento se quiere evidenciar los pasos a seguir para el uso de la PLATAFORMA GENERICA de aplicaciones de salud con la cual se pueden generar automáticamente aplicaciones para el uso del diagnóstico, tratamiento y análisis estadístico de una gran cantidad de enfermedades y donde simplemente será necesario definir la estructura de datos requerida para dichas aplicaciones. Como resultado se obtendrá una aplicación lista para su despliegue en la nube con herramientas como Heroku, lista además para ser integrada a una base de datos externa que cumpla con la estructura de datos definida y dicha aplicación estará enfocada en servicios web usados por clientes web diseñados para tres actores principales:
* El Paciente: quien podrá hacer registro de los diagnósticos que haga por su cuenta y podrá ver su avance en dichos diagnósticos.
* El Doctor: quien podrá consultar los diagnósticos realizados por los pacientes, así como ver sus avances, y además enviar comentarios al paciente de acuerdo a su evolución para aconsejarlo en pro de mantener una buena salud.
* El investigador: quien podrá consultar los datos conjunto de todos los pacientes registrados en la aplicación, dichos datos están anonimizados para mantener la seguridad de los datos de cada paciente.

## **REQUERIMIENTOS INICIALES**

* Cuenta activa en GitHub y Heroku
* git [(descargar)](https://git-scm.com/downloads)
* maven [(descargar)](https://maven.apache.org/download.cgi)
* bower [(descargar)](https://bower.io/#install-bower)
* heroku [(descargar)](https://devcenter.heroku.com/articles/heroku-cli)
* Eclipse IDE [ (descargar)](https://www.eclipse.org/downloads/)
* xText Eclipse Plugin [(descargar e instalar)](https://eclipse.org/Xtext/download.html)

## **DESCARGA Y USO DE LA PLATAFORMA**

1. **Descargar el Repositorio:**
Ingresamos desde cualquier navegador al sitio: [Plataforma para aplicaciones de eHealth y mHealth](https://github.com/PipeRojas/CodeGeneratorHealthFramework) y clonamos el repositorio en cualquier carpeta de nuestro equipo:
![Primer paso](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/1.png)

En la consola usamos el comando git clone <Link al Repositorio>
![Paso 2](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/2.png)

2. **Copiar la plantilla sin código a otro directorio**
Dentro del directorio creado encontraremos el WorkSpace de Eclipse de la plataforma, la definición de la gramática del Lenguaje de Dominio Especifico usado y un archivo comprimido con una plantilla a la que agregaremos el código generado más adelante, por ahora debemos descomprimir dicho archivo en un directorio diferente:

![Paso 3](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/3.png)

Al descomprimir el archivo obtendremos un proyecto con las dependencias necesarias para la aplicación que queremos realizar:

![Paso 4](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/4.png)

Dicho proyecto está realizado con Maven, así que podremos abrirlo con cualquier IDE que lo soporte (En este caso NetBeans), pero aun no es ejecutable, primero debemos agregar las fuentes que genere la plataforma.

![Paso 5](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/5.png)
![Paso 6](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/6.png)

3. **Generar el código necesario usando la plataforma**
Ahora, usando el IDE Eclipse y el plugin para xText (debe estar instalado para este punto, de lo contrario revisar sección de REQUERIMIENTOS INICIALES)
Importamos el proyecto al WorkSpace de nuestra preferencia:

![Paso 7](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/7.png)
![Paso 8](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/8.png)
![Paso 9](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/9.png)

Para ejecutar el IDE donde podremos especificar los requerimientos de nuestra aplicación ejecutamos el primer proyecto como EclipseApplication:
![Paso 10](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/10.png)

En caso de que Eclipse encuentre errores damos la opción Proceed:
![Paso 11](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/11.png)

En este momento solamente podría aparecer un error y es el siguiente:
![Paso 12](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/12.png)

Si es el caso, guardamos en el portapapeles lo resaltado y damos en OK, nos dirigimos a la barra de menú e ingresamos a Window/Preferences
![Paso 13](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/13.png)

Luego ingresamos a Java/Installed JREs y seleccionamos el existente, luego damos a la opción Edit:
![Paso 14](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/14.png)

En el cuadro de dialogo cambiamos el JRE name por el que teníamos en el portapapeles y damos en Finish, OK y volvemos a ejecutar el proyecto como EclipseApplication, debería abrirse un nuevo IDE:
![Paso 15](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/15.png)

En este IDE especificaremos los requerimientos para nuestra aplicación, primero creamos un nuevo proyecto Java:
![Paso 16](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/16.png)
![Paso 17](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/17.png)
![Paso 18](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/18.png)

Podemos especificar cualquier nombre al proyecto, luego, creamos un nievo archivo con la extensión .dmodel2>
![Paso 19](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/19.png)
![Paso 20](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/20.png)

El nombre del archivo puede ser cualquiera, lo importante es que tenga la extensión mostrada, si todo va bien, aparecerá un cuadro de dialogo referenciando xText, damos Yes.
![Paso 21](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/21.png)

Ahora especificamos nuestra aplicación en el Lenguaje de Dominio Especifico Hdsl2 en el archivo creado:
![Paso 22](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/22.png)

En la especificación anterior encontramos un ejemplo de aplicación enfocada en el diagnóstico y tratamiento del Alzheimer por medio de Juegos, como se puede observar, lo que se definió en el archivo fue la estructura de datos a usar por la aplicación, la cual será explicada a continuación:
![Paso 23](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/23.png)

En la primera parte encontramos la definición de los tipos de datos primitivos que se usara en la aplicación, por ahora existe soporte de Enteros, Fechas y Cadenas.
![Paso 24](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/24.png)

La palabra clave “package” sirve para especificar el nombre del paquete principal del proyecto, para cuestiones de distribución de fuentes.
![Paso 25](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/25.png)

Ahora se define la entidad principal de datos (definida con el token “principal”), esta se enfoca en el Paciente del diagnóstico y en ella se especifica los datos que se guardará del mismo, en este caso se guarda el ID como un Entero, el Nombre como una Cadena, y el token “transient” indica que este dato será modificable por el usuario luego del registro del mismo, también se guardará su clave, su rol, para diferenciar entre Paciente, Doctor o Investigador, también se guardará su edad, y por último, los diagnósticos que se guardarán (indicados por el token “diagnostic”) y los comentarios que hará el Doctor, estas dos últimas propiedades poseen más de un registro para cada paciente por tanto llevan el token “many” tienen de tipo otras entidades que también deben ser definidas:
![Paso 26](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/26.png)

Luego de definir los requerimientos de la aplicación a nivel de datos, cuando guardamos los cambios del archivo, se generan las fuentes necesarias para que la aplicación funcione:
![Paso 27](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/27.png)

4. **Copiar las fuentes generadas a su respectivo lugar en el proyecto en NetBeans**
Ahora copiamos las fuentes, primero, la existente en la carpeta “com” la combinamos con su homónima en el proyecto en NetBeans, para efectos practicos, esto lo hacemos desde la sección Files en NetBeans:
![Paso 28](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/28.png)

Luego combinamos la carpeta static en las fuentes generadas en Eclipse con su carpeta homónima en las carpetas de NetBeans:
![Paso 29](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/29.png)

Luego de hacer esto, nuestro proyecto en NetBeans tiene todo lo necesario para funcionar, solo debemos ejecutarlo:
![Paso 30](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/30.png)

Para comprobar que funciona ingresamos a la dirección localhost:8080 desde cualquier navegador en el PC:
![Paso 31](https://github.com/AlejandraZamora/HealthImages/blob/master/imagenes/31.png)


## **Desplegar el proyecto en la nube con Heroku**
* Entrar a la página de heroku ([Heroku](https://www.heroku.com/), escooger la opción de crear una nueva aplicación y poner el nombre que deseamos.
* Crear una nueva carpeta en la que se va a crear el proyecto para desplegar, para esto nos ubicamos en el directorio deseado y creamos la carpeta desde la terminal:
    *  cd DirectorioDeseado
    *  mkdir NombreCarpeta
* En la carpeta creada se deben copiar los archivos del proyecto a excepción de la carpeta .git, el archivo README.md y el archivo .gitignore que se encuentran en el directorio raíz del proyecto.
* Abrir la terminal y ubicarnos en el directorio de la carpeta creada antes con el comando cd:
    *  cd DirectorioProyecto
* Iniciar sesión en la cuenta de heroku con el comando:
    *  heroku login
* Crear un nuevo repositorio en GitHub y conectarlo con heroku:
    *  git init
    *  heroku git:remote -a NombreDeMiAplicación (nombre de la aplicación creada en el paso 1)
* Si desea realizar cambios en el proyecto puede realizarlos ahora.
* Después de realizar los cambios se debe hacer commit de los mismos en el nuevo repositorio:
    *  git add .
    *  git commit -am "Descripción del commit"
* Desplegar la aplicación en heroku:
    *  git push heroku master
* Para acceder a la aplicación desplegada nos dirijimos al link https://NombreDeMiAplicación.herokuapp.com/
