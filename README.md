# goldilocks-assessment

Clone this repository into your local system and follow instructions

Convert String to Number package consists of java program to convert decimal string to binary string

CSV Operations folder consists of java program to read and write numeric values from csv file located in classpath

Test-Goldilock folder consists fo spring boot application which executes following 
  - right click on pom.xml file and select open with any IDE you have
  - configure your db details, port in application.properties located in src > main > resources folder
  - locate TestGoldiLockApplication.class and run it
  - application runs on address - "127.0.0.1" and port - "8999", make changes if you need
  - save data to db - "http://127.0.0.1:8999/test?name={value}&age={value}", POST request
  - get user by id - "http://127.0.0.1:8999/test/getById?value={value}", GET request
  - get all users - "http://127.0.0.1:8999/test/getAll", GET request
  - retrieve users by age less than and name starts with letter - "http://127.0.0.1:8999/test/get?age={ageValue}&letter={letter}", GET request
  - retrieve users in key, value format i.e., {"name":age} by providing age value - "http://127.0.0.1:8999/test?value={ageValue}", GET request

Command Line folder consists of program to take command line arguments and print the same in console
  - open Intellij IDE, locate Main.class and right click on it
  - choose Modify Run Configuration and enter the arguments you want to list, in "CLI arguments to your application" tab and apply
  - now run the Main.class
  - OR
  - open folder of Command Line in File explorer and locate src
  - now open command prompt in src folder
  - run javac Main.java
  - run java Main arg1 arg2 arg3 arg4
  - the next few new lines prints the arguments entered in above execution

Goldilock-Secure consists of spring boot application implemented with spring security and frontend connectivity(HTML, CSS, JS)
  - right click on pom.xml file and select open with any IDE you have
  - configure your db details, port in application.properties located in src > main > resources folder
  - locate GoldiLockSecureApplication.class and run it
  - now locate the frontend folder in classpath which consists of frontend HTML, CSS, JS files (I recommend you open this folder in VS Code for better UI and for testing)
  - locate the index.html and open in browser you will have register and sign in buttons
  - Register button redirects you to register.html where you need to register yourself with name, email, password, role and submit
  - if registration is success you will be redirected to login.html page where you need to enter the same email and password
  - if login is success you will be redirected to home.html where you will see your name in big text
  - if login is failure you will get a popup or modal stating "Invalid Credentials" and try again
  - save user - "http://localhost:8880/user/save", POST request
  - retreive user by id - "http://localhost:8880/user/id?userId={value}", GET request
  - retreive user by mail - "http://localhost:8880/user/email?email={value}", GET request
  - retreive all users - "http://localhost:8880/user/all", GET request
  - login - "http://localhost:8880/user/signIn", GET request, it takes Authentication object which is populated with email, password and roles and validates if user details are available in db
  - get user by id, get user by mail have authorization permission only if you are admin, else all paths will be permitted
  - all paths are tested with Postman and respective html pages as well
