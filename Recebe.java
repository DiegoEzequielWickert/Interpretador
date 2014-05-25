public class Recebe {
	Error error = new Error();
	
	public void atribuiValores(String[] tokens){
				
		String valorSTRING = null;
		int intResultado = 0;
		float floatResultado = 0.0f;
								
		if(Interpretador.getReturnResult() == 3){
										
			valorSTRING = tokens[Interpretador.getCount()];
			Interpretador.addCount();
			
			if(tokens[Interpretador.getCount()].equals("FIM") == false){
				error.detectadoErro(5);
			}else{
				
				Interpretador.setStringVariable(valorSTRING);
				
			}
			
		}else{	
			
			try{
			
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}
				
				if(Interpretador.getReturnResult() == 1){ // INTEIRO
					
					if(tokens[Interpretador.getCount()].contains(".")){
						error.detectadoErro(1);
					}else{
						if(Interpretador.doesVariableNameAlreadyExists() == false){
							try{
								intResultado += Integer.parseInt(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException r){
								error.detectadoErro(2);
							}
						}else{
							intResultado += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						}
						
						Interpretador.addCount();
					}
					
					while(tokens[Interpretador.getCount()].equals("FIM") == false){
						
						if(tokens[Interpretador.getCount()].equals("SOMA")){
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{																				
								if(tokens[Interpretador.getCount()].contains(".")){
									error.detectadoErro(1);
								}else if(Interpretador.doesVariableNameAlreadyExists() == true){
									intResultado += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else{
									intResultado += Integer.parseInt(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}											
							}
						}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{
								if(tokens[Interpretador.getCount()].contains(".")){
									error.detectadoErro(1);
								}else if(Interpretador.doesVariableNameAlreadyExists() == true){
									intResultado -= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else{
									intResultado -= Integer.parseInt(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
						}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){ 
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{
								if(tokens[Interpretador.getCount()].contains(".")){
									error.detectadoErro(1);
								}else if(Interpretador.doesVariableNameAlreadyExists() == true){
									intResultado *= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else{
									intResultado *= Integer.parseInt(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
							
						}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
							Interpretador.addCount();
							
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{										
								if(tokens[Interpretador.getCount()].contains(".")){
									error.detectadoErro(1);
								}else if(Interpretador.doesVariableNameAlreadyExists() == true){
									intResultado /= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else{
									intResultado /= Integer.parseInt(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
							
						}else{
							error.detectadoErro(8);
						}
						
					}
					
					Interpretador.setIntegerVariable(intResultado);
					
					
				}else if(Interpretador.getReturnResult() == 2){ // FLOAT
					
					if(tokens[Interpretador.getCount()].contains(".") == false){
						error.detectadoErro(4);
					}else{
						if(Interpretador.doesVariableNameAlreadyExists() == false){
							try{
								floatResultado += Float.parseFloat(tokens[Interpretador.getCount()]);
							}catch(NumberFormatException r){
								error.detectadoErro(2);
							}
						}else{
							floatResultado += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						}
												
						Interpretador.addCount();
					}
					
					while(tokens[Interpretador.getCount()].equals("FIM") == false){
						
						if(tokens[Interpretador.getCount()].equals("SOMA")){
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{																				
								if(Interpretador.doesVariableNameAlreadyExists() == true){
									floatResultado += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else if(tokens[Interpretador.getCount()].contains(".") == false){
									error.detectadoErro(4);
								}else{
									floatResultado += Float.parseFloat(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}											
							}
						}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{
								if(Interpretador.doesVariableNameAlreadyExists() == true){
									floatResultado -= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else if(tokens[Interpretador.getCount()].contains(".") == false){
									error.detectadoErro(4);
								}else{
									floatResultado -= Float.parseFloat(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
						}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){ 
							Interpretador.addCount();
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{
								if(Interpretador.doesVariableNameAlreadyExists() == true){
									floatResultado *= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else if(tokens[Interpretador.getCount()].contains(".") == false){
									error.detectadoErro(4);
								}else{
									floatResultado *= Float.parseFloat(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
							
						}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
							Interpretador.addCount();
							
							if(error.verifyWord(tokens[Interpretador.getCount()])){
								error.detectadoErro(0);
							}else{
								if(Interpretador.doesVariableNameAlreadyExists() == true){
									floatResultado /= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}else if(tokens[Interpretador.getCount()].contains(".") == false){
									error.detectadoErro(4);
								}else{
									floatResultado /= Float.parseFloat(tokens[Interpretador.getCount()]);
									Interpretador.addCount();
								}
							}
							
						}else{
							error.detectadoErro(8);
						}
						
					}	
					
					Interpretador.setFloatVariable(floatResultado);
					
				}// FIM FLOAT
							
			}catch(NumberFormatException y){
				error.detectadoErro(2);
			}

		}
	
	}
	
	
	public int recebeInt(String [] tokens){
		
		int intResultado = 0;
		
		if(tokens[Interpretador.getCount()].contains(".")){
			error.detectadoErro(1);
		}else{
			if(Interpretador.doesVariableNameAlreadyExists() == false){
				try{
					intResultado += Integer.parseInt(tokens[Interpretador.getCount()]);
				}catch(NumberFormatException r){
					error.detectadoErro(2);
				}
			}else{
				intResultado += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
			}
			
			Interpretador.addCount();
		}
		
		
		while(tokens[Interpretador.getCount()].equals("FIM") == false){
			
			if(tokens[Interpretador.getCount()].equals("SOMA")){
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{																				
					if(tokens[Interpretador.getCount()].contains(".")){
						error.detectadoErro(1);
					}else if(Interpretador.doesVariableNameAlreadyExists() == true){
						intResultado += Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else{
						intResultado += Integer.parseInt(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}											
				}
			}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{
					if(tokens[Interpretador.getCount()].contains(".")){
						error.detectadoErro(1);
					}else if(Interpretador.doesVariableNameAlreadyExists() == true){
						intResultado -= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else{
						intResultado -= Integer.parseInt(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
			}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){ 
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{
					if(tokens[Interpretador.getCount()].contains(".")){
						error.detectadoErro(1);
					}else if(Interpretador.doesVariableNameAlreadyExists() == true){
						intResultado *= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else{
						intResultado *= Integer.parseInt(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
				
			}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{										
					if(tokens[Interpretador.getCount()].contains(".")){
						error.detectadoErro(1);
					}else if(Interpretador.doesVariableNameAlreadyExists() == true){
						intResultado /= Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else{
						intResultado /= Integer.parseInt(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
				
			}else{
				error.detectadoErro(8);
			}
			
		}
		
		return intResultado;	
	
	}
	
	
	public float recebeFloat(String [] tokens){
		
		float floatResultado = 0.0f;
		
		if(tokens[Interpretador.getCount()].contains(".") == false){
			error.detectadoErro(4);
		}else{
			if(Interpretador.doesVariableNameAlreadyExists() == false){
				try{
					floatResultado += Float.parseFloat(tokens[Interpretador.getCount()]);
				}catch(NumberFormatException r){
					error.detectadoErro(2);
				}
			}else{
				floatResultado += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
			}
									
			Interpretador.addCount();
		}
		
		while(tokens[Interpretador.getCount()].equals("FIM") == false){
			
			if(tokens[Interpretador.getCount()].equals("SOMA")){
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{																				
					if(Interpretador.doesVariableNameAlreadyExists() == true){
						floatResultado += Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else if(tokens[Interpretador.getCount()].contains(".") == false){
						error.detectadoErro(4);
					}else{
						floatResultado += Float.parseFloat(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}											
				}
			}else if(tokens[Interpretador.getCount()].equals("SUBTRAI")){
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{
					if(Interpretador.doesVariableNameAlreadyExists() == true){
						floatResultado -= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else if(tokens[Interpretador.getCount()].contains(".") == false){
						error.detectadoErro(4);
					}else{
						floatResultado -= Float.parseFloat(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
			}else if(tokens[Interpretador.getCount()].equals("MULTIPLICA")){ 
				Interpretador.addCount();
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{
					if(Interpretador.doesVariableNameAlreadyExists() == true){
						floatResultado *= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else if(tokens[Interpretador.getCount()].contains(".") == false){
						error.detectadoErro(4);
					}else{
						floatResultado *= Float.parseFloat(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
				
			}else if(tokens[Interpretador.getCount()].equals("DIVIDE")){
				Interpretador.addCount();
				
				if(error.verifyWord(tokens[Interpretador.getCount()])){
					error.detectadoErro(0);
				}else{
					if(Interpretador.doesVariableNameAlreadyExists() == true){
						floatResultado /= Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}else if(tokens[Interpretador.getCount()].contains(".") == false){
						error.detectadoErro(4);
					}else{
						floatResultado /= Float.parseFloat(tokens[Interpretador.getCount()]);
						Interpretador.addCount();
					}
				}
				
			}else{
				error.detectadoErro(8);
			}
			
		}	
		
		return floatResultado;
		
	}
		
	
	public String recebeString(String [] tokens){
		String valor = null;
		
		if(tokens[Interpretador.getCount()].equals("#VAZIO")){
			valor = " ";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#SOMA")){
			valor = "SOMA";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#SUBTRAI")){
			valor = "SUBTRAI";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MULTIPLICA")){
			valor = "MULTIPLICA";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#DIVIDE")){
			valor = "DIVIDE";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MUGIR")){
			valor = "MUGIR";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#FIM")){
			valor = "FIM";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#SE")){
			valor = "SE";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#int")){
			valor = "int";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#float")){
			valor = "float";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#string")){
			valor = "string";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#RECEBE")){
			valor = "RECEBE";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MAIOR")){
			valor = "MAIOR";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MAIORIGUAL")){
			valor = "MAIORIGUAL";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MENOR")){
			valor = "MENOR";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#MENORIGUAL")){
			valor = "MENORIGUAL";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#IGUAL")){
			valor = "IGUAL";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#DIFERENTE")){
			valor = "DIFERENTE";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#ENQUANTO")){
			valor = "ENQUANTO";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#ENTAO")){
			valor = "ENTAO";
			Interpretador.addCount();
		}else if(tokens[Interpretador.getCount()].equals("#FIMSE")){
			valor = "FIMSE";
			Interpretador.addCount();
		}else if(Interpretador.doesVariableNameAlreadyExists()){
			valor = Interpretador.getStringMap().get(tokens[Interpretador.getCount()]);
			Interpretador.addCount();
		}else{
			valor = tokens[Interpretador.getCount()];
			Interpretador.addCount();
		}
		
		
			
		if(tokens[Interpretador.getCount()].equals("FIM") == false){
			error.detectadoErro(8);
		}
		
		return valor;
		
	}
	
	
}
