import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class Read{

	public static void main(String args[]){
	
		try{
			File fileToRead = new File(args[0]);
			Scanner s = new Scanner(fileToRead);
			
			System.out.println(s.nextLine());
		}catch(Exception e){
			
		}
			
	}

}