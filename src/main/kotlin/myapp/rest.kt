//package myapp

import spark.kotlin.*

fun main(args: Array<String>) {
	println("\n\nCreating Hello World Api")
	val http: Http = ignite()
	
    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}
