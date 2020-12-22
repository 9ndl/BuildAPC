package Hardware;

public class PowerSupply extends Part{
	private String FormFactor;
	private String EfficiencyRating;
	private int Wattage;
	private String Modular;
	private String Color;
	public String getFormFactor() {
		return FormFactor;
	}
	public void setFormFactor(String formFactor) {
		FormFactor = formFactor;
	}
	public String getEfficiencyRating() {
		return EfficiencyRating;
	}
	public void setEfficiencyRating(String efficiencyRating) {
		EfficiencyRating = efficiencyRating;
	}
	public int getWattage() {
		return Wattage;
	}
	public void setWattage(int wattage) {
		Wattage = wattage;
	}
	public String getModular() {
		return Modular;
	}
	public void setModular(String modular) {
		Modular = modular;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public void printPartinfo(){
		System.out.println(this.getName()+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getFormFactor()+"\t"
				+this.getEfficiencyRating()+"\t"+this.getWattage()+"\t"+this.getModular()+"\t"+this.getColor()+"\t");

	}
}
