# Cosmos-Compose

Cosmos-Compose in a Modular Word is a sample project that presents modern, 2023
approach to [Android](https://www.android.com/) application development
using [Kotlin](https://kotlinlang.org/) and latest tech-stack.


The goal of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android
application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it
has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and
long application lifecycle management.


### Environment setup

First off, you require the latest Android Studio Hedgehog|2023.1.1(or newer) to be able to build the app.

You need to supply keys for Nasa API. You can find information about how to gain access by using the [link](https://api.nasa.gov/).

When you obtain the keys, you can provide them to the app by putting the following in the `local.properties` project root file:
```properties
#Nasa API KEYS
API_KEY = "<insert>"
```

### Design
For designing we are using [Jetpack Compose](https://developer.android.com/jetpack/compose) 

## Architecture

We are followed Clean Architecture for Cosmos-Compose.
You can read more about android best practices and architecture [Android Architecture ](https://developer.android.com/topic/architecture#recommended-app-arch)

