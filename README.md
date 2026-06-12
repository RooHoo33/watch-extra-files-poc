## Watch Extra Files POC

Project to show using mutiple source sets with the micronaut continuous build run. Without
plugin changes, if you run `./gradlew run -t` and edit the file `extras/Example.kt`, the
application will not be rebuilt. With
the [changes to the Micronaut plugin](https://github.com/RooHoo33/watch-extra-files-poc/blob/main/build.gradle.kts#L94),
you can specify
the `extras` source set `srcDirs` as an additional location for micronaut to watch causing
the application to be rebuilt when you modifiy `extras/Example.kt`.

## Micronaut 5.0.2 Documentation

- [User Guide](https://docs.micronaut.io/5.0.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/5.0.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/5.0.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://gradleup.com/shadow/)

## Feature ksp documentation

- [Micronaut Kotlin Symbol Processing (KSP) documentation](https://docs.micronaut.io/latest/guide/#kotlin)


- [https://kotlinlang.org/docs/ksp-overview.html](https://kotlinlang.org/docs/ksp-overview.html)

## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)

## Feature kotest documentation

- [Micronaut Test Kotest5 documentation](https://micronaut-projects.github.io/micronaut-test/latest/guide/#kotest5)


- [https://kotest.io/](https://kotest.io/)


