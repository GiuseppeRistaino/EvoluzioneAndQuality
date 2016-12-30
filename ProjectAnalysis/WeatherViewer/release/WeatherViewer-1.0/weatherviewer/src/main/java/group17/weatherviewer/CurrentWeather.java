package group17.weatherviewer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

//A data type class to hold all necessary information for the Current Weather view.
public class CurrentWeather {

    //Data fields required for Current Weather view
	private String City, Sky, Sunrise, Sunset, Country;
	private double Temp, Pressure, Humidity, TempMax, TempMin, WindSpeed,
			WindDir;

    /**
     * Constructor for CurrentWeather
     * Takes a City name as parameter, retrieves and parses the JSON for that city and stores the data
     * @param CityName is the name of the city for which we're storing and parsing information
     * @throws UnsupportedEncodingException if the JSOn retrieval fails
     */
	public CurrentWeather(String CityName) throws UnsupportedEncodingException {

		StringBuffer SBR;

		// get weather information from http://api.openweathermap.org for given
		// city
		// 65da394090951035f3a346d9a356ddd9 api key from OpenWeatherMap
		String OwmUrl = "http://api.openweathermap.org/data/2.5/weather?q="
				+ CityName + "&APPID=65da394090951035f3a346d9a356ddd9";

		// get current weather data from openweathermap.org in JSON format
		SBR = new StringBuffer();

		try {
			URL url = new URL(OwmUrl);
			URLConnection connection = url.openConnection();
			BufferedReader BReader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = null;
			while ((line = BReader.readLine()) != null)
				SBR.append(line + " ");
			BReader.close();
		} catch (IOException e) {
            e.printStackTrace();
        }

		String WeatherData = SBR.toString();

		// parse JSON data, JSON_Data:WeatherData

		JSONObject JsonData = JSONObject.fromObject(WeatherData);
        // Save all weather information��

		// get information from sys object
		JSONObject Obj_Sys = JsonData.getJSONObject("sys");// country
		Country = Obj_Sys.getString("country");
		Sunrise = Obj_Sys.getString("sunrise");
		Sunset = Obj_Sys.getString("sunset");

		// get information from string
		City = JsonData.getString("name");// city

		// get information from main object
		JSONObject Obj_Main = JsonData.getJSONObject("main");
		Temp = Obj_Main.getDouble("temp");// temperature
		Pressure = Obj_Main.getDouble("pressure"); // pressure
		Humidity = Obj_Main.getDouble("humidity");// humidity
		TempMin = Obj_Main.getDouble("temp_min");// min temperature
		TempMax = Obj_Main.getDouble("temp_max");// max temperature

		// get information from wind object
		JSONObject Obj_wind = JsonData.getJSONObject("wind");
		WindSpeed = Obj_wind.getDouble("speed");// wind speed
		WindDir = Obj_wind.getDouble("deg");// wind direction

		// get information from weather object
		JSONArray Array_Weather = JsonData.getJSONArray("weather");
		JSONObject Obj_Wea = Array_Weather.getJSONObject(0);
		Sky = Obj_Wea.getString("description");

		
	}

	// Getters -> Modified to return Strings instead of Doubles -TE

    /**
     * Getter method for City
     * @return the city from which this weather data was gathered
     */
    public String getCity() {
        if(City != null)    return City;
        else                return "ERR";
    }

    /**
     * Getter method for WindSpeed
     * @return the current wind speed
     */
	public String getWindSpeed() {
		return String.valueOf(WindSpeed);
	}
    /**
     * Getter method for Pressure
     * @return the current pressure
     */
	public String getPressure() {
		return String.valueOf(Pressure);
	}

    /**
     * Getter method for Humidity
     * @return the current humidity in %
     */
	public String getHumidity() {
		return String.valueOf(Humidity);
	}
    /**
     * Getter method for Sunrise
     * @return the current Sunrise time in Unix time
     */
	public String getSunriseTime() {
		return Sunrise;
	}
    /**
     * Getter method for Sunset
     * @return the current Sunset time in Unix time
     */
	public String getSunsetTime() {
		return Sunset;
	}
    /**
     * Getter method for wind direction
     * @return the current wind direction in degrees
     */
	public String getWindDirection() {
		return String.valueOf(WindDir);
	}

