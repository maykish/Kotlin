package myapp
import khttp.get

/*data class All_Weather_Data("{  
             "data":[          
    var city_name =
    var local_time =
    var temp = 
}
*/

var location = "Kings+George,VA"
val mykey = "ccba5254c42840338cfd532452954101"
val url = "http://api.weatherbit.io/v2.0/forecast/hourly?city=$location&key=$mykey&units=I&hours=1"
val r = get(url)

fun main() {
    println(r.text)
}
