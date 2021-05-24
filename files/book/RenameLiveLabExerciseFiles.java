import java.io.File;

public class RenameLiveLabExerciseFiles {
  public static void main(String[] args) {
	System.out.println("Usage: java RenameLiveLabExerciseFiles * ");
	
	System.out.println("Exercise25_5ag".matches("Exercise[\\d]_.*"));
	System.out.println("Exercise5_54df".matches("Exercise[\\d]_.*"));
	
	for (int i = 0; i < args.length; i++) {
	  if (args[i].matches("Exercise.*_[\\d][\\D]*")) {
		String s = args[i];
		String newName = s.substring(0, s.indexOf('_') - 1) 
		  + "0" + s.substring(s.indexOf('_') - 1) ;
		
		File file = new File(args[i]);
		file.renameTo(new File(newName));
	  }
	} 
  }
}