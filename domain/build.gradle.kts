val queryDslVersion = "5.0.0"

dependencies {
    // queryDSL
    implementation("com.querydsl:querydsl-jpa:$queryDslVersion")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
}

// QueryDSL이 만들어주는 Qclass를 사용하기 위해 저 위치로 접근할 수 있도록 설정해주는 부분이다.
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

// 해당 module은 테스트 대상에서 제외한다
tasks.withType<Test> {
    exclude("**/domain/**")
}