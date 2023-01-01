package team.me.application.outPort

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["team.me"])
class OutPortApplication

fun main(args: Array<String>) {
    runApplication<OutPortApplication>(*args)
}
