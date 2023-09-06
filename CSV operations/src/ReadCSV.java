import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadCSV {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("inputFile.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputFile.csv"));

        int sum = 0;
        while (reader.readLine() != null) {
            String[] line = reader.readLine().split(",");
            sum = Integer.parseInt(line[0]) + Integer.parseInt(line[1]) + Integer.parseInt(line[2]);
        }
        String stringSum = String.valueOf(sum);

        writer.write("Sum," + stringSum);

        reader.close();
        writer.close();
    }
}
