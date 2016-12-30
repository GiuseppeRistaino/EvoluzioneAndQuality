package group17.weatherviewer;

import java.io.*;
import java.util.ArrayList;

public class UserPreferences implements java.io.Serializable {

    //filename for serialized object
    private static final transient String FILENAME = "weather.prefs";

    //these will be preference fields, many more in final version
    private boolean isCelsius;
    private ArrayList<String> locations;

    /**
     * Constructor of user preferences, initializes locations list and sets default values
     */
    public UserPreferences() {
        //we use celsius by default
        isCelsius = true;
        //intialize empty locations (in the future we will have to prompt user so this will change)
        locations = new ArrayList<String>();
    }

    /**
     * Sets temperature type to celsius (c) or fahrenheit (f)
     * @param b boolean to indicate if temperature type is celsius (true) or fahrenheit (false)
     */
    public void setCelsius (boolean b) {
        isCelsius = b;
    }

    /**
     * Gets temperature type
     * @return true if temperature type is celsius
     */
    public boolean isCelsius() {
        return isCelsius;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    /**
     * Adds a location to the list of favorite locations
     * @param s name of the location
     */
    public void addLocation(String s) throws WeatherException {
        if(!locations.contains(s))
            locations.add(s);
        else
            throw new WeatherException("Location already exists");
    }

    /**
     * Removes a location from the list of favorite locations, if the location is in the list
     * @param s name of the location
     */
    public void removeLocation(String s) throws WeatherException {
        if(locations.contains(s))
            locations.remove(s);
        else
            throw new WeatherException("Location does not exist");
    }

    /**
     * Gives a favorite location identified by index
     * @param index index of the array (from 0 to size - 1)
     * @return the value of the array in given position if index is not out of bounds
     */
    public String getLocation(int index) throws WeatherException {
        try {
            return locations.get(index);
        }
        catch(ArrayIndexOutOfBoundsException ae) {
            throw new WeatherException("Out-of-bounds error in getLocation(int)", ae);
        }
    }

    /**
     * Saves a copy of the provided preferences object to the working directory in a file called FILENAME.
     * @param up is the preferences object to be serialized to a file for the next run.
     */
    public static void savePrefs(UserPreferences up) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
        oos.writeObject(up);
        oos.close();
    }

    /**
     * Finds the FILENAME file in the working directory and loaded the serialized object, then returns it.
     * Allows loading of preferences at the start of a program run.
     */
    public static UserPreferences getPrefs() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        Object o;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILENAME));
            o = ois.readObject();
        }
        catch(FileNotFoundException | NullPointerException e) {
            //need to create a new set of preferences if one doesn't exist
            return new UserPreferences();
        } finally {
            if(ois != null)
                ois.close();
        }
        return (UserPreferences)o;
    }
}
