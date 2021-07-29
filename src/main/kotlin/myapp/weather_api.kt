package myapp

import khttp.get
import spark.kotlin.*
import spark.Spark.*
import java.net.URLEncoder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

val mapper = jacksonObjectMapper() 
// Sign up on the Weatherbit API website and retrive a personal API key to add in the quotes below. Uncomment the next line when done.
//val mykey = ""

//The following classes represent needed fields from the json responce returned by the API. They will later be parsed by the jackson module. 
//The "@JsonIgnoreProperties" line above the classes allows for unlisted fields to be ignored, thus any json fields that one does not need can be deleted from the class and not be parsed later in the program.

@JsonIgnoreProperties(ignoreUnknown = true)
data class Weather(
	val country_code: String,
	val city_name: String,
	val data: List <WeatherData>,
	val state_code: String,
	)

@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherData(
	val pres: Int,
	val clouds: Int,
	val wind_spd: Float,
	val ozone: Float,
	val datetime: String,
	val precip: Int,
	val weather: WeatherDescriptors,
	val snow_depth: Int,
	val clouds_mid: Int,
	val uv: Float,
	val vis: Int,
	val temp: Float,
	val clouds_gi: Int,
	val app_temp: Int,
	val solar_rad: Float,
	val wind_gust_spd: Float,
	val clouds_low: Int,
	val snow: Int,
	val wind_cdir_full: String
	)

data class WeatherDescriptors(
	val code: Int,
	val icon: String,
	val description: String
	)


fun main(args: Array<String>) {
	get("/weather/:location") { req, res -> 
		val url = "http://api.weatherbit.io/v2.0/forecast/hourly?city=${URLEncoder.encode(req.params("location"), "utf-8")}&key=$mykey&units=I&hours=1"
		val r = get(url)
		val weather = mapper.readValue("""${r.jsonObject}""", Weather::class.java)

		"The weather in ${weather.city_name} is ${weather.data[0].weather.description}."	
	}
}

