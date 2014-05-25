import java.util.HashMap;
import java.util.Map;


public class Interpretador {
	
		
	Enquanto enquanto = new Enquanto();
	Error error = new Error();
	Recebe recebe = new Recebe();
	Mugir mugir = new Mugir();
	Se se = new Se();
	
	private static Map <String, String> stringVariables = new HashMap<String, String>();
	private static Map <String, Integer> integerVariables = new HashMap<String, Integer>();
	private static Map <String, Float> floatVariables = new HashMap<String, Float>();
			
	private int fimIndex = 0;
	private int indexCount = 0;
	private int [] enquantoIndex = new int[15];
	private int contadorDeSe = 0;
	private static String nomeDaVariavel;
	private static String [] tokens = new String[2000];
	private static int returnResult;
	private static int count;
	private	String valorSTRING;
	private boolean seRetorno = false;
	private boolean retornoEnquanto = false;
	
		
	public void setTokens(String storeTokens[]){
		tokens = storeTokens.clone();
	}
	
		
	private int verificaTipo(String abc){
		if(abc.equals("int")){
			return 1;
		}else if(abc.equals("float")){
			return 2;
		}else if(abc.equals("string")){
			return 3;
		}				
		return 0;
	}
	

	public void startInterpret(){
		
		try{	
			for(count = 0; count < tokens.length;){
				
				returnResult = verificaTipo(tokens[count]);				
				
				if(returnResult > 0){
					
					count++;
					if(error.verifyWord(tokens[count])){
						error.detectadoErro(0);
					}					
					
					try{
						Integer.parseInt(tokens[count]);
						error.detectadoErro(6);
					}catch(NumberFormatException r){
						//NOME VALIDO SE CHEGAR AQUI
					}
					
					if(doesVariableNameAlreadyExists() == false){
						nomeDaVariavel = tokens[count];
						count++;
					}else{
						error.detectadoErro(7);
					}
										
					if(tokens[count].equals("RECEBE")){
						count++;
						recebe.atribuiValores(tokens);
						
					}else if(tokens[count].equals("FIM")){            // FIM DO TOKENS == RECEBE
						if(returnResult == 1){
							integerVariables.put(nomeDaVariavel, 0);
						}else if(returnResult == 2){
							floatVariables.put(nomeDaVariavel, 0.0f);
						}else if(returnResult == 3){
							stringVariables.put(nomeDaVariavel, null);
						}
						
					}else{
						error.detectadoErro(5);
					}
					
							
				// FIM DO returnResult > 0	
				}else if(tokens[count].equals("MUGIR")){
					
					count++;
					mugir.comecaMugir(tokens);
						
				}else if(tokens[count].equals("SE")){   // FAZ O SE (IF)
					contadorDeSe++;
					count++;
					
					seRetorno = se.comecaSe(tokens);
					
					if(seRetorno == true){
						
					}else{
						while(true){
							
							if(tokens[count].equals("FIMSE") == true){
								contadorDeSe--;
								break;
							}else if(tokens[count].equals("SENAO") == true){
								break;
							}
							count++;
							
							if((count >= tokens.length)){
								error.detectadoErro(12);
							}
						}
										
					}
					
					
				
				}else if(tokens[count].equals("ENQUANTO")){
					
					count++;
					enquantoIndex[indexCount] = count;
					indexCount++;
					retornoEnquanto = enquanto.comecaEnquanto(tokens);
					
					if(retornoEnquanto == true){
						
					}else{
						while(true){
							
							if(tokens[count].equals("FIMENQUANTO")){
								indexCount--;
								break;
							}
							
							count++;
							
							if(count >= tokens.length){
								error.detectadoErro(12);
							}				
														
						}
					}					
					
					
					
				}else if(tokens[count].equals("FIMENQUANTO")){
					fimIndex = count;
					if(indexCount > 0){
						indexCount--;
					}
					count = enquantoIndex[indexCount];
					if(enquanto.comecaEnquanto(tokens)){
						indexCount++;
					}else{
						count = fimIndex;
												
					}
					
				}else if(tokens[count].equals("FIMSE")){
					contadorDeSe--;
				}else if(tokens[count].equals("SENAO")){
					while(tokens[count].equals("FIMSE") == false){
						count++;
						
						if(count >= tokens.length){
							error.detectadoErro(12);
						}
					}
					contadorDeSe--;
				}else{
					String nomeVar = null;
					if(integerVariables.containsKey(tokens[count])){
						nomeVar = tokens[count];
						count++;
						
						if(tokens[count].equals("RECEBE")){
							count++;
							if(error.verifyWord(tokens[count])){
								error.detectadoErro(0);
							}							
							integerVariables.put(nomeVar, recebe.recebeInt(tokens));
						}else{
							error.detectadoErro(8);
						}					
						
												
					}else if( floatVariables.containsKey(tokens[count])){
						nomeVar = tokens[count];
						count++;
						
						if(tokens[count].equals("RECEBE")){
							count++;
							if(error.verifyWord(tokens[count])){
								error.detectadoErro(0);
							}
							floatVariables.put(nomeVar, recebe.recebeFloat(tokens));
							
						}else{
							error.detectadoErro(8);
						}
					}else if(stringVariables.containsKey(tokens[count]) ){
						nomeVar = tokens[count];
						count++;
						
						if(tokens[count].equals("RECEBE")){
							count++;
							if(error.verifyWord(tokens[count])){
								error.detectadoErro(0);
							}
							
							stringVariables.put(nomeVar, recebe.recebeString(tokens));
														
						}else{
							error.detectadoErro(8);
						}
					}else{
						System.out.println(tokens[count]);	
						error.detectadoErro(9);						
					}
					
				}
				
				count++;
			}			
					
		}catch(NumberFormatException f){
			error.detectadoErro(2);
			System.exit(0);
		}
		
		
		
	}

	
	public static void addCount(){
		count++;		
	}
		
	public static int getCount(){
		return count;
	}
		
	public void setValorString(String novoValorString){
		this.valorSTRING = novoValorString;		
	}

	public static int getReturnResult(){
		return returnResult;
	}
	
	public static void setIntegerVariable(int intResultado){
		integerVariables.put(nomeDaVariavel, intResultado);
	}
	
	public static void setFloatVariable(float floatResultado){
		floatVariables.put(nomeDaVariavel, floatResultado);
	}
	
	public static void setStringVariable(String valorStr){
		stringVariables.put(nomeDaVariavel, valorStr);
	}
	
	public static Map<String,Integer> getIntegerMap(){
		return integerVariables;
	}
	
	public static Map<String,Float> getFloatMap(){
		return floatVariables;
	}
	
	public static Map<String, String> getStringMap(){
		return stringVariables;
	}
	
	public static boolean doesVariableNameAlreadyExists(){
		if(integerVariables.containsKey(tokens[count])){
			return true;
		}else if( floatVariables.containsKey(tokens[count])){
			return true;
		}else if(stringVariables.containsKey(tokens[count]) ){
			return true;
		}
		
		return false;
	}
	
}


