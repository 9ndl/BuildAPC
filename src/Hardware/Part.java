package Hardware;

import java.io.Serializable;

public abstract class Part implements Serializable{
	private String Name;
	private String Type;
	private double Price; //change in the diagram
	private String Seller;
	private double Rating; // change in the diagram
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getSeller() {
		return Seller;
	}
	public void setSeller(String seller) {
		Seller = seller;
	}
	public double getRating() {
		return Rating;
	}
	public void setRating(double rating) {
		Rating = rating;
	}
	abstract void printPartinfo();
}
