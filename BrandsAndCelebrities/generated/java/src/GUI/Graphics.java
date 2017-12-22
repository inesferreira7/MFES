package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.overture.codegen.runtime.VDMSeq;

import BrandsAndCelebrities.Activity;
import BrandsAndCelebrities.Celebrity;
import BrandsAndCelebrities.Platform;

public class Graphics {

	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	private static Platform platform = null;
	
	public static void main(String [] args){
		platform = new Platform();
		//menuChooseUser();
		
		Activity a1 = new Activity("Sponsor");
		Celebrity c1 = new Celebrity("ines", a1, 5,80);
		Celebrity c2 = new Celebrity("joao", a1, 4, 70);
		
		platform.addCelebrity(c1);
		platform.addCelebrity(c2);
		VDMSeq test = platform.getCelebsWithActivity(a1);
		System.out.println(a1);
		System.out.println(c1.getActivity());
		System.out.println("Oi: " + platform.getCelebrities().size() + " " + test.size());
		
		
	}
	
	private static void menuChooseUser(){
		
		System.out.println("**************************************************");
		System.out.println("**********     Brands and Celebrities   **********");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*                    You are :                   *");
		System.out.println("*                                                *");
		System.out.println("*     1 - Celebrity              2 - Agency      *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
		if(choice == 1){
			clearScreen();
			menuCelebrityRegister();
			System.out.println("Registered successfully! Just wait for a contact.");
			menuChooseUser();
		}
		else if (choice == 2){
			System.out.println("Agencia");
			menuDivide();
		}
		else{
			clearScreen();
			System.out.println("Please enter a valid option");
			menuChooseUser();
		}	
	}
	
	private static void menuDivide(){
		
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
			menuNoAccount();
		}
		else if(choice == 2){
			clearScreen();
			menuAccount();		
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
	
	private static void menuNoAccount(){
		
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*       1 - Consult services available           *");
		System.out.println("*       2 - Exit                                 *");
		System.out.println("                                                 *");
		System.out.println("**************************************************");
		
		int choice = getIntChoice();
		
		if(choice == 1){
			clearScreen();
			menuListActivities();
		}
		
	}
	private static void menuAccount(){
		
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*       1 - Consult services available           *");
		System.out.println("*       2 - List all my contracts                *");
		System.out.println("*       3 - Exit                                 *");
		System.out.println("                                                 *");
		System.out.println("**************************************************");
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
		Activity a = null;
		
		if(activity == 1 ){
			a = new Activity("Embassador");
		}
		else if (activity == 2){
			a = new Activity("Entertainer");
		}
		else if (activity == 2){
			a = new Activity ("Sponsor");
		}
		else System.out.println("Burro do crl");
		
		Celebrity c = new Celebrity(name,a, rating,price);
		platform.addCelebrity(c);
		
	}
	
	private static void menuAgencyRegister(){
		
		System.out.println("**************************************************");
		System.out.println("**********       Celebrity Register     **********");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*             Insert agency name :               *");
		String name = getStringChoice();
		System.out.println("*          Insert funds available :              *");
		int funds = getIntChoice();
	}
	
	private static void menuListActivities(){
		
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
}

