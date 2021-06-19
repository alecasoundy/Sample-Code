import java.util.Scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		//Variables: ascii text input, k key for encription/decription, and DorE for encription/decription process being done
        String text;
		char k, DorE;
		
		//Taking inputs for all variables and convert to capital letters
		System.out.print("Type E or D for encription mode or decription mode or any other character for brute force decription: ");
		DorE = reader.nextLine().charAt(0);
		DorE = Character.toUpperCase(DorE);
		
		System.out.print("Enter text you want to input: ");
		text = reader.nextLine();
		text = text.toUpperCase();
		
		System.out.print("Type the key ('A'-'Z') you would like to use: ");
		k = reader.nextLine().charAt(0);
		k = Character.toUpperCase(k);
		int K = (int) k - 65;
		
		//Lastly we are looping through input text and changing each character by the key, adding for encription and subtracting for decription
		if (DorE == 'E'){
			int textLength = text.length();
			for (int i = 0; i < textLength; i++) {
		
			    int current = (int) text.charAt(i) - 13;
			    char output = (char) (((current + K ) % 26) + 65);
			    System.out.print(output);
			}
		}
		else if (DorE == 'D'){
			int textLength = text.length();
			for (int i = 0; i < textLength; i++) {
		
			    int current = (int) text.charAt(i) - 13;
			    char output = (char) (((current - K ) % 26) + 65);
			    System.out.print(output);
			}
		}
		
		//In the event that a character besides E or D is entered for DorE, the Brute Force Decription process is started. This causes the plaintext to be decripted for every k
		else{
		    for (int j = 0; j < 26; j++){
		        int textLength = text.length();
			    for (int i = 0; i < textLength; i++) {
		
			        int current = (int) text.charAt(i) - 13;
			        char output = (char) (((current - j ) % 26) + 65);
			        System.out.print(output);
			    }
				char J = (char) (j + 65);
				System.out.print(" " + J);
			    System.out.print("\n");
		    }
		}
    }
}