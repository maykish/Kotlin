package myapp

import myapp.Weather


@Test
fun whenSerializeWeather_thenSuccess() {
    val weather = Weather(78, false, false)
    val serialized = mapper.writeValueAsString(weather)
    
    val expected_json = """
      {
        "temp":78,
        "rain":false,
        "snow":false
      }"""
    assertEquals(serialized, expected_json)
}
