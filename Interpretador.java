import java.util.HashMap;
import java.util.Map;


public class Interpretador {
	
	Error error = new Error();
	Recebe recebe = new Recebe();
	Mugir mugir = new Mugir();
	
	private static Map <String, String> stringVariables = new HashMap<String, String>();
	private static Map <String, Integer> integerVariables = new HashMap<String, Integer>();
	private static Map <String, Float> floatVariables = new HashMap<String, Float>();
			
	private static String nomeDaVariavel;
	private static String [] tokens = new String[2000];
	private static int returnResult;
	private static int count;
	private	String valorSTRING;
	
	
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
						int testConvert = 0;
						testConvert = Integer.parseInt(tokens[count]);
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
							integerVariables.put(nomeVar, recebe.recebeInt(tokens, integerVariables.get(nomeVar)));
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
							floatVariables.put(nomeVar, recebe.recebeFloat(tokens, floatVariables.get(nomeVar)));
							
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
					
					// SE ENCONTRAR NOME DE VARIAVEL E DEPOIS ATRIBUICAO
					// OU SE ENCONTRAR ALGO PERDIDO. FORA DE CONTEXTO
				}
				
				count++;
			}// ENQUANTO COUNT FOR MENOR QUE TOKENS.LENGTH
		
			// LEMBRE SE DE RESETAR VALORES
			
					
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


