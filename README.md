# Clean Architecture example with JPA

## Environment
- Kotlin 2.6.6
- SpringBoot version 2.6.6
- Spring Data JPA

## Module Explanation
- adapter: 외부와 직접 노출이 되어있는 모듈 모음
- port: adapter를 추상화한 모듈 모음
- domain: 도메인 모듈
- common: 공통 속성을 정의하는 모듈