package team.me.application.inPort

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["team.me"])
class InPortApplication

fun main(args: Array<String>) {
    runApplication<InPortApplication>(*args)
}
