package Software;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import People.User;



public class WebsiteGUI extends JFrame{

	private Website  web = new Website();
	private JMenuBar menuBar;		//the horizontal container
	private JMenu UserMenu;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenu PartMenu;
	private JMenu RcomendedBuildsMenue;
	//private JMenu Interactive;
	private JMenu Builds;
	
	//UserMenu
	private JMenuItem FileSave;
	private JMenuItem FileLoad;
	private JMenuItem Exit;
	private JMenuItem SignIn;
	private JMenuItem SignOut;
	private JMenuItem createaccount;
	
	//PartsMenu
	private JMenuItem PrintAllParts;
	private JMenuItem PrintAllCPU;
	private JMenuItem PrintAllMother;
	private JMenuItem PrintAllMemory;
	private JMenuItem PrintAllVideo;
	private JMenuItem PrintAllStorage;
	private JMenuItem PrintAllCPUCooler;
	private JMenuItem PrintAllPSU;
	private JMenuItem PrintAllCase;
	private JMenuItem PrintAllMonitor;
	private JMenuItem PrintAllAccessory;
	
	//BuildsMenu
	private JMenuItem createnewbuild;
	private JMenuItem PrintAllUserBuilds;
	private JMenuItem removebuild;
	
	//Recommendedbuilds menu;
	private JMenuItem Printrecommendedbuild;
	
