
import java.awt.event.*;
import javax.swing.*;

// These are my new ones
import java.awt.*;
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
	private JPanel mainPanel;
	private JLabel instructions;
	
	private JPanel runPanel;
	private JButton runButton;
	
	private JPanel mainMainPanel;
	
	private JPanel slideSimulationPanel;
	
	private JPanel resultsPanel;
	private JLabel results;
	
	private JPanel settingsPanel;
	private JLabel height;
	private JSlider heightSlider;
	private JLabel angle;
	private JSlider angleSlider;
	private JLabel friction;
	private JSlider FrictionSlider;
	private JLabel groundMaterial;
	private JComboBox<String> groundMaterialSelection;

	
	
	
	
	


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
//		 final int WINDOW_WIDTH = 100;
//		 final int WINDOW_HEIGHT = 100;
		//
		// // set the size
		 setSize(900,700);
	//	 setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pack gets rid of the need of setSize as it condeses the window to the
		// smallest size

		mainPanel = new JPanel();
		createPanel1();
		add(mainPanel, BorderLayout.NORTH);

		mainMainPanel = new JPanel();
		createPanel3Main();
		add(mainMainPanel, BorderLayout.CENTER);
		
		runPanel = new JPanel();
		createPanel2();
		add(runPanel, BorderLayout.SOUTH);

		//pack();

		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// setResizable(false); // to make it so the animation cannot be stretched
	}

	private void createPanel1()
	{
		//mainPanel.setLayout(new BorderLayout());

		instructions = new JLabel("Use this simulation to test potential playground slides");

		mainPanel.add(instructions);

	}
	
	private void createPanel2()
	{
		runButton = new JButton("Run");
		
		runPanel.add(runButton);

	}
	
	private void createPanel3Main()
	{
		mainMainPanel.setLayout(new FlowLayout());
		mainMainPanel.setSize(500,500);

		slideSimulationPanel = new JPanel();
		//BackgroundPanel clockPanel = new BackgroundPanel(Color.BLACK, Color.GREEN);
		// slideSimulationPanel.add(clockPanel);
		createSlideSimulationPanel();
		//slideSimulationPanel.setSize(500,400);
		mainMainPanel.add(slideSimulationPanel);

		
		
		settingsPanel = new JPanel();
		createSettingsPanel();
		mainMainPanel.add(settingsPanel);

		
		resultsPanel = new JPanel();
		createResultsPanel();		
		mainMainPanel.add(resultsPanel);
	}
	
	private void createResultsPanel()
	{

		results = new JLabel("Height:" + "height");
		// I may need to add a diffrent as Jlabel is only one line
		resultsPanel.add(results);
	}
	
	private void createSettingsPanel()
	{

		settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridLayout(0,1));

		height = new JLabel("height");
		heightSlider = new JSlider(0,10);
		heightSlider.setMajorTickSpacing(5);
		heightSlider.setMinorTickSpacing(1);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		
		
		angle = new JLabel("angle");
		angleSlider = new JSlider(0,45); 
		angleSlider.setMajorTickSpacing(15);
		angleSlider.setMinorTickSpacing(5);
		angleSlider.setPaintTicks(true);
		angleSlider.setPaintLabels(true);
		
		
		friction = new JLabel("friction");
		FrictionSlider = new JSlider(0,10); 
		FrictionSlider.setMajorTickSpacing(5);
		FrictionSlider.setMinorTickSpacing(1);
		FrictionSlider.setPaintTicks(true);
		FrictionSlider.setPaintLabels(true);
		
		
		groundMaterial = new JLabel("Ground Material");
		String[] comboOptions = { "Mulch", "Woodchips", "Asphalt" };
	      
		groundMaterialSelection = new JComboBox<String>(comboOptions);

		settingsPanel.add(height);
		settingsPanel.add(heightSlider);
		settingsPanel.add(angle);
		settingsPanel.add(angleSlider);
		settingsPanel.add(friction);
		settingsPanel.add(FrictionSlider);
		settingsPanel.add(groundMaterial);
		settingsPanel.add(groundMaterialSelection);

		


	}

	
	public void createSlideSimulationPanel() {
		
		JLabel blah = new JLabel("hello");
		 BackgroundPanel clockPanel = new BackgroundPanel(Color.BLACK, Color.GREEN);
		 //slideSimulationPanel.setSize(100,100);
		 slideSimulationPanel.add(blah);
		 slideSimulationPanel.add(clockPanel);
		
	
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
