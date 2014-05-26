
public class Error {
	
	
	public boolean verifyWord(String frase){
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
		}else if(frase.equals("MAIOR")){
			return true;
		}else if(frase.equals("MAIORIGUAL")){
			return true;
		}else if(frase.equals("MENOR")){
			return true;
		}else if(frase.equals("MENORIGUAL")){
			return true;
		}else if(frase.equals("IGUAL")){
			return true;
		}else if(frase.equals("DIFERENTE")){
			return true;
		}else if(frase.equals("ENQUANTO")){
			return true;
		}else if(frase.equals("ENTAO")){
			return true;
		}else if(frase.equals("FIMSE")){
			return true;
		}else if(frase.equals("RESTO")){
			return true;
		}else if(frase.equals("FIMENQUANTO")){
			return true;
		}else if(frase.equals("SENAO")){
			return true;
		}
		
		return false;
	}
	
	
	
public void detectadoErro(int num){
	
		System.err.println("\n");
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
			
		case 7:
			System.err.println("NOME DE VARIAVEL DUPLICADO DETECTADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 8:
			System.err.println("ERRO DE SINTAXE DETECTADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 9:
			System.err.println("PALAVRA ENCONTRADA NAO E NOME DE VARIAVEL");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 10:
			System.err.println("TIPOS DIFERENTES NA COMPARACAO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;	
			
		case 11:
			System.err.println("ERRO DE PREGUICA");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
			
		case 12:
			System.err.println("FIM DO *SE* NAO ENCONTRADO");
			System.err.println("-----------------------------------");
			System.exit(0);
			break;
		}
				
		
	}
	
	
	
	

}
