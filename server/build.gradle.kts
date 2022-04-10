import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("org.springframework.experimental.aot") version "0.11.2"
}

group = "com.github.jeremyrempel.yahn"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    maven { url = uri("https://repo.spring.io/release") }
    mavenCentral()
}

extra["testcontainersVersion"] = "1.16.2"

dependencies {

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0")

    // json: http://localhost:8080/v3/api-docs
    // webui: http://localhost:8080/swagger-ui/index.html
    implementation("org.springdoc:springdoc-openapi-native:1.6.6")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.6")

    // reactive web
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.withType<BootBuildImage> {
//    builder = "paketobuildpacks/builder:tiny"
//    environment = mapOf("BP_NATIVE_IMAGE" to "true")
//}
