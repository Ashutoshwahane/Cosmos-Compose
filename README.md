# [COSMOS](https://github.com/Ashutoshwahane/Cosmos-Compose/) is a space science app Built using Jetpack compose and modern Android libraries.



The goal of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android
application architecture that is modular, scalable, maintainable, and testable. This application may look simple, but it
has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and
long application lifecycle management.


### Environment setup

You need to supply keys for Nasa API. You can find information about how to gain access by using the [link](https://api.nasa.gov/).

When you obtain the keys, you can provide them to the app by putting the following in the `local.properties` project root file:
```properties
#Nasa API KEYS
API_KEY = "<insert>"
```


## Built with 

- [Kotlin](kotlinlang.org): Programming language
- [Jetpack Compose](https://developer.android.com/jetpack/compose): Jetpack compose is a modern android UI developement framework.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines): For multithreading
- [Serialization](https://github.com/Kotlin/kotlinx.serialization): For JSON serialization/deserialization
- [Retrofit](https://github.com/square/retrofit): Performing API request 
- [Coil](https://github.com/coil-kt/coil): Image loading for Android
- [buildSrc](https://android-developers.googleblog.com/2023/04/kotlin-dsl-is-now-default-for-new-gradle-builds.html) New way to implement libraries in build.gradle.kts

* Found issues, please report them on [GitHub](https://github.com/Ashutoshwahane/Cosmos-Compose/issues).



## Architecture

![image](https://github.com/Ashutoshwahane/Cosmos-Compose/assets/50887729/d43a5bbb-5cb4-4150-ad8c-2b1c61709e62)

We have followed Clean Architecture for Cosmos.
You can read more about Android best practices and architecture [Android Architecture ](https://developer.android.com/topic/architecture#recommended-app-arch)