    /**
     * Getter method for Celsius temperature
     * @return the current temp in degrees C (will be only Temp method in later versions)
     */
	public String getTemp() {
		return getTempC();
	}
    /**
     * Helper method for Celsius temperature
     * @return the current temp in degrees C (will phase this out in later versions)
     */
	public String getTempC() {
        return String.valueOf(Temp - 273); 
    }
    /**
     * Getter method for Fahrenheit temperature
     * @return the current temp in degrees F (will phase this out in later versions)
     */
	public String getTempF() {
        return String.valueOf(((Temp - 273) * 9 / 5.0) + 32);
    }
    /**
     * Getter method for max Celsius temperature
     * Same story as getTemp()s, will be the only getTempMax method later.
     * @return the current max temp in degrees C
     */
	public String getTempMax() {
		return getMaxTempC();
	}
    /**
     * Getter method for max Celsius temperature
     * @return the current max temp in degrees C
     */
	public String getMaxTempC() {
        return String.valueOf(TempMax - 273);
    }
    /**
     * Getter method for max F temperature
     * @return the current max temp in degrees F
     */
	public String getTempMaxF() {
        return String.valueOf(((TempMax - 273) * 9 / 5.0) + 32);
    }
    /**
     * Getter method for min Celsius temperature
     * Same story as getTemp()s, will be the only getTempMax method later.
     * @return the current min temp in degrees C
     */
	public String getTempMin() {
		return getTempMinC();
	}
    /**
     * Getter method for min Celsius temperature
     * @return the current min temp in degrees C
     */
	public String getTempMinC() {
        return String.valueOf(TempMin - 273);
    }
    /**
     * Getter method for min F temperature
     * @return the current min temp in degrees f
     */
    public String getTempMinF() {
        return String.valueOf(((TempMin - 273) * 9 / 5.0) + 32);
    }
    /**
     * Getter method for country name
     * @return the name of the country the city is in
     */
	public String getCountry() {
		return Country;
	}

    /**
     * Getter method for sky condition
     * @return a string representing sky condition
     */
	public String getSkyCondition() {
		return Sky;
	}

	/* Setters (almost certainly not needed)
	public void setCity(String City) {
		this.City = City;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public void setTemp(double Temp) {
		this.Temp = Temp;
	}

	public void setPressure(double Pressure) {
		this.Pressure = Pressure;
	}

	public void setHumidity(double Humidity) {
		this.Humidity = Humidity;
	}

	public void setTempMin(double TempMin) {
		this.TempMin = TempMin;
	}

	public void setTempMax(double TempMax) {
		this.TempMax = TempMax;
	}

	public void setWinddirection(double WindDir) {
		this.WindDir = WindDir;
	}

	public void setWindspeed(double Windspeed) {
		this.WindSpeed = Windspeed;
	}

	public void setSky(String Sky) {
		this.Sky = Sky;
	}

	public void setSunrise(String Sunrise) {
		this.Sunrise = Sunrise;
	}

	public void setSunset(String Sunset) {
		this.Sunset = Sunset;
	}*/

    /**
     * Purely for testing purposes, will be taken out in later versions.
     * @param args command line arguments
     */
	public static void main(String[] args) {
		try {
			CurrentWeather test = new CurrentWeather("Shanghai,CN"); // using shanghai CN to test
			System.out.println( test.getCountry()+ "\n" + test.getCity() + "\n" + test.getTemp() + "\n"
					+ test.getPressure() + "\n" + test.getHumidity() + "\n" + test.getTempMin() + "\n" + test.getTempMax()
					+ "\n" + test.getWindSpeed() + "\n" + test.getWindDirection() + "\n" + test.getSkyCondition() + "\n"
					+ test.getSunriseTime() + "\n" + test.getSunsetTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
