package Hardware;

public class Monitor extends Part{
	private double ScreenSize;
	private String Resolution;
	private int RefreshRate;
	private int ResponseTime;
	private String PanelType;
	private String AspectRatio;
	private boolean CurvedScreen;
	private String Interface;
	private String FrameSync;
	
	
	public double getScreenSize() {
		return ScreenSize;
	}
	public void setScreenSize(double screenSize) {
		ScreenSize = screenSize;
	}
	public String getResolution() {
		return Resolution;
	}
	public void setResolution(String resolution) {
		Resolution = resolution;
	}
	public int getRefreshRate() {
		return RefreshRate;
	}
	public void setRefreshRate(int refreshRate) {
		RefreshRate = refreshRate;
	}
	public int getResponseTime() {
		return ResponseTime;
	}
	public void setResponseTime(int responseTime) {
		ResponseTime = responseTime;
	}
	public String getPanelType() {
		return PanelType;
	}
	public void setPanelType(String panelType) {
		PanelType = panelType;
	}
	public String getAspectRatio() {
		return AspectRatio;
	}
	public void setAspectRatio(String aspectRatio) {
		AspectRatio = aspectRatio;
	}
	public boolean isCurvedScreen() {
		return CurvedScreen;
	}
	public void setCurvedScreen(boolean curvedScreen) {
		CurvedScreen = curvedScreen;
	}
	public String getInterface() {
		return Interface;
	}
	public void setInterface(String interface1) {
		Interface = interface1;
	}
	public String getFrameSync() {
		return FrameSync;
	}
	public void setFrameSync(String frameSync) {
		FrameSync = frameSync;
	}
	public void printPartinfo(){
		System.out.print(this.getName()+"\t$"+this.getPrice()+"\t"+this.getSeller()+"\t"+this.getRating()+"\t"+this.getScreenSize()+" Inches\t"
				+this.getResolution()+"\t"+this.getRefreshRate()+" hz\t"+this.getResponseTime()+" ms\t"+this.getAspectRatio()+"\t");
		if(this.CurvedScreen == true) {System.out.print("Yes");}
		else { System.out.print("No");}
		System.out.println("\t"+this.getInterface()+"\t"+this.getFrameSync());

	}
}
