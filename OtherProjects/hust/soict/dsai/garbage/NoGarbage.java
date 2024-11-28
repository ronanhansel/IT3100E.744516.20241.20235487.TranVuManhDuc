
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filePath = "path/to/your/large/text/file.txt";
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File read successfully.");
    }
}