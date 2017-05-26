Welcome to the CodeGeneratorHealthFramework wiki!

![Logo ECI](http://www.escuelaing.edu.co/uploads/descargables/1193_logo_horizontal.jpg)

# **MANUAL DE USO DE PLATAFORMA GENÉRICA PARA EL DESARROLLO DE APLICACIONES DE E-HEALTH Y M-HEALTH**

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
