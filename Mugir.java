public class Mugir {
	
	Error error = new Error();
	
	public void comecaMugir(String [] tokens){
				
		int h = 0;
		String frase[] = new String[25];
		
		if(tokens[Interpretador.getCount()].equals("FIM")){
			frase[h] = "MOOOOOOOOOOOOO";
		}else{
														
			while(tokens[Interpretador.getCount()].equals("FIM") == false){
				
				if(tokens[Interpretador.getCount()].equals("VAR")){
					Interpretador.addCount();
					
					while(tokens[Interpretador.getCount()].equals("--")){
						Interpretador.addCount();
						frase[h] = " ";
						h++;
					}
											
					if(Interpretador.getIntegerMap().containsKey(tokens[Interpretador.getCount()])){
						frase[h] = String.valueOf(Interpretador.getIntegerMap().get(tokens[Interpretador.getCount()]));
						h++;
					}else if( Interpretador.getFloatMap().containsKey(tokens[Interpretador.getCount()])){
						frase[h] = String.valueOf(Interpretador.getFloatMap().get(tokens[Interpretador.getCount()]));
						h++;
					}else if(Interpretador.getStringMap().containsKey(tokens[Interpretador.getCount()]) ){
						frase[h] = Interpretador.getStringMap().get(tokens[Interpretador.getCount()]);
						h++;
					}else{
						error.detectadoErro(3);
					}
					
				}else if(tokens[Interpretador.getCount()].equals("VAZIO")){
					frase[h] = "\n";
					h++;
				}else if(tokens[Interpretador.getCount()].equals("--")){
					frase[h] = " ";
					h++;
				}else{
					frase[h] = tokens[Interpretador.getCount()];
					h++;
				}
				Interpretador.addCount();
			
			}
			
			
		}
		
		for(int e = 0; frase[e] != null ; e++){
			System.out.print(frase[e]);
		}
		
		
		
	}
	

}
