package group17.weatherviewer;

import group17.weatherviewer.ShortTermForecast.ShortTermWeather;
import group17.weatherviewer.LongTermForecast.LongTermWeather;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainFrame {

	// this is incredibly messy
	// a lot of these can be local fields too
	private static Font font;

	private JFrame frame;

	private ImageIcon backgroundImage;
	private String skyConditionIconLarge;
	private String skyConditionIconSmall;
	private String skyConditionBackground;

	private JLabel backgroundLabel;

	private JTextField textField;
	private JTextField barSearch;

	private JScrollPane scrollPane;

	private JButton buttonFavourite;
	private JButton buttonLongTerm;
	private JButton buttonShortTerm;
	private JButton buttonRefresh;
	private JButton buttonToCelsius;
	private JButton buttonToFahrenheit;
	private JLabel labelSkyConditionIcon;
	private JLabel labelAirPressure;
	private JLabel labelSunrise;
	private JLabel labelSunset;
	private JLabel labelSky;
	private JLabel labelWind;
	private JLabel labelHumidity;
	private JLabel labelLocation;
	private JLabel labelPrecipitation;
	private JLabel labelTempInfo;
	private JLabel labelWindInfo;
	private JLabel labelHumidityInfo;
	private JLabel labelAirPressureInfo;
	private JLabel labelCurrentMMTempInfo;
	private JLabel labelSunriseInfo;
	private JLabel labelSunsetInfo;
	private JLabel labelSkyConditionInfo;
	private JLabel labelPrecipitationInfo;
	private JLabel labelUpdated;
	private JLabel labelUpdatedInfo;
	private JLabel label12AM;
	private JLabel label12AMSkyConditionIcon;
	private JLabel label12AMTempInfo;
	private JLabel label12AMSkyConditionInfo;
	private JLabel label12AMPrecipitation;
	private JLabel label3AM;
	private JLabel label3AMSkyConditionIcon;
	private JLabel label3AMTempInfo;
	private JLabel label3AMSkyConditionInfo;
	private JLabel label3AMPrecipitation;
	private JLabel label6AM;
	private JLabel label6AMSkyConditionIcon;
	private JLabel label6AMTempInfo;
	private JLabel label6AMSkyConditionInfo;
	private JLabel label6AMPrecipitation;
	private JLabel label9AM;
	private JLabel label9AMSkyConditionIcon;
	private JLabel label9AMTempInfo;
	private JLabel label9AMSkyConditionInfo;
	private JLabel label9AMPrecipitation;
	private JLabel label12PM;
	private JLabel label12PMSkyConditionIcon;
	private JLabel label12PMTempInfo;
	private JLabel label12PMSkyConditionInfo;
	private JLabel label12PMPrecipitation;
	private JLabel label3PM;
	private JLabel label3PMSkyConditionIcon;
	private JLabel label3PMTempInfo;
	private JLabel label3PMSkyConditionInfo;
	private JLabel label3PMPrecipitation;
	private JLabel label6PM;
	private JLabel label6PMSkyConditionIcon;
	private JLabel label6PMTempInfo;
	private JLabel label6PMSkyConditionInfo;
	private JLabel label6PMPrecipitation;
	private JLabel label9PM;
	private JLabel label9PMSkyConditionIcon;
	private JLabel label9PMTempInfo;
	private JLabel label9PMSkyConditionInfo;
	private JLabel label9PMPrecipitation;
	private JLabel labelDay1Info;
	private JLabel labelDay1TempInfo;
	private JLabel labelDay1MMTempInfo;
	private JLabel labelDay1SkyConditionIcon;
	private JLabel labelDay1SkyConditionInfo;
	private JLabel labelDay1PrecipitationInfo;
	private JLabel labelDay2Info;
	private JLabel labelDay2TempInfo;
	private JLabel labelDay2MMTempInfo;
	private JLabel labelDay2SkyConditionInfo;
	private JLabel labelDay2SkyConditionIcon;
	private JLabel labelDay2PrecipitationInfo;
	private JLabel labelDay3Info;
	private JLabel labelDay3TempInfo;
	private JLabel labelDay3MMTempInfo;
	private JLabel labelDay3SkyConditionInfo;
	private JLabel labelDay3SkyConditionIcon;
	private JLabel labelDay3PrecipitationInfo;
	private JLabel labelDay4Info;
	private JLabel labelDay4TempInfo;
	private JLabel labelDay4MMTempInfo;
	private JLabel labelDay4SkyConditionInfo;
	private JLabel labelDay4SkyConditionIcon;
	private JLabel labelDay4PrecipitationInfo;
	private JLabel labelDay5Info;
	private JLabel labelDay5TempInfo;
	private JLabel labelDay5MMTempInfo;
	private JLabel labelDay5SkyConditionInfo;
	private JLabel labelDay5SkyConditionIcon;
	private JLabel labelDay5PrecipitationInfo;
	private JLabel labelDay6Info;
	private JLabel labelDay6TempInfo;
	private JLabel labelDay6MMTempInfo;
	private JLabel labelDay6SkyConditionInfo;
	private JLabel labelDay6SkyConditionIcon;
	private JLabel labelDay6PrecipitationInfo;
	private JLabel labelDay7Info;
	private JLabel labelDay7TempInfo;
	private JLabel labelDay7MMTempInfo;
	private JLabel labelDay7SkyConditionInfo;
	private JLabel labelDay7SkyConditionIcon;
	private JLabel labelDay7PrecipitationInfo;

	private DateFormat dateFormat;
	private Calendar cal;
	private String lastUpdated;

	private JList listLocations;
	private DefaultListModel listModel;

	private UserPreferences prefs;

	private CurrentWeather currentWeather;
	private ShortTermForecast shortTermForecast;
	private LongTermForecast longTermForecast;

	private ArrayList<JLabel> shortTermTime = new ArrayList<JLabel>();
	private ArrayList<JLabel> shortTermIcon = new ArrayList<JLabel>();
	private ArrayList<JLabel> shortTermSkyCon = new ArrayList<JLabel>();
	private ArrayList<JLabel> shortTermTemp = new ArrayList<JLabel>();
	private ArrayList<JLabel> shortTermPrecip = new ArrayList<JLabel>();

	private ArrayList<JLabel> longTermDate = new ArrayList<JLabel>();
	private ArrayList<JLabel> longTermIcon = new ArrayList<JLabel>();
	private ArrayList<JLabel> longTermSkyCon = new ArrayList<JLabel>();
	private ArrayList<JLabel> longTermTemp = new ArrayList<JLabel>();
	private ArrayList<JLabel> longTermHighLow = new ArrayList<JLabel>();
	private ArrayList<JLabel> longTermPrecip = new ArrayList<JLabel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//grab the preferences from weather.prefs and store a reference to the preferences object
		prefs = UserPreferences.getPrefs();
		//initialize the font
		createFont();

		/// BEGIN INITIALIZING FRAME ///
		
		backgroundImage = new ImageIcon(getClass().getResource(
				"/backgrounds/default.jpg"));
		backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setSize(800, 570);
		frame = new JFrame("Group 17 Weather Viewer");
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 570);
		frame.setContentPane(backgroundLabel);
		frame.setResizable(false);

		// this window listener contains a method windowClosing which is called
		// whenever the window is closed
		// therefore, we need to save preferences and anything else we do upon
		// closing here. -TE
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				// save the preferences
				UserPreferences.savePrefs(prefs);
				frame.dispose();
			}
		});

		/// END INITIALIZING FRAME ///

		/// BEGIN INITIALIZING LOCAL WEATHER VIEW PANEL ///

		// city label
		final String labelLocationInit = "Please select or enter in a city.";
		labelLocation = new JLabel("");
		labelLocation.setText(labelLocationInit);
		labelLocation.setForeground(Color.WHITE);
		labelLocation.setFont(font.deriveFont(17f));
		labelLocation.setBounds(50, 20, 300, 37);
		frame.getContentPane().add(labelLocation);

		// temperature label
		labelTempInfo = new JLabel("");
		labelTempInfo.setFont(font.deriveFont(85f));
		labelTempInfo.setForeground(Color.WHITE);
		labelTempInfo.setBounds(50, 50, 318, 94);
		frame.getContentPane().add(labelTempInfo);

		// wind label
		labelSky = new JLabel("Sky:");
		labelSky.setForeground(Color.LIGHT_GRAY);
		labelSky.setFont(font.deriveFont(15f));
		labelSky.setBounds(50, 150, 61, 15);
		// frame.getContentPane().add(labelSky);

		// wind label
		labelWind = new JLabel("Wind Speed:");
		labelWind.setForeground(Color.LIGHT_GRAY);
		labelWind.setFont(font.deriveFont(15f));
		labelWind.setBounds(50, 200, 100, 15);
		frame.getContentPane().add(labelWind);

		// humidity label
		labelHumidity = new JLabel("Humidity:");
		labelHumidity.setForeground(Color.LIGHT_GRAY);
		labelHumidity.setFont(font.deriveFont(15f));
		labelHumidity.setBounds(50, 225, 70, 15);
		frame.getContentPane().add(labelHumidity);

		// air pressure label
		labelAirPressure = new JLabel("Air Pressure:");
		labelAirPressure.setForeground(Color.LIGHT_GRAY);
		labelAirPressure.setFont(font.deriveFont(15f));
		labelAirPressure.setBounds(50, 250, 96, 15);
		frame.getContentPane().add(labelAirPressure);

		// sunrise label
		labelSunrise = new JLabel("Sunrise:");
		labelSunrise.setForeground(Color.LIGHT_GRAY);
		labelSunrise.setFont(font.deriveFont(15f));
		labelSunrise.setBounds(350, 200, 61, 15);
		frame.getContentPane().add(labelSunrise);

		// sunset label
		labelSunset = new JLabel("Sunset:");
		labelSunset.setForeground(Color.LIGHT_GRAY);
		labelSunset.setFont(font.deriveFont(15f));
		labelSunset.setBounds(350, 225, 58, 15);
		frame.getContentPane().add(labelSunset);

		// precipitation label
		labelPrecipitation = new JLabel("Precipitation:");
		labelPrecipitation.setForeground(Color.LIGHT_GRAY);
		labelPrecipitation.setFont(font.deriveFont(15f));
		labelPrecipitation.setBounds(350, 250, 98, 15);
		frame.getContentPane().add(labelPrecipitation);

		// updated label
		labelUpdated = new JLabel("Last Updated:");
		labelUpdated.setForeground(Color.LIGHT_GRAY);
		labelUpdated.setFont(font.deriveFont(15f));
		labelUpdated.setBounds(150, 285, 98, 15);
		frame.getContentPane().add(labelUpdated);

		// wind info
		labelWindInfo = new JLabel("");
		labelWindInfo.setForeground(Color.WHITE);
		labelWindInfo.setFont(font.deriveFont(15f));
		labelWindInfo.setBounds(150, 200, 200, 15);
		frame.getContentPane().add(labelWindInfo);

		// humidity info
		labelHumidityInfo = new JLabel("");
		labelHumidityInfo.setForeground(Color.WHITE);
		labelHumidityInfo.setFont(font.deriveFont(15f));
		labelHumidityInfo.setBounds(150, 225, 200, 15);
		frame.getContentPane().add(labelHumidityInfo);

		// air pressure info
		labelAirPressureInfo = new JLabel("");
		labelAirPressureInfo.setForeground(Color.WHITE);
		labelAirPressureInfo.setFont(font.deriveFont(15f));
		labelAirPressureInfo.setBounds(150, 250, 200, 15);
		frame.getContentPane().add(labelAirPressureInfo);

		// max/min temp info
		labelCurrentMMTempInfo = new JLabel("");
		labelCurrentMMTempInfo.setForeground(Color.WHITE);
		labelCurrentMMTempInfo.setFont(font.deriveFont(17f));
		labelCurrentMMTempInfo.setBounds(75, 135, 200, 15);
		frame.getContentPane().add(labelCurrentMMTempInfo);

		// sunrise info
		labelSunriseInfo = new JLabel("");
		labelSunriseInfo.setForeground(Color.WHITE);
		labelSunriseInfo.setFont(font.deriveFont(15f));
		labelSunriseInfo.setBounds(450, 200, 200, 15);
		frame.getContentPane().add(labelSunriseInfo);

		// sunset info
		labelSunsetInfo = new JLabel("");
		labelSunsetInfo.setForeground(Color.WHITE);
		labelSunsetInfo.setFont(font.deriveFont(15f));
		labelSunsetInfo.setBounds(450, 225, 200, 15);
		frame.getContentPane().add(labelSunsetInfo);

		// precipitation info
		labelPrecipitationInfo = new JLabel("");
		labelPrecipitationInfo.setForeground(Color.WHITE);
		labelPrecipitationInfo.setFont(font.deriveFont(15f));
		labelPrecipitationInfo.setBounds(450, 250, 200, 15);
		frame.getContentPane().add(labelPrecipitationInfo);

		// sky condition info
		labelSkyConditionInfo = new JLabel("");
		labelSkyConditionInfo.setForeground(Color.WHITE);
		labelSkyConditionInfo.setFont(font.deriveFont(17f));
		labelSkyConditionInfo.setBounds(75, 155, 200, 30);
		frame.getContentPane().add(labelSkyConditionInfo);

		// sky condition icon info
		labelSkyConditionIcon = new JLabel();
		labelSkyConditionIcon.setBounds(310, 15, 204, 181);
		frame.getContentPane().add(labelSkyConditionIcon);

		// updated label info
		labelUpdatedInfo = new JLabel("");
		labelUpdatedInfo.setForeground(Color.WHITE);
		labelUpdatedInfo.setFont(font.deriveFont(15f));
		labelUpdatedInfo.setBounds(260, 285, 98, 15);
		frame.getContentPane().add(labelUpdatedInfo);
		// date format shown in updated label
		dateFormat = new SimpleDateFormat("MMM dd HH:mm");

		// refresh button
		buttonRefresh = new JButton("");
		buttonRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loc = labelLocation.getText();
				if (!(loc.equalsIgnoreCase(labelLocationInit)))
					refresh(labelLocation.getText());
				else
					labelLocation.setText(labelLocationInit);
			}
		});
		buttonRefresh.setIcon(new ImageIcon(getClass().getResource(
				"/icons/refresh_icon.png")));
		buttonRefresh.setBounds(540, 16, 41, 37);
		buttonRefresh.setOpaque(false);
		buttonRefresh.setContentAreaFilled(false);
		buttonRefresh.setBorderPainted(false);
		frame.getContentPane().add(buttonRefresh);

		// short term button
		buttonShortTerm = new JButton("Short Term");
		buttonShortTerm.setForeground(Color.WHITE);
		buttonShortTerm.setFont(font.deriveFont(14f));
		buttonShortTerm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toggleShortTerm(true);
			}
		});
		buttonShortTerm.setOpaque(false);
		buttonShortTerm.setContentAreaFilled(false);
		buttonShortTerm.setBorderPainted(false);
		buttonShortTerm.setBounds(19, 328, 120, 29);
		frame.getContentPane().add(buttonShortTerm);

		// long term button
		buttonLongTerm = new JButton("Long Term");
		buttonLongTerm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleShortTerm(false);
			}
		});

		buttonLongTerm.setOpaque(false);
		buttonLongTerm.setForeground(Color.GRAY);
		buttonLongTerm.setFont(font.deriveFont(14f));
		buttonLongTerm.setContentAreaFilled(false);
		buttonLongTerm.setBorderPainted(false);
		buttonLongTerm.setBounds(95, 328, 127, 29);
		frame.getContentPane().add(buttonLongTerm);

		// toCelsius button
		buttonToCelsius = new JButton("°C");
		buttonToCelsius.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// set preferences to celsius
				prefs.setTempUnit('c');
				buttonToCelsius.setForeground(Color.WHITE);
				buttonToFahrenheit.setForeground(Color.GRAY);
				setTemperatureFields();
			}
		});
		buttonToCelsius.setOpaque(false);

		buttonToCelsius.setFont(font.deriveFont(18f));
		buttonToCelsius.setContentAreaFilled(false);
		buttonToCelsius.setBorderPainted(false);
		buttonToCelsius.setBounds(475, 283, 75, 29);

		// toFarenheit button
		buttonToFahrenheit = new JButton("°F");
		buttonToFahrenheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// set preferences to f
				prefs.setTempUnit('f');
				buttonToFahrenheit.setForeground(Color.WHITE);
				buttonToCelsius.setForeground(Color.GRAY);
				setTemperatureFields();
			}
		});
		buttonToFahrenheit.setOpaque(false);

		buttonToFahrenheit.setFont(font.deriveFont(18f));
		buttonToFahrenheit.setContentAreaFilled(false);
		buttonToFahrenheit.setBorderPainted(false);
		buttonToFahrenheit.setBounds(520, 283, 70, 29);
		// update the buttons to the color they should be initially
		if (prefs.getTempUnit() == 'c') {
			buttonToCelsius.setForeground(Color.WHITE);
			buttonToFahrenheit.setForeground(Color.GRAY);
		} else {
			buttonToCelsius.setForeground(Color.GRAY);
			buttonToFahrenheit.setForeground(Color.WHITE);
		}

		frame.getContentPane().add(buttonToCelsius);
		frame.getContentPane().add(buttonToFahrenheit);

		/// END INITIALIZATION OF LOCAL WEATHER VIEW PANEL ///

		/// BEGIN INITIALIZATION OF LOCATIONS PANEL ///

		// scroll pane
		scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(595, 56, 205, 255);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		Border scrollBorder = BorderFactory.createLineBorder(new Color(255,
				255, 255, 40));
		scrollPane.setBorder(scrollBorder);
		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);

		// locations list
		listModel = new DefaultListModel();
		
		// Add saved locations to current list
		for (String loc : prefs.getLocations()) { // loads the MyLocations arraylist into listModel
			listModel.addElement(loc);
		}

		listLocations = new JList(listModel);
		listLocations.setOpaque(false);
		listLocations.setBackground(new Color(0, 0, 0, 0));
		listLocations.setForeground(Color.WHITE);
		ListSelectionModel lsm = listLocations.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!listLocations.getValueIsAdjusting()){
					String selectedLocation = listLocations.getSelectedValue().toString();
					refresh(selectedLocation);
					prefs.setDefaultLocation(selectedLocation);
				}
			}

		});
		scrollPane.setViewportView(listLocations);

		// favorite button
		buttonFavourite = new JButton();
		AddLocation addlocation = new AddLocation(buttonFavourite);
		buttonFavourite.addActionListener(addlocation);
		buttonFavourite.setEnabled(false);
		buttonFavourite.setIcon(new ImageIcon(getClass().getResource(
				"/icons/star_icon.png")));
		buttonFavourite.setOpaque(false);
		buttonFavourite.setContentAreaFilled(false);
		buttonFavourite.setBorderPainted(false);
		buttonFavourite.setBounds(762, 16, 41, 37);
		frame.getContentPane().add(buttonFavourite);

		// search bar
		barSearch = new JTextField();
		barSearch.setText("Search (City, Country)");
		barSearch.setToolTipText("Enter new locations here!");
		barSearch.setForeground(Color.WHITE);
		barSearch.addActionListener(addlocation);
		barSearch.getDocument().addDocumentListener(addlocation);
		barSearch.setBounds(595, 16, 171, 37);
		barSearch.setBackground(new Color(0, 0, 0, 0));
		barSearch.setOpaque(false);
		barSearch.setColumns(10);
		Border searchBorder = BorderFactory.createLineBorder(new Color(255,
				255, 255, 40));
		barSearch.setBorder(searchBorder);
		barSearch.setVisible(true);
		barSearch.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (barSearch.getText().equals("Search (City, Country)"))
					barSearch.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (barSearch.getText().equals(""))
					barSearch.setText("Search (City, Country)");
			}
		});
		frame.getContentPane().add(barSearch);

		/// END INITIALIZATION OF LOCATIONS PANEL ///

		/// BEGIN INITIALIZATION OF SHORT-TERM FORECAST PANEL ///

		// 12AM
		// time
		label12AM = new JLabel("");
		shortTermTime.add(label12AM);
		label12AM.setForeground(Color.LIGHT_GRAY);
		label12AM.setFont(font.deriveFont(15f));
		label12AM.setBounds(80, 360, 58, 15);
		frame.getContentPane().add(label12AM);
		// icon
		label12AMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label12AMSkyConditionIcon);
		label12AMSkyConditionIcon.setBounds(70, 380, 55, 49);
		frame.getContentPane().add(label12AMSkyConditionIcon);
		// sky condition
		label12AMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label12AMSkyConditionInfo);
		label12AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label12AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label12AMSkyConditionInfo.setBounds(80, 470, 75, 50);
		frame.getContentPane().add(label12AMSkyConditionInfo);
		// temperature
		label12AMTempInfo = new JLabel("");
		shortTermTemp.add(label12AMTempInfo);
		label12AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label12AMTempInfo.setFont(font.deriveFont(15f));
		label12AMTempInfo.setBounds(80, 435, 58, 25);
		frame.getContentPane().add(label12AMTempInfo);
		// precipitation
		label12AMPrecipitation = new JLabel("");
		shortTermPrecip.add(label12AMPrecipitation);
		label12AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label12AMPrecipitation.setFont(font.deriveFont(15f));
		label12AMPrecipitation.setBounds(80, 455, 58, 25);
		frame.getContentPane().add(label12AMPrecipitation);

		// 3AM
		// time
		label3AM = new JLabel("");
		shortTermTime.add(label3AM);
		label3AM.setForeground(Color.LIGHT_GRAY);
		label3AM.setFont(font.deriveFont(15f));
		label3AM.setBounds(165, 360, 58, 15);
		frame.getContentPane().add(label3AM);
		// icon
		label3AMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label3AMSkyConditionIcon);
		label3AMSkyConditionIcon.setBounds(155, 380, 55, 49);
		frame.getContentPane().add(label3AMSkyConditionIcon);
		// sky condition
		label3AMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label3AMSkyConditionInfo);
		label3AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label3AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label3AMSkyConditionInfo.setBounds(165, 470, 75, 50);
		frame.getContentPane().add(label3AMSkyConditionInfo);
		// temperature
		label3AMTempInfo = new JLabel("");
		shortTermTemp.add(label3AMTempInfo);
		label3AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label3AMTempInfo.setFont(font.deriveFont(15f));
		label3AMTempInfo.setBounds(165, 435, 58, 25);
		frame.getContentPane().add(label3AMTempInfo);
		// precipitation
		label3AMPrecipitation = new JLabel("");
		shortTermPrecip.add(label3AMPrecipitation);
		label3AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label3AMPrecipitation.setFont(font.deriveFont(15f));
		label3AMPrecipitation.setBounds(165, 455, 58, 25);
		frame.getContentPane().add(label3AMPrecipitation);

		// 6AM
		// time
		label6AM = new JLabel("");
		shortTermTime.add(label6AM);
		label6AM.setForeground(Color.LIGHT_GRAY);
		label6AM.setFont(font.deriveFont(15f));
		label6AM.setBounds(250, 360, 58, 15);
		frame.getContentPane().add(label6AM);
		// icon
		label6AMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label6AMSkyConditionIcon);
		label6AMSkyConditionIcon.setBounds(240, 380, 55, 49);
		frame.getContentPane().add(label6AMSkyConditionIcon);
		// sky condition
		label6AMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label6AMSkyConditionInfo);
		label6AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label6AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label6AMSkyConditionInfo.setBounds(250, 470, 75, 50);
		frame.getContentPane().add(label6AMSkyConditionInfo);
		// temperature
		label6AMTempInfo = new JLabel("");
		shortTermTemp.add(label6AMTempInfo);
		label6AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label6AMTempInfo.setFont(font.deriveFont(15f));
		label6AMTempInfo.setBounds(250, 435, 58, 25);
		frame.getContentPane().add(label6AMTempInfo);
		// precipitation
		label6AMPrecipitation = new JLabel("");
		shortTermPrecip.add(label6AMPrecipitation);
		label6AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label6AMPrecipitation.setFont(font.deriveFont(15f));
		label6AMPrecipitation.setBounds(250, 455, 58, 25);
		frame.getContentPane().add(label6AMPrecipitation);

		// 9AM
		// time
		label9AM = new JLabel("");
		shortTermTime.add(label9AM);
		label9AM.setForeground(Color.LIGHT_GRAY);
		label9AM.setFont(font.deriveFont(15f));
		label9AM.setBounds(335, 360, 58, 15);
		frame.getContentPane().add(label9AM);
		// icon
		label9AMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label9AMSkyConditionIcon);
		label9AMSkyConditionIcon.setBounds(325, 380, 55, 49);
		frame.getContentPane().add(label9AMSkyConditionIcon);
		// sky condition
		label9AMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label9AMSkyConditionInfo);
		label9AMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label9AMSkyConditionInfo.setFont(font.deriveFont(11f));
		label9AMSkyConditionInfo.setBounds(335, 470, 75, 50);
		frame.getContentPane().add(label9AMSkyConditionInfo);
		// temperature
		label9AMTempInfo = new JLabel("");
		shortTermTemp.add(label9AMTempInfo);
		label9AMTempInfo.setForeground(Color.LIGHT_GRAY);
		label9AMTempInfo.setFont(font.deriveFont(15f));
		label9AMTempInfo.setBounds(335, 435, 58, 25);
		frame.getContentPane().add(label9AMTempInfo);
		// precipitation
		label9AMPrecipitation = new JLabel("");
		shortTermPrecip.add(label9AMPrecipitation);
		label9AMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label9AMPrecipitation.setFont(font.deriveFont(15f));
		label9AMPrecipitation.setBounds(335, 455, 58, 25);
		frame.getContentPane().add(label9AMPrecipitation);

		// 12PM
		// time
		label12PM = new JLabel("");
		shortTermTime.add(label12PM);
		label12PM.setForeground(Color.LIGHT_GRAY);
		label12PM.setFont(font.deriveFont(15f));
		label12PM.setBounds(420, 360, 58, 15);
		frame.getContentPane().add(label12PM);
		// icon
		label12PMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label12PMSkyConditionIcon);
		label12PMSkyConditionIcon.setBounds(410, 380, 55, 49);
		frame.getContentPane().add(label12PMSkyConditionIcon);
		// sky condition
		label12PMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label12PMSkyConditionInfo);
		label12PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label12PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label12PMSkyConditionInfo.setBounds(420, 470, 75, 50);
		frame.getContentPane().add(label12PMSkyConditionInfo);
		// temperature
		label12PMTempInfo = new JLabel("");
		shortTermTemp.add(label12PMTempInfo);
		label12PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label12PMTempInfo.setFont(font.deriveFont(15f));
		label12PMTempInfo.setBounds(420, 435, 58, 25);
		frame.getContentPane().add(label12PMTempInfo);
		// precipitation
		label12PMPrecipitation = new JLabel("");
		shortTermPrecip.add(label12PMPrecipitation);
		label12PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label12PMPrecipitation.setFont(font.deriveFont(15f));
		label12PMPrecipitation.setBounds(420, 455, 58, 25);
		frame.getContentPane().add(label12PMPrecipitation);

		// 3PM
		// time
		label3PM = new JLabel("");
		shortTermTime.add(label3PM);
		label3PM.setForeground(Color.LIGHT_GRAY);
		label3PM.setFont(font.deriveFont(15f));
		label3PM.setBounds(505, 360, 58, 15);
		frame.getContentPane().add(label3PM);
		// icon
		label3PMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label3PMSkyConditionIcon);
		label3PMSkyConditionIcon.setBounds(495, 380, 55, 49);
		frame.getContentPane().add(label3PMSkyConditionIcon);
		// sky condition
		label3PMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label3PMSkyConditionInfo);
		label3PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label3PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label3PMSkyConditionInfo.setBounds(505, 470, 75, 50);
		frame.getContentPane().add(label3PMSkyConditionInfo);
		// temperature
		label3PMTempInfo = new JLabel("");
		shortTermTemp.add(label3PMTempInfo);
		label3PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label3PMTempInfo.setFont(font.deriveFont(15f));
		label3PMTempInfo.setBounds(505, 435, 58, 25);
		frame.getContentPane().add(label3PMTempInfo);
		// precipitation
		label3PMPrecipitation = new JLabel("");
		shortTermPrecip.add(label3PMPrecipitation);
		label3PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label3PMPrecipitation.setFont(font.deriveFont(15f));
		label3PMPrecipitation.setBounds(505, 455, 58, 25);
		frame.getContentPane().add(label3PMPrecipitation);

		// 6PM
		// time
		label6PM = new JLabel("");
		shortTermTime.add(label6PM);
		label6PM.setForeground(Color.LIGHT_GRAY);
		label6PM.setFont(font.deriveFont(15f));
		label6PM.setBounds(590, 360, 58, 15);
		frame.getContentPane().add(label6PM);
		// icon
		label6PMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label6PMSkyConditionIcon);
		label6PMSkyConditionIcon.setBounds(580, 380, 55, 49);
		frame.getContentPane().add(label6PMSkyConditionIcon);
		// sky condition
		label6PMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label6PMSkyConditionInfo);
		label6PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label6PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label6PMSkyConditionInfo.setBounds(590, 470, 75, 50);
		frame.getContentPane().add(label6PMSkyConditionInfo);
		// temperature
		label6PMTempInfo = new JLabel("");
		shortTermTemp.add(label6PMTempInfo);
		label6PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label6PMTempInfo.setFont(font.deriveFont(15f));
		label6PMTempInfo.setBounds(590, 435, 58, 25);
		frame.getContentPane().add(label6PMTempInfo);
		// precipitation
		label6PMPrecipitation = new JLabel("");
		shortTermPrecip.add(label6PMPrecipitation);
		label6PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label6PMPrecipitation.setFont(font.deriveFont(15f));
		label6PMPrecipitation.setBounds(590, 455, 58, 25);
		frame.getContentPane().add(label6PMPrecipitation);

		// 9PM
		// time
		label9PM = new JLabel("");
		shortTermTime.add(label9PM);
		label9PM.setForeground(Color.LIGHT_GRAY);
		label9PM.setFont(font.deriveFont(15f));
		label9PM.setBounds(675, 360, 58, 15);
		frame.getContentPane().add(label9PM);
		// icon
		label9PMSkyConditionIcon = new JLabel();
		shortTermIcon.add(label9PMSkyConditionIcon);
		label9PMSkyConditionIcon.setBounds(665, 380, 55, 49);
		frame.getContentPane().add(label9PMSkyConditionIcon);
		// sky condition
		label9PMSkyConditionInfo = new JLabel("");
		shortTermSkyCon.add(label9PMSkyConditionInfo);
		label9PMSkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		label9PMSkyConditionInfo.setFont(font.deriveFont(11f));
		label9PMSkyConditionInfo.setBounds(675, 470, 75, 50);
		frame.getContentPane().add(label9PMSkyConditionInfo);
		// temperature
		label9PMTempInfo = new JLabel("");
		shortTermTemp.add(label9PMTempInfo);
		label9PMTempInfo.setForeground(Color.LIGHT_GRAY);
		label9PMTempInfo.setFont(font.deriveFont(15f));
		label9PMTempInfo.setBounds(675, 435, 58, 25);
		frame.getContentPane().add(label9PMTempInfo);
		// precipitation
		label9PMPrecipitation = new JLabel("");
		shortTermPrecip.add(label9PMPrecipitation);
		label9PMPrecipitation.setForeground(Color.LIGHT_GRAY);
		label9PMPrecipitation.setFont(font.deriveFont(15f));
		label9PMPrecipitation.setBounds(675, 455, 58, 25);
		frame.getContentPane().add(label9PMPrecipitation);

		/// END INITIALIZATION OF SHORT-TERM FORECAST PANEL ///

		/// BEGIN INITIALIZATION OF LONG-TERM FORECAST PANEL ///

		// DAY 1
		// date
		labelDay1Info = new JLabel("");
		longTermDate.add(labelDay1Info);
		labelDay1Info.setForeground(Color.LIGHT_GRAY);
		labelDay1Info.setFont(font.deriveFont(15f));
		labelDay1Info.setBounds(125, 360, 58, 15);
		frame.getContentPane().add(labelDay1Info);
		// icon
		labelDay1SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay1SkyConditionIcon);
		labelDay1SkyConditionIcon.setBounds(115, 380, 55, 49);
		frame.getContentPane().add(labelDay1SkyConditionIcon);
		// sky condition
		labelDay1SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay1SkyConditionInfo);
		labelDay1SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay1SkyConditionInfo.setBounds(105, 495, 75, 25);
		frame.getContentPane().add(labelDay1SkyConditionInfo);
		// expected  temperature
		labelDay1TempInfo = new JLabel("");
		longTermTemp.add(labelDay1TempInfo);
		labelDay1TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1TempInfo.setFont(font.deriveFont(15f));
		labelDay1TempInfo.setBounds(125, 435, 58, 15);
		frame.getContentPane().add(labelDay1TempInfo);
		// expected high/low temperatures
		labelDay1MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay1MMTempInfo);
		labelDay1MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1MMTempInfo.setFont(font.deriveFont(11f));
		labelDay1MMTempInfo.setBounds(105, 455, 65, 15);
		frame.getContentPane().add(labelDay1MMTempInfo);
		// precipitation
		labelDay1PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay1PrecipitationInfo);
		labelDay1PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay1PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay1PrecipitationInfo.setBounds(105, 475, 65, 15);
		frame.getContentPane().add(labelDay1PrecipitationInfo);

		// DAY 2
		// date
		labelDay2Info = new JLabel("");
		longTermDate.add(labelDay2Info);
		labelDay2Info.setForeground(Color.LIGHT_GRAY);
		labelDay2Info.setFont(font.deriveFont(15f));
		labelDay2Info.setBounds(205, 360, 58, 15);
		frame.getContentPane().add(labelDay2Info);
		// icon
		labelDay2SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay2SkyConditionIcon);
		labelDay2SkyConditionIcon.setBounds(195, 380, 55, 49);
		frame.getContentPane().add(labelDay2SkyConditionIcon);
		// sky condition
		labelDay2SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay2SkyConditionInfo);
		labelDay2SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay2SkyConditionInfo.setBounds(190, 495, 75, 25);
		frame.getContentPane().add(labelDay2SkyConditionInfo);
		// expected temperature
		labelDay2TempInfo = new JLabel("");
		longTermTemp.add(labelDay2TempInfo);
		labelDay2TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2TempInfo.setFont(font.deriveFont(15f));
		labelDay2TempInfo.setBounds(205, 435, 58, 15);
		frame.getContentPane().add(labelDay2TempInfo);
		// expected high/low temperatures
		labelDay2MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay2MMTempInfo);
		labelDay2MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2MMTempInfo.setFont(font.deriveFont(11f));
		labelDay2MMTempInfo.setBounds(190, 455, 65, 15);
		frame.getContentPane().add(labelDay2MMTempInfo);
		// precipitation
		labelDay2PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay2PrecipitationInfo);
		labelDay2PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay2PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay2PrecipitationInfo.setBounds(190, 475, 65, 15);
		frame.getContentPane().add(labelDay2PrecipitationInfo);

		// DAY 3
		// date
		labelDay3Info = new JLabel("");
		longTermDate.add(labelDay3Info);
		labelDay3Info.setForeground(Color.LIGHT_GRAY);
		labelDay3Info.setFont(font.deriveFont(15f));
		labelDay3Info.setBounds(295, 360, 58, 15);
		frame.getContentPane().add(labelDay3Info);
		// icon
		labelDay3SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay3SkyConditionIcon);
		labelDay3SkyConditionIcon.setBounds(285, 380, 55, 49);
		frame.getContentPane().add(labelDay3SkyConditionIcon);
		// sky condition
		labelDay3SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay3SkyConditionInfo);
		labelDay3SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay3SkyConditionInfo.setBounds(280, 495, 75, 25);
		frame.getContentPane().add(labelDay3SkyConditionInfo);
		// expected temperature
		labelDay3TempInfo = new JLabel("");
		longTermTemp.add(labelDay3TempInfo);
		labelDay3TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3TempInfo.setFont(font.deriveFont(15f));
		labelDay3TempInfo.setBounds(295, 435, 58, 15);
		frame.getContentPane().add(labelDay3TempInfo);
		// expected high/low temperatures
		labelDay3MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay3MMTempInfo);
		labelDay3MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3MMTempInfo.setFont(font.deriveFont(11f));
		labelDay3MMTempInfo.setBounds(280, 455, 65, 15);
		frame.getContentPane().add(labelDay3MMTempInfo);
		// precipitation
		labelDay3PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay3PrecipitationInfo);
		labelDay3PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay3PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay3PrecipitationInfo.setBounds(280, 475, 65, 15);
		frame.getContentPane().add(labelDay3PrecipitationInfo);

		// DAY 4
		// date
		labelDay4Info = new JLabel("");
		longTermDate.add(labelDay4Info);
		labelDay4Info.setForeground(Color.LIGHT_GRAY);
		labelDay4Info.setFont(font.deriveFont(15f));
		labelDay4Info.setBounds(385, 360, 58, 15);
		frame.getContentPane().add(labelDay4Info);
		// icon
		labelDay4SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay4SkyConditionIcon);
		labelDay4SkyConditionIcon.setBounds(375, 380, 55, 49);
		frame.getContentPane().add(labelDay4SkyConditionIcon);
		// sky condition
		labelDay4SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay4SkyConditionInfo);
		labelDay4SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay4SkyConditionInfo.setBounds(370, 495, 75, 25);
		frame.getContentPane().add(labelDay4SkyConditionInfo);
		// expected temperature
		labelDay4TempInfo = new JLabel("");
		longTermTemp.add(labelDay4TempInfo);
		labelDay4TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4TempInfo.setFont(font.deriveFont(15f));
		labelDay4TempInfo.setBounds(385, 435, 58, 15);
		frame.getContentPane().add(labelDay4TempInfo);
		// expected high/low temperatures
		labelDay4MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay4MMTempInfo);
		labelDay4MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4MMTempInfo.setFont(font.deriveFont(11f));
		labelDay4MMTempInfo.setBounds(370, 455, 65, 15);
		frame.getContentPane().add(labelDay4MMTempInfo);
		// precipitation
		labelDay4PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay4PrecipitationInfo);
		labelDay4PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay4PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay4PrecipitationInfo.setBounds(370, 475, 65, 15);
		frame.getContentPane().add(labelDay4PrecipitationInfo);

		// DAY 5
		// date
		labelDay5Info = new JLabel("");
		longTermDate.add(labelDay5Info);
		labelDay5Info.setForeground(Color.LIGHT_GRAY);
		labelDay5Info.setFont(font.deriveFont(15f));
		labelDay5Info.setBounds(475, 360, 58, 15);
		frame.getContentPane().add(labelDay5Info);
		// icon
		labelDay5SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay5SkyConditionIcon);
		labelDay5SkyConditionIcon.setBounds(465, 380, 55, 49);
		frame.getContentPane().add(labelDay5SkyConditionIcon);
		// sky condition
		labelDay5SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay5SkyConditionInfo);
		labelDay5SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay5SkyConditionInfo.setBounds(460, 495, 75, 25);
		frame.getContentPane().add(labelDay5SkyConditionInfo);
		// temperature
		labelDay5TempInfo = new JLabel("");
		longTermTemp.add(labelDay5TempInfo);
		labelDay5TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5TempInfo.setFont(font.deriveFont(15f));
		labelDay5TempInfo.setBounds(475, 435, 58, 15);
		frame.getContentPane().add(labelDay5TempInfo);
		// expected high/low temperatures
		labelDay5MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay5MMTempInfo);
		labelDay5MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5MMTempInfo.setFont(font.deriveFont(11f));
		labelDay5MMTempInfo.setBounds(460, 455, 65, 15);
		frame.getContentPane().add(labelDay5MMTempInfo);
		// precipitation
		labelDay5PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay5PrecipitationInfo);
		labelDay5PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay5PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay5PrecipitationInfo.setBounds(460, 475, 65, 15);
		frame.getContentPane().add(labelDay5PrecipitationInfo);

		// DAY 6
		labelDay6Info = new JLabel("");
		longTermDate.add(labelDay6Info);
		labelDay6Info.setForeground(Color.LIGHT_GRAY);
		labelDay6Info.setFont(font.deriveFont(15f));
		labelDay6Info.setBounds(565, 360, 58, 15);
		frame.getContentPane().add(labelDay6Info);
		// icon
		labelDay6SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay6SkyConditionIcon);
		labelDay6SkyConditionIcon.setBounds(555, 380, 55, 49);
		frame.getContentPane().add(labelDay6SkyConditionIcon);
		// sky condition
		labelDay6SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay6SkyConditionInfo);
		labelDay6SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay6SkyConditionInfo.setBounds(550, 495, 75, 25);
		frame.getContentPane().add(labelDay6SkyConditionInfo);
		// temperature
		labelDay6TempInfo = new JLabel("");
		longTermTemp.add(labelDay6TempInfo);
		labelDay6TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6TempInfo.setFont(font.deriveFont(15f));
		labelDay6TempInfo.setBounds(565, 435, 58, 15);
		frame.getContentPane().add(labelDay6TempInfo);
		// expected high/low temperatures
		labelDay6MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay6MMTempInfo);
		labelDay6MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6MMTempInfo.setFont(font.deriveFont(11f));
		labelDay6MMTempInfo.setBounds(550, 455, 65, 15);
		frame.getContentPane().add(labelDay6MMTempInfo);
		// precipitation
		labelDay6PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay6PrecipitationInfo);
		labelDay6PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay6PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay6PrecipitationInfo.setBounds(550, 475, 65, 15);
		frame.getContentPane().add(labelDay6PrecipitationInfo);

		// DAY 7
		// date
		labelDay7Info = new JLabel("");
		longTermDate.add(labelDay7Info);
		labelDay7Info.setForeground(Color.LIGHT_GRAY);
		labelDay7Info.setFont(font.deriveFont(15f));
		labelDay7Info.setBounds(655, 360, 58, 15);
		frame.getContentPane().add(labelDay7Info);
		// icon
		labelDay7SkyConditionIcon = new JLabel();
		longTermIcon.add(labelDay7SkyConditionIcon);
		labelDay7SkyConditionIcon.setBounds(645, 380, 55, 49);
		frame.getContentPane().add(labelDay7SkyConditionIcon);
		// sky condition
		labelDay7SkyConditionInfo = new JLabel("");
		longTermSkyCon.add(labelDay7SkyConditionInfo);
		labelDay7SkyConditionInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7SkyConditionInfo.setFont(font.deriveFont(11f));
		labelDay7SkyConditionInfo.setBounds(640, 495, 75, 25);
		frame.getContentPane().add(labelDay7SkyConditionInfo);
		// temperature
		labelDay7TempInfo = new JLabel("");
		longTermTemp.add(labelDay7TempInfo);
		labelDay7TempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7TempInfo.setFont(font.deriveFont(15f));
		labelDay7TempInfo.setBounds(655, 435, 58, 15);
		frame.getContentPane().add(labelDay7TempInfo);
		// expected high/low temperatures
		labelDay7MMTempInfo = new JLabel("");
		longTermHighLow.add(labelDay7MMTempInfo);
		labelDay7MMTempInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7MMTempInfo.setFont(font.deriveFont(11f));
		labelDay7MMTempInfo.setBounds(640, 455, 65, 15);
		frame.getContentPane().add(labelDay7MMTempInfo);
		// precipitation
		labelDay7PrecipitationInfo = new JLabel("");
		longTermPrecip.add(labelDay7PrecipitationInfo);
		labelDay7PrecipitationInfo.setForeground(Color.LIGHT_GRAY);
		labelDay7PrecipitationInfo.setFont(font.deriveFont(15f));
		labelDay7PrecipitationInfo.setBounds(640, 475, 65, 15);
		frame.getContentPane().add(labelDay7PrecipitationInfo);

		/// END INITIALIZATION OF LONG-TERM CONDITIONS ///

		// show short term view by default
		toggleShortTerm(true);
		
		//try refreshing from default location
		String defaultLocation = prefs.getDefaultLocation();
		if (!(defaultLocation.contentEquals("")))
			refresh(defaultLocation);
	}

	/**
	 * called once by the constructor to initialize font data from file before drawing
	 */
	private void createFont() {
		java.io.InputStream fontInputStream = this.getClass()
				.getResourceAsStream("/fonts/HelveticaNeue-Medium.otf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
		} catch (Exception e) {
			//fail safe, should not ever happen
			font = new Font("Helvetica", Font.PLAIN, 20);
			System.out.println("Font loading failed");
		}
	}

	/**
	 * refreshes the weather data throughout the UI
 	 * @param location the city for which we are viewing weather data
	 */
	public void refresh(String location) {
		try {
			//get all weather data
			currentWeather = new CurrentWeather(location);
			shortTermForecast = new ShortTermForecast(location);
			final int LENGTH_OF_LONGTERM = 7;
			longTermForecast = new LongTermForecast(location, LENGTH_OF_LONGTERM);

			// get the current time and set the lastUpdated label accordingly
			cal = Calendar.getInstance();
			lastUpdated = dateFormat.format(cal.getTime());

			// current location panel
			labelLocation.setText(currentWeather.getCity() + ", "
					+ currentWeather.getCountry());
			labelSkyConditionInfo.setText(currentWeather.getSkyCondition());

			labelWindInfo.setText(currentWeather.getWindSpeed() + " km/h "
					+ currentWeather.getWindDirection());
			labelHumidityInfo.setText(currentWeather.getHumidity() + " %");
			labelAirPressureInfo.setText(currentWeather.getPressure() + " kPa");

			labelSunriseInfo.setText(currentWeather.getSunriseTime());
			labelSunsetInfo.setText(currentWeather.getSunsetTime());
			
			labelUpdatedInfo.setText(lastUpdated);
			
			//display total daily precipitation
			labelPrecipitationInfo.setText(shortTermForecast.getTotalPrecipitation() + " mm");
			
			// display weather icon and background image
			setSkyConditionImages(currentWeather.getWeatherID());
			labelSkyConditionIcon.setIcon(new ImageIcon(skyConditionIconLarge));
			backgroundLabel.setIcon(new ImageIcon(skyConditionBackground));

			// display temperature
			setTemperatureFields();

			// display weather info for short/long-term forecasts
			updateShortTerm();
			updateLongTerm();
		}
		catch (IOException e) {
			//should not be executed.
			System.out.println("Something went wrong retrieving current weather");
		}	
	}

	/**
	 * Sets all the temperature fields in the interface. This is called when data is refreshed, but also when C/F
	 * unit is changed - which is why it is kept seperate from non-temperature fields.
	 */
    private void setTemperatureFields() {
    	char tempUnit = prefs.getTempUnit();
    	if(currentWeather != null) {
            labelTempInfo.setText(currentWeather.getTemp(tempUnit));
            labelCurrentMMTempInfo.setText(currentWeather.getMinTemp(tempUnit) + "  |  " + currentWeather.getMaxTemp(tempUnit));
        }
    	//do same for short/long-term forecasts
    	for (int i = 0; i < 8; i++){
    		ShortTermWeather stw = shortTermForecast.getShortTermForecast().get(i);
        	shortTermTemp.get(i).setText(stw.getTemp(tempUnit));
        }
    	for (int i = 0; i < 7; i++){
    		LongTermWeather ltw = longTermForecast.getLongTermForecast().get(i);
        	longTermTemp.get(i).setText(ltw.getTemp(tempUnit));
        	longTermHighLow.get(i).setText(ltw.getLow(tempUnit) + "  |  " + ltw.getHigh(tempUnit));
        }
    }

	/**
	 * updates the short term weather forecast values when the location is changed / data is refreshed
	 * (except temperatures since these are handled in setTemperatureFields)
	 */
    private void updateShortTerm(){
    	for (int i = 0; i < 8; i++){
    		ShortTermWeather stw = shortTermForecast.getShortTermForecast().get(i);
    		
    		shortTermTime.get(i).setText(stw.getTime().substring(11, 13) + " h");
			setSkyConditionImages(stw.getWeatherID());
    		shortTermIcon.get(i).setIcon(new ImageIcon(skyConditionIconSmall));
			shortTermSkyCon.get(i).setText("<html>"+stw.getSkyCondition()+"</html>");
			if (!(stw.getRain().contentEquals("0")))
				shortTermPrecip.get(i).setText(stw.getRain()+" mm");
			else if (!(stw.getSnow().contentEquals("0")))
				shortTermPrecip.get(i).setText(stw.getSnow()+ " mm");
			else 
				shortTermPrecip.get(i).setText("0 mm");
    	}
    }

	/**
	 * updates the long term weather forecast values when the location is changed / data is refreshed
	 * (except temperatures since these are handled in setTemperatureFields)
	 */
    private void updateLongTerm(){
    	for (int i = 0; i < 7; i++){
    		LongTermWeather ltw = longTermForecast.getLongTermForecast().get(i);
    		
    		longTermDate.get(i).setText(ltw.getDate());
    		setSkyConditionImages(ltw.getWeatherID());
    		longTermIcon.get(i).setIcon(new ImageIcon(skyConditionIconSmall));
			longTermSkyCon.get(i).setText("<html>"+ltw.getSkyCondition()+"</html>");
			if (!(ltw.getRain().contentEquals("0")))
				longTermPrecip.get(i).setText(ltw.getRain()+" mm");
			else if (!(ltw.getSnow().contentEquals("0")))
				longTermPrecip.get(i).setText(ltw.getSnow()+ " mm");
			else 
				longTermPrecip.get(i).setText("0 mm");
    	}
    }


	/**
	 * Class representing the action listener for adding locations to the list
	 */
	private class AddLocation implements ActionListener, DocumentListener {
		// whether or not the button is active
		private boolean alreadyEnabled = false;
		private JButton button;
		// this is used to test the validity of the location in the API
		private CurrentWeather test;

		/**
		 * constructor for AddLocation
		 * @param button JButton where the actionlistener is called from
		 */
		public AddLocation(JButton button) {
			this.button = button;
		}

		/**
		 * overrided ActionListener interface method which is executed whenever an event is fired
		 * @param e the event fired that caused the method call
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = barSearch.getText();

			try {
				test = new CurrentWeather(name);

				// user didn't enter a valid location...
				if (!(name.contentEquals(test.getCity()+", "+test.getCountry()))) {
					barSearch.setText("Please enter a valid location.");
					return;
				}

				// user didn't type in a unique name...
				if (name.equals("") || alreadyInList(name)) {
					Toolkit.getDefaultToolkit().beep();
					barSearch.requestFocusInWindow();
					barSearch.selectAll();
					return;
				}

				int index = listLocations.getSelectedIndex(); // get selected
																// index
				if (index == -1) { // no selection, so insert at beginning
					index = 0;
				} else { // add after the selected item
					index++;
				}

				listModel.insertElementAt(barSearch.getText(), index);


				// add element to user preferences as well
					// add the element to the position at index index
					prefs.addLocation(index, barSearch.getText());



				// reset the text field.
				barSearch.requestFocusInWindow();
				barSearch.setText("");

				// select the new item and make it visible.
				listLocations.setSelectedIndex(index);
				listLocations.ensureIndexIsVisible(index);

			} catch (Exception err) {
				System.out.println("An invalid location was entered.");
				barSearch.setText("Please enter a valid location.");
			}
		}

		/**
		 * checks to see if the city being added is already in the list
		 * @param name the name of the city being added
		 * @return whether or not city is in the list
		 */
		protected boolean alreadyInList(String name) {
			return listModel.contains(name);
		}

		/*
		 * overrides documentListener method
		 * @param e document event
		 */

		@Override
		public void insertUpdate(DocumentEvent e) {
			enableButton();
		}


		/**
		 * overrides documentListener method
		 * @param e document event
		 */

		@Override
		public void removeUpdate(DocumentEvent e) {
			handleEmptyTextField(e);
		}

		/**
		 * overrides documentListener method
		 * @param e document event
		 */

		@Override
		public void changedUpdate(DocumentEvent e) {
			if (!handleEmptyTextField(e)) {
				enableButton();
			}
		}

		/**
		 * enables addLocation button
		 */
		private void enableButton() {
			if (!alreadyEnabled) {
				button.setEnabled(true);
			}
		}

		/**
		 * handles empty text field
		 */
		private boolean handleEmptyTextField(DocumentEvent e) {
			if (e.getDocument().getLength() <= 0) {
				button.setEnabled(false);
				alreadyEnabled = false;
				return true;
			}
			return false;
		}
	}

	/**
	 * toggles whether the short or long term display is shown
	 * @param b whether to show or hide short term (ie, true shows short term, false shows long term)
	 */
	public void toggleShortTerm(boolean b) {
		if (b) {
			buttonLongTerm.setForeground(Color.GRAY);
			buttonShortTerm.setForeground(Color.WHITE);
		} else {
			buttonLongTerm.setForeground(Color.WHITE);
			buttonShortTerm.setForeground(Color.GRAY);
		}
		
		for (JLabel label: longTermDate){
			label.setVisible(!b);
		}
		for (JLabel label: longTermIcon){
			label.setVisible(!b);
		}
		for (JLabel label: longTermSkyCon){
			label.setVisible(!b);
		}
		for (JLabel label: longTermTemp){
			label.setVisible(!b);
		}
		for (JLabel label: longTermHighLow){
			label.setVisible(!b);
		}
		for (JLabel label: longTermPrecip){
			label.setVisible(!b);
		}
		
		for (JLabel label: shortTermTime){
			label.setVisible(b);
		}
		for (JLabel label: shortTermIcon){
			label.setVisible(b);
		}
		for (JLabel label: shortTermSkyCon){
			label.setVisible(b);
		}
		for (JLabel label: shortTermTemp){
			label.setVisible(b);
		}
		for (JLabel label: shortTermPrecip){
			label.setVisible(b);
		}
			
		
	}

	/**
	 * takes a parameter ID obtained from the weather API and sets the corresponding sky condition icons to match
	 * the sky condition described by the ID.
	 * unfortunately doing this manually using a switch is still the easiest way to do this.
	 * @param ID the ID number describing the sky condition
	 */
	public void setSkyConditionImages(int ID) {
		String icon, background;

		switch (ID) {
		// THUNDERSTORM
		// Thunderstorm with Light Rain
		case 200:
			// Thunderstorm with Rain
		case 201:
			// Thunderstorm with Heavy Rain
		case 202:
			// Light Thunderstorm
		case 210:
			// Thunderstorm
		case 211:
			// Heavy Thunderstorm
		case 212:
			// Ragged Thunderstorm
		case 221:
			// Thunderstorm with Light Drizzle
		case 230:
			// Thunderstorm with Drizzle
		case 231:
			// Thunderstorm with Heavy Drizzle
		case 232:
			icon = "thunder";
			background = "thunder";
			break;
		// DRIZZLE
		// Light Intensity Drizzle
		case 300:
			// Drizzle
		case 301:
			// Heavy Intensity Drizzle
		case 302:
			// Light Intensity Drizzle Rain
		case 310:
			// Drizzle Rain
		case 311:
			// Heavy Intensity Drizzle Rain
		case 312:
			// Shower Rain and Drizzle
		case 313:
			// Heavy Shower Rain and Drizzle
		case 314:
			// Shower Drizzle
		case 321:
			icon = "drizzle";
			background = "rain";
			break;
		// RAIN
		// Light Rain
		case 500:
			// Moderate Rain
		case 501:
			// Heavy Intensity Rain
		case 502:
			// Very Heavy Rain
		case 503:
			// Extreme Rain
		case 504:
			// Shower Rain
		case 521:
			// Heavy Intensity Shower Rain
		case 522:
			// Ragged Shower Rain
		case 531:
			icon = "heavy_rain";
			background = "rain";
			break;
		// Freezing Rain
		case 511:
			icon = "sleet";
			background = "rain";
			break;
		// Light Intensity Shower Rain
		case 520:
			icon = "light_rain";
			background = "rain";
			break;
		// SNOW
		// Light Snow
		case 600:
			// Snow
		case 601:
			icon = "light_snow";
			background = "snow";
			break;
		// Heavy Snow
		case 602:
			// Hurricane
		case 902:
			// Hail
		case 906:
			icon = "heavy_snow";
			background = "snow";
			break;
		// Sleet
		case 611:
			// Shower Sleet
		case 612:
			// Light Rain and Snow
		case 615:
			// Rain and Snow
		case 616:
			icon = "sleet";
			background = "rain";
			break;
		// Light Shower Snow
		case 620:
			// Shower Snow
		case 621:
			// Heavy Shower Snow
		case 622:
			icon = "sleet";
			background = "snow";
			break;
		// ATMOSPHERE
		// Mist
		case 701:
			// Fog
		case 721:
			// Haze
		case 741:
			icon = "mist";
			background = "fog";
			break;
		// Smoke
		case 711:
			// Volcanic Ash
		case 762:
			icon = "mist";
			background = "volcano";
			break;
		// Sand/Dust Whirls
		case 731:
			// Sand
		case 751:
			// Dust
		case 761:
			icon = "mist";
			background = "sand";
			break;
		// Squalls
		case 771:
			icon = "tornado";
			background = "snow";
			break;
		// Tornado
		case 781:
		case 900:
			icon = "tornado";
			background = "tornado";
			break;
		// CLOUDS
		// Sky is clear
		case 800:
			icon = "sun";
			background = "sun";
			break;
		// Calm
		case 951:
			icon = "sun";
			background = "partial_clouds";
			break;
		// Few Clouds
		case 801:
			// Scattered Clouds
		case 802:
			icon = "light_clouds";
			background = "partial_clouds";
			break;
		// Broken Clouds
		case 803:
			// Overcast Clouds
		case 804:
			icon = "heavy_clouds";
			background = "clouds";
			break;
		// EXTREME
		// Tropical Storm
		case 901:
			icon = "tornado";
			background = "rain";
			break;
		// Cold
		case 903:
			icon = "wind";
			background = "snow";
			break;
		// Hot
		case 904:
		case 950:
			icon = "sun";
			background = "sun";
			break;
		// Windy
		case 905:
			// Severe Gale
		case 959:
			// ADDITIONAL
			// Setting
			// Light Breeze
		case 952:
			// Gentle Breeze
		case 953:
			// Moderate breeze
		case 954:
			// Fresh Breeze
		case 955:
			// Strong Breeze
		case 956:
			// High Wind, near Gale
		case 957:
			// Gale
		case 958:
			// Storm
		case 960:
			icon = "wind";
			background = "wind";
			break;
		// Violent Storm
		case 961:
			icon = "wind";
			background = "tornado";
			break;
		// Hurricane
		case 962:
			icon = "tornado";
			background = "hurricane";
			break;
		// failsafe, but shouldn't happen
		default:
			icon = "sun";
			background = "sun";
		}
		skyConditionIconLarge = "src/main/resources/icons/large/" + icon
				+ ".png";
		skyConditionIconSmall = "src/main/resources/icons/small/" + icon
				+ ".png";
		skyConditionBackground = "src/main/resources/backgrounds/" + background
				+ ".jpg";
	}
}
