plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.3.21"
    id("com.google.devtools.ksp") version "2.3.7"
    id("io.micronaut.application") version "5.0.1-SNAPSHOT-JACK"
    id("com.gradleup.shadow") version "9.4.1"
    id("io.micronaut.aot") version "5.0.0"
}

version = "0.1"
group = "dev.roohoo"


val kotlinVersion=project.properties.get("kotlinVersion")

repositories {
    mavenLocal()
    mavenCentral()
}
// 1. Define the custom source set in standard Gradle
sourceSets {
    create("extras") {
        java.srcDir("extras") // Kotlin plugin hooks into this automatically
    }
}

// 2. Configure the Kotlin-specific source directories
kotlin {
    sourceSets {
        getByName("extras") {
            kotlin.srcDir("extras")
        }
    }
}

dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation(sourceSets["extras"].output)
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("tools.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
}



application {
    mainClass = "dev.roohoo.ApplicationKt"
}

java {
    sourceCompatibility = JavaVersion.toVersion("25")
}




graalvmNative.toolchainDetection = false
graalvmNative {
    binaries {
        all {
            buildArgs.add("-H:+SharedArenaSupport")
        }
    }
}




micronaut {
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("dev.roohoo.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
    additionalFilesToWatch.setFrom( sourceSets["extras"].kotlin.srcDirs)

}

tasks.named<io.micronaut.gradle.docker.MicronautDockerfile>("dockerfile") {

    baseImage = "eclipse-temurin:25-jre"
}







// https://docs.gradle.org/current/userguide/upgrading_major_version_9.html#test_task_fails_when_no_tests_are_discovered
tasks.withType<AbstractTestTask>().configureEach {
    failOnNoDiscoveredTests = false
}




