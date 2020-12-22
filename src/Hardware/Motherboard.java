package Hardware;

public class Motherboard extends Part {
	private String Socket;
	private String FormFactor;
	private int RAMSlot;
	private int RAMMax;
	private String Chipset;
	private String MemoryType;
	
	public String getSocket() {
		return Socket;
	}
	public void setSocket(String socket) {
		Socket = socket;
	}
	public String getFormFactor() {
		return FormFactor;
	}
	public void setFormFactor(String formFactor) {
		FormFactor = formFactor;
	}
	public int getRAMSlot() {
		return RAMSlot;
	}
	public void setRAMSlot(int rAMSlot) {
		RAMSlot = rAMSlot;
	}
	public int getRAMMax() {
		return RAMMax;
	}
	public void setRAMMax(int rAMMax) {
		RAMMax = rAMMax;
	}
	public String getChipset() {
		return Chipset;
	}
	public void setChipset(String chipset) {
		Chipset = chipset;
	}
	public String getMemoryType() {
		return MemoryType;
	}
	public void setMemoryType(String memoryType) {
		MemoryType = memoryType;
	}
	public Boolean isCompatibleWithCPU(CPU p) {
		boolean compatible = false;
		String A = this.getSocket();
		String B = p.getSocket();
		if(A.equals(B)) {
			compatible = true;
		}
		return compatible;
	}
	public void printPartinfo(){
		String input = this.getName(); 	
		String shortname = ""; 	 
		if (input.length() > 21){
		    shortname = input.substring(0, 21);}
		else{shortname = input;}
		System.out.print(shortname);
		if(input.length() <= 6) System.out.print("\t\t");
		else if(input.length() <= 14) System.out.print("\t\t");
		else System.out.print("\t");
		System.out.print(this.getPrice()+"\t"+this.getSeller());
		if(this.getSeller().length() < 7) System.out.print("\t\t");
		else System.out.print("\t");
		System.out.print(+this.getRating()+ "\t"+ this.getSocket()+ "\t" + this.getFormFactor());
		if(this.getFormFactor().length() < 7) System.out.print("\t\t\t");
		else System.out.print("\t\t");
		System.out.println(this.getRAMSlot() + "\t" + this.getRAMMax()+ "\t" + this.getChipset() + "\t" + this.getMemoryType());
		}
}
