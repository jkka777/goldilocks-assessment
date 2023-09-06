import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            System.out.println(convertToInteger(s));
            br.close();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter a valid number");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    static int convertToInteger(String s) {
        return Integer.parseInt(s);
    }
}