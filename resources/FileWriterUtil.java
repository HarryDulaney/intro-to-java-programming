package resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@code resources.FileWriterUtil.class } writes starter files per chapter and number of
 * exercises.
 * <p>
 * *
 * Execute this utility by running the command:
 * " java resources.FileWriterUtil <package name> <Chapter Number> <Number Of Exercises> " in the target folder
 * </p>
 *
 * @author Harry Dulaney
 */
public class FileWriterUtil {

    public static void main(String[] args) {

        String packageName = args[0];
        String CHAPTER = args[1];
        int numExercises = Integer.valueOf(args[2]);

        for (int i = 1; i <= numExercises; i++) {
            String exerciseId = "";
            if (i < 10) {
                exerciseId = "0" + i;
            } else {
                exerciseId = "" + i;
            }

            File file = new File(new File(".").getAbsolutePath());
            String currentDirectoryPath = file.getAbsolutePath();
            Path pathCurrWd = Paths.get(currentDirectoryPath);

            System.out.println(pathCurrWd.toString());

            String filename = "";

            if (Integer.parseInt(CHAPTER) < 10) {
                filename = "E0" + CHAPTER + exerciseId;

            } else {
                filename = "E" + CHAPTER + exerciseId;
            }
            String javaFileName = filename + ".java";

            Path fullPath = pathCurrWd.resolve(javaFileName);

            System.out.println(fullPath.toString());

            try {
                Files.createFile(fullPath);

                String contents = "package " + packageName + ";" + " \n \nimport java.util.*; \n \npublic class " + filename
                        + "{\n     public static void main(String[] args) {\n    }\n}";

                try (FileOutputStream fOs = new FileOutputStream(fullPath.toFile())) {
                    byte[] bytes = contents.getBytes();
                    fOs.write(bytes);

                } catch (IOException ie) {
                    System.out.println("IOException while writing: " + filename);
                }

            } catch (FileAlreadyExistsException ex) {
                System.out.println("Skipping write file because " + javaFileName + " already exists...");
            } catch (IOException e) {
                System.out.print("IO Exception occured while creating: " + fullPath.toString());
                e.printStackTrace();
            }
        }
        System.out.println("FileWriter complete");

    }

}
