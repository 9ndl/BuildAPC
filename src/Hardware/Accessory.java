package Hardware;

public class Accessory extends Part{
	private String AccessorryType;
	private boolean Wireless;
	
	
	public String getAccessorryType() {
		return AccessorryType;
	}
	public void setAccessorryType(String accessorryType) {
		AccessorryType = accessorryType;
	}
	public boolean isWireless() {
		return Wireless;
	}
	public void setWireless(boolean wireless) {
		Wireless = wireless;
	}
	public void printPartinfo(){
		//System.out.println("Name \t Type \t Price \t Seller \t Rating \t Accesssory Type \t Wireless?");
		System.out.print(this.getName() + "\t$" + this.getPrice() + "\t" + this.getSeller() + "\t" + this.getAccessorryType() + "\t");
		if(this.Wireless == true) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}
	
}
