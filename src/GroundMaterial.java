import java.awt.Color;

//TODO implement this class to make it change ground color and impact 


public class GroundMaterial
{
	
	private String name;
	private int percentage;
	private Color color;

	GroundMaterial(String name, int percentage, Color color){
		
//		GroundMaterial[] comboOptions2 = {GroundMaterial("Mulch",10,Color.RED)};
	
		this.name = name;
		this.percentage = percentage;
		this.color = color;

	}
	public String getName(){
		return name;
	}
	
	public Color getColor(){
		return color;
	}

	public int getPercentage(){
		return percentage;
	}
	
	

}
