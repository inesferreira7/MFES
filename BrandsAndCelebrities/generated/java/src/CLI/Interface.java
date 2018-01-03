package CLI;

import java.io.*; 
import java.util.Iterator;

import org.overture.codegen.runtime.VDMSeq;

import BrandsAndCelebrities.Activity; 
import BrandsAndCelebrities.Agency; 
import BrandsAndCelebrities.Celebrity; 
import BrandsAndCelebrities.Platform; 
import BrandsAndCelebrities.Service; 
import BrandsAndCelebrities.Setor;
 
public class Interface { 
 
  static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in)); 
  private static Platform platform = null; 
   
  public static void main(String [] args){ 
     
    initializePlatform();
    menuChooseUser(); 
    return; 
  } 
   
  private static void initializePlatform() { 
    File f = new File("./src/info.txt"); 
    if(f.exists() && !f.isDirectory()) {  
       try { 
           FileInputStream streamIn = new FileInputStream("./src/info.txt"); 
           ObjectInputStream objectinputstream = new ObjectInputStream(streamIn); 
           platform = (Platform) objectinputstream.readObject(); 
           objectinputstream.close();
       } catch (Exception e) { 
           e.printStackTrace(); 
       }
    } 
    else { 
      platform = new Platform(); 
       
      Activity a1 = new Activity("Ambassador"); 
      Setor se1 = new Setor("Technology");
      VDMSeq setors = new VDMSeq(); setors.add(se1);
      Celebrity c1 = new Celebrity("ines",80,setors); 
      Celebrity c2 = new Celebrity("nuno",70,setors);
      c1.addActivity(a1);
      c1.addSetor(se1);
      c2.addActivity(a1);
       
      platform.addCelebrity(c1); 
      platform.addCelebrity(c2); 
       
      Agency ag1 = new Agency("Agencia1");
      ag1.addFunds(100);
      Service s1 = new Service(a1);
      s1.addCelebrity(c1);
      ag1.addService(s1);
      platform.addAgency(ag1); 
    } 
  } 
   
  private static void writeInfo() throws IOException { 
    ObjectOutputStream oos = null; 
    FileOutputStream fout = null; 
    try{ 
        fout = new FileOutputStream("./src/info.txt", true); 
        oos = new ObjectOutputStream(fout); 
        oos.writeObject(platform); 
    } catch (Exception ex) { 
        ex.printStackTrace(); 
    } finally { 
        if(oos != null){ 
            oos.close(); 
        } 
    } 
  } 
   
  private static void menuChooseUser(){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********     Brands and Celebrities   **********"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*                    Enter as:                   *"); 
    System.out.println("*     1 - Celebrity              2 - Agency      *"); 
    System.out.println("*                                                *");  
    System.out.println("*                                                *"); 
    System.out.println("*                    3 - Exit                    *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice == 1){ 
      clearScreen(); 
      menuCelebrity(); 
    } 
    else if (choice == 2){ 
      clearScreen(); 
      menuDivide(); 
    } 
    else if(choice == 3) { 
      try { 
        writeInfo(); 
      } catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } 
      return; 
    } 
    else{ 
      clearScreen(); 
      System.out.println("Please enter a valid option"); 
      menuChooseUser(); 
    }   
  }
  
  private static void menuCelebrity() {
	System.out.println("**************************************************"); 
	System.out.println("**********          Celebrity           **********"); 
	System.out.println("**************************************************"); 
	System.out.println("**************************************************"); 
	System.out.println("*                                                *"); 
	System.out.println("*        1 - Register a new celebrity            *"); 
	System.out.println("*        2 - Find a registered celebrity         *");
	System.out.println("*                                                *");
	System.out.println("*        0 - Back                                *"); 
	System.out.println("*                                                *"); 
	System.out.println("**************************************************");
	
	int choice = getIntChoice(); 
	
    if(choice == 1){ 
        clearScreen(); 
        menuCelebrityRegister(); 
      } 
      else if(choice == 2){ 
        clearScreen();
        menuCelebrityChoiceOption();    
      }   
      else if(choice == 0){ 
        clearScreen(); 
        menuChooseUser(); 
      } 
      else{ 
        clearScreen(); 
        System.out.println("Please enter a valid option."); 
        menuCelebrity(); 
      } 
  }
  
  private static void menuCelebrityChoiceOption() {
		System.out.println("**************************************************"); 
		System.out.println("**********          Celebrity           **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		System.out.println("*        1 - Find by celebrity name              *");
		System.out.println("*        2 - Find by celebrity price             *");
		System.out.println("*        3 - Find by celebrity rating            *");
		System.out.println("*        4 - List all celebrities                *");
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice(); 
		
	    if(choice == 1){ 
	        clearScreen();
		    System.out.println("*             Insert celebrity name :               *"); 
		    String name = getStringChoice();
		    
		    if (!platform.celebrityExists(name)){
		    	clearScreen();
		    	System.out.println("There are no celebrities registered with the name " + name);
		    	System.out.println();
		    	menuCelebrityChoiceOption();
		    }
		    else{
			    Celebrity cel = platform.getCelebrityByName(name);
		        menuRegisteredCelebrity(cel);
		    }
 
	      }
	      else if(choice == 2) {
	    	clearScreen();
	    	menuListCelebritiesByPrice(-1);
	      }
	      else if(choice == 3) {
	    	clearScreen();
	    	menuListCelebritiesByRating(-1);
	      }
	      else if(choice == 4){
	    	clearScreen();
	    	menuListCelebrities();
	      }   
	      else if(choice == 0){ 
	        clearScreen(); 
	        menuCelebrity(); 
	      } 
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuCelebrityChoiceOption();
	      } 
  }
  
  private static int menuAskPrice(){
		System.out.println("**************************************************"); 
		System.out.println("**********          Celebrites          **********"); 
	    System.out.println("**************************************************");
	    System.out.println("*                                                *");
	    System.out.println("*       Insert the maximum price:                *");
	    
	    int price = getIntChoice();
	    
	    if (price < 0) {
	    	System.out.println();
	    	System.out.println("The price must be a positive value");
	    	return -1;
	    }
	    else{
		    System.out.println();
		    System.out.println();
		    System.out.println();
		    
		    return price;
	    }
  }
  
  private static int menuAskRating(){
		System.out.println("**************************************************"); 
		System.out.println("**********          Celebrites          **********"); 
	    System.out.println("**************************************************");
	    System.out.println("*                                                *");
	    System.out.println("*       Insert the minimum rating (1 - 5):       *");
	    
	    int rating = getIntChoice();
	    
	    if (rating < 1 || rating > 5) {
	    	System.out.println();
	    	System.out.println("The rating must be a value between 1 and 5");
	    	return -1;
	    }
	    else{
		    System.out.println();
		    System.out.println();
		    System.out.println();
		    
		    return rating;
	    }
  }
  
  private static void menuListCelebritiesByPrice(int price){
	  	
	  	while(price == -1)
	  		price = menuAskPrice();

	    System.out.println("**************************************************"); 
		System.out.println("**********          Celebrites          **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		listCelebritiesByPrice(price);
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
	    if(choice == 0){ 
	        clearScreen(); 
	        menuCelebrityChoiceOption();
	      } 
	      else if(choice > 0 && choice <= platform.getCelebritiesByPrice(price).size()){ 
	        clearScreen();
	        Celebrity cel = (Celebrity) platform.getCelebritiesByPrice(price).get(choice - 1);
	        menuRegisteredCelebrity(cel);     
	      }
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuListCelebritiesByPrice(price); 
	      } 
  }
  
  private static void menuListCelebritiesByRating(int rating){
	  	
	  	while(rating == -1)
	  		rating = menuAskRating();

	    System.out.println("**************************************************"); 
		System.out.println("**********          Celebrites          **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		listCelebritiesByRating(rating);
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
	    if(choice == 0){ 
	        clearScreen(); 
	        menuCelebrityChoiceOption();
	      } 
	      else if(choice > 0 && choice <= platform.getCelebritiesByRating(rating).size()){ 
	        clearScreen();
	        Celebrity cel = (Celebrity) platform.getCelebritiesByRating(rating).get(choice - 1);
	        menuRegisteredCelebrity(cel);     
	      }
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuListCelebritiesByPrice(rating); 
	      } 
}
  
  private static void menuAgencyChoiceOption() {
		System.out.println("**************************************************"); 
		System.out.println("**********           Agency             **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		System.out.println("*        1 - Find by agency name                 *"); 
		System.out.println("*        2 - List all agencies                   *");
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice(); 
		
	    if(choice == 1){ 
	        clearScreen();
	        System.out.println("*             Insert agency name :               *"); 
	        String name = getStringChoice();
	        
		    if (!platform.agencyExists(name)){
		    	clearScreen();
		    	System.out.println("There are no agencies registered with the name " + name);
		    	System.out.println();
		    	menuAgencyChoiceOption();
		    }
		    else{
		        Agency ag = platform.getAgencyByName(name);
		        clearScreen();
		        menuAccount(ag);
		    }
	      } 
	      else if(choice == 2){
	    	clearScreen();
	    	menuListAgencies();
	      }   
	      else if(choice == 0){ 
	        clearScreen(); 
	        menuCelebrity(); 
	      } 
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuCelebrityChoiceOption();
	      } 
  }
  
  private static void menuListCelebrities() {
		System.out.println("**************************************************"); 
		System.out.println("**********          Celebrites          **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		listAllCelebrities();
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
	    if(choice == 0){ 
	        clearScreen(); 
	        menuCelebrityChoiceOption();
	      } 
	      else if(choice > 0 && choice <= platform.getCelebrities().size()){ 
	        clearScreen();
	        Celebrity cel = (Celebrity) platform.getCelebrities().get(choice - 1);
	        menuRegisteredCelebrity(cel);     
	      }
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuListCelebrities(); 
	      } 
  }
  
  private static void menuListAgencies() {
		System.out.println("**************************************************"); 
		System.out.println("**********           Agencies           **********"); 
		System.out.println("**************************************************"); 
		System.out.println("**************************************************"); 
		System.out.println("*                                                *"); 
		listAllAgencies();
		System.out.println("*                                                *");
		System.out.println("*        0 - Back                                *"); 
		System.out.println("*                                                *"); 
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
	    if(choice == 0){ 
	        clearScreen(); 
	        menuAgencyChoiceOption();
	      } 
	      else if(choice > 0 && choice <= platform.getAgencies().size()){ 
	        clearScreen();
	        Agency ag = (Agency) platform.getAgencies().get(choice - 1);
	        menuAccount(ag);     
	      }
	      else{ 
	        clearScreen(); 
	        System.out.println("Please enter a valid option."); 
	        menuListCelebrities(); 
	      } 
  }
   
  private static void menuDivide(){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********            Agency            **********"); 
    System.out.println("**************************************************"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*        1 - Register a new agency               *"); 
    System.out.println("*        2 - Find a registered agency            *");
    System.out.println("*                                                *");
    System.out.println("*        0 - Back                                *"); 
    System.out.println("*                                                *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice == 1){ 
      clearScreen(); 
      menuAgencyRegister(); 
    } 
    else if(choice == 2){ 
      clearScreen(); 
      menuAgencyChoiceOption();     
    }   
    else if(choice == 0){ 
      clearScreen(); 
      menuChooseUser(); 
    } 
    else{ 
      clearScreen(); 
      System.out.println("Please enter a valid option."); 
      menuDivide(); 
    } 
     
  }
  
  private static void menuRegisteredCelebrity(Celebrity cel){	     
	    System.out.println("**************************************************"); 
	    System.out.println("            Celebrity - " + cel.name ); 
	    System.out.println("**************************************************"); 
	    System.out.println("*                                                *"); 
	    System.out.println("*       1 - See current contracts                *"); 
	    System.out.println("*       2 - See current activities               *"); 
	    System.out.println("*       3 - Add Activities                       *");
	    System.out.println("*       4 - Remove Activities                    *");
	    System.out.println("*                                                *");
	    System.out.println("*       0 - Back                                 *");
	    System.out.println("                                                 *"); 
	    System.out.println("**************************************************"); 
	     
	    int choice = getIntChoice();
	    
	    if(choice == 1){
	    	clearScreen();
	    	menuListCelebrityContracts(cel);
	    }
	    else if (choice == 2) {
	    	clearScreen();
	    	menuListCelebrityActivities(cel);
	    }
	    else if (choice == 3) {
	    	clearScreen();
	    	menuAddCelebrityActivities(cel);
	    }
	    else if (choice == 4) {
	    	clearScreen();
	    	menuRemoveCelebrityActivities(cel);
	    }
	    else if (choice == 0) {
	    	clearScreen();
	    	menuCelebrity();
	    }
	    else {
	        clearScreen(); 
	        System.out.println("Please enter a valid option"); 
	        menuRegisteredCelebrity(cel); 
	    }
  }
  
   
  private static void menuAccount(Agency ag){   
    System.out.println("**************************************************"); 
    System.out.println("                Agency - " + ag.name ); 
    System.out.println("**************************************************");
    System.out.println("*                                                *");
    System.out.println("        Funds: " + ag.getFunds() + "€");
    System.out.println("*                                                *"); 
    System.out.println("*       1 - Consult services available           *"); 
    System.out.println("*       2 - List all my contracts                *");
    System.out.println("*       3 - Add funds                            *");
    System.out.println("                                                 *");
    System.out.println("*       0 - Back                                 *"); 
    System.out.println("                                                 *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice ==1){ 
      clearScreen(); 
      menuListActivities(ag); 
    } 
    else if(choice == 2){ 
      clearScreen(); 
      menuListContracts(ag); 
    }
    else if(choice == 3) {
    	clearScreen();
    	menuAddFunds(ag);
    }
    else if(choice == 0){ 
      clearScreen(); 
      menuDivide(); 
    }
    else{
      clearScreen(); 
      System.out.println("Please enter a valid option"); 
      menuAccount(ag); 
    }
  }
  
  public static void menuAddFunds(Agency ag) {
	  
	    System.out.println("**************************************************"); 
	    System.out.println("                Agency - " + ag.name ); 
	    System.out.println("**************************************************");
	    System.out.println("*                                                *");
	    System.out.println("        Current Funds: " + ag.getFunds() + "€");
	    System.out.println("*                                                *");
	    System.out.println("*       Insert the ammount you want to add :     *"); 
	    int funds = getIntChoice();
	    
	    ag.addFunds(funds);
	    clearScreen();
	    System.out.println(" Added funds successfully");
	    System.out.println();
	    menuAccount(ag);
	    
  }
   
  public static void menuListContracts(Agency ag){ 
     
    System.out.println("**************************************************"); 
    System.out.println("                Agency - " + ag.name ); 
    System.out.println("**************************************************"); 
    System.out.println(); 
     
    Iterator it = ag.getServices().iterator(); 
    int i=1; 
    while(it.hasNext()){ 
      Service s = (Service) it.next(); 
      System.out.println("       " + i + " - Service: " + s.getActivity().name);
      i++;
    }
    
    System.out.println();
    System.out.println("       0 - Back");
    System.out.println();
    
    int choice = getIntChoice();
    
    if(choice == 0){
    	clearScreen();
    	menuAccount(ag);
    }
    else if (choice > 0 && choice <= ag.getServices().size()) {
        clearScreen(); 
        Service s1 = (Service) ag.getServices().get(choice - 1);
        menuServiceDetails(ag, s1);
    }
    else {
    	clearScreen();
    	System.out.println("Please enter a valid option");
    	menuListContracts(ag);
    }
  }
    
  private static void menuServiceDetails(Agency ag, Service s) {
	    System.out.println("**************************************************"); 
	    System.out.println("                Agency - " + ag.name );
	    System.out.println("**************************************************");
	    System.out.println("                   Service Details");
	    System.out.println();
	    System.out.println("         Service " + s.getActivity().name);
	    System.out.println();
	    System.out.println("         Celebrities Assigned:");
	    
	    Iterator it = s.getCelebrities().iterator();
	    int i = 1;
	    
	    while(it.hasNext()){
	    	Celebrity cel = (Celebrity) it.next();
	    	System.out.println("                   " + i + " - " + cel.name);
	    	i++;
	    }
	    System.out.println();
	    System.out.println("         0 - Back      " + i + " - Add celebrities");
	    int choice = getIntChoice();
	    
	    if (choice == 0) {
	    	clearScreen();
	    	menuListContracts(ag);
	    }
	    else if (choice > 0 && choice <= s.getCelebrities().size()) {
	    	clearScreen();
	    	menuCelebrityInfo((Celebrity) s.getCelebrities().get(choice - 1), ag, s);
	    }
	    else if (choice == s.getCelebrities().size() + 1) {
	    	clearScreen();
	    	Activity a = s.getActivity();
	    	menuListAgencyCelebrities(a, ag);
	    }
	    else {
	    	clearScreen();
	    	System.out.println("Please enter a valid option");
	    	menuServiceDetails(ag, s);
	    }
  }
  
  private static void menuCelebrityInfo(Celebrity c, Agency ag, Service s) {
	    System.out.println("**************************************************");
	    System.out.println("                Celebrity Info");
	    System.out.println("**************************************************");
	    System.out.println();
	    System.out.println("         Name: " + c.name);
	    System.out.println("         Rating: " + c.getRating());
	    System.out.println("         Price: " + c.getPrice() + "€");
	    System.out.println();
	    System.out.println("      1 - Fire Celebrity          0 - Back");
	    
	    int choice = getIntChoice();
	    
	    if (choice == 0) {
	    	clearScreen();
	    	menuServiceDetails(ag, s);
	    }
	    else if (choice == 1) {
	    	clearScreen();
	    	ag.fireCelebrity(s, c);
	    	menuAccount(ag);	    	
	    }
	    else {
	    	clearScreen();
	    	System.out.println("Please enter a valid option");
	    	menuCelebrityInfo(c, ag, s);
	    }
  }
   
  private static void menuCelebrityRegister(){ 
    System.out.println("**************************************************"); 
    System.out.println("**********       Celebrity Register     **********"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*              Insert your name :                *"); 
    String name = getStringChoice();
    
    if(platform.celebrityExists(name)){
    	clearScreen();
    	System.out.println("There is already a celebrity with the name " + name);
    	System.out.println();
    	menuCelebrityRegister();
    }
    else{
        System.out.println("*              Insert your price :               *"); 
        int price = getIntChoice();
        System.out.println("                                                 *");
        System.out.println("*     Choose setors (press 0 to finish):         *");
        System.out.println("                                                 *");
        listAllSetors();
        int setor = getIntChoice();
        VDMSeq setors = new VDMSeq();
        while(setor != 0){
        	Setor s = getSetor(setor);
        	setors.add(s);
        	setor = getIntChoice();
        }
        Celebrity c = new Celebrity(name, price,setors); 
        
        platform.addCelebrity(c);
        
        clearScreen();
        menuRegisteredCelebrity(c);
    }
  } 
   
  private static void menuAgencyRegister(){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********        Agency Register       **********"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*             Insert agency name :               *"); 
    String name = getStringChoice();
    
    if(platform.agencyExists(name)){
    	clearScreen();
    	System.out.println("There is already a celebrity with the name " + name);
    	System.out.println();
    	menuAgencyRegister();
    }
    else{
        System.out.println("*           Insert funds available :             *"); 
        int funds = getIntChoice(); 
         
        Agency ag = new Agency(name); 
        ag.addFunds(funds); 
        platform.addAgency(ag);
        System.out.println("Registered agency successfully!");
        
        clearScreen();
        menuAccount(ag); 	
    }

  } 
   
  public static void contract(Agency ag, Celebrity c, Activity a){ 
    Service s = new Service(a);
    if (!ag.hasService(s.getActivity().name))
    	ag.addService(s);
    
    ag.hireCelebrity(s, c);     
    clearScreen(); 
    System.out.println("Contract finalized with " + c.name); 
    System.out.println();
    System.out.println();
    menuAccount(ag); 
  } 
   
  private static void menuListActivities(Agency ag){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********     Services and Sectors     **********"); 
    System.out.println("**************************************************"); 
    System.out.println("                                                  ");
    System.out.println("              Services:                           ");
    System.out.println("                                                  ");
    listActivities(ag);
    System.out.println("                                                  ");
    System.out.println("              Setors:                           ");
    System.out.println("                                                  ");
    listAllSetors();
    
    System.out.println("                                                  ");
    System.out.println("                  0 - Back");
    System.out.println("**************************************************"); 
    System.out.println(""); 
    System.out.println("Choose the service for the sector you need"); 
     
    int service = getIntChoice();
    int setor = getIntChoice();
    if(service <= platform.Activity.size() && service != 0 && setor <=Platform.Setor.size() && setor !=0){
    	clearScreen();
    	Activity a = getActivity(service);
    	Setor s = getSetor(setor);
    	menuListAgencyCelebrities(a, s, ag);
    }
    else if(service == 0){
    	clearScreen();
    	menuAccount(ag);
    }
    else{
        clearScreen(); 
        System.out.println("Please enter a valid option");
        menuListActivities(ag);
    }
  } 
  
  public static void menuListAgencyCelebrities(Activity a, Agency ag){ 
	    System.out.println("**************************************************"); 
	    System.out.println("**********          Celebrities         **********"); 
	    System.out.println(); 
	    listCelebrities(a, ag); 
	    System.out.println();
	    
	    int choice = getIntChoice();
	    
	    if(choice == 0){ 
	      clearScreen();  
	      if(ag != null)
	    	  menuAccount(ag);
	    } 
	    else if(choice > 0 && choice <= platform.getCelebsWithActivity(a).size()){
	      Celebrity cel = (Celebrity) platform.getCelebsWithActivity(a).get(choice - 1);
	      contract(ag,cel,a); 
	    } 
	    else { 
	        clearScreen(); 
	        System.out.println("Please enter a valid option");
	        menuListAgencyCelebrities(a, ag);
	    } 
	  } 
   
  public static void menuListAgencyCelebrities(Activity a,Setor s,Agency ag){ 
    System.out.println("**************************************************"); 
    System.out.println("**********          Celebrities         **********"); 
    System.out.println(); 
    listAvailableCelebrities(a, s, ag); 
    System.out.println();
    
    int choice = getIntChoice();
    
    if(choice == 0){ 
      clearScreen();  
      if(ag != null)
    	  menuAccount(ag);
    } 
    else if(choice > 0 && choice <= platform.getCelebsWithActivity(a).size()){
      Celebrity cel = (Celebrity) platform.getCelebsWithActivity(a).get(choice - 1);
      contract(ag,cel,a); 
    } 
    else { 
        clearScreen(); 
        System.out.println("Please enter a valid option");
        menuListAgencyCelebrities(a, ag);
    } 
  } 
   
  public static int getIntChoice() {   
    int input = -1; 
    try { 
      input = Integer.parseInt(buffer.readLine()); 
    } catch (Exception e) {} 
    return input; 
  } 
   
  public static String getStringChoice() {   
    String input = "erro"; 
    try { 
      input = buffer.readLine(); 
    } catch (Exception e) {} 
    return input; 
  } 
   
  public static void clearScreen() {   
      for(int i = 0; i < 50; i++) 
        System.out.println(""); 
  } 
   
  public static String getActivityString (Object obj){   
    if(obj.getClass() == BrandsAndCelebrities.quotes.AmbassadorQuote.class) 
      return "Ambassador"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.EntertainerQuote.class) 
      return "Entertainer"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.SponsorQuote.class) 
      return "Sponsor"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.SpeakerQuote.class) 
        return "Speaker"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.DigitalInfluenceQuote.class) 
        return "Digital Influence"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.ProductPlacementQuote.class) 
        return "Product Placement"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.AttendanceQuote.class) 
        return "Attendance"; 
    else return "erro";   
  } 
  
  public static String getSetorString(Object obj){   
	    if(obj.getClass() == BrandsAndCelebrities.quotes.NutritionQuote.class) 
	      return "Nutrition"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.DecorationQuote.class) 
	      return "Decoration"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.ConsultoryQuote.class) 
	      return "Consultory"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.MusicQuote.class) 
	        return "Music"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.CinemaQuote.class) 
	        return "Cinema"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.TechnologyQuote.class) 
	        return "Technology"; 
	    else if(obj.getClass() == BrandsAndCelebrities.quotes.FashionQuote.class) 
	        return "Fashion"; 
	    else return "erro";   
	  } 
   
  public static void listActivities(Agency ag){ 
     
    Iterator iter = Platform.Activity.iterator(); 
    int i=1; 
    while (iter.hasNext()) {
    	String s = getActivityString(iter.next());
    	if(!ag.hasService(s))
    		System.out.println("                  " + i + " - " + s); 
        i++; 
    } 
  }
  
  	public static void listAllSetors(){ 
	     
	    Iterator iter = Platform.Setor.iterator(); 
	    int i=1; 
	    while (iter.hasNext()) {
	    	String s = getSetorString(iter.next());
	    	System.out.println("                  " + i + " - " + s); 
	        i++; 
	    } 
	  }
 
  
  public static void listAllActivities(){ 
	     
	    Iterator iter = Platform.Activity.iterator(); 
	    int i=1; 
	    while (iter.hasNext()) {
	    	String s = getActivityString(iter.next());
	    	System.out.println("                  " + i + " - " + s); 
	        i++; 
	    } 
	  }
  
  private static void listAllCelebrities() {
	  Iterator it = platform.getCelebrities().iterator();
	  int i = 1;
	  
	  while(it.hasNext()){
		  Celebrity cel = (Celebrity) it.next();
		  System.out.println("         " + i + " - " + cel.name + "  Rating: " + cel.getRating() + "  Price: " + cel.getPrice() + "€");
		  i++;
	  }
  }
  
  private static void listCelebritiesByPrice(int price) {
	  Iterator it = platform.getCelebritiesByPrice(price).iterator();
	  int i = 1;
	  
	  while(it.hasNext()){
		  Celebrity cel = (Celebrity) it.next();
		  System.out.println("         " + i + " - " + cel.name + "  Rating: " + cel.getRating() + "  Price: " + cel.getPrice() + "€");
		  i++;
	  }
  }
  
  private static void listCelebritiesByRating(int rating) {
	  Iterator it = platform.getCelebritiesByRating(rating).iterator();
	  int i = 1;
	  
	  while(it.hasNext()){
		  Celebrity cel = (Celebrity) it.next();
		  System.out.println("         " + i + " - " + cel.name + "  Rating: " + cel.getRating() + "  Price: " + cel.getPrice() + "€");
		  i++;
	  }
  }
  
  private static void listAllAgencies() {
	  Iterator it = platform.getAgencies().iterator();
	  int i = 1;
	  while(it.hasNext()){
		  Agency ag = (Agency) it.next();
		  System.out.println("         " + i + " - " + ag.name);
		  i++;
	  }
  }
 
  public static void menuListCelebrityContracts(Celebrity cel) {
	    System.out.println("**************************************************"); 
	    System.out.println("                " + cel.name + " - Contracts");
	    System.out.println("**************************************************");
	    System.out.println();
	    
	    Iterator iter = platform.getCelebrityContracts(cel).iterator();
	    
	    while (iter.hasNext()) {
	    	Agency ag = (Agency) iter.next();
	    	System.out.println("             Agency - " + ag.name);
	    	
	    	Iterator iter2 = ag.findServiceByCelebrity(cel).iterator();
	    	while (iter2.hasNext()) {
	    		Service s = (Service) iter2.next();
	    		System.out.println("                   -> " + s.getActivity().name);
	    	}
	    }
	    
	    System.out.println();
    	System.out.println("                   0 - Back");
	    
	    int choice = getIntChoice();
	    
	    if(choice == 0) {
	    	clearScreen();
	    	menuRegisteredCelebrity(cel);
	    }
	    else {
	        clearScreen(); 
	        System.out.println("Please enter a valid option");
	        menuListCelebrityContracts(cel);
	    }
  }
  
  public static void menuListCelebrityActivities(Celebrity cel) {
	    System.out.println("**************************************************"); 
	    System.out.println("                " + cel.name + " - Activities");
	    System.out.println("**************************************************");
	    System.out.println();

	    Iterator it = cel.getActivities().iterator();
	    int i = 1;
	    
	    while(it.hasNext()) {
	    	Activity a = (Activity) it.next();
	    	System.out.println("              " + i + " - " + a.name);
	    	i++;
	    }
	    
	    System.out.println();
	    System.out.println("              0 - Back");
	    
	    int choice = getIntChoice();
	    
	    if(choice == 0) {
	    	clearScreen();
	    	menuRegisteredCelebrity(cel);
	    }
	    else if (choice != 0 && choice <= cel.getActivities().size()) {
	    	clearScreen();
	    	Activity act = (Activity) cel.getActivities().get(i);
	    	platform.removeActivityFromCelebrity(cel, act);
	    	menuRegisteredCelebrity(cel);
	    }
	    else {
	        clearScreen(); 
	        System.out.println("Please enter a valid option");
	        menuRemoveCelebrityActivities(cel);
	    }
  }
  
  public static void menuRemoveCelebrityActivities(Celebrity cel) {
	    System.out.println("**************************************************"); 
	    System.out.println("           " + cel.name + " - Remove Activities");
	    System.out.println("**************************************************");
	    System.out.println();

	    Iterator it = cel.getActivities().iterator();
	    int i = 1;
	    
	    while(it.hasNext()) {
	    	Activity a = (Activity) it.next();
	    	System.out.println("              " + i + " - " + a.name);
	    	i++;
	    }
	    
	    System.out.println();
	    System.out.println("              0 - Back");
	    
	    int choice = getIntChoice();
	    
	    if(choice == 0) {
	    	clearScreen();
	    	menuRegisteredCelebrity(cel);
	    }
	    else if (choice != 0 && choice <= cel.getActivities().size()) {
	    	clearScreen();
	    	Activity act = (Activity) cel.getActivities().get(choice-1);
	    	platform.removeActivityFromCelebrity(cel, act);
	    	menuRegisteredCelebrity(cel);
	    }
	    else {
	        clearScreen(); 
	        System.out.println("Please enter a valid option");
	        menuRemoveCelebrityActivities(cel);
	    }
}
  
  public static void menuAddCelebrityActivities(Celebrity cel) {
	    System.out.println("**************************************************"); 
	    System.out.println("            " + cel.name + " - Add Activities");
	    System.out.println("**************************************************");
	    System.out.println();

	    Iterator it = platform.Activity.iterator();
	    int i = 1;
	    
	    while(it.hasNext()) {
	    	String s = getActivityString(it.next());
	    	if(!cel.hasActivity(s)){
		    	System.out.println("              " + i + " - " + s);
	    	}
	    	i++;
	    }
	    
	    System.out.println();
	    System.out.println("              0 - Back");
	    
	    int choice = getIntChoice();
	    
	    if(choice == 0) {
	    	clearScreen();
	    	menuRegisteredCelebrity(cel);
	    }
	    else if (choice != 0 && choice <= platform.Activity.size()) {
	    	clearScreen();
	    	Activity act = getActivity(choice);
	    	cel.addActivity(act);
	    	menuRegisteredCelebrity(cel);
	    }
	    else {
	        clearScreen(); 
	        System.out.println("Please enter a valid option");
	        menuRemoveCelebrityActivities(cel);
	    }
}
  
  public static void listCelebrities(Activity act,Agency ag){ 
	     
	    Iterator iter = platform.getCelebsWithActivity(act).iterator(); 
	    int i=1; 
	     
	    while (iter.hasNext()) { 
	      Celebrity c = (Celebrity) iter.next();
	      	
	      if(ag == null)
	      		System.out.println("   " + i + " - Name: " + c.name + "  Rating: " + c.getRating() + "  Price: " + c.getPrice() + "€");
	      	
	      	else if(!ag.hasServiceWithCelebrity(act.name, c)){
	            System.out.println("   " + i + " - Name: " + c.name + "  Rating: " + c.getRating() + "  Price: " + c.getPrice() + "€"); 
	      	}
	        i++; 
	    } 
	    System.out.println();
	    System.out.println("   0 - Back");
	    System.out.println();
	    System.out.println("**************************************************"); 
	  } 
  
  public static void listAvailableCelebrities(Activity act, Setor s,Agency ag){ 
     
    Iterator iter = platform.getCelebsWithActivityAndSetor(act,s).iterator(); 
    int i=1; 
     
    while (iter.hasNext()) { 
      Celebrity c = (Celebrity) iter.next();
      System.out.println("   " + i + " - Name: " + c.name + "  Rating: " + c.getRating() + "  Price: " + c.getPrice() + "€"); 
        i++; 
    } 
    System.out.println();
    System.out.println("   0 - Back");
    System.out.println();
    System.out.println("**************************************************"); 
  } 
   
  public static Activity getActivity(int choice){ 
     
    if(choice == 1 ){ 
      return new Activity("Ambassador"); 
    } 
    else if (choice == 2){ 
      return new Activity("Sponsor"); 
    } 
    else if (choice == 3){ 
      return new Activity ("Entertainer"); 
    } 
    else if (choice == 4){
    	return new Activity("Speaker");
    }
    else if (choice == 5){
    	return new Activity("Digital Influence");
    }
    else if (choice == 6){
    	return new Activity("Product Placement");
    }
    else if (choice == 7){
    	return new Activity("Attendance");
    }
    else return null;  
  } 
  
  public static Setor getSetor(int choice){ 
	     
	    if(choice == 1 ){ 
	      return new Setor("Nutrition"); 
	    } 
	    else if (choice == 2){ 
	      return new Setor("Decoration"); 
	    } 
	    else if (choice == 3){ 
	      return new Setor("Consultory"); 
	    } 
	    else if (choice == 4){
	    	return new Setor("Music");
	    }
	    else if (choice == 5){
	    	return new Setor("Cinema");
	    }
	    else if (choice == 6){
	    	return new Setor("Technology");
	    }
	    else if (choice == 7){
	    	return new Setor("Fashion");
	    }
	    else return null;  
	  } 
} 
