
public class Se {
	Error error = new Error();
	int valorInt;
	int intCompara;
	float floatCompara;
	float valorFloat;
	String valorString;
	String stringCompara;
	int valueType;
	int valueOther;
	
	
	public boolean comecaSe(String [] tokens){
		
		valueType = verificaVar(tokens);
		setCompara();
		Interpretador.addCount();
		
			while(true){				
		
				if(tokens[Interpretador.getCount()].equals("IGUAL")){			/////////////////////////////////////////////////////////////
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						if(valueType == 1){
							if(intCompara == valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara == valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.equals(valorString)){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
				}else if(tokens[Interpretador.getCount()].equals("MAIOR")){				/////////////////////////////////////////////////////////////
					
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
						
					
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						
						if(valueType == 1){
							if(intCompara > valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara > valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.length() > valorString.length()){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
					
				}else if(tokens[Interpretador.getCount()].equals("MENOR")){			/////////////////////////////////////////////////////////////
					
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						if(valueType == 1){
							if(intCompara < valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara < valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.length() < valorString.length()){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
					
					
				}else if(tokens[Interpretador.getCount()].equals("MENORIGUAL")){
					
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						if(valueType == 1){
							if(intCompara <= valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara <= valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.length() <= valorString.length()){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
					
				}else if(tokens[Interpretador.getCount()].equals("MAIORIGUAL")){
					
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						if(valueType == 1){
							if(intCompara >= valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara >= valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.length() >= valorString.length()){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
					
				}else if(tokens[Interpretador.getCount()].equals("DIFERENTE")){
					
					Interpretador.addCount();
					valueOther = verificaVar(tokens);
					Interpretador.addCount();
					
					if(valueType != valueOther){
						error.detectadoErro(10);
					}else{
						
						if(tokens[Interpretador.getCount()].equals("ENTAO") == false){
							resolveExpressao(tokens);
						}
						
						if(valueType == 1){
							if(intCompara != valorInt){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 2){
							if(floatCompara != valorFloat){
								return true;
							}else{
								return false;
							}
						}else if(valueType == 3){
							if(stringCompara.equals(valorString) == false){
								return true;
							}else{
								return false;
							}
						}
						error.detectadoErro(11);
					}
					
				}else if(tokens[Interpretador.getCount()].equals("SOMA")){
					
					Interpretador.addCount();
					
					if(error.verifyWord(tokens[Interpretador.getCount()])){
						error.detectadoErro(0);
					}
								
					if(valueType == 1){
						if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
							intCompara += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						}else{
						
							try{
								intCompara += Integer.parseInt(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						
						}
						 
					}else if(valueType == 2){
						
						if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
							floatCompara += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						}else{
						
							try{
								floatCompara += Float.parseFloat(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
							
						}
					}else if(valueType == 3){
						error.detectadoErro(8);
					}
						
				}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
					
					Interpretador.addCount();
					
					if(error.verifyWord(tokens[Interpretador.getCount()])){
						error.detectadoErro(0);
					}
								
					if(valueType == 1){
						
						if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
							intCompara -= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						}else{
						
							try{
								intCompara -= Integer.parseInt(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
							
						}
						 
					}else if(valueType == 2){
						if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
							floatCompara -= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						}else{
							try{
								floatCompara -= Float.parseFloat(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						}	
					}else if(valueType == 3){
						error.detectadoErro(8);
					}
				}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){
					Interpretador.addCount();
					
					if(error.verifyWord(tokens[Interpretador.getCount()])){
						error.detectadoErro(0);
					}
								
					if(valueType == 1){
						if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
							intCompara *= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						}else{
						
							try{
								intCompara *= Integer.parseInt(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						}
					}else if(valueType == 2){
						if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
							floatCompara *= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						}else{
							try{
								floatCompara *= Float.parseFloat(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						}
					}else if(valueType == 3){
						error.detectadoErro(8);
					}
				}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
					Interpretador.addCount();
					
					if(error.verifyWord(tokens[Interpretador.getCount()])){
						error.detectadoErro(0);
					}
								
					if(valueType == 1){
						if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
							intCompara /= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						}else{
						
							try{
								intCompara /= Integer.parseInt(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						}	 
					}else if(valueType == 2){
						if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
							floatCompara /= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						}else{
							try{
								floatCompara /= Float.parseFloat(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException g){
								error.detectadoErro(2);
							}
						}
					}else if(valueType == 3){
						error.detectadoErro(8);
					}
				}else{
					error.detectadoErro(11);					
				}
				Interpretador.addCount();
		}
		
	}	
	
	private int verificaVar(String [] tokens){
		if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
			valorInt = Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
			return 1;
		}else if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
			valorFloat = Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
			return 2;
		}else if(Interpretador.getStringMap().containsKey(tokens[Interpretador.getCount()])){
			valorString = Interpretador.getStringMap().get(tokens[Interpretador.getCount()]);
			return 3;
		}else{
			try{				
				Integer.parseInt(tokens[Interpretador.getCount()]);
				if(tokens[Interpretador.getCount()].contains(".")){
					error.detectadoErro(1);
				}else{
					valorInt = Integer.parseInt(tokens[Interpretador.getCount()]);
					return 1;
				}
				 
			}catch(NumberFormatException r){
				try{
					Float.parseFloat(tokens[Interpretador.getCount()]);
					valorFloat = Float.parseFloat(tokens[Interpretador.getCount()]);
					return 2;
				}catch(NumberFormatException e){
					if(error.verifyWord(tokens[Interpretador.getCount()])){
						error.detectadoErro(0);
					}
					valorString = verificaString(tokens);
					return 3;
				}
			}
					
		}
		error.detectadoErro(11);
		return 0;
	}
	
	
	private String verificaString(String [] tokens){
		
		String valor = null;
		
		if(tokens[Interpretador.getCount()].equals("#VAZIO")){
			valor = " ";
		}else if(tokens[Interpretador.getCount()].equals("#SOMA")){
			valor = "SOMA";
		}else if(tokens[Interpretador.getCount()].equals("#SUBTRAI")){
			valor = "SUBTRAI";
		}else if(tokens[Interpretador.getCount()].equals("#MULTIPLICA")){
			valor = "MULTIPLICA";
		}else if(tokens[Interpretador.getCount()].equals("#DIVIDE")){
			valor = "DIVIDE";
		}else if(tokens[Interpretador.getCount()].equals("#MUGIR")){
			valor = "MUGIR";
		}else if(tokens[Interpretador.getCount()].equals("#FIM")){
			valor = "FIM";
		}else if(tokens[Interpretador.getCount()].equals("#SE")){
			valor = "SE";
		}else if(tokens[Interpretador.getCount()].equals("#int")){
			valor = "int";
		}else if(tokens[Interpretador.getCount()].equals("#float")){
			valor = "float";
		}else if(tokens[Interpretador.getCount()].equals("#string")){
			valor = "string";
		}else if(tokens[Interpretador.getCount()].equals("#RECEBE")){
			valor = "RECEBE";
		}else if(tokens[Interpretador.getCount()].equals("#MAIOR")){
			valor = "MAIOR";
		}else if(tokens[Interpretador.getCount()].equals("#MENOR")){
			valor = "MENOR";
		}else if(tokens[Interpretador.getCount()].equals("#MAIORIGUAL")){
			valor = "MAIORIGUAL";
		}else if(tokens[Interpretador.getCount()].equals("#MENORIGUAL")){
			valor = "MENORIGUAL";
		}else if(tokens[Interpretador.getCount()].equals("#IGUAL")){
			valor = "IGUAL";
		}else if(tokens[Interpretador.getCount()].equals("#DIFERENTE")){
			valor = "DIFERENTE";
		}else if(tokens[Interpretador.getCount()].equals("#ENQUANTO")){
			valor = "ENQUANTO";
		}else if(tokens[Interpretador.getCount()].equals("#ENTAO")){
			valor = "ENTAO";
		}else if(tokens[Interpretador.getCount()].equals("#FIMSE")){
			valor = "FIMSE";
		}else{
			valor = tokens[Interpretador.getCount()];
		}
		
		return valor;
	}
	
	private void setCompara(){
		if(valueType == 1){
			intCompara = valorInt;
		}else if(valueType == 2){
			floatCompara = valorFloat;
		}else if(valueType == 3){
			stringCompara = valorString;
		}
	}
	
	private void resolveExpressao(String [] tokens){
		
		while(tokens[Interpretador.getCount()].equals("ENTAO") == false){
			if(tokens[Interpretador.getCount()].equals("SOMA")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}
							
				if(valueOther == 1){
					if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
						intCompara += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
					}else{
					
						try{
							valorInt += Integer.parseInt(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					} 
				}else if(valueOther == 2){
					if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
						floatCompara += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
					}else{
						try{
							valorFloat += Float.parseFloat(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					}
				}else if(valueOther == 3){
					error.detectadoErro(8);
				}
					
			}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}
							
				if(valueOther == 1){
					if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
						intCompara -= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
					}else{
					
						try{
							valorInt -= Integer.parseInt(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					} 
				}else if(valueOther == 2){
					if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
						floatCompara -= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
					}else{
						try{
							valorFloat -= Float.parseFloat(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					}
				}else if(valueOther == 3){
					error.detectadoErro(8);
				}
			}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}
							
				if(valueOther == 1){
					if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
						intCompara *= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
					}else{
					
						try{
							valorInt *= Integer.parseInt(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					} 
				}else if(valueOther == 2){
					if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
						floatCompara *= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
					}else{
						try{
							valorFloat *= Float.parseFloat(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					}
				}else if(valueOther == 3){
					error.detectadoErro(8);
				}
			}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}
							
				if(valueOther == 1){
					if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
						intCompara /= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
					}else{
					
						try{
							valorInt /= Integer.parseInt(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					} 
				}else if(valueOther == 2){
					if(Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
						floatCompara /= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
					}else{
						try{
							valorFloat /= Float.parseFloat(tokens[Interpretador.getCount()]);
						}catch(NumberFormatException g){
							error.detectadoErro(2);
						}
					}
				}else if(valueOther == 3){
					error.detectadoErro(8);
				}
			}else{
				error.detectadoErro(8);
			}
			
			Interpretador.addCount();
		}
	}
	
		
}
