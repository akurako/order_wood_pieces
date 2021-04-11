import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        boolean running = true;
        ParseCommands pc = new ParseCommands();
        Scanner input = new Scanner(System.in);
        while (running) {
            pc.ParseInput(input.nextLine());
        }
    }
}
