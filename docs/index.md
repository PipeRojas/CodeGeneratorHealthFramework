![Logo](https://raw.githubusercontent.com/AlejandraZamora/HealthImages/master/imagenes/logo.png)
![Logo ECI](https://raw.githubusercontent.com/AlejandraZamora/HealthImages/master/imagenes/logoEscuela.jpg)

# **Diseño e implementación de una plataforma genérica para el desarrollo de aplicaciones de e-Health y m-Health**

## **Autores**
* Ing. María Alejandra Goenaga Zamora
* Ing. Andrés Felipe Rojas Ortíz

### **Directores de proyecto**
* Ing. Luis Daniel Benavides Navarro
* Ing. Olga Patricia Álvarez Piñeiro

## **INTRODUCCIÓN**

Muchas de las enfermedades que actualmente afectan a las personas generan en las mismas una dependencia con algún tipo de tratamiento, más aún cuando estas enfermedades son crónicas, por ejemplo, la Ataxia, el riesgo cardiaco o el Alzheimer entre otras. Estas enfermedades generan en el paciente una continua necesidad de evaluación de su salud por parte de un profesional de la salud, lo que hasta el momento genera muchas dificultades al paciente debido a su asistencia continua a centros de salud para la realización de diagnóstico y tratamiento médico.

Las herramientas que ofrecen las nuevas tecnologías permiten que este tipo de tratamientos no se realicen siempre de manera presencial, la realidad aumentada, el conjunto de sensores que se integran a los Smartphones, los gadgets actuales o simplemente la información que el paciente pueda comunicar al profesional de la salud abren las puertas a un nuevo tipo de interacción del paciente con el profesional de la salud.

Las ventajas que traen consigo aplicaciones para tratar las enfermedades ya mencionadas de forma remota son fáciles de identificar y mejoran la calidad de vida de las personas que las utilizan; las herramientas que se pueden utilizar para el tratamiento de las enfermedades son cada vez mejores, pero actualmente el desarrollo de este tipo de aplicaciones aún es muy problemático.

Las aplicaciones que se han desarrollado hasta el momento en telemedicina, aunque de alto nivel y con resultados excelentes, aun presentan dificultades en su desarrollo, y es que en la mayoría de los casos su desarrollo es muy limitado, las soluciones que se desarrollan se enfocan en enfermedades o casos específicos lo que genera soluciones similares pero concentradas en funcionalidades específicas.

Por otro lado las soluciones que se tienen no suelen contar con la particularidad de ser extensibles, es decir en caso de tener nuevos requerimientos no suelen ser adaptables a las funcionalidades ya desarrolladas, esto debido a lo explicado, son soluciones Ad hoc y no permiten adaptación a cambios tan fácilmente.

Es por esto que se desarrolló un framework genérico que permite el desarrollo de aplicaciones de salud apoyadas en el uso de tecnologías de la nube, móviles y de realidad aumentada, a partir de parámetros genéricos para el estudio, diagnóstico y tratamiento de enfermedades, de modo que el desarrollo de estas es más eficiente y extensible evitando las problemáticas enunciadas.

## **PLATAFORMA GENÉRICA**

Esta plataforma permite generar automáticamente aplicaciones para el diagnóstico, tratamiento y análisis estadístico de una gran cantidad de enfermedades y donde simplemente es necesario definir la estructura de datos requerida para dichas aplicaciones. . Como resultado se obtendrá una aplicación lista para su despliegue en la nube con herramientas como Heroku, lista además para ser integrada a una base de datos externa que cumpla con la estructura de datos definida, y si se desea se podrá conectar con dispositivos externos para la captura y procesamiento de bioseñales constantes y en tiempo real. Dicha aplicación estará enfocada en servicios web usados por clientes web y/o clientes externos diseñados para tres actores principales:
* El Paciente: quien podrá hacer registro de los diagnósticos que haga por su cuenta o que sean dados por los dispositivos externos y podrá ver su avance en dichos diagnósticos.
* El Doctor: quien podrá consultar los diagnósticos realizados por los pacientes, así como ver sus avances, y además enviar comentarios al paciente de acuerdo a su evolución para aconsejarlo en pro de mantener una buena salud.
* El investigador: quien podrá consultar los datos conjunto de todos los pacientes registrados en la aplicación, dichos datos están anonimizados para mantener la seguridad de los datos de cada paciente.

______
* Para consultar más información sobre el proyecto puede dirigirse al siguiente link:
     * [CodeGeneratorHealthFramework Wiki](https://github.com/PipeRojas/CodeGeneratorHealthFramework/wiki)
     
     
     
     
     
     
     
     
