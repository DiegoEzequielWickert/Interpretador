import java.util.HashMap;
import java.util.Map;


public class Interpretador {
	
	Map <String, String> stringVariables = new HashMap<String, String>();
	Map <String, Integer> integerVariables = new HashMap<String, Integer>();
	Map <String, Float> floatVariables = new HashMap<String, Float>();
			
	String nomeDaVariavel;
	String [] tokens = new String[2000];
	int returnResult;
	int count;
	int intResultado = 0;
	int valorINT = 0;
	float valorFLOAT = 0.0f;
	float floatResultado = 0.0f;
	String valorSTRING;
	
	
	private boolean verifyMistakes(String frase){
		if(frase.equals("fim")){
			return true;
		}else if(frase.equals("recebe")){
			return true;
		}else if(frase.equals("soma")){
			return true;
		}else if(frase.equals("subtrai")){
			return true;
		}else if(frase.equals("multiplica")){
			return true;
		}else if(frase.equals("dividido")){
			return true;
		}else if(frase.equals("mugir")){
			return true;
		}else if(frase.equals("int")){
			return true;
		}else if(frase.equals("float")){
			return true;
		}else if(frase.equals("string")){
			return true;
		}
		
		return false;
	}
	
	public void setTokens(String storeTokens[]){
		tokens = storeTokens.clone();
	}
	
	private void erroDetectado(){
		System.err.println("-----------------------------------");
		System.err.println("ERRO DETECTADO, TERMINANDO PROGRAMA");
		System.err.println("-----------------------------------");
		System.exit(0);
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
					nomeDaVariavel = tokens[count];
					count++;
					if(tokens[count].equals("recebe")){
						count++;
						if(verifyMistakes(tokens[count])){
							erroDetectado();
						}
						
						if(returnResult == 3){
							valorSTRING = tokens[count];
							count++;
							
							if(tokens[count].equals("fim") == false){
								erroDetectado();
							}else{
								stringVariables.put(nomeDaVariavel, valorSTRING);
								count++;
							}
							
						}else{
							
							if(tokens[count].contains(".")){
								valorFLOAT += Float.parseFloat(tokens[count]);
								count++;
							}else{
								valorINT += Integer.parseInt(tokens[count]);
								count++;
							}					
						
							while(tokens[count].equals("fim") == false){
								
								if(tokens[count].equals("soma")){
									count++;
									if(verifyMistakes(tokens[count])){
										erroDetectado();
									}else{
										if(tokens[count].contains(".")){
											valorFLOAT += Float.parseFloat(tokens[count]);
											count++;
										}else{
											valorINT += Integer.parseInt(tokens[count]);
											count++;
										}
										
									}
								}else if(tokens[count].equals("subtrai")){
									count++;
									if(verifyMistakes(tokens[count])){
										erroDetectado();
									}else{
										if(tokens[count].contains(".")){
											valorFLOAT -= Float.parseFloat(tokens[count]);
											count++;
										}else{
											valorINT -= Integer.parseInt(tokens[count]);
											count++;
										}
									}
								}else if(tokens[count].equals("multiplica")){ // AQUI TEM ERRO  FADOPFJSDFNDFUIHSDFIOSHFUIDFHSDUI
									count++;
									if(verifyMistakes(tokens[count])){
										erroDetectado();
									}else{
										
										if(returnResult == 1){
											intResultado = valorINT + (int)valorFLOAT;
										}else if(returnResult == 2){
											floatResultado = (float)valorINT + valorFLOAT;
										}		
																				
										if(tokens[count].contains(".")){
											floatResultado *= Float.parseFloat(tokens[count]);
											count++;
										}else{
											intResultado *= Integer.parseInt(tokens[count]);
											count++;
										}
									}
									
								}else if(tokens[count].equals("dividido")){
									count++;
									
									if(returnResult == 1){
										intResultado = valorINT + (int)valorFLOAT;
									}else if(returnResult == 2){
										floatResultado = (float)valorINT + valorFLOAT;
									}									
									
									if(tokens[count].contains(".")){
										floatResultado /= Float.parseFloat(tokens[count]);
										count++;
									}else{
										intResultado /= Integer.parseInt(tokens[count]);
										count++;
									}
								}else{
									System.err.println("ERRO NA SINTAXE, TERMINANDO PROGRAMA");
									System.exit(0);
								}
								
							}
							count++;
							
							
							
							
							
							if(returnResult == 1){
								intResultado += valorINT + (int)valorFLOAT;
								integerVariables.put(nomeDaVariavel, intResultado);
							}else if(returnResult == 2){
								floatResultado += (float)valorINT + valorFLOAT;
								floatVariables.put(nomeDaVariavel, floatResultado);
							}
							
						} // AQUI FHDIUHFAOIDJASIODJAIODAJDSAODIJAIOSDJAOSDIDJIODJSOIDAJSIODJ
							
						
					}else{
						// APENAS DECLARA VARIÁVEL SEM VALOR
						
					}
					
					
				}else if(tokens[count].equals("mugir")){
					
					
				}		
				count++;
				System.out.println("VALOR DA LISTA " + integerVariables.get("nome"));
		
			}
			
			
					
		}catch(NumberFormatException f){
			System.err.println("ERRO AO CONVERTER NUMERO");
			System.exit(0);
		}
		
	
	}
	
}


