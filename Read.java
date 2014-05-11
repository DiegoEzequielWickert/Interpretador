import java.util.Scanner;  
import java.io.File;

public class Read{

	public static void main(String args[]){
		
		Interpretador interpret = new Interpretador();	
		int i = 0;
		String storeWords[] = new String[2000];
		String storeTokens[] = new String[3000];
				
		try{
			
			File fileToRead = new File(args[0]);
			Scanner s = new Scanner(fileToRead);
			
			while(s.hasNextLine()){
				storeWords[i] = s.nextLine();
				i++;
			}
			
			int f = 0;
			String temp[] = new String[200];
			
			
			while(storeWords[f] != null){
				int g = 0;
				temp = storeWords[f].split("\\s");
				
				while(storeTokens[g] != null){
					g++;
				}
					
							
				for(int y = 0; y < temp.length; y++){
					if(temp[y].contentEquals("") == false){
						storeTokens[g] = temp[y];
						g++;
					}
				}
				
				temp = new String[temp.length];
				f++;
				
			}
			
			// Comentado loop que imprime valores dentro de StoreTokens
			/*for(int h = 0; storeTokens[h] != null; h++){
				System.out.println(storeTokens[h]);
			}*/
			
			interpret.setTokens(storeTokens);
			interpret.iniciaInterpretacao();
			
		}catch(Exception e){
			
		}
			
	}

}