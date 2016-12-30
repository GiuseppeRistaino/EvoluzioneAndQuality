package group17.weatherviewer;

import java.io.UnsupportedEncodingException;
import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShortTermForecast {
	
	private String time, skyCon;
	private double temp, rain, snow;
	private double totalRain = 0, totalSnow = 0;
	private int weatherID;

	// arraylist of all weather information
	private ArrayList<ShortTermWeather> shortTermForecast = new ArrayList<ShortTermWeather>();

	public ShortTermForecast(String cityName)
			throws UnsupportedEncodingException {

		final String key = "&APPID=65da394090951035f3a346d9a356ddd9";// api key

		String Url = "http://api.openweathermap.org/data/2.5/forecast?q="
				+ cityName + "&type=accurate&mode=json" + key;

		// send link to json parser and get weather data back as string
		JsonParser Data = new JsonParser(Url);
		String DataStr = Data.getData();

		// Save all weather information
		JSONObject JsonData = JSONObject.fromObject(DataStr);
		JSONArray Arraylist = JsonData.getJSONArray("list");

		// Short term shows every 3 hours forecast, 3X8=24 hours forecast
		for (int i = 0; i < 8; i++) {
			// every 3 hours forecast
			JSONObject ObjList = Arraylist.getJSONObject(i);

			JSONObject ObjMain = ObjList.getJSONObject("main");
			temp = ObjMain.getDouble("temp")-273;// temperature

			// rain
			if (ObjList.containsKey("rain")) {

				JSONObject ObjRain = ObjList.getJSONObject("rain");
				rain = ObjRain.getDouble("3h");

			} else {
				rain = 0;
			}

			totalRain += rain;// total rain

			// snow
			if (ObjList.containsKey("snow")) {
				JSONObject ObjSnow = ObjList.getJSONObject("snow");
				snow = ObjSnow.getDouble("3h");

			} else {
				snow = 0;
				
			}

			totalSnow += snow;// total snow

			JSONArray ArraySky = ObjList.getJSONArray("weather");
			JSONObject ObjSky = ArraySky.getJSONObject(0);
			skyCon = ObjSky.getString("description");// sky description
			weatherID = ObjSky.getInt("id"); //weatherID
			time = ObjList.getString("dt_txt");// date
			
			shortTermForecast.add(new ShortTermWeather(time, skyCon, temp, rain, snow, weatherID));
		}
	}
	
	//getter methods
	
	//returns the total precipitation
	public String getTotalPrecipitation(){
		double totalPrecip = totalRain + totalSnow;
		if (0 < totalPrecip && totalPrecip < 1)
			return "< 1";
		else
			return String.valueOf(Math.round(totalPrecip));
	}

	
	//returns weather information
	public ArrayList<ShortTermWeather> getShortTermForecast(){
		return this.shortTermForecast;
	}
	
	//helper class
	public class ShortTermWeather{
		private String time, skycon; 
		private double temp, rain, snow;
		private int weatherID;
		
		public ShortTermWeather(String time, String skycon, double temp, double rain, double snow, int weatherID){
			this.time = time;
			this.skycon = skycon;
			this.temp = temp;
			this.rain = rain;
			this.snow = snow;
			this.weatherID = weatherID;
		}
		
		//getter methods
		
		public String getTime(){
			return this.time;
		}
		
		public String getSkyCon(){
			return this.skycon;
		}
		
		/**
	     * Getter method for Celsius temperature
	     * @return the current temp in degrees C (will be only temp method in later versions)
	     */
		public String getTemp(char tempUnit) {
			if(tempUnit == 'f')
	            return cleanTemp(temp * 9 / 5 + 32, tempUnit);
	        else
	            return cleanTemp(temp, tempUnit);
		}

	    //puts the temperature into a readable form
	    private String cleanTemp(double t, char unit) {
	        int substringLength = 1;
	        //correct for negative zero
	        if(t < 0 && t >= -1)
	            t = 0;
	        //correct number of characters to take
	        if (t < 0 || t > 10) {
	            substringLength++;
	            if(t < -10)
	                substringLength++;
	        }
	        return String.valueOf(t).substring(0,substringLength) + '°' + Character.toUpperCase(unit);
	    }

	    public String getRain(){
			if (0 < this.rain && this.rain < 1)
				return "< 1";	
			else
				return String.valueOf(Math.round(this.rain));
		}
		
		public String getSnow(){
			if (0 < this.snow && this.snow < 1)
				return "< 1";	
			else
				return String.valueOf(Math.round(this.snow));
		}
		
		public String getSkyCondition() {
			return skyCon.substring(0, 1).toUpperCase() + skyCon.substring(1);
		}
		
		public int getWeatherID(){
			return this.weatherID;	
		}
	}
}
	


