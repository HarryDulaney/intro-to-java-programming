package ch_10;

/**
 * @author Harry D.
 */
public class Exercise10_26 {
	public static void main(String[] args) {
		
		String str = "";
		
		for(int i = 0; i < args.length;i++) {
			
			str += args[i];
			
		}
		
		String str2 = str.replaceAll(" ", "");
			
		str2 = str2.replaceAll("[+]","%+%");
		str2 = str2.replaceAll("[-]", "%-%");
		str2 = str2.replaceAll("[.]","%.%");
		str2 = str2.replaceAll("[/]","%/%");
				

		args = str2.split("%");
		
		int result = 0;
		
		switch (args[1].charAt(0)) {
		
		case '+': 
			result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
		break;
		
		case '-': 
			result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
		break;
		
		case '.': 
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
		break;
		
		case '/': 
			result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
		break;
		
		}
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
	}

}