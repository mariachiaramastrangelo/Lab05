package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class AnagrammiModel {
	
	
	public List<String> generaAnagrammi(String parola){
		List<String> anagrammi= new LinkedList<String>();
		String parziale= "";
		this.calcolaAnagrammi(parola, parziale, 0 , anagrammi);
		return anagrammi;
		
	}
	//metodo ricorsivo
	private void calcolaAnagrammi(String parola, String parziale, int L, List<String> anagrammi) {
		//metodo ricorsivo 
		if(L==parola.length()) {
			anagrammi.add(parziale);
			return;
		}
		for(int i=0; i<parola.length(); i++) {
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))) {
			parziale+= parola.charAt(i);
			
			this.calcolaAnagrammi(parola, parziale, L+1, anagrammi);
			
			parziale.substring(0, parziale.length()-1);
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
