# RestROOM
 A project to integrate any restaurant with the digital world (Final Project)

This project is organised in two main folders (api & front). This way the main project is divided in two big sections (backend & frontend)

···| API |···
This folder contains the backend of the project, programmed using Java, consisting in a simple API which comunicates with a MySQL 
central database to perform simple CRUD operations. This operations are performed through the JPA framework applied via Hibernate ORM
The whole backend project has been developed within a NetBeans IDE, and it makes use of the Spring Boot framework in order to initialise
and configure the multiple frameworks which take part on the project.

o=> A summary of the most relevant used technologies, along with its version, is listed below:

	-- Windows 10 v10.0
	-- Java Platform, Enterprise Edition 8
		- Java Development Kit 11.0.9+7-LTS
		- Java Runtime Environment 11.0.9+7-LTS
	-- Apache NetBeans IDE 12.0
	-- Spring Boot 2.4.1 (implements the following dependencies)
		- Spring Data JPA 2.4.2
		- Spring JDBC 5.3.2
		- Spring ORM 5.3.2
		- Hibernate 5.4.0.Final
		- HikariCP 3.4.5
		- Spring Web MVC 5.3.2
		- Jackson 2.11.3
		- Tomcat 9.0.41
	-- MySQL Server 8.0.22
		- MySQL connector JDBC 8.0.22

o=> The API programming consists in five main steps:
	- Project configuration and DataBase connection -
		Using Spring Boot eases a lot the configuration time-usage and complexity. By defining the most important dependencies
		and some of the main attributes of the project (name, package, location ...), it is configured and ready to code in 
		no time. Once the project is ready, the DataBase is connected via the NetBeans IDE 'services' tab and configured
		inside the project via the 'application.properties' file in 'src/main/resources' directory, which defines the url, 
		username and password among other possibilities.

	- Creation of data POJOs -
		The basic, essential, operational unit for the project is a simple POJO class. This classes reflect the DataBase
		entities, its attributes and relationships. Constructors and Getter/Setter methods are also added for every POJO.
		This classes include some annotations to clearify the behaviour of the Hibernate ORM, such as @Entity to stand out
		thas this class is a DB entity or @Id (@GeneratedValue) to define an attribute as an entity primary key.

	- Definition of Repositories -
		Repositories will ultimately allow the API to communicate with the datasource via some built-in methods defined inside
		the CrudRepository interface such as save() or deleteById(). 
	
	- Definition of Services - 
		This is where the business logic is applied, independent from the rest of the project. This will make the project more 
		mantainable and scalable in a future. This classes are marked with the '@Service' annotation to indicate Spring these
		are components which hold the business logic, so the framework can include this classes as beans in the 
		ApplicationContext. This services consist of different methods that use the repository built-in methods to manipulate
		the DataBase data according with the business logic and return objects, lists or Strings that will later be used by 
		the Controller

	- Definition of the Controller -
		This final layer is where the data extracted and manipulated by the Services will be Mapped to the specified URIs.
		Using SpringMVC annotations, this class defines the mappings, request methods and variables that will be part of the
		interaction of other software with this API via HTTP Requests. The Controller is defined with a '@RestController'
		annotation which indicates that every method response will be strictly what the return of that method defines. 
		This way the Api obtains and delivers data wich will later be used by the NUXTJS framework to define dynamic views.

···| FRONT |···
This folder contains the visual part of the project, the one that consumes the API to make the data interaction visible and accessible
to the user. This task is performed using NUXTJS, a Vue framework that aims to make Server-Side-Rendered applications. In the same way,
Vue is a JavaScript framework used to ease and reduce the programming complexity of the process of data-binding and API consumption of
the frontend pages. 