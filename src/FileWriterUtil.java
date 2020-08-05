

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@code FileWriterUtil.class } writes starter files per chapter and number of 
 * exercises. <p>TODO User sets the CHAPTER and NUMBER OF EXERCISES. Execute this utility inside the
 * the target folder in which you wish to write the starter files.</p>
 * 
 * @author Harry Dulaney
 */
public class FileWriterUtil {

	private static int totalFiles = 23; //TODO Number of end of chapter exercises to write from 1 to n 
	private static final String CHAPTER = "25";//TODO Current Chapter here

	public static void main(String[] args) {

		for (int i = 10; i <= totalFiles; i++) {
			String exerciseId = "";
			if (i < 10) {
				exerciseId = "0" + i;
			}else {
				exerciseId = "" + i;
			}
			
			File file = new File(".");

			String midPath = "src" + File.separatorChar + "ch_" + CHAPTER + File.separatorChar + "exercises";
			Path path = file.toPath();
			Path mid = Paths.get(midPath);
			Path fullPath = path.resolve(mid);

			System.out.println(fullPath.toString());

			String filename = "E" + CHAPTER + exerciseId;
			String end = filename + ".java";

			fullPath = fullPath.resolve(end);
			System.out.println(fullPath.toString());

			try {
				Files.createFile(fullPath);
				
				String contents = "package ch_" + CHAPTER + ".exercises;\n \npublic class " + filename
						+ "{\n     public static void main(String[] args) {\n    }\n}";
				
				try (FileOutputStream fOs = new FileOutputStream(fullPath.toFile())) {
					byte[] bytes = contents.getBytes();
					fOs.write(bytes);
					
				}catch(IOException ie) {
					System.out.println("IOException while writing: " + filename);
				}

			} catch (IOException e) {
				System.out.print("IO Exception occured while creating: " + fullPath.toString());
				e.printStackTrace();
			}
			

		}
		System.out.println("FileWriter complete");

	}

}
