plugins {
    id("java")
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("jacoco")
}

group = "ltr.org"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

var starterWeb = "2.7.2";
var postgres = "42.5.0";
var lombok = "1.18.24";
var swagger = "3.0.0";
var commons = "3.10";
var commonsCommons = "2.11.0";
var modelMapper = "3.1.0";
var commonsCsv = "1.9.0";
var logBack = "6.4";
var commonsIo = "2.11.0";
var springBatchTest = "5.0.1";
var prometheus = "1.10.2";
var springBatch = "4.3.6";
var fileUpload = "1.5";
var mockitoInline = "5.2.0";

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-security:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.3")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.modelmapper:modelmapper:3.1.1")
}

tasks.test {
    useJUnitPlatform()
}