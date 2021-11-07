package ch_21.exercise21_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * **21.5 (Syntax highlighting) Write a program that converts a Java file into an HTML
 * file. In the HTML file, the keywords, comments, and literals are displayed in
 * bold navy, green, and blue, respectively. Use the command line to pass a Java file
 * and an HTML file. For example, the following command
 * java Exercise21_05 Welcome.java Welcome.html
 * converts Welcome.java into Welcome.html. Figure 21.8a shows a Java file. The
 * corresponding HTML file is shown in Figure 21.8b.
 */
public class Exercise21_05 {
    private static final String KEYWORD = "keyword_style_class";
    private static final String COMMENT = "comment_style_class";
    private static final String LITERAL = "literals_style_class";

    private static final String CSS_STYLE = "div{display: inline-block}" +
            ".none{font-weight: normal;color:black;}" +
            " .keyword_style_class {font-weight: bold;color: navy;}" +
            " .comment_style_class {font-weight: bold; color: green;}" +
            " .literals_style_class {font-weight: bold; color: blue;}";

    private static final String[] KEY_WORDS = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Exercise21_05 Welcome.java Welcome.html");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];
        System.out.println("Reading file: " + inputFile);

        try {
            List<String> txtLines = Files.readAllLines(Paths.get(inputFile));
            System.out.println("Reading complete.\nMapping input file to HTML file...");

            ArrayList<String> htmlFileLines = mapTextToHtml(txtLines);

            System.out.println("Mapping complete...");
            System.out.println("Writing output file: " + outputFile);

            Files.write(Paths.get(outputFile), htmlFileLines, StandardOpenOption.CREATE);
            System.out.println("Writing output file complete.");

        } catch (IOException e) {
            System.out.println("Something went wrong during read/convert/write...");
            e.printStackTrace();
        }
    }

    private static ArrayList<String> mapTextToHtml(List<String> txtFileLines) {
        ArrayList<String> htmlLines = new ArrayList<>();
        htmlLines.add("<html lang=\"en\">");
        htmlLines.add("<head>");
        htmlLines.add("<style>");
        htmlLines.add(CSS_STYLE);
        htmlLines.add("</style>");
        htmlLines.add("<title>" + Exercise21_05.class.getName() + "</title>");
        htmlLines.add("</head>");
        htmlLines.add("<body>");

        Set<String> keywordSet = new HashSet<>(Arrays.asList(KEY_WORDS));
        // Iterate lines
        for (String txtFileLine : txtFileLines) {
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append("<div>"); // Start of line
            String[] words = txtFileLine.split(" "); // Split the line by whitespace
            // Iterate words (character groups seperated by whitespace)
            for (int idx = 0; idx < words.length; idx++) {
                if (words[idx].startsWith("//")) { // Beginning of a line comment rest of line must be Comment class
                    lineBuilder.append("<div class=\"" + COMMENT + "\">"); // Start of comment html tag
                    while (idx < words.length) { // Fill remaining words in line with Comment class
                        lineBuilder.append(words[idx]).append("&nbsp;");
                        idx++;
                    }
                    lineBuilder.append("</div>"); // End of comment line, close tag
                    continue;
                }

                if (keywordSet.contains(words[idx])) {
                    lineBuilder.append("<div class=\"" + KEYWORD + "\">"); // Start of keyword html tag
                    lineBuilder.append(words[idx]).append("&nbsp;");
                    lineBuilder.append(" </div>"); // Close tag
                    continue;
                }

                if (words[idx].startsWith("\"")) {
                    lineBuilder.append("<div class=\"" + LITERAL + "\">"); // Start of literal html tag
                    while (!words[idx].endsWith("\"")) { // Iterate rest of string literal
                        lineBuilder.append(words[idx]).append("&nbsp;");
                        idx++;
                    }
                    lineBuilder.append(words[idx]).append("&nbsp;");
                    lineBuilder.append("</div>"); // Close literal tag
                    continue;
                }
                if (words[idx].isEmpty()) {
                    lineBuilder.append("&nbsp;");
                } else {
                    // word is not Comment or Keyword or Literal so Map to the default style class
                    lineBuilder.append(words[idx]).append("&nbsp;");
                }
            }
            htmlLines.add(lineBuilder + "</div><br>");
        }
        htmlLines.add("</body>");
        htmlLines.add("</html>");

        return htmlLines;
    }
}
