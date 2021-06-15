package myapp

import khttp.get
import spark.kotlin.*
import spark.Spark.*
import java.net.URLEncoder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

val mapper = jacksonObjectMapper() 
//var location = "Kings+George,VA"
val mykey = "ccba5254c42840338cfd532452954101"

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
	//val http : Http = ignite()	
	//path ("/weather") {
	
	get("/weather/:location") { req, res -> 
		val url = "http://api.weatherbit.io/v2.0/forecast/hourly?city=${URLEncoder.encode(req.params("location"), "utf-8")}&key=$mykey&units=I&hours=1"
		val r = get(url)
		val weather = mapper.readValue("""${r.jsonObject}""", Weather::class.java)

		"The weather in ${weather.city_name} is ${weather.data[0].weather.description}."
	
		//"Hello from ${req.params("location")}"
	}
	
		//get("/", (request, responce) -> {
		//val url = "http://api.weatherbit.io/v2.0/forecast/hourly?city=${req.params(":location").toInt()}&key=$mykey&units=I&hours=1"
		//val r = get(url)
		//val weather = mapper.readValue("""${r.jsonObject}""", Weather::class.java)

		//"The weather in " 
		//${weather.city_name} is ${weather.data[0].weather.description}."
	//});
}


/*Sample Output:
{"country_code":"US","city_name":"King George","data":[{"pod":"d","pres":1014,"wind_cdir":"SE","clouds":59,"wind_spd":9.5,"ozone":311.75,"pop":0,"datetime":"2021-06-02:20","timestamp_local":"2021-06-02T16:00:00","precip":0,"timestamp_utc":"2021-06-02T20:00:00","weather":{"code":803,"icon":"c03d","description":"Broken clouds"},"snow_depth":0,"dni":869.72,"clouds_mid":13,"uv":3.67176,"vis":15,"temp":78.8,"dhi":111.83,"clouds_hi":1,"app_temp":79,"ghi":767.42,"dewpt":61.6,"wind_dir":141,"solar_rad":671.703,"wind_gust_spd":12.3,"clouds_low":59,"rh":56,"slp":1019,"snow":0,"wind_cdir_full":"southeast","ts":1622664000}],"timezone":"America/New_York","lon":"-77.18442","state_code":"VA","lat":"38.26818"}*/
