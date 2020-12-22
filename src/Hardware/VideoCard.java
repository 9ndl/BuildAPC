package Hardware;

public class VideoCard extends Part{
	//private String Chipset;
	private int MemorySize;
	private int CoreClock;
	private int BoostClock;
	private String Interface;
//	public String getChipset() {
//		return Chipset;
//	}
//	public void setChipset(String chipset) {
//		Chipset = chipset;
//	}
	public int getMemorySize() {
		return MemorySize;
	}
	public void setMemorySize(int memorySize) {
		MemorySize = memorySize;
	}
	public int getCoreClock() {
		return CoreClock;
	}
	public void setCoreClock(int coreClock) {
		CoreClock = coreClock;
	}
	public int getBoostClock() {
		return BoostClock;
	}
	public void setBoostClock(int boostClock) {
		BoostClock = boostClock;
	}
	public String getInterface() {
		return Interface;
	}
	public void setInterface(String interface1) {
		Interface = interface1;
	}
	public void printPartinfo(){
		System.out.println(this.getName()+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getMemorySize()+" GB VRAM\t"
				+ this.getCoreClock()+" hz\t"+this.getBoostClock()+" hz\t"+this.getInterface());

	}

}
