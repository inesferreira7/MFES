package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import BrandsAndCelebrities.Activity;
import BrandsAndCelebrities.Celebrity;
import BrandsAndCelebrities.Platform;

public class Graphics {

	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	private static Platform platform = null;
	
	public static void main(String [] args){
		platform = new Platform();
		menuChooseUser();
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
			System.out.println("Celebridade");
			menuCelebrityRegister();
		}
		else if (choice == 2){
			System.out.println("Agencia");
		}
		else{
			clearScreen();
			System.out.println("Please enter a valid option");
			menuChooseUser();
		}	
	}
	
	private static void menuCelebrityRegister(){
		System.out.println("**************************************************");
		System.out.println("**********                   Register   **********");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*              Insert your name :                *");
		String name = getStringChoice();
		System.out.println("*          Insert your rating (1-5) :            *");
		int rating = getIntChoice();
		System.out.println("*              Insert your price :               *");
		int price = getIntChoice();
		System.out.println("*  Choose the type of activity to collaborate :  *");
		
		Iterator iter = Platform.Activity.iterator();
		int i=1;
		while (iter.hasNext()) {
		    System.out.println(i + " - " + getActivityString(iter.next()));
		    i++;
		}
		
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
}
