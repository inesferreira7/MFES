package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		platform = new Platform();
		
		Activity a1 = new Activity("Embassador");
		Celebrity c1 = new Celebrity("ines",a1,5,80);
		Celebrity c2 = new Celebrity("nuno", a1, 4, 70);
		
		platform.addCelebrity(c1);
		platform.addCelebrity(c2);
		
		Agency ag1 = new Agency("ola");
		platform.addAgency(ag1);
		
		menuChooseUser();
		
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
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
		if(choice == 1){
			clearScreen();
			menuCelebrityRegister();
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
		else{
			clearScreen();
			System.out.println("Please enter a valid option");
			menuChooseUser();
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
		System.out.println("*        3 - Exit                                *");
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
		else if(choice == 3){
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
		System.out.println("*       2 - Exit                                 *");
		System.out.println("                                                 *");
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
		if(choice == 1){
			clearScreen();
			menuListActivities(account, null);
		}
		
		if(choice == 2){
			clearScreen();
			menuChooseUser();
		}
	}
	
	private static void menuAccount(int account){
		
		System.out.println("*             Insert agency name :               *");
		String name = getStringChoice();
		Agency ag = platform.getAgencyByName(name);
		
		System.out.println("**************************************************");
		System.out.println("                       " + name);
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*       1 - Consult services available           *");
		System.out.println("*       2 - List all my contracts                *");
		System.out.println("*       3 - Exit                                 *");
		System.out.println("                                                 *");
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
		if(choice ==1){
			clearScreen();
			menuListActivities(account, ag);
		}
		
		if(choice == 2){
			clearScreen();
			menuListContracts(ag);
		}
		
		if(choice == 3){
			clearScreen();
			menuChooseUser();
		}
	}
	
	public static void menuListContracts(Agency ag){
		
		System.out.println("**************************************************");
		System.out.println("               " + ag.name );
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
	}
	
	private static void menuCelebrityRegister(){
		System.out.println("**************************************************");
		System.out.println("**********       Celebrity Register     **********");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*              Insert your name :                *");
		String name = getStringChoice();
		System.out.println("*          Insert your rating (1-5) :            *");
		int rating = getIntChoice();
		System.out.println("*              Insert your price :               *");
		int price = getIntChoice();
		System.out.println("*  Choose the type of activity to collaborate :  *");
		
		listActivities();
		
		int activity = getIntChoice();
		Activity a = getActivity(activity);
		
		Celebrity c = new Celebrity(name,a,rating,price);
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
		s.addCelebrity(c);
		ag.addService(s);
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
		System.out.println("**************************************************");
		System.out.println("");
		System.out.println("Choose the service you need");
		
		int service = getIntChoice();
		Activity a = getActivity(service);
		menuListCelebrities(a, account, ag);
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
		else if (choice == 2){
			return new Activity ("Entertainer");
		}
		else return null;
		
	}
}

