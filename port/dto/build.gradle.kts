dependencies {
    api(project(":domain"))
}

// 해당 module은 테스트 대상에서 제외한다
tasks.withType<Test> {
    exclude("**/dto/**")
}