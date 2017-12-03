# Jupper

Jupper is a minimal tool that makes profiling specific behaviors of your application easier without having to resort to paid frameworks or clunky workarounds. 


## Getting Started

The best free tool for profiling Java applications is probably JVisualVM, which is the GUI profiler that ships with regular distributions of the Java Development Kit (JDK).
JVisualVM works by hooking to running Java processes. If you are developing a library or some other Java application that doesn’t have a main loop, it’s not very easy to keep the process around long enough to let VisualVM to hook into it. 
There are a few tricks that you can use, as you can see in [this Stack Overflow question] (https://stackoverflow.com/questions/11826680/profile-junit-in-eclipse-indigo-using-visualvm), but these are clunky and require messing around with breakpoints. 

Jupper is just a JavaFX window that calls a method in your test package. The advantage is that the window keeps the process alive until you close it. This way you have all the time to set up JVisualVM and painlessly profile your application code.


### Installing

You can install Jupper with maven: 
1. Clone this repository.
2. Navigate to the installation folder and run: 

``` mvn clean install ```

3. Add the library as a maven dependency to your project:

```
<dependency>
	<groupId>com.vibridi</groupId>
	<artifactId>jupper</artifactId>
	<version>1.0.0</version>
	<scope>test</scope>
</dependency>
```

Requirements:
Java 8 or above.


### Usage

The easiest way to use Jupper is to create new class in the test package of your project that launches the test window. Assuming that yours is a Maven project, you can do the following:

- Create a `Profiler` class in your test package, e.g. `com.vibridi.myapp.test.Profiler
- Add a `main` method to the `Profiler` class. It’s preferable to use a `main` instead of, let’s say, a JUnit `@Test` so that Maven will not launch it during the build phase.

```
	public static void main(String[] args) {
		Jupper.profile();
	}
```

- Run the `main`
- Calling `profile()` will start JavaFX and show the Jupper window.

[test window](img/jupper-window.png)

- Copy the **qualified** name of the class you want to profile in the “Test Class” field and the name of the method in the “Test Method” field. Example:

[filled out](img/jupper-filled.png)

- Open JVisualVM. It should be in the `bin` folder of your JDK folder.
- Hook up JVisualVM to the process of the `Profiler` class’ `main`, set up your sampling or profiling preferences and start sampling/profiling.

- Click “Launch Test”. JVisualVM should start collecting CPU or RAM information.


## Current version

1.0.0


## Authors

* **Gabriele Vaccari** - *Initial work* - [Vibridi](https://github.com/vibridi/)

Currently there are no other contributors

## TODOs


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
