# Getting Started with Spring Boot
This is a simple “Hello World!” web application in Java with Maven build tool that highlights some of Spring Boot’s key features.

To be able to run and build this application java and maven should be installed. Check for valid versions of Java

	$ java -version
	java version "1.7.0_51"
	Java(TM) SE Runtime Environment (build 1.7.0_51-b13)
	Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode)
 and Maven installed.
 
 	$ mvn -v
	Apache Maven 3.2.3 	(33f8c3e1027c3ddde99d3cdebad2656a31e8fdf4; 2014-08-11T13:58:10-07:00)
	Maven home: /Users/user/tools/apache-maven-3.1.1
	Java version: 1.7.0_51, vendor: Oracle Corporation

## Building application
To build this application execute following command:

	$ mvn package


This will compile all source files and will produce executeable jar file `getting-started-0.0.1-SNAPSHOT.jar` into `target` directory.

## Running application
Application can be run either with spring-boot `run` command:

	$ mvn spring-boot:run

	
or by starting executable jar file:

	$ java -jar target/getting-started-0.0.1-SNAPSHOT.jar

If you open a web browser to [localhost:8080](localhost:8080) you should see the following output:

	Hello World!
	
To gracefully exit the application hit `ctrl-c`.

