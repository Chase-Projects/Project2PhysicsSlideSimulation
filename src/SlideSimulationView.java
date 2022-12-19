
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
 * @author Chase Varga
 * @author Jayden Brown
 * 
 * 
 *         Responsibilities of class: To greate a GUI with a results, setting,
 *         and animation panel
 * 
 */

public class SlideSimulationView extends JFrame
{

	private DecimalFormat df = new DecimalFormat("####0.00");

	// to create instructions
	private JPanel mainPanel;
	private JLabel instructions;

	// to create run and refresh button
	private JPanel runPanel;
	private JButton runButton;
	private JButton refreshButton;

	private JPanel mainMainPanel;

	// Animation Panel
	private BackgroundPanel slidePanel;

	// Results Panel
	private JPanel resultsPanel;

	private JLabel heightResults;
	private JLabel angleResults;
	private JLabel frictionResults;
	private JLabel speedResults;
	private JLabel groundImpactResults;
	private JLabel lengthResults;
	private JLabel groundMaterialResults;
	private JLabel gravityResults;

	// Settings Panel
	private JPanel settingsPanel;
	private JLabel height;
	private JSlider heightSlider;
	private JLabel angle;
	private JSlider angleSlider;
	private JLabel friction;
	private JSlider frictionSlider;
	private JLabel groundMaterial;
	private JComboBox<String> groundMaterialSelection;

	/**
	 * 
	 * @param
	 * This        sets the settings of the JFrame and adds our Jpanels
	 */
	public SlideSimulationView() // param model? or add slide simulation
	{

		// TODO
		super("Physics Slide Simulation");

		// // set the size
		setSize(900, 700);
		// setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		createInstructionPanel();
		add(mainPanel, BorderLayout.NORTH);
		mainPanel.setSize(500, 500);

		mainMainPanel = new JPanel();
		createMainPanel();
		add(mainMainPanel, BorderLayout.CENTER);

		runPanel = new JPanel();
		createRunPanel();
		add(runPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// setResizable(false); // to make it so the animation cannot be
	}

	/**
	 * 
	 * @param
	 * This        creates our instruction panel
	 */
	private void createInstructionPanel()
	{
		// mainPanel.setLayout(new BorderLayout());

		instructions = new JLabel(
				"Use this simulation to test potential playground slides");

		mainPanel.add(instructions);

	}

	/**
	 * 
	 * @param
	 * This        creates our Main panel
	 */
	private void createMainPanel()
	{
		mainMainPanel.setLayout(new GridLayout(1, 0));
		mainMainPanel.setSize(500, 500);

		slidePanel = new BackgroundPanel(Color.BLACK, Color.GREEN);

		mainMainPanel.add(slidePanel);

		resultsPanel = new JPanel();
		createResultsPanel();
		// we have to put this before we add the main panel so when settings
		// accesses the results it's not null

		settingsPanel = new JPanel();
		createSettingsPanel();
		mainMainPanel.add(settingsPanel);

		mainMainPanel.add(resultsPanel);

	}

	/**
	 * 
	 * @param
	 * This        creates our run panel
	 */
	private void createRunPanel()
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
	
	
	/**
	 * 
	 * @param
	 * This creates our results panel
	 */
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
	/**
	 * 
	 * @param
	 * This creates our settigs panel
	 */
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
		frictionSlider.setMajorTickSpacing(5);
		frictionSlider.setMinorTickSpacing(1);
		frictionSlider.setPaintTicks(true);
		frictionSlider.setPaintLabels(true);

		frictionSlider.setValue(0); 
		angleSlider.setValue(15); 
		heightSlider.setValue(10); 

		groundMaterial = new JLabel("Ground Material");
		
		 String[] comboOptions = { "Mulch", "Woodchips", "Asphalt" };
		
		GroundMaterial mulch = new GroundMaterial("Mulch", 10, Color.GREEN);
		GroundMaterial asph = new GroundMaterial("Asphalt", 10, Color.GRAY);
		GroundMaterial woodch = new GroundMaterial("Woodchips", 10,
				Color.ORANGE);
		GroundMaterial[] comboOptions2 = { mulch, asph, woodch };

		groundMaterialSelection = new JComboBox<String>(comboOptions);
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

	/**
	 * 
	 * 
	 * This class serves as the listener to both our angle and height sliders.
	 */
	public class sliderListener implements ChangeListener
	{

		private String variableName;
		private JSlider sliderName;
		private JLabel jlabelName;

		
		/**
		 * 
		 * @param variable name to change in results panel, slider name to get value, and jLabel to change in results panel
		 * This class updates the results panel with the slider result, as well calculate the length
		 */
		public sliderListener(String variableName, JSlider sliderName,
				JLabel jlabelName)
		{
			this.variableName = variableName;
			this.sliderName = sliderName;
			this.jlabelName = jlabelName;

		}
		/**
		 * 
		 * @param Changed event e
		 * This class updates the results panel with the slider result, as well calculate the length
		 */
		@Override
		public void stateChanged(ChangeEvent e)
		{

			jlabelName.setText(variableName + ": "
					+ String.valueOf(sliderName.getValue()));

			slidePanel.setHeight(heightSlider.getValue());

			
			// THis if statement checks height or angle is 0, which would cause unuseful inforamation. Thus it is set to "-- " in this case
			if (angleSlider.getValue() != 0 && heightSlider.getValue() != 0)
			{

				slidePanel.setLength(heightSlider.getValue()
						* Math.tan(Math.toRadians(angleSlider.getValue())));

				lengthResults.setText("Length: " + String
						.valueOf(df.format(heightSlider.getValue() * Math
								.tan(Math.toRadians(angleSlider.getValue())))));
			}else {
				lengthResults.setText("Length: -- ");
			}

		}

	}

	
	public class runButtonListener implements ActionListener
	{
		/**
		 * 
		 * @param Action event E
		 * This will reset the location of the ball to the top of the slide
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			runButton.setForeground(Color.BLUE);
		}
	}

	public class refreshButtonListener implements ActionListener
	{
		/**
		 * 
		 * @param Action event E
		 * This will reset the changed variables to defaults
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{

			angleSlider.setValue(15); 
										
			heightSlider.setValue(4); 
			heightSlider.setValue(10); 
			frictionSlider.setValue(0);
			slidePanel.setbaseX();
			slidePanel.setbaseY();

		}
	}

	
	
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


	public static void main(String[] args)
	{

		new SlideSimulationView();

	}

}
