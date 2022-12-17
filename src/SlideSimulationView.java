
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

// These are my new ones
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//

/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class:
 * 
 */

public class SlideSimulationView extends JFrame
{

	private DecimalFormat df = new DecimalFormat("####0.00");

	private JPanel mainPanel;
	private JLabel instructions;

	private JPanel runPanel;
	private JButton runButton;
	private JButton refreshButton;

	private JPanel mainMainPanel;

	// private JPanel slideSimulationPanel;
	// going to replace this by just adding the clockpanel directly??
	private BackgroundPanel clockPanel;

	private JPanel resultsPanel;

	private JLabel heightResults;
	private JLabel angleResults;
	private JLabel frictionResults;
	private JLabel speedResults;
	private JLabel groundImpactResults;
	private JLabel lengthResults;
	private JLabel groundMaterialResults;
	private JLabel gravityResults;

	// TODO: Jayden, add JLabels for all information the user can choose
	// ie. Angle, Friction, Height... Speed, Max Speed, Ground impact,...

	// Edit the Create Panel for the Results panel to add them

	private JPanel settingsPanel;
	private JLabel height;
	private JSlider heightSlider;
	private JLabel angle;
	private JSlider angleSlider;
	private JLabel friction;
	private JSlider frictionSlider;
	private JLabel groundMaterial;
	private JComboBox<GroundMaterial> groundMaterialSelection;

	/**
	 * TODO
	 * 
	 * @param model
	 */
	public SlideSimulationView() // param model? or add slide simulation
	{

		// TODO
		super("Physics Slide Simulation");

		// a few constants for the size of the window
		// final int WINDOW_WIDTH = 100;
		// final int WINDOW_HEIGHT = 100;
		//
		// // set the size
		setSize(900, 700);
		// setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pack gets rid of the need of setSize as it condeses the window to the
		// smallest size

		mainPanel = new JPanel();
		createPanel1();
		add(mainPanel, BorderLayout.NORTH);
		mainPanel.setSize(500, 500);

		mainMainPanel = new JPanel();
		createPanel3Main();
		add(mainMainPanel, BorderLayout.CENTER);

		runPanel = new JPanel();
		createPanel2();
		add(runPanel, BorderLayout.SOUTH);

		// pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// setResizable(false); // to make it so the animation cannot be
		// stretched
	}

	private void createPanel1()
	{
		// mainPanel.setLayout(new BorderLayout());

		instructions = new JLabel(
				"Use this simulation to test potential playground slides");

		mainPanel.add(instructions);

	}



	private void createPanel3Main()
	{
		mainMainPanel.setLayout(new GridLayout(1, 0));
		mainMainPanel.setSize(500, 500);

		 clockPanel = new BackgroundPanel(Color.BLACK,
				Color.GREEN);
		// slideSimulationPanel = new JPanel();
		// BackgroundPanel clockPanel = new BackgroundPanel(Color.BLACK,
		// Color.GREEN);
		// slideSimulationPanel.add(clockPanel);
		// createSlideSimulationPanel();
		// slideSimulationPanel.setSize(500,400);
		


		mainMainPanel.add(clockPanel);

		resultsPanel = new JPanel();
		createResultsPanel();
		// we have to put this before we add the main panel so when settings
		// accesses the results it's not null

		settingsPanel = new JPanel();
		createSettingsPanel();
		mainMainPanel.add(settingsPanel);

		mainMainPanel.add(resultsPanel);


	}
	
	private void createPanel2()
	{
		
		runButton = new JButton("Run");
		runButtonListener newListener = new runButtonListener();
		runButton.addActionListener(newListener);

		refreshButton = new JButton("Refresh");
		refreshButtonListener refreshListener = new refreshButtonListener();
		refreshButton.addActionListener(refreshListener);

		runPanel.add(refreshButton);
		runPanel.add(runButton);

	}

	private void createResultsPanel()
	{
		resultsPanel.setLayout(new GridLayout(0, 1));

		heightResults = new JLabel("Height: -- ");
		lengthResults = new JLabel("Length: -- ");
		angleResults = new JLabel("Angle: -- ");
		frictionResults = new JLabel("Friction: -- ");
		speedResults = new JLabel("Speed: -- ");
		groundImpactResults = new JLabel("Ground Impact: -- ");
		groundMaterialResults = new JLabel("Groud Material: -- ");
		gravityResults = new JLabel("Gravity: 9.8 m/s^2");
	

		resultsPanel.add(heightResults);
		resultsPanel.add(lengthResults);
		resultsPanel.add(angleResults);
		resultsPanel.add(frictionResults);

		resultsPanel.add(speedResults);
		resultsPanel.add(groundImpactResults);
		resultsPanel.add(groundMaterialResults);
		resultsPanel.add(gravityResults);

	}

	private void createSettingsPanel()
	{

		settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridLayout(0, 1));

		height = new JLabel("height");
		heightSlider = new JSlider(0, 10);

		sliderListener newListenerHeight = new sliderListener("Height",
				heightSlider, heightResults);
		heightSlider.addChangeListener(newListenerHeight);

