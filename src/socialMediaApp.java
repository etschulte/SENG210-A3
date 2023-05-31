import java.util.Scanner;
import java.util.ArrayList;


public class socialMediaApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList <String> users = new ArrayList<String>();
		int x;
		String user;
		String poster;

		frontPage();
		int option = Integer.parseInt(scnr.nextLine());
		featureChooser(option);
		
		
	}
	
	// prints the front page
	public static void frontPage() {
		Scanner scnr = new Scanner(System.in);
		System.out.println(welcomeMessage());
		System.out.println(logo());
		System.out.println(menu());
	}
	
	// takes user input and chooses what feature to do
	public static void featureChooser(int x) {
		Scanner scnr = new Scanner(System.in);
		String user;
		String poster;
		String post;
		ArrayList <String> posts = new ArrayList<String>();
		ArrayList <String> users = new ArrayList<String>();
		
		if (x == 1) {
			System.out.println("Enter 1 to add new user or 2 to go back");
			x = Integer.parseInt(scnr.nextLine());
			if (x == 1) {
				System.out.println("Enter username");
				user = scnr.nextLine();
				users.add(user);
				x = scnr.nextInt();
				
			}
			toMainPage(x);
		}
		else if (x == 2){
			System.out.println("Press 1 to add a new post or press 2 to go back");
			x = Integer.parseInt(scnr.nextLine());
			if (x == 1) {
				System.out.println("Who is posting?");
				poster = scnr.nextLine();
				System.out.println("Ok, " + poster + " what would you like to say?");
				post = scnr.nextLine();
				posts.add(post);
				System.out.println(poster + ": " + post);
				System.out.println("Press 3 to delete your most recent post or press 2 to go back");
				x = scnr.nextInt();
				if (x == 3) {
					posts.remove(0);
					x = scnr.nextInt();
				}
				toMainPage(x);
			}
		}
		else if (x == 3) {
			System.out.println("Read the previous post or press 2 to go back");
			x = scnr.nextInt();
			toMainPage(x);
		}
		else if (x == 4) {
			System.out.println("Press 1 to check password");
			x = scnr.nextInt();
			passwordChecker();
			x = scnr.nextInt();
			toMainPage(x);
		}
		else if (x == 5) {
			System.out.println("Print an ascii art of you're choice 1) frog 2) cat 3) dog");
			int y = scnr.nextInt();
			if (y == 1) {
				System.out.println("            _     _\r\n"
						+ "           (')-=-(')\r\n"
						+ "         __(   \"   )__\r\n"
						+ "        / _/'-----'\\_ \\\r\n"
						+ "     ___\\\\ \\\\     // //___\r\n"
						+ "      >____)/_\\---/_\\(____<");
			}
			else if (y == 2) {
				System.out.println(" _._     _,-'\"\"`-._\r\n"
						+ "(,-.`._,'(       |\\`-/|\r\n"
						+ "    `-.-' \\ )-`( , o o)\r\n"
						+ "          `-    \\`_`\"'-");
			}
			else if (y == 3) {
				System.out.println("            __\r\n"
						+ "(\\,--------'()'--o\r\n"
						+ " (_    ___    /~\"\r\n"
						+ "  (_)_)  (_)_)");
			}
			x = scnr.nextInt();
			toMainPage(x);
		}
		System.out.println("Users " + users);
		System.out.println("Posts " + posts);
	}
	
	public static void newUser(int x) {
		Scanner scnr = new Scanner(System.in);
		ArrayList <String> users = new ArrayList<String>();
		
		if (x == 1) {
			System.out.println("Enter username");
			String user = scnr.nextLine();
			users.add(user);
			System.out.println(users);
			x = scnr.nextInt();
		}
	}
	
	public static void toMainPage(int x) {
		Scanner scnr = new Scanner(System.in);
		
		if (x == 2) {
			System.out.println(welcomeMessage());
			System.out.println(logo());
			System.out.println(menu());
			int option = scnr.nextInt();
			featureChooser(option);
		}
	}
	
	// menu text
	public static String menu() {
		return "Choose 1 to add a new user \r\n"
				+ "Choose 2 to add a new post \r\n"
				+ "Choose 3 to read previous posts \r\n"
				+ "Choose 4 check your password \r\n"
				+ "Choose 5 print ascii art of your choice \r\n"
				+ "Choose 6 coin flip \r\n"
				+ "Choose 7 to quit";
	}
	
	// logo text
	public static String logo() {
		return "  / _ \\\r\n"
				+ "\\_\\(_)/_/\r\n"
				+ " _//\"\\\\_ \r\n"
				+ "  /   \\"
				+ "\n"
				+ " _       ____________ _       ______  ____  __ __\r\n"
				+ "| |     / / ____/ __ ) |     / / __ \\/ __ \\/ //_/\r\n"
				+ "| | /| / / __/ / __  | | /| / / / / / /_/ / ,<   \r\n"
				+ "| |/ |/ / /___/ /_/ /| |/ |/ / /_/ / _, _/ /| |  \r\n"
				+ "|__/|__/_____/_____/ |__/|__/\\____/_/ |_/_/ |_| ";
	}
	
	// welcome message
	public static String welcomeMessage() {
		return "Welcome to Webwork!";
	}
	
	public static void passwordChecker() {
        Scanner scnr = new Scanner(System.in);
		
		boolean flag = false;
		
		while (flag != true) {
			
			System.out.println("Enter your password: ");
			String password1 = scnr.nextLine();
			
			boolean validPassword = isValidPassword(password1);
			
			if (validPassword == true) {
				System.out.println("This password is Valid!");
				flag = true;
			}
			else {
				System.out.println("Try again");
			}
		}
		
	}
	public static boolean isValidPassword(String password) {
		
		boolean isValid = true;
		if (password.length() < 8) {
			System.out.println("Invalid. Password too short, must be atleast 8 "
					+ "characters long");
			isValid = false;
		}
		
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			System.out.println("Password must have atleast one uppercase character");
			isValid = false;
		}
		
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			System.out.println("Password must have atleast one lowercase character");
			isValid = false;
		}
		
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			System.out.println("Password must have atleast one number");
			isValid = false;
		}
		
		String specialChars = "(.*[@,#,$,%].*)";
		if (!password.matches(specialChars)) {
			System.out.println("Password must have atleast one special character among @#$%");
			isValid = false;
		}
		return isValid;
	}
	

}
