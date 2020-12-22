package Hardware;

public class Case extends Part{
	private String CaseType;
	private String SidePanel;
	private String Color;
	private String FrontPanelUSB;
	private String MotherboardFormFactor;
	private int bay25;
	private int bay35;
	
	public String getCaseType() {
		return CaseType;
	}
	public void setCaseType(String caseType) {
		CaseType = caseType;
	}
	public String getSidePanel() {
		return SidePanel;
	}
	public void setSidePanel(String sidePanel) {
		SidePanel = sidePanel;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getFrontPanelUSB() {
		return FrontPanelUSB;
	}
	public void setFrontPanelUSB(String frontPanelUSB) {
		FrontPanelUSB = frontPanelUSB;
	}
	public String getMotherboardFormFactor() {
		return MotherboardFormFactor;
	}
	public void setMotherboardFormFactor(String motherboardFormFactor) {
		MotherboardFormFactor = motherboardFormFactor;
	}
	public int getBay25() {
		return bay25;
	}
	public void setBay25(int bay25) {
		this.bay25 = bay25;
	}
	public int getBay35() {
		return bay35;
	}
	public void setBay35(int bay35) {
		this.bay35 = bay35;
	}
	public void printPart() {
		System.out.println(this.getName()+" "+this.getType()+" "+this.getSeller()+" $"+this.getPrice()
		+" "+this.getRating()+" "+this.getCaseType()+" "+this.getSidePanel()+" "+this.getColor()
		+" "+this.getFrontPanelUSB()+" "+this.getMotherboardFormFactor()+" "+this.getBay25()+" "
		+this.getBay35());
	}
	public boolean isCompatibleWithMotherboard(Motherboard p) {
		String A = p.getFormFactor();
		
		if(A.equals(MotherboardFormFactor)){
			return true;
		}else if((A.equals("Micro ATX"))&&(MotherboardFormFactor.equals("ATX"))){
			return true;
		}	
		return false;
	}
	public void printPartinfo(){
		System.out.println(this.getName()+"\t"+this.getType()+"\t"+this.getSeller()+"\t$"+this.getPrice()
		+"\t"+this.getRating()+"\t"+this.getSidePanel()+"\t"+this.getColor()
		+"\t"+this.getFrontPanelUSB()+"\t"+this.getMotherboardFormFactor()+"\t"+this.getBay25()+"\t"
		+this.getBay35());
	}
	
}
