package group17.weatherviewer;

import java.io.*;
import java.util.ArrayList;

public class UserPreferences implements java.io.Serializable {

    //filename for serialized object - not stored
    private static final transient String FILENAME = "weather.prefs";
    //allows versioning without changing weather.prefs
    private static final long serialVersionUID =  5423608160937997909L;
    //preference fields to be serialized
    private char tempUnit;
    private ArrayList<String> locations;
    private String defaultLocation;

    /**
     * Constructor of user preferences, initializes locations list and sets default values
     */
    public UserPreferences() {
        //intialize empty locations (in the future we will have to prompt user so this will change)
        locations = new ArrayList<>();
        tempUnit = 'c';
        defaultLocation = "";
    }

    /**
     * Sets temperature type to celsius (c) or fahrenheit (f)
     * we can trust that the appropriate units are given because the user has no input for this
     * @param unit char to indicate temperature type, can be either celsius (c) or fahrenheit (f)
     */
    public void setTempUnit(char unit) {
        if(unit == 'c' || unit == 'f') { //maybe a try/catch?
            tempUnit = unit;
        }
    }

    /**
     * Sets default location to the last selected location
     * @param location string representing the new default location
     */
    public void setDefaultLocation(String location){
    	this.defaultLocation = location;
    }
    /**
     * Gets temperature unit
     * @return c for celsius, f for fahrenheit
     */
    public char getTempUnit() {
        return tempUnit;
    }
    /**
     * Gets location list
     * @return an ArrayList<String> of locations
     */
    public ArrayList<String> getLocations() {
        return locations;
    }
    
    /**
     * Gets defaultLocation
     * @return the default location
     */
    public String getDefaultLocation(){
    	return defaultLocation;
    }

    /**
     * Adds a location to the list of favorite locations in a certain position
     * @param index provides where in the list the element should be added
     * @param s name of the location
     * @return false if the adding failed, true otherwise
     */
     public boolean addLocation(int index, String s) {
        if(!locations.contains(s)) {
            locations.add(index, s);
            return true;
        }
        else
            return false;
    }

    /**
     * Saves a copy of the provided preferences object to the working directory in a file called FILENAME.
     * @param up is the preferences object to be serialized to a file for the next run.
     */
    public static void savePrefs(UserPreferences up) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(up);
            oos.close();
        }
        catch(IOException e) {
            System.out.println("Saving user preferences failed! Due to:");
            e.printStackTrace();
        }
    }

    /**
     * Finds the FILENAME file in the working directory and loaded the serialized object, then returns it.
     * Allows loading of preferences at the start of a program run.
     */
    public static UserPreferences getPrefs() {
        ObjectInputStream ois;
        Object o;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILENAME));
            o = ois.readObject();
        }
        catch(IOException | NullPointerException | ClassNotFoundException e) {
            //need to create a new set of preferences if one doesn't exist
            return new UserPreferences();
        }
        if(o instanceof UserPreferences)
            return (UserPreferences)o;
        else {
            //this block will never be executed
            System.out.println("Something went seriously wrong loading preferences");
            return new UserPreferences();
        }
    }
}