	public WebsiteGUI(String windowTitle, Website web1) {
		super(windowTitle);

		web = web1;


		setSize(400, 100); //size of the window
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(new JLabel("<HTML><center>Welcome to BuildAPC where PC building dreams come true." +
				"<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	
	public void buildGUI() 
	{
		menuBar = new JMenuBar();
     	
		// four menus in the bar
		UserMenu = new JMenu("User");
		PartMenu = new JMenu("Parts");
		Builds = new JMenu("Builds");
		RcomendedBuildsMenue = new JMenu("Recomended Builds");

		// Create account setup
		createaccount = new JMenuItem("Creata a new account");
		createaccount.addActionListener(new MenuListener());
		UserMenu.add(createaccount);
		
		// Sign in setup
		SignIn = new JMenuItem("Sign In");
		SignIn.addActionListener(new MenuListener());
		UserMenu.add(SignIn);
		
		// sign out setup
		SignOut = new JMenuItem("Sign out");
		SignOut.addActionListener(new MenuListener());
		UserMenu.add(SignOut);
		
		// save setup
		FileSave = new JMenuItem("Save");
		FileSave.addActionListener(new MenuListener());
		UserMenu.add(FileSave);
		// load setup
		FileLoad = new JMenuItem("Load");
		FileLoad.addActionListener(new MenuListener());
		UserMenu.add(FileLoad);
		
		//exit setup
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(new MenuListener());
		UserMenu.add(Exit);
		
		//print all parts setup
		PrintAllParts = new JMenuItem("Print All Parts");
		PrintAllParts.addActionListener(new MenuListener());
		PartMenu.add(PrintAllParts);
		//PrintAllCPU
		PrintAllCPU = new JMenuItem("Print All CPUs");
		PrintAllCPU.addActionListener(new MenuListener());
		PartMenu.add(PrintAllCPU);
		//PrintAllMother
		PrintAllMother = new JMenuItem("Print All Motherboards");
		PrintAllMother.addActionListener(new MenuListener());
		PartMenu.add(PrintAllMother);
		//PrintAllMemory
		PrintAllMemory = new JMenuItem("Print All Memories");
		PrintAllMemory.addActionListener(new MenuListener());
		PartMenu.add(PrintAllMemory);
		//PrintAllVideo
		PrintAllVideo = new JMenuItem("Print All Video Cards");
		PrintAllVideo.addActionListener(new MenuListener());
		PartMenu.add(PrintAllVideo);
		//PrintAllStorage
		PrintAllStorage = new JMenuItem("Print All Storages");
		PrintAllStorage.addActionListener(new MenuListener());
		PartMenu.add(PrintAllStorage);
		//PrintAllCPUCooler
		PrintAllCPUCooler = new JMenuItem("Print All CPU Coolers");
		PrintAllCPUCooler.addActionListener(new MenuListener());
		PartMenu.add(PrintAllCPUCooler);
		//PrintAllPSU
		PrintAllPSU = new JMenuItem("Print All Power Supllies");
		PrintAllPSU.addActionListener(new MenuListener());
		PartMenu.add(PrintAllPSU);
		//PrintAllCase
		PrintAllCase = new JMenuItem("Print All Cases");
		PrintAllCase.addActionListener(new MenuListener());
		PartMenu.add(PrintAllCase);
		//PrintAllMonitor
		PrintAllMonitor = new JMenuItem("Print All Monitors");
		PrintAllMonitor.addActionListener(new MenuListener());
		PartMenu.add(PrintAllMonitor);
		//PrintAllAccessory
		PrintAllAccessory = new JMenuItem("Print All Accessoriess");
		PrintAllAccessory.addActionListener(new MenuListener());
		PartMenu.add(PrintAllAccessory);
		
		//buildsmenu
		createnewbuild = new JMenuItem("Create New Build");
		createnewbuild.addActionListener(new MenuListener());
		Builds.add(createnewbuild);
		
		removebuild = new JMenuItem("Remove a Build");
		removebuild.addActionListener(new MenuListener());
		Builds.add(removebuild);
		
		PrintAllUserBuilds = new JMenuItem("Print user builds");
		PrintAllUserBuilds.addActionListener(new MenuListener());
		Builds.add(PrintAllUserBuilds);
		//Recommendedbuilds menu;
		Printrecommendedbuild = new JMenuItem("Print a Recomended Build");
		Printrecommendedbuild.addActionListener(new MenuListener());
		RcomendedBuildsMenue.add(Printrecommendedbuild);
		
		menuBar.add(UserMenu);
		menuBar.add(PartMenu);
		menuBar.add(Builds);
		menuBar.add(RcomendedBuildsMenue);
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(Exit))
			{
				web.SignOut();
				System.exit(0);	
			}
			else if(source.equals(FileSave)) {
				handleFileSave();
			}
			else if(source.equals(FileLoad)) {
				handleFileLoad();
			}
			else if(source.equals(SignIn)) {
				handleSignIn();
			}
			else if(source.equals(createaccount)) {
				handleCreatenewAccount();
			}
			else if(source.equals(SignOut)) {
				handleSignOut();
			}
			else if(source.equals(PrintAllParts)) {
				handlePrintAllParts();
			}
			else if(source.equals(PrintAllCPU)) {
				handlePrintAllCPU();
			}
			else if(source.equals(PrintAllMother)) {
				handlePrintAllMother();
			}
			else if(source.equals(PrintAllMemory)) {
				handlePrintAllMemory();
			}
			else if(source.equals(PrintAllVideo)) {
				handlePrintAllVideo();
			}
			else if(source.equals(PrintAllStorage)) {
				handlePrintAllStorage();
			}
			else if(source.equals(PrintAllCPUCooler)) {
				handlePrintAllCPUCooler();
			}
			else if(source.equals(PrintAllPSU)) {
				handlePrintAllPSU();
			}
			else if(source.equals(PrintAllCase)) {
				handlePrintAllCase();
			}
			else if(source.equals(PrintAllMonitor)) {
				handlePrintAllMonitor();
			}
			else if(source.equals(PrintAllAccessory)) {
				handlePrintAllAccessory();
			}
			else if(source.equals(createnewbuild)) {
				handlecreatenewbuild();
			}
			else if(source.equals(PrintAllUserBuilds)) {
				handlePrintAllUserBuilds();
			}
			else if(source.equals(Printrecommendedbuild)) {
				handlePrintrecommendedbuild();
			}
			else if(source.equals(removebuild)) {
				handleremovebuild();
			}
			else if(source.equals(FileLoad)) {
				handleFileLoad();
			}
		}
		
		private void handleremovebuild() {
			if(web.getSignedInUser() != null) {
				JPanel pane = new JPanel();
		        //pane.setLayout(new GridLayout(0, 2, 2, 2));
		        //pane.setBounds(0, 0, 500, 500);
		        JTextField BuildnameField = new JTextField(15);

		        pane.add(new JLabel("Build Name: "));
		        pane.add(BuildnameField);

		        int option = JOptionPane.showConfirmDialog(null, pane, "Remove Build", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	String buildname = BuildnameField.getText();
		        		User user = web.getSignedInUser();
		        		int flag = 0;
		        		for(int i = 0; i < user.getBuilds().size();++i) {
		        			if(buildname.equals(user.getBuilds().get(i).getBuildname())) {
		        				flag = 1;
		        				user.getBuilds().remove(i);
		        				break;
		        			}
		        		}
		        		if (flag == 1) {
		        			pane = new JPanel();      
			        		pane.add(new JLabel("Successfully removed "+buildname));
		    	            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
		        		}else {
		        			pane = new JPanel();      
			        		pane.add(new JLabel("No such build with the name "+buildname));
		    	            JOptionPane.showMessageDialog(null, pane,"error",JOptionPane.PLAIN_MESSAGE);
		        		}
		        		
		        		
		        	}else {
		        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
		        	}
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		
		private void handlePrintrecommendedbuild() {
			if(web.getSignedInUser() != null) {
				Build build1 = new Build();
				//add CPU to build
				build1.AddCPUtoBuild(web.cpus.get(0));
				
				//we choose B450 Tomahawk motherboard
				build1.AddMotherboardtoBuild(web.motherboards.get(2));
				
				// we choose NZXT H500 to add to the build
				build1.AddCasetoBuild(web.cases.get(1));
				
				//add memory to build we choose Corsair Vengeance RGB Pro
				build1.AddMemorytoBuild(web.memories.get(4));
				
				//we choose 5.Samsung 970 Evo to add to build
				build1.AddStorage(web.storages.get(5));
				
				//we choose 5.MSI GeForce RTX 2060 Ventus OC
				build1.AddVideoCard(web.videocards.get(5));
				
				//add 0.Noctua NH-U12A to build
				build1.AddCPUCooler(web.cpucoolers.get(0));
		
				//add 2.Corsair RM to build
				build1.AddPSU(web.powersupplies.get(2));
				
				// add 1.MSI Optix MAG241C to build
				build1.AddMonitor(web.monitors.get(1));
				
				//add 1.MSI Optix MAG241C to build
				build1.AddAccessory(web.accessories.get(1));
				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all User's Builds");
						setLayout(new GridLayout());
						User found = new User();
						found = web.getSignedInUser();
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						
						build1.PrintBuild();
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		
		private void handlecreatenewbuild() {
			if(web.getSignedInUser() != null) {
				Build newbuild = new Build();
				JPanel pane = new JPanel();
		        //pane.setLayout(new GridLayout(0, 2, 2, 2));
		       // pane.setBounds(0, 0, 500, 500);
		        JTextField nameField = new JTextField(15);
		        

		        pane.add(new JLabel("Enter Build Name: "));
		        pane.add(nameField);

		        int option = JOptionPane.showConfirmDialog(null, pane, "Create New Build", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	String name = nameField.getText();
		        	newbuild.setBuildname(name);
		        	newbuild = PickACPU(newbuild);
					if(newbuild.getCpu()!=null) {
						newbuild = PickAmother(newbuild);
						if(newbuild.getMotherboard()!=null) {
							newbuild = PickCase(newbuild);
							if(newbuild.getcAse()!=null) {
								newbuild = PickMemory(newbuild);
								if(newbuild.getMemory()!=null) {
									newbuild = PickStorage(newbuild);
									if(newbuild.getStorage()!=null) {
										newbuild = PickPSU(newbuild);
										if(newbuild.getPowersupply()!=null) {
											newbuild = PickMonitor(newbuild);
											if(newbuild.getMonitor()!=null) {
												newbuild = PickCPUCooler(newbuild);
												if(newbuild.getCpucooler()!=null) {
													newbuild = PickAccessory(newbuild);
													if(newbuild.getAccessory()!=null) {
														newbuild = PickVideoCard(newbuild);
														if(newbuild.getVideocard()!=null) {
															User found = web.getSignedInUser();
															found.addBuild(newbuild);
															pane = new JPanel();   
												    		pane.add(new JLabel("Successfully created new build"));
												            JOptionPane.showMessageDialog(null, pane,"Success",JOptionPane.PLAIN_MESSAGE);
														}
													}
												}
											}
										}
									}
								}
							
							}
						}
					}
		        }		
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllUserBuilds() {
			if(web.getSignedInUser() != null) {
				
				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all User's Builds");
						setLayout(new GridLayout());
						User found = new User();
						found = web.getSignedInUser();
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						int flag = 0;
						for(int i =0; i < found.builds.size();i++) {
							System.out.println("Build #"+(i+1)+" Name: "+found.builds.get(i).getBuildname());
							found.builds.get(i).PrintBuild();
							flag = 1;
						}
						if(flag == 0) {
							System.out.println("You dont have any builds.");
						}
						
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllAccessory() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Accessories");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Accessories in the system:");
						for(int i =0; i < web.accessories.size();i++) {
							web.accessories.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllMonitor() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Monitors");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Monitors in the system:");
						for(int i =0; i < web.monitors.size();i++) {
							web.monitors.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllCase() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Cases");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Cases in the system:");
						for(int i =0; i < web.cases.size();i++) {
							web.cases.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllPSU() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Power Supplies");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Power Supplies in the system:");
						for(int i =0; i < web.powersupplies.size();i++) {
							web.powersupplies.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllCPUCooler() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all CPU Coolers");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all CPU Coolers in the system:");
						for(int i =0; i < web.cpucoolers.size();i++) {
							web.cpucoolers.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllStorage() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Storages");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Storages in the system:");
						for(int i =0; i < web.storages.size();i++) {
							web.storages.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllVideo() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Video Cards");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Video Cards in the system:");
						for(int i =0; i < web.videocards.size();i++) {
							web.videocards.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllMemory() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Memories");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Memories in the system:");
						for(int i =0; i < web.memories.size();i++) {
							web.memories.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllMother() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all Motherboards");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all Motherboards in the system:");
						for(int i =0; i < web.motherboards.size();i++) {
							//System.out.print((i+1)+".");
							web.motherboards.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllCPU() {
			if(web.getSignedInUser() != null) {

				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("Print all CPUS");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						System.out.println("Here are all CPUs in the system:");
						for(int i =0; i < web.cpus.size();i++) {
							web.cpus.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();	
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePrintAllParts() {
			if(web.getSignedInUser() != null) {
				final class SimpleWindow extends JFrame{

					private SimpleWindow(){
						super("All Parts info");
						setLayout(new GridLayout());
						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						web.printAllPartsinfo();
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handleSignOut() {
			web.SignOut();
			JPanel pane = new JPanel();   
    		pane.add(new JLabel("You are Signed-out."));
            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
		}
		
		private void handleFileSave() {
			if(web.getSignedInUser() != null) {
				Website.saveData(web);
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Successfully saved all data."));
	            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		private void handleFileLoad() {
			
			if(web.getSignedInUser() != null) {
				web = Website.loadData();
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Successfully load all data."));
	            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
			}else {
				JPanel pane = new JPanel();   
	    		pane.add(new JLabel("Sign in first please!"));
	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			}
		}
		private void handleSignIn() {
			JPanel pane = new JPanel();
	        pane.setLayout(new GridLayout(0, 2, 2, 2));
	        pane.setBounds(0, 0, 500, 500);
	        JTextField UsernameField = new JTextField(15);
	        JTextField PasswordField = new JTextField(15);

	        pane.add(new JLabel("Username: "));
	        pane.add(UsernameField);
	        
	        pane.add(new JLabel("Password: "));
	        pane.add(PasswordField);
	        int option = JOptionPane.showConfirmDialog(null, pane, "Sign In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

	        if (option == JOptionPane.OK_OPTION) {
	        	String Username = UsernameField.getText();
	        	String Password = PasswordField.getText();
	        	User found = null;
	        	for(int i = 0; i < web.users.size();i++) {
	        		found = web.users.get(i);
	        		if((Username.equals(found.getUsername()))&&(Password.equals(found.getPassword()))) {
		        		web.SignOut();
		        		found.SignIn();
		        		pane = new JPanel();      
		        		pane.add(new JLabel("You are now Signed-in."));
	    	            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
		        		break;
		        	}
		        	else {
		        		pane = new JPanel();      
	    	            pane.add(new JLabel("Username or Password are not valid. Please try again!"));
	    	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
	    	            break;
		        	}
	        	}
	        	
	        }
		}
		private void handleCreatenewAccount() {
			JPanel pane = new JPanel();
	        pane.setLayout(new GridLayout(0, 2, 2, 2));
	        pane.setBounds(0, 0, 500, 500);
	        JTextField UsernameField = new JTextField(15);
	        JTextField EmailField = new JTextField(15);
	        JTextField PasswordField = new JTextField(15);

	        pane.add(new JLabel("Username: "));
	        pane.add(UsernameField);

	        pane.add(new JLabel("Email: "));
	        pane.add(EmailField);
	        
	        pane.add(new JLabel("Password: "));
	        pane.add(PasswordField);
	        int option = JOptionPane.showConfirmDialog(null, pane, "Create New Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

	        if (option == JOptionPane.OK_OPTION) {
	        	String Username = UsernameField.getText();
	        	String Email = EmailField.getText();
	        	String Password = PasswordField.getText();
	        	
	        	if(web.UsernameIsValid(Username)) {
	        		web.SignOut();
	        		User newuser = new User();
	        		newuser.setUsername(Username);
	        		newuser.setEmail(Email);
	        		newuser.setPassword(Password);
	        		newuser.SignIn();
	        		web.Addaccount(newuser);
	        		pane = new JPanel();      
	        		pane.add(new JLabel("Successfully Created a new Account. You Are now Signed-in."));
    	            JOptionPane.showMessageDialog(null, pane,"Successe",JOptionPane.PLAIN_MESSAGE);
	        		
	        	}
	        	else {
	        		pane = new JPanel();      
    	            pane.add(new JLabel("Username is not valid\n"));
    	            pane.add(new JLabel("Please try again!"));
    	            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
	        	}
	        }
		}		
		
		
		private Boolean isInputValid(String input) {
			 if ((input == null)||(input=="")) {
			        return false;
			 }
			 try {
			        int d = Integer.parseInt(input);
			        if((d > (-1))&&(d<10)) {
			        	return true;
			        }
			 } catch (NumberFormatException nfe) {
			        return false;
			 	}
			    
			    
			return false;
		}
		private Build PickACPU(Build build){
			
				final class SimpleWindow extends JFrame{
					private SimpleWindow(){
						super("Pick a CPU for Your PC");
						setLayout(new GridLayout());

						final int WINDOW_WIDTH = 500;
						final int WINDOW_HEIGHT = 500;
						setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						// IMPORTANT: Save the old System.out!
						PrintStream old = System.out;
						// Tell Java to use your special stream
						System.setOut(ps);
						// Print some output: goes to your special stream
						
						for(int i =0; i < web.cpus.size();i++) {
							System.out.print(i+".");
							web.cpus.get(i).printPartinfo();
						}
						// Put things back
						System.out.flush();
						System.setOut(old);
						// Show what happened
						String data = baos.toString();
						//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JTextArea sampleTextArea = new JTextArea ();
						sampleTextArea.append(data);
						JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
														JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
														JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.add(sampleScrollPane);
						setVisible(true);
					}
				}	 
				 SimpleWindow myWindow = new SimpleWindow();
				 
	
				 JPanel pane = new JPanel();
			     pane.setLayout(new GridLayout(0, 2, 2, 2));
			        pane.setBounds(0, 0, 500, 500);
			        JTextField IndexField = new JTextField(15);
			        pane.add(new JLabel("Enter the index of the Part you like: "));
			        pane.add(IndexField);			        
			        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a CPU", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			        if (option == JOptionPane.OK_OPTION) {
			        	if(!isInputValid(IndexField.getText())) {
			        		pane = new JPanel();   
				    		pane.add(new JLabel("Input is not valid. Please try agan!"));
				            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
				            build = PickACPU(build);
			        		
			        	}else {
			        		String SIndex = IndexField.getText();
				        	int index = Integer.parseInt(SIndex);
				        	build.AddCPUtoBuild(web.cpus.get(index));
			        	}
			        	
			        }
			        myWindow.setVisible(false);
			return build;
		}
	
		private Build PickAmother(Build build1) {
			final Build build = build1;
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Motherboard for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					
					System.out.println("Compatible motherboards for the choosen CPU");
					
					for(int i = 0; i<web.motherboards.size();i++) {
						//test adding the compatible motherboard to the build
						if(web.motherboards.get(i).isCompatibleWithCPU(build.getCpu())) {
							System.out.print(i+".");
							web.motherboards.get(i).printPartinfo();			
						}
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Motherboard", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build1 = PickAmother(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddMotherboardtoBuild(web.motherboards.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
		return build;
		}
	
		private Build PickCase(Build build1) {
			final Build build = build1;
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Case for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("Compatible Cases for the choosen CPU & Motherboard");
					for(int i = 0; i < web.cases.size();i++) {
						if(web.cases.get(i).isCompatibleWithMotherboard(build.getMotherboard())) {
							System.out.print(i+".");
							web.cases.get(i).printPartinfo();
						}
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Case", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build1 = PickCase(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddCasetoBuild(web.cases.get(index));
		        	}
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}
		
		private Build PickMemory(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Memory(RAM) for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					
					System.out.println("Memory to choose from for the build");
					for(int i = 0; i < web.memories.size();i++) {	
							System.out.print(i+".");
							web.memories.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Memory(RAM)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickMemory(build);
		        		
		        	}else {
			        	String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddMemorytoBuild(web.memories.get(index));
		        	}

		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}

		private Build PickStorage(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Storage for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					
					System.out.println("Storages to choose from for the build");
					for(int i = 0; i < web.storages.size();i++) {	
							System.out.print(i+".");
							web.storages.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Storage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickStorage(build);
		        		
		        	}else {
			        	String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddStorage(web.storages.get(index));
		        	}
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}

		private Build PickVideoCard(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Video Card for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("Video Cards to choose from for the build");
					for(int i = 0; i < web.videocards.size();i++) {	
						System.out.print(i+".");
						web.videocards.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Video Card", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickVideoCard(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddVideoCard(web.videocards.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}

		private Build PickCPUCooler(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a CPU Cooler for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("CPU Cooler to choose from for the build");
					for(int i = 0; i < web.cpucoolers.size();i++) {	
						System.out.print(i+".");
						web.cpucoolers.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a CPU Cooler", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickCPUCooler(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddCPUCooler(web.cpucoolers.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}

		private Build PickPSU(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Power Supply for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("Power Supply to choose from for the build");
					for(int i = 0; i < web.powersupplies.size();i++) {	
						System.out.print(i+".");
						web.powersupplies.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Power Supply", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickPSU(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddPSU(web.powersupplies.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}

		private Build PickMonitor(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick a Monitor for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("Monitors to choose from for the build");
					for(int i = 0; i < web.monitors.size();i++) {	
						System.out.print(i+".");
						web.monitors.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick a Monitor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickMonitor(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddMonitor(web.monitors.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}
		
		private Build PickAccessory(Build build) {
			final class SimpleWindow extends JFrame{
				private SimpleWindow(){
					super("Pick an Accessory for Your PC");
					setLayout(new GridLayout());

					final int WINDOW_WIDTH = 500;
					final int WINDOW_HEIGHT = 500;
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					// IMPORTANT: Save the old System.out!
					PrintStream old = System.out;
					// Tell Java to use your special stream
					System.setOut(ps);
					// Print some output: goes to your special stream
					System.out.println("Accessories to choose from for the build");
					for(int i = 0; i < web.accessories.size();i++) {	
						System.out.print(i+".");
						web.accessories.get(i).printPartinfo();
					}
					// Put things back
					System.out.flush();
					System.setOut(old);
					// Show what happened
					String data = baos.toString();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JTextArea sampleTextArea = new JTextArea ();
					sampleTextArea.append(data);
					JScrollPane sampleScrollPane = new JScrollPane (sampleTextArea,
													JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					this.add(sampleScrollPane);
					setVisible(true);
				}
			}	 
			 SimpleWindow myWindow = new SimpleWindow();
			 
			 JPanel pane = new JPanel();
		     pane.setLayout(new GridLayout(0, 2, 2, 2));
		        pane.setBounds(0, 0, 500, 500);
		        JTextField IndexField = new JTextField(15);
		        pane.add(new JLabel("Enter the index of the Part you like: "));
		        pane.add(IndexField);			        
		        int option = JOptionPane.showConfirmDialog(null, pane, "Pick an Accessory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (option == JOptionPane.OK_OPTION) {
		        	if(!isInputValid(IndexField.getText())) {
		        		pane = new JPanel();   
			    		pane.add(new JLabel("Input is not valid. Please try agan!"));
			            JOptionPane.showMessageDialog(null, pane,"Error",JOptionPane.PLAIN_MESSAGE);
			            build = PickAccessory(build);
		        		
		        	}else {
		        		String SIndex = IndexField.getText();
			        	int index = Integer.parseInt(SIndex);
			        	build.AddAccessory(web.accessories.get(index));
		        	}
		        	
		        }else {
	        		WebsiteGUI gui = new WebsiteGUI("BuildAPC", web);
	        	}
		        myWindow.setVisible(false);
			return build;
		}
	}
	
}

