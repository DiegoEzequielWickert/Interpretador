import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class Read{

	public static void main(String args[]){
		int j = 0;
		int i = 0;
		String storeWords[] = new String[2000];
		
		try{
			File fileToRead = new File(args[0]);
			Scanner s = new Scanner(fileToRead);
			
			while(s.hasNextLine()){
				storeWords[i] = s.nextLine();
				//System.out.println(s.nextLine());
				i++;
			}
			
			
			System.out.println("A PARTIR DAQUI O QUE ESTA GUARDADO NO STOREWORDS");
			while(storeWords[j] != null ){
				System.out.println(storeWords[j]);
				j++;
			}
			
		}catch(Exception e){
			
		}
			
	}

}