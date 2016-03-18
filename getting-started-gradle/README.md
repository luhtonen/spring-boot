# Getting Started with Spring Boot, Gradle and Groovy
This is a simple “Hello World!” web application in Groovy with [Gradle](http://gradle.org/) build tool that highlights some of Spring Boot’s key features.

To be able to run and build this application java and maven should be installed. Check for valid versions of Java

	$ java -version
	java version "1.7.0_51"
	Java(TM) SE Runtime Environment (build 1.7.0_51-b13)
	Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode)

## Developing your first Spring Boot application with Gradle and Groovy
This is simple "Hello World" application web application in Groovy that highlights some of Spring Boot’s key features. We’ll use Gradle to build this project. This is sample application as the one on the [official spring-boot docs site](http://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-first-application.html) except that this one is using Gradle and is developed with Groovy.

### Creating the Gradle build file
We need to start by creating a Gradle `build.gradle` file. The `build.gradle` is the recipe that will be used to build your project. Open your favorite text editor and add the following:
	
	buildscript {
		ext {
			springBootVersion = '1.3.3.RELEASE'
		}
		repositories {
			mavenCentral()
		}
		dependencies {
			classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}") 
		}
	}

	apply plugin: 'groovy'
	apply plugin: 'spring-boot'

	jar {
		baseName = 'getting-started-gradle'
		version = '0.0.1-SNAPSHOT'
	}

	sourceCompatibility = 1.8
	targetCompatibility = 1.8

	repositories {
		mavenCentral()
	}


	dependencies {
		compile('org.springframework.boot:spring-boot-starter-web')
		compile('org.codehaus.groovy:groovy')
	}


	task wrapper(type: Wrapper) {
		gradleVersion = '2.9'
	}
	
Gradle uses Groovy for defining build configuration and `build.gradle` build is just regular Groovy script. 

`buildscript` section defines configuration used during the `build` process. In `ext` section are defined the configuration which can be used by the other parts of `buildscript` section. In our build script we define Spring Boot version. `repositories` defines location of the repositories which should be used by build process to resolve and download all required dependencies. In this project `mavenCentral()` central Maven repository is used to download required repositories. More Maven repositories can be defined to be used. For example if some companies have their own repositories available on their own local network they can be defined in the format: `mvn "https://company.com/artifactory/maven/repo"`. If someone prefer to use local maven repository the it can be done as following `mavenLocal()`.  Gradle can also use Ivy repositories either public or company's own. More information can be found on the Gradle official [User Guide](https://docs.gradle.org/current/userguide/userguide.html). `dependencies` defines that this project depends on `spring-boot-gradle-plugin`.

In this project 2 plugins are defined: `groovy` and `spring-boot` with `apply plugin:` command. 

Build target is defined as `jar`. This will generate über jar file which will contains all required jar files and will be named as combination of `baseName` and `version`. In this example it would be `getting-started-gradle-0.0.1-SNAPSHOT.jar`.

Project have 2 dependencies `spring-boot-starter-web` and `groovy`. The first one will add number of additional dependencies, including the Tomcat web server and Spring Boot itself. The other one will add Groovy sdk and rutime.

### Writing the code
To finish our application we need to create a single Groovy file. Gradle will compile sources from `src/main/groovy` by default so you need to create that folder structure, then add a file named `src/main/groovy/Example.groovy`:

	package org.elu.springboot.example

	import org.springframework.boot.SpringApplication
	import org.springframework.boot.autoconfigure.EnableAutoConfiguration
	import org.springframework.web.bind.annotation.RequestMapping
	import org.springframework.web.bind.annotation.RestController

	@RestController
	@EnableAutoConfiguration
	class Example {

		@RequestMapping('/')
		def home() {
			return 'Hello World!'
		}

		static void main(String[] args) {
			SpringApplication.run Example, args
		}
	}

Although there isn’t much code here, quite a lot is going on. Let’s step through the important parts.

### The @RestController and @RequestMapping annotations
The first annotation on our `Example` class is `@RestController`. This is known as a *stereotype* annotation. It provides hints for people reading the code, and for Spring, that the class plays a specific role. In this case, our class is a web `@Controller` so Spring will consider it when handling incoming web requests.

The `@RequestMapping` annotation provides “routing” information. It is telling Spring that any HTTP request with the path “/” should be mapped to the `home` method. The `@RestController` annotation tells Spring to render the resulting string directly back to the caller.

### The @EnableAutoConfiguration annotation
The second class-level annotation is `@EnableAutoConfiguration`. This annotation tells Spring Boot to “guess” how you will want to configure Spring, based on the jar dependencies that you have added. Since `spring-boot-starter-web` added Tomcat and Spring MVC, the auto-configuration will assume that you are developing a web application and setup Spring accordingly.

### The “main” method
The final part of our application is the `main` method. This is just a standard method that follows the Java convention for an application entry point. Our main method delegates to Spring Boot’s `SpringApplication` class by calling `run`. `SpringApplication` will bootstrap our application, starting Spring which will in turn start the auto-configured Tomcat web server. We need to pass `Example` as an argument to the `run` method to tell `SpringApplication` which is the primary Spring component. The `args` array is also passed through to expose any command-line arguments.

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
