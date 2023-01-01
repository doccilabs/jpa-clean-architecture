package team.me.application.outPort

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApplicationOutboundApplication

fun main(args: Array<String>) {
    runApplication<ApplicationOutboundApplication>(*args)
}
