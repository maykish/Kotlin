### Installation with IntellijIDEA

* Clone git repository using command: `git clone https://github.com/anysolo/toyGraphics-starter.git`
or  
Download [Zip Archive](https://github.com/anysolo/toyGraphics-starter/archive/master.zip) and unpack it.

* Open the directory in IntellijIDEA.

* Wait until IDEA finished downloading and indexing.

* Open file src/main/kotlin/myapp/prg1.kt

* On the left on fun main you should see a green triangle. Click it to start the program.

* To stop the program click red icon on the toolbar.


### Installation with Vim & Linux

* Clone git repository using command: `git clone https://github.com/maykish/Kotlin.git`

* Install jdk-11.0.11 from Oracle website online and extract to /opt/ with `tar -xvf <jdk file name> -C /opt/`

* Add Java Environment Variables to the .profile file (name may vary in different linux distributions) with the following lines:
`Extract JAVA_HOME=/opt/jdk-11.0.11`
`Extract PATH=$PATH:/opt/jdk-11.0.11/bin/`

* Check if Java works in the terminal with the `java` command

* Optional: Add syntax highlighting for Kotlin with `git clone https://github.com/udalov/kotlin-vim.git ~/.vim/pack/plugins/start/kotlin-vim`

* Sign up online for a free tier of the weather api with your own credentials and copy your own API key to the key variable in my program. Create an account on weatherbit to retrieve your own weather data with the link "https://www.weatherbit.io/account/create". Keep in mind that there are limits of usage in the free tier. 

* Compile the application with the command `./gradlew shadowJar`executed in the project's directory

* Launch the rest server with `java -jar build/libs/<name of compiled jar file from previous step>`

* To see the server working, send a request such as `curl https://<ip address of server machine>:4567/weather/:<location>`. The location parameter needs to specify the city name, then the state (abbreviated), and needs to include a country (if outside of United States). This should not include any spaces and instead have a "+" if needed, and commas separating the city, state, and country names. Example: `curl https://XXX.XX.XX.XX:4567/weather/King+George,VA`

* The output should be something like "The Weather in <your location> is <weather name>".

