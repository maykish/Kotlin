package myapp

import myapp.whenSerializeWeather_thenSuccess
import khttp.get
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val mapper = jacksonObjectMapper() 
var location = "Kings+George,VA"
val mykey = "ccba5254c42840338cfd532452954101"
val url = "http://api.weatherbit.io/v2.0/forecast/hourly?city=$location&key=$mykey&units=I&hours=1"
val r = get(url)

data class Weather(
	var temp: Int,
	var rain: Boolean,
	var snow: Boolean,
	)

fun main() {
    whenSerializeWeather_thenSuccess()
	//println(r.jsonObject)
}

/*Sample Output:
{"country_code":"US","city_name":"King George","data":[{"pod":"d","pres":1014,"wind_cdir":"SE","clouds":59,"wind_spd":9.5,"ozone":311.75,"pop":0,"datetime":"2021-06-02:20","timestamp_local":"2021-06-02T16:00:00","precip":0,"timestamp_utc":"2021-06-02T20:00:00","weather":{"code":803,"icon":"c03d","description":"Broken clouds"},"snow_depth":0,"dni":869.72,"clouds_mid":13,"uv":3.67176,"vis":15,"temp":78.8,"dhi":111.83,"clouds_hi":1,"app_temp":79,"ghi":767.42,"dewpt":61.6,"wind_dir":141,"solar_rad":671.703,"wind_gust_spd":12.3,"clouds_low":59,"rh":56,"slp":1019,"snow":0,"wind_cdir_full":"southeast","ts":1622664000}],"timezone":"America/New_York","lon":"-77.18442","state_code":"VA","lat":"38.26818"}*/

