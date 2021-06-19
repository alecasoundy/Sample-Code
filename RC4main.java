import java.util.Random;

public class RC4main{
	public static void main(String args[]){
		Random rd = new Random(); 														//Random number generator
		byte[] Key = hexStringToByteArray("FFFFFFFFFFFFFFFF"); 							//Key used to encrypt/decrypt message
		
		byte[] message = hexStringToByteArray("11111111"); 								//Message used for encryption
		
		RC4 rc4 = new RC4(Key);															//Initialization of RC4 cypher
		
		System.out.print("\n This is the original message: "); 							//To show the original message used in encryption
        for (int i = 0; i < message.length; i++) {          
            System.out.print(message[i]);          
        }    

		final long startTime = System.nanoTime(); 										//To record program runtime

        byte[] encripted = rc4.en(message); 											//The message is encrypted here into cyphertext
        System.out.print("\n This is the message encoded: "); 							//The cyphertext is shown here
        for (int i = 0; i < encripted.length; i++) {          
            System.out.print(encripted[i]);          
        }    
		System.out.print("\n");
		for (int i = 0; i < encripted.length; i++) {   									//Binary representation of encrypted message       
            String s1 = String.format("%8s", Integer.toBinaryString(encripted[i] & 0xFF)).replace(' ', '0');
			System.out.print(s1);          
        }
		

		//for (int j = 0; j<999; j++){ 													//To run encryption 1000 times
			rc4 = new RC4(Key); 														//A new RC4 cypher is initialized to reset S and T arrays
			encripted = rc4.de(encripted); 												//The cyphertext is decrypted into the original message here
		//}
		System.out.print("\n This is the message decoded: "); 							//The decrypted message is then shown here
			for (int i = 0; i < encripted.length; i++) {          
				System.out.print(encripted[i]);            
			} 
			System.out.print("\n");
			for (int i = 0; i < encripted.length; i++) {          						//Binary representation of decrypted message
				String s1 = String.format("%8s", Integer.toBinaryString(encripted[i] & 0xFF)).replace(' ', '0');
				System.out.print(s1);          
			}
		
		final long Duration = System.nanoTime() - startTime;
		System.out.print("\n ");
		System.out.print(Duration);
		System.out.print(" Nanoseconds");
		
	}
	public static byte[] hexStringToByteArray(String s) { 								//A string to hex converter that I found online
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}
}