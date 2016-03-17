# Getting Started with Spring Boot, Gradle and Groovy
This is a simple “Hello World!” web application in Groovy with [Gradle](http://gradle.org/) build tool that highlights some of Spring Boot’s key features.

To be able to run and build this application java and maven should be installed. Check for valid versions of Java

	$ java -version
	java version "1.7.0_51"
	Java(TM) SE Runtime Environment (build 1.7.0_51-b13)
	Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode)


## Building application
This project uses [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) for building this project. No separate gradle installation is required. Gradle Wrapper will download all required gradle packages in order to run the build tasks.

To build this application execute following command:

	$ ./gradlew build


This will compile all source files and will produce executable jar file `getting-started-gradle-0.0.1-SNAPSHOT.jar` into `build/libs` directory.

## Running application
Application can be run either with Gradle command:

	$ ./gradlew bootRun

	
or by starting executable jar file:

	$ java -jar build/libs/getting-started-gradle-0.0.1-SNAPSHOT.jar

If you open a web browser to [localhost:8080](localhost:8080) you should see the following output:

	Hello World!
	
To gracefully exit the application hit `ctrl-c`.

