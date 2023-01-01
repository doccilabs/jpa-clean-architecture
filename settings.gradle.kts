rootProject.name = "jpa-clean-architecture"

pluginManagement {
    val kotlinVersion = "1.5.10"
    val kaptVersion = "1.7.10"
    val springBootVersion = "2.6.6"
    val dependencyManagementVersion = "1.0.11.RELEASE"
    val protobufVersion = "0.8.15" // for gRPC

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version dependencyManagementVersion
        id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("plugin.jpa") version kotlinVersion

        kotlin("kapt") version kotlinVersion

        id("com.google.protobuf") version protobufVersion // gRPC
    }
}

include(
    "commons:common"
)

include(
    "domain"
)

include(
    "port",
    "port:repository",
    "port:usecases",
    "port:dto"
)

include(
    "adapter",
    "adapter:dao",
    "adapter:interactor"
)