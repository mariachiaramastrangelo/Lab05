package it.polito.tdp.anagrammi.model;


import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.ParoleDAO;


public class AnagrammiModel {

	ParoleDAO pd= new ParoleDAO();
	
	public List<String> generaAnagrammi(String parola){
		List<String> anagrammi = new LinkedList<String>();
		String parziale= "";
		calcolaAnagrammi(parziale, parola, 0, anagrammi);
		return anagrammi;
		
	}
	
	public boolean isCorretto(String parola) {
		return pd.isCorretto(parola);
	}
			
	//metodo ricorsivo
	private void calcolaAnagrammi(String parziale, String parola, int j, List<String> anagrammi ) {
		//metodo ricorsivo 
		if(j == parola.length()) {
			anagrammi.add(parziale);
			return;
		}
		for(int i=0; i<parola.length(); i++) {
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))) {
			parziale+= parola.charAt(i);
			
			calcolaAnagrammi(parziale, parola, j+1, anagrammi);
			
			parziale= parziale.substring(0, parziale.length()-1);
			}
		}
		
	}
	private static int charCounter(String string, char c){
		int count = 0;
	    for (int i=0; i < string.length(); i++)
	    {
	        if (string.charAt(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}

}
