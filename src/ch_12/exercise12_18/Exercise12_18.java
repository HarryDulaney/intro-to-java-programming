package ch_12.exercise12_18;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * *12.18 (Add package statement) Suppose you have Java source files under the directories chapter1, chapter2, . . . , chapter34.
 * Write a program to insert the statement package chapteri; as the first line for each Java source file under
 * the directory chapteri. Suppose chapter1, chapter2, . . . , chapter34
 * are under the root directory srcRootDirectory. The root directory and
 * chapteri directory may contain other folders and files. Use the following
 * command to run the program:
 * java Exercise12_18 srcRootDirectory
 */
public class Exercise12_18 {
    private final static String USAGE = "java Exercise12_18 srcRootDirectory";
    private static final String SUB_DIR_PATTERN = "chapter";
    private static final String SRC_FILE_PATTERN = "*.java";
    private static final String RESOLVE_PACKAGE_PATH = "src\\ch_12\\exercise12_18\\";

    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("You must enter parameters when running this program. ");
            System.out.println("Example command: " + USAGE);
            System.exit(1);
        }
        Path parentPath = Paths.get(args[0]);
        List<Path> parentFiles = new ArrayList<>();

        File file = parentPath.toFile();
        if (!file.exists()) {
            System.out.println("Parent File one not found.....");
            parentPath = Paths.get(RESOLVE_PACKAGE_PATH, args[0]);
            if (!parentPath.toFile().exists()) {
                System.out.println("Error: Please enter the full filepath to your srcRootDirectory. The current " +
                        "directory is " + new File("").getAbsolutePath());
                System.exit(2);
            } else {
                System.out.println("Resolved ");
            }
        }


        try (DirectoryStream<Path> parentDirStream = Files.newDirectoryStream(parentPath, SUB_DIR_PATTERN)) {
            for (Path subPath : parentDirStream) {
                parentFiles.add(subPath);
            }

        } catch (IOException dirIterException) {
            System.out.println("The srcRootDirectory is empty or cannot be read because of system security settings.");
//            dirIterException.printStackTrace();

        }

        for (Path subPath : parentFiles) {
            System.out.println("Handling package reference writing for: " + subPath);
            handlePackage(subPath);
        }
    }

    private static void handlePackage(Path path) {
        String pkg = path.getName(path.getNameCount() - 1).toString();
        System.out.println("pkg: " + pkg);
        try (DirectoryStream<Path> subDirStream = Files.newDirectoryStream(path, SRC_FILE_PATTERN)) {
            for (Path targetFilePath : subDirStream) {
                File file = targetFilePath.toFile();
                PrintWriter fileWriter = new PrintWriter(file);
                fileWriter.println();
                fileWriter.println("package " + pkg + ":");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while handling the source files in " + pkg);
        }

    }
}
