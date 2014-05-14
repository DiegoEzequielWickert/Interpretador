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
		if(frase.equals("FIM")){
			return true;
		}else if(frase.equals("RECEBE")){
			return true;
		}else if(frase.equals("SOMA")){
			return true;
		}else if(frase.equals("SUBTRAI")){
			return true;
		}else if(frase.equals("MULTIPLICA")){
			return true;
		}else if(frase.equals("DIVIDE")){
			return true;
		}else if(frase.equals("MUGIR")){
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
	
	private void erroDetectado(int num){
		
		System.err.println("-----------------------------------");
		System.err.println("ERRO DETECTADO, TERMINANDO PROGRAMA");
		System.err.println("-----------------------------------");
		
		switch(num){
		
		case 0:
			System.err.println("PALAVRA RESERVADA UTILIZADA NO CONTEXTO ERRADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 1:
			System.err.println("NAO E POSSIVEL ATRIBUIR VALOR FLOAT PARA VARIAVEL DO TIPO INT");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
		
		case 2:
			System.err.println("ERRO AO CONVERTER NUMERO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 3:			
			System.err.println("NAO FOI POSSIVEL ENCONTRAR NENHUMA VARIAVEL COM O NOME INFORMADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;	
		
		case 4:
			System.err.println("NAO E POSSIVEL ATRIBUIR VALOR INT PARA VARIAVEL DO TIPO FLOAT");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 5:
			System.err.println("FIM NAO ENCONTRADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 6:
			System.err.println("NOME DE VARIAVEL INVALIDO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		}
				
		
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
					if(verifyMistakes(tokens[count])){
						erroDetectado(0);
					}					
					
					try{
						int testConvert;
						testConvert = Integer.parseInt(tokens[count]);
						erroDetectado(6);
					}catch(NumberFormatException r){
						//NOME VALIDO SE CHEGAR AQUI
					}
					
					nomeDaVariavel = tokens[count];
					count++;
										
					if(tokens[count].equals("RECEBE")){
						count++;
						
						
						if(returnResult == 3){
														
							valorSTRING = tokens[count];
							count++;
							
							if(tokens[count].equals("FIM") == false){
								erroDetectado(5);
							}else{
								stringVariables.put(nomeDaVariavel, valorSTRING);
								count++;
							}
							
						}else{	
							
							if(verifyMistakes(tokens[count])){
								erroDetectado(0);
							}
							
							if(returnResult == 1){ // INTEIRO
								
								if(tokens[count].contains(".")){
									erroDetectado(1);
								}else{
									intResultado += Integer.parseInt(tokens[count]);
									count++;
								}
								
								while(tokens[count].equals("FIM") == false){
									
									if(tokens[count].equals("SOMA")){
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{																				
											if(tokens[count].contains(".")){
												erroDetectado(1);
											}else{
												intResultado += Integer.parseInt(tokens[count]);
												count++;
											}											
										}
									}else if(tokens[count].equals("SUBTRAI")){
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{
											if(tokens[count].contains(".")){
												erroDetectado(1);
											}else{
												intResultado -= Integer.parseInt(tokens[count]);
												count++;
											}
										}
									}else if(tokens[count].equals("MULTIPLICA")){ // AQUI TEM ERRO  FADOPFJSDFNDFUIHSDFIOSHFUIDFHSDUI
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{
											if(tokens[count].contains(".")){
												erroDetectado(1);
											}else{
												intResultado *= Integer.parseInt(tokens[count]);
												count++;
											}
										}
										
									}else if(tokens[count].equals("DIVIDE")){
										count++;
										
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{										
											if(tokens[count].contains(".")){
												erroDetectado(1);
											}else{
												intResultado /= Integer.parseInt(tokens[count]);
												count++;
											}
										}
										
									}else{
										System.err.println("ERRO NA SINTAXE, TERMINANDO PROGRAMA");
										System.exit(0);
									}
									
								}
								
								integerVariables.put(nomeDaVariavel, intResultado);
								
							}else if(returnResult == 2){ // FLOAT
								
								if(tokens[count].contains(".") == false){
									erroDetectado(4);
								}else{
									floatResultado += Float.parseFloat(tokens[count]);
									count++;
								}
								
								while(tokens[count].equals("FIM") == false){
									
									if(tokens[count].equals("SOMA")){
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{																				
											if(tokens[count].contains(".") == false){
												erroDetectado(4);
											}else{
												floatResultado += Float.parseFloat(tokens[count]);
												count++;
											}											
										}
									}else if(tokens[count].equals("SUBTRAI")){
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{
											if(tokens[count].contains(".") == false){
												erroDetectado(4);
											}else{
												floatResultado -= Float.parseFloat(tokens[count]);
												count++;
											}
										}
									}else if(tokens[count].equals("MULTIPLICA")){ // AQUI TEM ERRO  FADOPFJSDFNDFUIHSDFIOSHFUIDFHSDUI
										count++;
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{
											if(tokens[count].contains(".") == false){
												erroDetectado(4);
											}else{
												floatResultado *= Float.parseFloat(tokens[count]);
												count++;
											}
										}
										
									}else if(tokens[count].equals("DIVIDE")){
										count++;
										
										if(verifyMistakes(tokens[count])){
											erroDetectado(0);
										}else{
											if(tokens[count].contains(".") == false){
												erroDetectado(4);
											}else{
												floatResultado /= Float.parseFloat(tokens[count]);
												count++;
											}
										}
										
									}else{
										System.err.println("ERRO NA SINTAXE, TERMINANDO PROGRAMA");
										System.exit(0);
									}
									
								}	
								
								floatVariables.put(nomeDaVariavel, floatResultado);
								
							}// FIM FLOAT
							
						}// FIM DO VERIFICA SE E INT OU FLOAT	
						
					}else if(tokens[count].equals("FIM")){            // FIM DO TOKENS == RECEBE
						if(returnResult == 1){
							integerVariables.put(nomeDaVariavel, null);
						}else if(returnResult == 2){
							floatVariables.put(nomeDaVariavel, null);
						}else if(returnResult == 3){
							stringVariables.put(nomeDaVariavel, null);
						}
						
					}else{
						erroDetectado(5);
					}
					
							
				// FIM DO returnResult > 0	
				}else if(tokens[count].equals("MUGIR")){
					
					count++;
					int h;
					h = 0;
					String frase[] = new String[25];
					
					if(tokens[count].equals("FIM")){
						frase[h] = "MOOOOOOOOOOOOO";
					}else{
																	
						while(tokens[count].equals("FIM") == false){
							
							if(tokens[count].equals("VAR")){
								count++;
								
								while(tokens[count].equals("--")){
									count++;
									frase[h] = " ";
									h++;
								}
														
								if(integerVariables.containsKey(tokens[count])){
									frase[h] = String.valueOf(integerVariables.get(tokens[count]));
									h++;
								}else if( floatVariables.containsKey(tokens[count])){
									frase[h] = String.valueOf(floatVariables.get(tokens[count]));
									h++;
								}else if(stringVariables.containsKey(tokens[count]) ){
									frase[h] = stringVariables.get(tokens[count]);
									h++;
								}else{
									erroDetectado(3);
								}
								
							}else if(tokens[count].equals("VAZIO")){
								frase[h] = "\n";
								h++;
							}else if(tokens[count].equals("--")){
								frase[h] = " ";
								h++;
							}else{
								frase[h] = tokens[count];
								h++;
							}
							count++;
						
						}
						
						
					}
					
					for(int e = 0; frase[e] != null ; e++){
						System.out.print(frase[e]);
					}
					
					
				}else if(tokens[count].equals("SE")){   // FAZ O SE (IF)
								
				
				
				
				}else{
					
					if(integerVariables.containsKey(tokens[count])){
						
					}else if( floatVariables.containsKey(tokens[count])){
						
					}else if(stringVariables.containsKey(tokens[count]) ){
						
					}else{
						
						
					}
					
					// SE ENCONTRAR NOME DE VARIAVEL E DEPOIS ATRIBUICAO
					// OU SE ENCONTRAR ALGO PERDIDO. FORA DE CONTEXTO
				}
				
				count++;
			}// ENQUANTO COUNT FOR MENOR QUE TOKENS.LENGTH
			
		
			// LEMBRE SE DE RESETAR VALORES
			
					
		}catch(NumberFormatException f){
			erroDetectado(2);
			System.exit(0);
		}
		
	
	}

	
	
	
}


