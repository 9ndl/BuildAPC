package Software;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;



import Hardware.*;
import People.*;

public class Website implements Serializable {
	public ArrayList<User> users;
	public ArrayList<Part> parts;
	public ArrayList<CPU> cpus;
	public ArrayList<Case> cases;
	public ArrayList<Accessory> accessories;
	public ArrayList<CPUCooler> cpucoolers;
	public ArrayList<Memory> memories;
	public ArrayList<Monitor> monitors;
	public ArrayList<Motherboard> motherboards;
	public ArrayList<PowerSupply> powersupplies;
	public ArrayList<Storage> storages;
	public ArrayList<VideoCard> videocards;
	
	public Website() {
		users = new ArrayList<User>();
		parts = new ArrayList<Part>();
		cpus = new ArrayList<CPU>();
		cases = new ArrayList<Case>();
		accessories = new ArrayList<Accessory>();
		cpucoolers = new ArrayList<CPUCooler>();
		memories = new ArrayList<Memory>();
		monitors = new ArrayList<Monitor>();
		motherboards = new ArrayList<Motherboard>();
		powersupplies = new ArrayList<PowerSupply>();
		storages = new ArrayList<Storage>();
		videocards = new ArrayList<VideoCard>();
	}
	public void Addaccount(User user) {
		users.add(user);
	}

