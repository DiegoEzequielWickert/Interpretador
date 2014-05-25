
public class Enquanto {

	Error error = new Error();
	Se se = new Se();
	private boolean retornoCondicao = false;
	
	public boolean comecaEnquanto(String [] tokens){
		
		retornoCondicao = se.comecaSe(tokens);
		
		return retornoCondicao;
		
	}
	
}
