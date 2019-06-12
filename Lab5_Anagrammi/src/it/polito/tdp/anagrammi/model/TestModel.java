package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagrammiModel model= new AnagrammiModel();
		for(String s: model.generaAnagrammi("eat")) {
			System.out.println(s);
		}
		
	}

}