		heightSlider.setMajorTickSpacing(5);
		heightSlider.setMinorTickSpacing(1);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);

		angle = new JLabel("angle");
		angleSlider = new JSlider(0, 45);
		sliderListener newListenerAngle = new sliderListener("Angle",
				angleSlider, angleResults);
		angleSlider.addChangeListener(newListenerAngle);
		System.out.println(heightSlider.getValue() + "hello");

		angleSlider.setMajorTickSpacing(15);
		angleSlider.setMinorTickSpacing(5);
		angleSlider.setPaintTicks(true);
		angleSlider.setPaintLabels(true);

		friction = new JLabel("friction");
		frictionSlider = new JSlider(0, 10);

		sliderListener newListenerFriction = new sliderListener("friction",
				frictionSlider, frictionResults);
		frictionSlider.addChangeListener(newListenerFriction);
		frictionSlider.setValue(0); // this needs to be after the listener to
									// set the results change

		frictionSlider.setMajorTickSpacing(5);
		frictionSlider.setMinorTickSpacing(1);
		frictionSlider.setPaintTicks(true);
		frictionSlider.setPaintLabels(true);

		// Make this change more elegant?
		angleSlider.setValue(15); // this needs to be after the listener to set
									// the results change
		heightSlider.setValue(10); // this needs to be after the listener to set
									// the results change
									// the results change

		groundMaterial = new JLabel("Ground Material");
	//	String[] comboOptions = { "Mulch", "Woodchips", "Asphalt" };

	//GroundMaterial[] comboOptions2 = {GroundMaterial("Mulch",10,Color.ORANGE)};
		GroundMaterial mulch = new GroundMaterial("Mulch",10,Color.ORANGE);
		GroundMaterial asph = new GroundMaterial("Mulch",10,Color.ORANGE);
		GroundMaterial woodch = new GroundMaterial("Mulch",10,Color.ORANGE);
		GroundMaterial[] comboOptions2 = {mulch,asph,woodch};
		
		groundMaterialSelection = new JComboBox<GroundMaterial>(comboOptions2);
		groundMaterialSelection.setSelectedIndex(0);
		// System.out.println(groundMaterialSelection.getSelectedIndex(0));

		settingsPanel.add(height);
		settingsPanel.add(heightSlider);
		settingsPanel.add(angle);
		settingsPanel.add(angleSlider);
		settingsPanel.add(friction);
		settingsPanel.add(frictionSlider);
		settingsPanel.add(groundMaterial);
		settingsPanel.add(groundMaterialSelection);

	}

	// public void createSlideSimulationPanel()
	// {
	//
	// slideSimulationPanel.setLayout(new GridLayout(1, 0));
	// BackgroundPanel clockPanel = new BackgroundPanel(Color.BLACK,
	// Color.GREEN);
	//
	// // slideSimulationPanel.setSize(100,100);
	// // Dimension simulationSize = new Dimension(500,500);
	// // setPreferredSize(simulationSize);
	//
	// slideSimulationPanel.add(clockPanel);
	//
	//
	// }

	public class sliderListener implements ChangeListener
	{

		private String variableName;
		private JSlider sliderName;
		private JLabel jlabelName;

		// TODO: Write a constructor with the values of variable, slider as
		// parameters
		public sliderListener(String variableName, JSlider sliderName,
				JLabel jlabelName)
		{
			this.variableName = variableName;
			this.sliderName = sliderName;
			this.jlabelName = jlabelName;

		}

		@Override
		public void stateChanged(ChangeEvent e)
		{

			jlabelName.setText(variableName + ": "
					+ String.valueOf(sliderName.getValue()));

			
			clockPanel.setHeight(heightSlider.getValue());
			
			
			
			if (angleSlider.getValue() != 0 && heightSlider.getValue() != 0)
			{
			
				clockPanel.setLength(heightSlider.getValue() * Math.tan(Math.toRadians(angleSlider.getValue())));


				
				lengthResults.setText("Length: " + String
						.valueOf(df.format(
								heightSlider.getValue() * Math.tan(Math.toRadians(angleSlider.getValue())))));
			}

		}

	}

	public class runButtonListener implements ActionListener
	{

		

		@Override
		public void actionPerformed(ActionEvent e)
		{
			runButton.setForeground(Color.BLUE);
		}
	}
	
	public class refreshButtonListener implements ActionListener
	{		

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			angleSlider.setValue(15); // this needs to be after the listener to set
			// the results change
			heightSlider.setValue(4); // this needs to be after the listener to set
			heightSlider.setValue(10); // this needs to be after the listener to set
			frictionSlider.setValue(0);
			clockPanel.setbaseX();
			clockPanel.setbaseY();

		}
	}

	
	// TODO: Add listener to change the results panel ++ create a ground Material class
	public class comboBoxListener implements ActionListener
	{

		// TODO: edit this to make it work so ground material changes
		// add it to the combo box

		@Override
		public void actionPerformed(ActionEvent e)
		{

			groundMaterialResults
					.setText("Ground Material: " + groundMaterialSelection);

		}

	}

	

	/**
	 * TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{

		new SlideSimulationView();

	}

}
