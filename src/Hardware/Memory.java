package Hardware;

public class Memory extends Part{
	private String Speed;
	private String MemoryType;
	private String module;
	private int MSize;
	
	public Memory() {
		Speed = "";
		MemoryType = "";
		module = "";
	}

	public String getSpeed() {
		return Speed;
	}

	public void setSpeed(String speed) {
		Speed = speed;
	}

	public String getMemoryType() {
		return MemoryType;
	}

	public void setMemoryType(String memoryType) {
		MemoryType = memoryType;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public int getMSize() {
		return MSize;
	}

	public void setMSize(int mSize) {
		MSize = mSize;
	}
	public void printPartinfo(){
		System.out.println(this.getName()+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getMSize()+" GB\t"+this.getSpeed()+"\t"+this.getModule());
	}
}