	public static Website ReadData() throws Exception{ 
		//READ CPU PARTS FROM DATABASE //
		//------------------ Read CPU ------------------//
		File file = new File("database/CPU_Data.txt");
		Website web = new Website();
		Scanner sc = new Scanner(file); 
		String[] temp = new String[20];
		while (sc.hasNextLine()) {
			CPU cpu = new CPU();
		   	temp = sc.nextLine().split(", ");
		   	cpu.setName(temp[0]); //name
		   	cpu.setType(temp[1]); //type   	
		    cpu.setPrice(Double.parseDouble(temp[2])); //price
		   	cpu.setSeller(temp[3]);
		   	cpu.setRating(Double.parseDouble(temp[4]));
		   	cpu.setCoreCount(Integer.parseInt(temp[5]));
		   	cpu.setCoreClock(Double.parseDouble(temp[6]));
	    	cpu.setBoostclock(Double.parseDouble(temp[7]));
	    	cpu.setTDP(Integer.parseInt(temp[8]));
	    	cpu.setIntegratingGraphics(temp[9]);
		   	cpu.setSocket(temp[10]);
		   	web.AddPart(cpu);	
		   	web.cpus.add(cpu);
		}
		sc.close();
		//------------------ Read motherboard ------------------//
		file = new File("database/Motherboard_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			Motherboard mother = new Motherboard();
		   	temp = sc.nextLine().split(", ");
		   	mother.setName(temp[0]); //name
		   	mother.setType(temp[1]); //type   	
		    mother.setPrice(Double.parseDouble(temp[2])); //price
		   	mother.setSeller(temp[3]); //
		   	mother.setRating(Double.parseDouble(temp[4]));
		   	mother.setSocket(temp[5]);
		   	mother.setFormFactor(temp[6]);
		   	mother.setRAMSlot(Integer.parseInt(temp[7]));
		   	mother.setRAMMax(Integer.parseInt(temp[8]));
		   	mother.setChipset(temp[9]);
		   	mother.setMemoryType(temp[10]);
		   	web.AddPart(mother);
		   	web.motherboards.add(mother);
		}
		sc.close();
		//------------------ Read Storage ------------------//
		file = new File("database/Storage_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			Storage storage = new Storage();
		   	temp = sc.nextLine().split(", ");
		   	storage.setName(temp[0]); //name
		   	storage.setType(temp[1]); //type   	
		    storage.setPrice(Double.parseDouble(temp[2])); //price
		   	storage.setSeller(temp[3]); //seller
		   	storage.setRating(Double.parseDouble(temp[4])); //rating
		   	storage.setCapacity(temp[5]);
		   	storage.setStorageType(temp[6]);
		   	storage.setCache(Double.parseDouble(temp[7]));
		   	storage.setFormFactor(temp[8]);
		   	storage.setInterface(temp[9]);
		   	web.AddPart(storage);
		   	web.storages.add(storage);
		}
		sc.close();
		//------------------ Read Memory ------------------//
				file = new File("database/Memory_Data.txt");
				sc = new Scanner(file); 
				temp = null;
				while (sc.hasNextLine()) {
					Memory mem = new Memory();
				   	temp = sc.nextLine().split(", ");
				   	mem.setName(temp[0]); //name
				   	mem.setType(temp[1]); //type   	
				    mem.setPrice(Double.parseDouble(temp[2])); //price
				   	mem.setSeller(temp[3]); //seller
				   	mem.setRating(Double.parseDouble(temp[4])); //rating
				   	mem.setMSize(Integer.parseInt(temp[5]));
				   	mem.setSpeed(temp[6]);
				   	mem.setMemoryType(temp[7]);
				   	mem.setModule(temp[8]);
				   	web.AddPart(mem);
				   	web.memories.add(mem);
				}
		sc.close();
		//------------------ Read PowerSupply ------------------//
				file = new File("database/PowerSupply_Data.txt");
				sc = new Scanner(file); 
				temp = null;
				while (sc.hasNextLine()) {
					PowerSupply power = new PowerSupply();
				   	temp = sc.nextLine().split(", ");
				   	power.setName(temp[0]); //name
				   	power.setType(temp[1]); //type   	
				    power.setPrice(Double.parseDouble(temp[2])); //price
				   	power.setSeller(temp[3]); //seller
				   	power.setRating(Double.parseDouble(temp[4])); //rating
				   	power.setFormFactor(temp[5]);
				   	power.setEfficiencyRating(temp[6]);
				   	power.setWattage(Integer.parseInt(temp[7]));
				   	power.setModular(temp[8]);
				   	power.setColor(temp[9]);
				   	web.AddPart(power);
				   	web.powersupplies.add(power);
				}
		sc.close();
		//------------------ Read Accessory ------------------//
		file = new File("database/Accessories_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			Accessory access = new Accessory();
			temp = sc.nextLine().split(", ");
			access.setName(temp[0]); //name
			access.setType(temp[1]); //type   	
			access.setPrice(Double.parseDouble(temp[2])); //price
			access.setSeller(temp[3]); //seller
			access.setRating(Double.parseDouble(temp[4])); //rating				   	
			access.setAccessorryType(temp[5]);
			access.setWireless(Boolean.parseBoolean(temp[6]));
		   	web.AddPart(access);
		   	web.accessories.add(access);
		}
		sc.close();
		//------------------ Read Case ------------------//
		file = new File("database/Case_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			Case cas = new Case();
			temp = sc.nextLine().split(", ");
			cas.setName(temp[0]); //name
			cas.setType(temp[1]); //type   	
			cas.setPrice(Double.parseDouble(temp[2])); //price
			cas.setSeller(temp[3]); //seller
			cas.setRating(Double.parseDouble(temp[4])); //rating
			cas.setCaseType(temp[5]);
			cas.setSidePanel(temp[6]);
			cas.setColor(temp[7]);
			cas.setFrontPanelUSB(temp[8]);
			cas.setMotherboardFormFactor(temp[9]);
			cas.setBay25(Integer.parseInt(temp[10]));
			cas.setBay35(Integer.parseInt(temp[11]));
		   	web.AddPart(cas);
		   	web.cases.add(cas);
		}
		sc.close();
		//------------------ Read Cooler ------------------//
		file = new File("database/Cooler_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			CPUCooler cooler = new CPUCooler();
			temp = sc.nextLine().split(", ");
			cooler.setName(temp[0]); //name
			cooler.setType(temp[1]); //type   	
			cooler.setPrice(Double.parseDouble(temp[2])); //price
			cooler.setSeller(temp[3]); //seller
			cooler.setRating(Double.parseDouble(temp[4])); //rating
			cooler.setFanRPM(temp[5]);
			cooler.setNoise(temp[6]);
			cooler.setColor(temp[7]);
			cooler.setRadiatorSize(temp[8]);
			cooler.setWaterCooled(Boolean.parseBoolean(temp[9]));
		   	web.AddPart(cooler);
		   	web.cpucoolers.add(cooler);
		}
		sc.close();
		//------------------ Read Monitor ------------------//
		file = new File("database/Monitor_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			Monitor monitor = new Monitor();
			temp = sc.nextLine().split(", ");
			monitor.setName(temp[0]); //name
			monitor.setType(temp[1]); //type   	
			monitor.setPrice(Double.parseDouble(temp[2])); //price
			monitor.setSeller(temp[3]); //seller
			monitor.setRating(Double.parseDouble(temp[4])); //rating
			monitor.setScreenSize(Double.parseDouble(temp[5]));
			monitor.setResolution(temp[6]);
			monitor.setRefreshRate(Integer.parseInt(temp[7]));
			monitor.setResponseTime(Integer.parseInt(temp[8]));
			monitor.setPanelType(temp[9]);
			monitor.setAspectRatio(temp[10]);
			monitor.setCurvedScreen(Boolean.parseBoolean(temp[11]));
			monitor.setInterface(temp[12]);
			monitor.setFrameSync(temp[13]);
		   	web.AddPart(monitor);
		   	web.monitors.add(monitor);
		}
		sc.close();
		//------------------ Read VideoCard ------------------//
		file = new File("database/VideoCard_Data.txt");
		sc = new Scanner(file); 
		temp = null;
		while (sc.hasNextLine()) {
			VideoCard card = new VideoCard();
			temp = sc.nextLine().split(", ");
			card.setName(temp[0]); //name
			card.setType(temp[1]); //type   	
			card.setPrice(Double.parseDouble(temp[2])); //price
			card.setSeller(temp[3]); //seller
			card.setRating(Double.parseDouble(temp[4])); //rating
			card.setMemorySize(Integer.parseInt(temp[5]));
			card.setCoreClock(Integer.parseInt(temp[6]));
			card.setBoostClock(Integer.parseInt(temp[7]));
			card.setInterface(temp[8]);
		   	web.AddPart(card);
		   	web.videocards.add(card);
		}
		sc.close();
	
	return web;	
	}

