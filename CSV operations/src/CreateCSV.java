import java.io.BufferedWriter;
import java.io.FileWriter;

public class CreateCSV {

    public static void main(String[] args) throws Exception {

        BufferedWriter br = new BufferedWriter(new FileWriter("inputFile.csv"));
        br.newLine();
        br.write("1,2,3");

        br.close();
    }
}
