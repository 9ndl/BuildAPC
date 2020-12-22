package Hardware;

public class CPUCooler extends Part{
	private String FanRPM;
	private String Noise;
	private String Color;
	private String RadiatorSize;
	private boolean WaterCooled;
	public String getFanRPM() {
		return FanRPM;
	}
	public void setFanRPM(String fanRPM) {
		FanRPM = fanRPM;
	}
	public String getNoise() {
		return Noise;
	}
	public void setNoise(String noise) {
		Noise = noise;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getRadiatorSize() {
		return RadiatorSize;
	}
	public void setRadiatorSize(String radiatorSize) {
		RadiatorSize = radiatorSize;
	}
	public boolean isWaterCooled() {
		return WaterCooled;
	}
	public void setWaterCooled(boolean waterCooled) {
		WaterCooled = waterCooled;
	}
	public void printPartinfo(){
		String input = this.getName(); 	
		String shortname = ""; 	
		 
		if (input.length() > 20)
		{
		    shortname = input.substring(0, 20);
		}
		else
		{
		    shortname = input;
		}
		System.out.print(shortname+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getFanRPM()+" RPM\t"
				+this.getNoise()+" dbl\t"+this.getColor()+"\t"+this.getRadiatorSize()+"\t");
		if(this.WaterCooled == true) {
			System.out.println("Yes");}
		else {System.out.println("No");}
	}

}
