### Quickstart:

* Compile the application with gradle and run. Should output something like "Hello World Rest Server started".

* Send an API request with command `curl http://localhost:4567/hello` after launching the rest server program. The output should be "Hello World!"

* Follow the instructions below for more information if needed for set up prior to sending the API request.


### Installation with IntellijIDEA

* Clone git repository using command: `git clone https://github.com/anysolo/toyGraphics-starter.git`
or  
Download [Zip Archive](https://github.com/anysolo/toyGraphics-starter/archive/master.zip) and unpack it.

* Open the directory in IntellijIDEA.

* Wait until IDEA finished downloading and indexing.

* Open file src/main/kotlin/myapp/prg1.kt

* On the left on fun main you should see a green triangle. Click it to start the program. The output should be something like "Hello World Rest Server started"

* To stop the program click red icon on the toolbar.


### Installation with a basic editor (something like nano/vi/vim) on Unix

* Clone git repository using command: `git clone https://github.com/maykish/Kotlin.git`

* Install jdk-11.0.11 from Oracle website online and extract to /opt/ with `tar -xvf <jdk file name> -C /opt/`

* Add Java Environment Variables to the .profile file (name may vary in different linux distributions) with the following lines:
`Extract JAVA_HOME=/opt/jdk-11.0.11`
`Extract PATH=$PATH:/opt/jdk-11.0.11/bin/`

* Check if Java works in the terminal with the `java` command

* Optional: Add syntax highlighting for Kotlin with `git clone https://github.com/udalov/kotlin-vim.git ~/.vim/pack/plugins/start/kotlin-vim`

* Compile the application with the command `./gradlew shadowJar`executed in the project's directory

* Launch the rest server with `java -jar build/libs/<name of compiled jar file from previous step>`. There should be output such as "Hello World Rest Server started" on the screen.

