package bookshow.model;

import java.util.ArrayList;

public class ArrayListDatabaseHandler {

	public ArrayListDatabaseHandler() {
	}

	public String ArrayListToString(ArrayList<String> lista) {
		if (lista.isEmpty()) {
			return "";
		}
		String retVal = "";
		for (int i = 0; i < lista.size() - 1; i++) {
			retVal += lista.get(i) + ",";
		}
		retVal += lista.get(lista.size() - 1);
		return retVal;
	}
	
	public ArrayList<String> StringToArrayList(String lista) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		if(lista.trim().equals("")) {	//	prazna lista
			return new ArrayList<String>();
		}
		if(!(lista.trim()).contains(",")){	// samo 1 element		
			retVal.add(lista.trim());
			return retVal;
		}
		
		//ostalo
		String[] splitted = lista.split(",");
		for(int i = 0; i < splitted.length; i++) {
			if((splitted[i].trim()).equals("") == false){
				retVal.add(splitted[i].trim());
			}
		}
		return retVal;
	}
}
