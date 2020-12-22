package Software;

import Hardware.*;

import java.io.Serializable;
import java.util.*;
public class Build implements Serializable{
	private String buildname;
	private CPU cpu;
	private Motherboard motherboard;
	private Memory memory;
	private VideoCard videocard;
	private ArrayList<Storage> storage = new ArrayList<Storage>();
	private Case cAse;
	private Monitor monitor;
	private PowerSupply powersupply;
	private ArrayList<Accessory> accessory = new ArrayList<Accessory>();
	private CPUCooler cpucooler;
	private double BuildPrice = 0;
	public String getBuildname() {
		return buildname;
	}
	public void setBuildname(String buildname) {
		this.buildname = buildname;
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public Motherboard getMotherboard() {
		return motherboard;
	}
	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	public VideoCard getVideocard() {
		return videocard;
	}
	public void setVideocard(VideoCard videocard) {
		this.videocard = videocard;
	}
	public ArrayList<Storage> getStorage() {
		return storage;
	}
	public void setStorage(Storage stor) {
		this.storage.add(stor);
	}
	public Case getcAse() {
		return cAse;
	}
	public void setcAse(Case cAse) {
		this.cAse = cAse;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	public PowerSupply getPowersupply() {
		return powersupply;
	}
	public void setPowersupply(PowerSupply powersupply) {
		this.powersupply = powersupply;
	}
	public ArrayList<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(Accessory accessor) {
		this.accessory.add(accessor);
	}
	public CPUCooler getCpucooler() {
		return cpucooler;
	}
	public void setCpucooler(CPUCooler cpucooler) {
		this.cpucooler = cpucooler;
	}
	public void ComarePart(Part a, Part b) {
		
	}
//	private double getAccessoriesPrice() {
//		double num;
//		for()
//		return num
//	}
	public void AddPartToBuild(Part p) {
		String type = p.getType();
		if(type == "CPU") {

		}else if(type == "Motherboard"){
			
		}else if(type == "Memory"){
			memory = new Memory();
			memory.setName(p.getName());
			memory.setPrice(p.getPrice());
			memory.setType("Memory");
			memory.setSeller(p.getSeller());
			memory.setRating(p.getRating());
		}else if(type == "Storage"){			
			Storage storag = new Storage();
			storag.setName(p.getName());
			storag.setPrice(p.getPrice());
			storag.setType("Storage");
			storag.setSeller(p.getSeller());
			storag.setRating(p.getRating());
			storage.add(storag);
		}else if(type == "PSU"){
			powersupply = new PowerSupply();
			powersupply.setName(p.getName());
			powersupply.setPrice(p.getPrice());
			powersupply.setType("PSU");
			powersupply.setSeller(p.getSeller());
			powersupply.setRating(p.getRating());
		}else if(type == "Accessory"){
			Accessory access = new Accessory();
			access.setName(p.getName());
			access.setPrice(p.getPrice());
			access.setType("Accessory");
			access.setSeller(p.getSeller());
			access.setRating(p.getRating());
			accessory.add(access);
		}else if(type == "Case"){
			cAse = new Case();
			cAse.setName(p.getName());
			cAse.setPrice(p.getPrice());
			cAse.setType("Case");
			cAse.setSeller(p.getSeller());
			cAse.setRating(p.getRating());
		}else if(type == "CPU Cooler"){
			cpucooler = new CPUCooler();
			cpucooler.setName(p.getName());
			cpucooler.setPrice(p.getPrice());
			cpucooler.setType("CPU Cooler");
			cpucooler.setSeller(p.getSeller());
			cpucooler.setRating(p.getRating());
		}else if(type == "Monitor"){
			monitor = new Monitor();
			monitor.setName(p.getName());
			monitor.setPrice(p.getPrice());
			monitor.setType("Monitor");
			monitor.setSeller(p.getSeller());
			monitor.setRating(p.getRating());
		}else if(type == "Video Card"){
			videocard = new VideoCard();
			videocard.setName(p.getName());
			videocard.setPrice(p.getPrice());
			videocard.setType("Video Card");
			videocard.setSeller(p.getSeller());
			videocard.setRating(p.getRating());
		}else {
			System.out.println("Type entered is not compatible with the build");
		}
	}

	public void AddCPUtoBuild(CPU p) {
		cpu = new CPU();
		cpu.setName(p.getName());
		cpu.setPrice(p.getPrice());
		cpu.setType("CPU");
		cpu.setSeller(p.getSeller());
		cpu.setRating(p.getRating());
		cpu.setSocket(p.getSocket());
	}
	public void AddMotherboardtoBuild(Motherboard p) {
		if(p.isCompatibleWithCPU(cpu)) {
			motherboard = new Motherboard();
			motherboard = p;
		}
	}
	public void AddCasetoBuild(Case cas) {
		if(cas.isCompatibleWithMotherboard(motherboard)) {
			cAse = cas;
		}
	}
	public void AddMemorytoBuild(Memory mem) {
		memory = mem;
	}
	public void AddStorage(Storage s) {
		storage.add(s);
	}
	public void AddVideoCard(VideoCard v) {
		videocard = v;
	}
	
	public double getBuildPrice() {
		BuildPrice = 0;
		
		if(cpu != null) {
			BuildPrice += cpu.getPrice();
		}
		if(motherboard != null) {
			BuildPrice += cpu.getPrice();
		}
		if(memory != null) {
			BuildPrice += memory.getPrice();
		}
		if(videocard != null) {
			BuildPrice += videocard.getPrice();}
		if(storage.size() != 0) {
			BuildPrice += storage.get(0).getPrice();}
		if(cAse != null) {
			BuildPrice += cAse.getPrice();}
		if(monitor != null) {
			BuildPrice += monitor.getPrice();}
		if(powersupply != null) {
			BuildPrice += powersupply.getPrice();}
		if(accessory.size()!=0) {
			BuildPrice += accessory.get(0).getPrice();}
		if(cpucooler != null) {
			BuildPrice += cpucooler.getPrice();}

		
		
		return BuildPrice;
	}
	public void AddCPUCooler(CPUCooler cooler) {
		cpucooler = cooler;
	}
	public void AddPSU(PowerSupply p) {
		powersupply = p;
	}
	public void AddMonitor(Monitor m) {
		monitor = m;
	}
	public void AddAccessory(Accessory a) {
		accessory.add(a);
	}
	public void PrintBuild() {
		if(cpu != null) {
			System.out.println("CPU: " +cpu.getName() + " $"+cpu.getPrice()+ " "+ cpu.getRating()+"Star");	
		}
		if(motherboard != null) {
			System.out.println("Motherboard: " +motherboard.getName() + " $"+motherboard.getPrice()+ " "+ motherboard.getRating()+"Star");	
		}
		if(memory != null) {
			System.out.println("Memory: " +memory.getName() + " $"+memory.getPrice()+ " "+ memory.getRating()+"Star");
		}
		if(videocard != null) {
			System.out.println("videocard: " +videocard.getName() + " $"+videocard.getPrice()+ " "+ videocard.getRating()+"Star");
		}
		if(storage.size() != 0) {
			System.out.println("Storage: " +storage.get(0).getName() + " $"+storage.get(0).getPrice()+ " "+ storage.get(0).getRating()+"Star");
		}
		if(cAse != null) {
			System.out.println("Case: " +cAse.getName() + " $"+cAse.getPrice()+ " "+ cAse.getRating()+"Star");
		}
		if(monitor != null) {
			System.out.println("Monitor: " +monitor.getName() + " $"+monitor.getPrice()+ " "+ monitor.getRating()+"Star");
		}
		if(powersupply != null) {
			System.out.println("Power Supply: " +powersupply.getName() + " $"+powersupply.getPrice()+ " "+ powersupply.getRating()+"Star");
		}
		if(accessory.size()!=0) {
			System.out.println("Accessory: " +accessory.get(0).getName() + " $"+accessory.get(0).getPrice()+ " "+ accessory.get(0).getRating()+"Star");
		}
		if(cpucooler != null) {
			System.out.println("CPU Cooler: " +cpucooler.getName() + " $"+cpucooler.getPrice()+ " "+ cpucooler.getRating()+"Star");
		}

		
		System.out.println("The total Build Price: $" +this.getBuildPrice());

	}
}
