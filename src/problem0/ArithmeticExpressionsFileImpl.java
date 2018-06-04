package problem0;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticExpressionsFileImpl implements ArithmeticExpressionsFile {

    @Override
    public void checkUsingJava(String fullPathTiFile) throws IOException {
        FileInputStream fis = new FileInputStream(fullPathTiFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;

        // read file line by line
        while ((line = br.readLine()) != null) {
            if (checkStringUsingJava(line)) {
                System.out.println(line);
            }
        }
    }

    @Override
    public void checkUsingJavaAndRegExp(String fullPathTiFile) throws IOException {
        // Convert file text to Java String
        Path path = Paths.get(fullPathTiFile);
        byte[] encoded = Files.readAllBytes(path);
        String text = new String(encoded);

        // Break solid text into lines
        String regexp= "(.*?[\\r][\\n])|(.+?$)";  // for Windows
        //String regexp= "(.*?[\\n])|(.+?$)";     // for Unix
        //String regexp= "(.*?[\\r])|(.+?$)";     // for Mac

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (checkStringUsingRegExp(matcher.group())) {
                System.out.print(matcher.group());
            }
        }
    }

    /**
     * This method checks whether the line contains an even number
     *
     * The number is a set of characters that end in a digit and the next character is not a digit.
     * By this last digit we determine whether the number is even (2 == 0)
     * If line contains even number flag = true
     * @param line one line from file
     */
    private boolean checkStringUsingJava(String line) {
        boolean flag = false;

        for (int i = 0; i < line.length(); i++) {
            if (i == (line.length() - 1) && Character.isDigit(line.charAt(i))) {  // check last character in the line
                if (line.charAt(i) % 2 == 0) {
                    flag = true;
                }
            } else if (Character.isDigit(line.charAt(i)) && !Character.isDigit(line.charAt(i + 1))) {
                if (line.charAt(i) % 2 == 0) {
                    flag = true;
                }
            }
            if (flag == true) break;
        }
        return flag;

    }

    /**
     * This method checks whether the line contains an even number
     *
     * @param line one line from file
     */
    private boolean checkStringUsingRegExp(String line) {
        // delete \r\n from end of the line
        // and create newLine without \r\n
        String newLine = "";
        String subLine = line.substring(line.length()-1);
        // equals.("\n") - for windows
        if (subLine.equals("\n")) {
            newLine = line.substring(0, line.length()-2);
        } else {
            newLine = line;
        }

        String pattern = "(.*[02468][^1-9].*)|(^.*[02468]$)";

        return newLine.matches(pattern);
    }
}
