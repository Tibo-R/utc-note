package etunote;

import java.util.ArrayList;

public class Tools {

	public static String explode(ArrayList<String> inputArray, String separator){
		
		if (inputArray.size()==0) {
			return "";
		} 
		else {
			StringBuffer sb = new StringBuffer();
			sb.append(inputArray.get(0));
			for (int i=1;i<inputArray.size();i++) {
				sb.append(separator);
				sb.append(inputArray.get(i));
			}
			return sb.toString();
		}
	}


}
