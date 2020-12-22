package Software;
import Hardware.*;
import People.*;
public class Driver {
	
	public static void main(String[] args) throws Exception{
		
		
		//test read function for all parts of the SYSTEM
		Website web = new Website();
		web = Website.ReadData();
		
		//test create accounts
		User user1 = new User();
		user1.setUsername("Yasser");
		user1.setEmail("Test@email.com");
		user1.setCurrency("USD");
		user1.setPassword("123456");
		
		
		
		User user2 = new User();
		user2.setUsername("kyle");
		user2.setEmail("Test2@email.com");
		user2.setCurrency("RY");
		user2.setPassword("1234");
		
		Build build1 = new Build();
		build1.setBuildname("superPC");
		//add CPU to build
		build1.AddCPUtoBuild(web.cpus.get(0));
		
		System.out.println("Compatible motherboards for the choosen CPU");
		
		for(int i = 0; i<web.motherboards.size();i++) {
			//test adding the compatible motherboard to the build
			if(web.motherboards.get(i).isCompatibleWithCPU(build1.getCpu())) {
				System.out.print(i+".");
				web.motherboards.get(i).printPartinfo();			
			}
		}
		//we choose B450 Tomahawk motherboard
		build1.AddMotherboardtoBuild(web.motherboards.get(2));
		
		//test finding and adding the compatible case for the build
		System.out.println("Compatible Cases for the choosen CPU & Motherboard");
		for(int i = 0; i < web.cases.size();i++) {
			if(web.cases.get(i).isCompatibleWithMotherboard(build1.getMotherboard())) {
				System.out.print(i+".");
				web.cases.get(i).printPartinfo();
			}
		}
		// we choose NZXT H500 to add to the build
		build1.AddCasetoBuild(web.cases.get(1));
		
		
		//test Memory
		System.out.println("Memory to choose from for the build");
		for(int i = 0; i < web.memories.size();i++) {	
				System.out.print(i+".");
				web.memories.get(i).printPartinfo();
		}
		//add memory to build we choose Corsair Vengeance RGB Pro
		build1.AddMemorytoBuild(web.memories.get(4));
		
		//test storage part
		
		System.out.println("Storages to choose from for the build");
		for(int i = 0; i < web.storages.size();i++) {	
				System.out.print(i+".");
				web.storages.get(i).printPartinfo();
		}
		//we choose 5.Samsung 970 Evo to add to build
		build1.AddStorage(web.storages.get(5));
		
		//test video card 
		System.out.println("Video Cards to choose from for the build");
		for(int i = 0; i < web.videocards.size();i++) {	
			System.out.print(i+".");
			web.videocards.get(i).printPartinfo();
		}
		//we choose 5.MSI GeForce RTX 2060 Ventus OC
		build1.AddVideoCard(web.videocards.get(5));
		
		//test CPUCooler
		System.out.println("CPU Cooler to choose from for the build");
		for(int i = 0; i < web.cpucoolers.size();i++) {	
			System.out.print(i+".");
			web.cpucoolers.get(i).printPartinfo();
		}
		//add 0.Noctua NH-U12A to build
		build1.AddCPUCooler(web.cpucoolers.get(0));
		
		
		//test PowerSupply
		System.out.println("Power Supply to choose from for the build");
		for(int i = 0; i < web.powersupplies.size();i++) {	
			System.out.print(i+".");
			web.powersupplies.get(i).printPartinfo();
		}
		//add 2.Corsair RM to build
		build1.AddPSU(web.powersupplies.get(2));
		
		//test monitor 
		System.out.println("Monitors to choose from for the build");
		for(int i = 0; i < web.monitors.size();i++) {	
			System.out.print(i+".");
			web.monitors.get(i).printPartinfo();
		}
		//test add 1.MSI Optix MAG241C to build
		build1.AddMonitor(web.monitors.get(1));
		
		//test monitor 
		System.out.println("Accessories to choose from for the build");
		for(int i = 0; i < web.accessories.size();i++) {	
			System.out.print(i+".");
			web.accessories.get(i).printPartinfo();
		}
		//test add 1.MSI Optix MAG241C to build
		build1.AddAccessory(web.accessories.get(1));
		
		//test add build to user
		user1.addBuild(build1);
		Build build2 = new Build();
		build2.setBuildname("build1");
		build2.AddCPUtoBuild(web.cpus.get(4));
		user2.addBuild(build2);
		
		//test add users to the web
		web.Addaccount(user1);
		web.Addaccount(user2);
		//print all builds in the system
		for(int i = 0; i < web.users.size();i++) {
			System.out.println("the Build for "+web.users.get(i).getUsername());
			for(int j = 0; j < web.users.get(i).builds.size();j++){
				System.out.println("Build number #"+(j+1));
				web.users.get(i).getBuilds().get(j).PrintBuild();
				
			}
		}
		
		System.out.println("test signing in");
		//test sign in and sign out
		web.SignIn(web.users.get(0), "123456");
		if(web.users.get(0).isSignedIn()) {
			web.users.get(0).printAccountinfo();
		}
		//test sign out
		System.out.println("test signing out");
		web.users.get(0).SignOut();
		web.users.get(0).printAccountinfo();
		
		
		//test print all parts in system
		System.out.println("test print all parts in system");
		web.printAllPartsinfo();
		Website.saveData(web);
		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	}
	
	

}
