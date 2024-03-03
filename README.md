This API gets the current weather report for a requested location from weatherapi.com and sends it as a response. 


Prerequisites for installation: 
1) Java IDE (IntelliJ recommended) with JDK 21 (older versions can possible work, but it is not guaranteed) for managing and running the program
2) MySQL DB to store the weather reports for different locations
3) Postman or a browser to send requests to the program and to display the response
4) An account and an API KEY from https://www.weatherapi.com


Installation steps: 
1) Open the project in your Java IDE
2) To use this API, you will need to register to https://www.weatherapi.com and get yourself an API KEY.
3) Go to src/main/resources/application.properties and set spring.datasource.username and spring.datasource.password properties to your DB credentials. Also set weatherapi.apikey to your weatherapi.com API_KEY. This step is important and program will not work without it. 
4) Run the program
5) Use Postman or Browser to send GET requests to the URL below. {city_name} is a placeholder and you should replace it with a city name of your choice.
http://localhost:8081/weatherapi/getWeather/{city_name}
For example: http://localhost:8081/weatherapi/getWeather/london will give you the weather report for London. You can also change the port number in the application.properties file.


