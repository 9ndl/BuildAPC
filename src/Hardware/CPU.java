package Hardware;

public class CPU extends Part {
	private int CoreCount;
	private double CoreClock;
	private double Boostclock;
	private int TDP;
	private String IntegratingGraphics;
	private String Socket;
	public CPU() {
		CoreCount = 0;
		CoreClock = 0;
		Boostclock = 0;
		TDP = 0;
		IntegratingGraphics = "empty";
		Socket = "empty";
	}
	public int getCoreCount() {
		return CoreCount;
	}
	public void setCoreCount(int coreCount) {
		CoreCount = coreCount;
	}
	public double getCoreClock() {
		return CoreClock;
	}
	public void setCoreClock(double coreClock) {
		CoreClock = coreClock;
	}
	public double getBoostclock() {
		return Boostclock;
	}
	public void setBoostclock(double boostclock) {
		Boostclock = boostclock;
	}
	public int getTDP() {
		return TDP;
	}
	public void setTDP(int tDP) {
		TDP = tDP;
	}
	public String getIntegratingGraphics() {
		return IntegratingGraphics;
	}
	public void setIntegratingGraphics(String integratingGraphics) {
		IntegratingGraphics = integratingGraphics;
	}
	public String getSocket() {
		return Socket;
	}
	public void setSocket(String socket) {
		Socket = socket;
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
		System.out.println(shortname+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getCoreCount()+"\t"+this.getBoostclock()
		+"\t"+this.getTDP()+"\t"+this.getIntegratingGraphics()+"\t"+this.getSocket()+"\t");
	}
}
