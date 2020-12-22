package Hardware;

public class Storage extends Part{
	private String Capacity;
	private String StorageType;
	private double Cache;
	private String FormFactor;
	private String Interface;
	
	public Storage() {
		Capacity = "";
		StorageType = "";
		Cache = 0;
		FormFactor = "";
		Interface = "";
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getStorageType() {
		return StorageType;
	}

	public void setStorageType(String storageType) {
		StorageType = storageType;
	}

	public double getCache() {
		return Cache;
	}

	public void setCache(double cache) {
		Cache = cache;
	}

	public String getFormFactor() {
		return FormFactor;
	}

	public void setFormFactor(String formFactor) {
		FormFactor = formFactor;
	}

	public String getInterface() {
		return Interface;
	}

	public void setInterface(String interface1) {
		Interface = interface1;
	}
	public void printPartinfo(){
		System.out.println(this.getName()+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getCapacity()+"\t"
				+this.getStorageType()+"\t"+this.getCache()+"\t"+this.getFormFactor()+"\t"+this.getInterface());
	}
}
