import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val coroutineVersion = "1.6.3"
val mockkVersion = "1.10.3"
val kotestVersion = "5.3.2"
val springCloudVersion = "2021.0.2"

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.allopen")
    id("org.jetbrains.kotlin.plugin.noarg")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")

    kotlin("kapt")

    id("com.google.protobuf")
}

allprojects {
    group = "team.me.template"
    version = "1.0.0"

    apply(plugin = "kotlin")

    dependencies {
        // common을 포함한 모든 모듈 대상으로 coroutine 의존을 포함해준다
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    }

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }

    // DuplicatesStrategy 설정
    tasks.withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}

// 공통 Dependency 적용을 제외할 모듈 리스트
val nonDependencyProjects = listOf("commons", "independent", "grpc-interface")

configure(subprojects.filter { it.name !in nonDependencyProjects }) {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")

    apply(plugin = "kotlin-kapt")

    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlin.plugin.noarg")

    dependencies {
        // Kotlin Standard Library
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Jackson
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.module:jackson-module-afterburner")

        // Kotlin Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutineVersion")

        // Spring
        implementation("org.springframework.boot:spring-boot-starter-web")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")

        runtimeOnly("mysql:mysql-connector-java")

        // mockk
        testImplementation("io.mockk:mockk:$mockkVersion")
        testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion") // for kotest framework
        testImplementation("io.kotest:kotest-assertions-core:$kotestVersion") // for kotest core jvm assertions
        testImplementation("io.kotest:kotest-property:$kotestVersion") // for kotest property test
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")

        kapt("org.springframework.boot:spring-boot-configuration-processor")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// root folder의 gradle project는 빌드하지 않는다
tasks {
    named<Jar>("jar") {
        enabled = true
    }

    named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
        enabled = false
    }
}