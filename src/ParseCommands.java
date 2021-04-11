import java.io.IOException;

public class ParseCommands {
    OrderPlywood op = new OrderPlywood();


    public void ParseInput(String command) throws IOException {
        String[] cmd_splitted;
        String cmd = command;
        cmd_splitted = cmd.split(" ");

        switch (cmd_splitted[0]) {
            case "add":
                op.AddNewPiece(cmd_splitted[1]);
                break;

            case "new":
                op.CreateNewOrder();
                break;

            case "quit":
                System.exit(1);
                break;

            case "calculate":
                switch (cmd_splitted[1]) {
                    case "area" -> op.CalculateArea();
                    case "price" -> op.CalculatePrice();
                    default -> System.out.println("Available commands: calculate area, calculate price");
                }
                break;

            default:
                System.out.println("Unknown Command");
                break;
        }
    }
}

