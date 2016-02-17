package sbkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by zozfabio on 16/02/2016.
 */
@SpringBootApplication open class Application

fun main(args : Array<String>) {
    SpringApplication.run(Application::class.java, *args);
}