	public void AddPart(Part p) {
		parts.add(p);
	}
	
	public void printAllPartsinfo() {
		for(int i = 0; i < parts.size(); i++) {
			System.out.println(this.parts.get(i).getName() + " - " + this.parts.get(i).getType()
					+ " - " + this.parts.get(i).getRating() + " stars - $"+ this.parts.get(i).getPrice());
		}
	}
	public void SignIn(User user, String pass) {
		for(int i = 0; i < users.size();i++) {
			if(user == users.get(i)) {
				if(users.get(i).getPassword().equals(pass)) {
					users.get(i).SignIn();
					break;
				}
			}
		}
	}
	public void SignOut() {
		for(int i = 0; i < users.size();i++) {
			users.get(i).SignOut();
		}
	}
	public static void saveData(Website web){
		
		
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream("./root/Website.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(web);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }		
		}

	public static Website loadData(){	
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Website web = null;
			
		try
		{
			fileIn = new FileInputStream("./root/Website.ser");
			objIn = new ObjectInputStream(fileIn);
			web = (Website) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		return web;
		}
	public User getSignedInUser() {
		User user=null;
		for(int i = 0; i < users.size();i++) {
			if(users.get(i).isSignedIn()) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}
	
	public Boolean UsernameIsValid(String name) {
		boolean valid = true;
		for(int i = 0; i<users.size();i++) {
			if(name.equals(users.get(i).getUsername())){
				valid = false;
				break;
			}
		}
		return valid;
	}

}
