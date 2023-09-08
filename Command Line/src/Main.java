public class Main {
    public static void main(String[] args) {

        if (args.length == 0) System.out.println("No arguments provided");
        else {
            for (String a : args) {
                System.out.println(a);
            }
        }

    }
}