public class RC4{
	int i;
	int j=0;
	private final byte[] S = new byte[256]; 							//Allocate memory for S and T arrays
	private final byte[] T = new byte[256];
	int Keylength;
	
	public RC4(final byte[] key){
		Keylength = key.length;
		for (i=0; i<256; i++){ 											//Fill up the S and T arrays with initial state values
			S[i] = (byte) i;
			T[i] = key[i % Keylength];
		}
		byte temp;
		for (i=0; i<256; i++){ 
			j = ((j+S[i]+T[i]) & 0xFF);
			temp = S[j];
            S[j] = S[i];
            S[i] = temp;
		}
	}
	
	public byte[] en(final byte[] Message){
		i = 0;
		j = 0;
		int t,m;
		byte temp;
		int bytenum; 													//Counter for current byte from message being encripted
		final byte[] Crypt = new byte[Message.length]; 					//Allocate memory for the ciphertext
		for (bytenum = 0; bytenum < Message.length; bytenum++){ 		//The encription algorithm starts here
			i = ((i+1) & 0xFF); 										//i is assigned i mod 256
			j = ((j+S[i]) & 0xFF); 										//j is assigned j+s[i] mod 256
			temp = S[j]; 												//swap S[j] and S[i]
            S[j] = S[i];
            S[i] = temp;
			t = ((S[i] + S[j]) & 0xFF); 								//t is assigned S[i]+S[j] mod 256
			m = S[t];
			Crypt[bytenum] = (byte) (Message[bytenum] ^ m);
		}
		return Crypt;
	}
	
	public byte[] de(final byte[] Crypt){ 								//The encription process is the same as decription
		return en(Crypt);
	}
}