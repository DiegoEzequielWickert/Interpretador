
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
		
		if(tokens[Interpretador.getCount()].equals("IGUAL")){			/////////////////////////////////////////////////////////////
			Interpretador.addCount();
			valueOther = verificaVar(tokens);
			
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara == Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara == Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.equals(verificaString(tokens))){
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
						
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara > Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara > Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.length() > verificaString(tokens).length()){
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
			
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara < Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara < Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.length() < verificaString(tokens).length()){
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
			
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara <= Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara <= Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.length() <= verificaString(tokens).length()){
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
			
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara >= Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara >= Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.length() >= verificaString(tokens).length()){
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
			
			if(valueType != valueOther){
				error.detectadoErro(10);
			}else{
				if(valueType == 1){
					if(intCompara != Integer.parseInt(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 2){
					if(floatCompara != Float.parseFloat(tokens[Interpretador.getCount()])){
						return true;
					}else{
						return false;
					}
				}else if(valueType == 3){
					if(stringCompara.equals(verificaString(tokens)) == false){
						return true;
					}else{
						return false;
					}
				}
				error.detectadoErro(11);
			}
			
		}
		error.detectadoErro(11);
		return false;
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
			/*if(tokens[Interpretador.getCount()].contains(".")){
				String num = tokens[Interpretador.getCount()];
				System.out.println(num);
				valorFloat = Float.parseFloat(num);
				return 2;
			}else{
				try{
					valorInt = Integer.parseInt(tokens[Interpretador.getCount()]);
					return 1;
				}catch(NumberFormatException d){
					valorString = tokens[Interpretador.getCount()];
					return 3;
				}
			}*/
			
			
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
	
		
}
