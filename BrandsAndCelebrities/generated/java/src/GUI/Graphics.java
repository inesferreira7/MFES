package GUI; 
 
import java.io.*; 
import java.util.Iterator; 
 
import BrandsAndCelebrities.Activity; 
import BrandsAndCelebrities.Agency; 
import BrandsAndCelebrities.Celebrity; 
import BrandsAndCelebrities.Platform; 
import BrandsAndCelebrities.Service; 
 
public class Graphics { 
 
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
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 
    } 
    else { 
      platform = new Platform(); 
       
      Activity a1 = new Activity("Embassador"); 
      Celebrity c1 = new Celebrity("ines",80); 
      Celebrity c2 = new Celebrity("nuno",70);
      c1.addActivity(a1);
      c2.addActivity(a1);
       
      platform.addCelebrity(c1); 
      platform.addCelebrity(c2); 
       
      Agency ag1 = new Agency("ola");
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
    System.out.println("*        3 - Consult available services          *"); 
    System.out.println("*                                                *"); 
    System.out.println("*                                                *"); 
    System.out.println("*                    4 - Exit                    *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice == 1){ 
      clearScreen(); 
      menuCelebrity();
      //menuCelebrityRegister(); 
      System.out.println("Registered successfully! Just wait for a contact."); 
      System.out.println(); 
      menuChooseUser(); 
    } 
    else if (choice == 2){ 
      clearScreen(); 
      menuDivide(); 
    } 
    else if(choice == 3){ 
      menuListActivities(choice, null); 
    } 
    else if(choice == 4) { 
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
	System.out.println("*        1 - I don't have an account             *"); 
	System.out.println("*        2 - I already have an account           *");
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
	    System.out.println("*             Insert celebrity name :               *"); 
	    String name = getStringChoice(); 
	    Celebrity cel = platform.getCelebrityByName(name);
        menuRegisteredCelebrity(cel);     
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
   
  private static void menuDivide(){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********            Agency            **********"); 
    System.out.println("**************************************************"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*        1 - I don't have an account             *"); 
    System.out.println("*        2 - I already have an account           *");
    System.out.println("*                                                *");
    System.out.println("*        0 - Back                                *"); 
    System.out.println("*                                                *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice == 1){ 
      clearScreen(); 
      menuNoAccount(choice); 
    } 
    else if(choice == 2){ 
      clearScreen(); 
      menuAccount(choice);     
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
   
  private static void menuNoAccount(int account){ 
     
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*       1 - Consult services available           *");
    System.out.println("*                                                *"); 
    System.out.println("*       0 - Back                                 *"); 
    System.out.println("*                                                *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice == 1){ 
      clearScreen(); 
      menuListActivities(account, null); 
    }
    else if(choice == 0){ 
      clearScreen(); 
      menuDivide(); 
    }
    else{
      clearScreen(); 
      System.out.println("Please enter a valid option"); 
      menuNoAccount(account); 
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
  
   
  private static void menuAccount(int account){ 
     
    System.out.println("*             Insert agency name :               *"); 
    String name = getStringChoice(); 
    Agency ag = platform.getAgencyByName(name); 
     
    System.out.println("**************************************************"); 
    System.out.println("                Agency - " + name ); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*       1 - Consult services available           *"); 
    System.out.println("*       2 - List all my contracts                *");
    System.out.println("                                                 *");
    System.out.println("*       0 - Back                                 *"); 
    System.out.println("                                                 *"); 
    System.out.println("**************************************************"); 
     
    int choice = getIntChoice(); 
     
    if(choice ==1){ 
      clearScreen(); 
      menuListActivities(account, ag); 
    } 
    else if(choice == 2){ 
      clearScreen(); 
      menuListContracts(ag, account); 
    } 
    else if(choice == 0){ 
      clearScreen(); 
      menuDivide(); 
    }
    else{
      clearScreen(); 
      System.out.println("Please enter a valid option"); 
      menuAccount(account); 
    }
  } 
   
  public static void menuListContracts(Agency ag, int account){ 
     
    System.out.println("**************************************************"); 
    System.out.println("                Agency - " + ag.name ); 
    System.out.println("**************************************************"); 
    System.out.println(); 
     
    Iterator it = ag.getServices().iterator(); 
    int i=1; 
    while(it.hasNext()){ 
      Service s = (Service) it.next(); 
      System.out.print(i + " - Service: " + s.getActivity().name + "   Celebrities: "); 
      Iterator iter = s.getCelebrities().iterator(); 
      int j=1; 
      while(iter.hasNext()){ 
        Celebrity c = (Celebrity) iter.next(); 
        System.out.print(c.name + "   "); 
        j++; 
      } 
      i++; 
    }
    System.out.println();
    System.out.println("                  0 - Back");
    System.out.println();
    
    int choice = getIntChoice();
    if(choice == 0){
    	clearScreen();
    	menuAccount(account);
    }
    else{
        clearScreen(); 
        System.out.println("Please enter a valid option"); 
        menuListContracts(ag, account); 
    }
  } 
   
  private static void menuCelebrityRegister(){ 
    System.out.println("**************************************************"); 
    System.out.println("**********       Celebrity Register     **********"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*              Insert your name :                *"); 
    String name = getStringChoice(); 
    System.out.println("*              Insert your price :               *"); 
    int price = getIntChoice();
    Celebrity c = new Celebrity(name, price); 
    platform.addCelebrity(c);
  } 
   
  private static void menuAgencyRegister(Activity a, Celebrity c){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********        Agency Register       **********"); 
    System.out.println("**************************************************"); 
    System.out.println("*                                                *"); 
    System.out.println("*             Insert agency name :               *"); 
    String name = getStringChoice(); 
    System.out.println("*           Insert funds available :             *"); 
    int funds = getIntChoice(); 
     
    Agency ag = new Agency(name); 
    ag.addFunds(funds); 
    platform.addAgency(ag); 
    System.out.println("Registered agency successfully!"); 
     
    contract(ag,c,a); 
  } 
   
  public static void contract(Agency ag, Celebrity c, Activity a){ 
    Service s = new Service(a); 
    ag.addService(s); 
    ag.hireCelebrity(s, c);     
    clearScreen(); 
    System.out.println("Contract finalized with " + c.name); 
    System.out.println(); 
    menuChooseUser(); 
  } 
   
  private static void menuListActivities(int account, Agency ag){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********           Services           **********"); 
    System.out.println("**************************************************"); 
    System.out.println("                                                  "); 
    listActivities(); 
    System.out.println("                                                  ");
    System.out.println("                  0 - Back");
    System.out.println("**************************************************"); 
    System.out.println(""); 
    System.out.println("Choose the service you need"); 
     
    int service = getIntChoice();
    if(service <= platform.Activity.size() && service != 0){
    	Activity a = getActivity(service);
    	menuListCelebrities(a, account, ag);
    }
    else if(service == 0){
    	clearScreen();
    	menuChooseUser();
    }
    else{
        clearScreen(); 
        System.out.println("Please enter a valid option");
        menuListActivities(account, ag);
    }
  } 
   
  public static void menuListCelebrities(Activity a, int account, Agency ag){ 
     
    System.out.println("**************************************************"); 
    System.out.println("**********          Celebrities         **********"); 
    System.out.println(); 
    Celebrity c = listCelebrities(a); 
    System.out.println(); 
    if(account == 1){ 
      clearScreen(); 
      System.out.println("You've chosen " + c.name + ". To complete the contract, you have to register."); 
      menuAgencyRegister(a, c); 
    } 
    else if(account == 2){ 
      contract(ag,c,a); 
    } 
    else if(account == 3){ 
      System.out.println("Enter platform as an agency to make a contract!"); 
      System.out.println(); 
      menuChooseUser(); 
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
    if(obj.getClass() == BrandsAndCelebrities.quotes.EmbassadorQuote.class) 
      return "Embassador"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.EntertainerQuote.class) 
      return "Entertainer"; 
    else if(obj.getClass() == BrandsAndCelebrities.quotes.SponsorQuote.class) 
      return "Sponsor"; 
    else return "erro";   
  } 
   
  public static void listActivities(){ 
     
    Iterator iter = Platform.Activity.iterator(); 
    int i=1; 
    while (iter.hasNext()) { 
        System.out.println("                  " + i + " - " + getActivityString(iter.next())); 
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
  
  public static Celebrity listCelebrities(Activity act){ 
     
    Iterator iter = platform.getCelebsWithActivity(act).iterator(); 
    int i=1; 
     
    while (iter.hasNext()) { 
      Celebrity c = (Celebrity) iter.next(); 
        System.out.println(i + " - Name: " + c.name + "  Rating: " + c.getRating() + "  Price: " + c.getPrice()); 
        i++; 
    } 
    System.out.println("                                                  "); 
    System.out.println("**************************************************"); 
    System.out.println("                                                  "); 
     
    int choice = getIntChoice(); 
     
    int j = 1; 
     
    iter = platform.getCelebsWithActivity(act).iterator(); 
    while(iter.hasNext()){ 
      Celebrity c = (Celebrity) iter.next(); 
      if(j == choice){ 
        return c; 
      } 
      j++; 
    } 
    return null; 
  } 
   
  public static Activity getActivity(int choice){ 
     
    if(choice == 1 ){ 
      return new Activity("Embassador"); 
    } 
    else if (choice == 2){ 
      return new Activity("Sponsor"); 
    } 
    else if (choice == 3){ 
      return new Activity ("Entertainer"); 
    } 
    else return null; 
     
  } 
} 