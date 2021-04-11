import java.io.IOException;

public class ParseCommands {
    OrderPlywood op = new OrderPlywood();


    public void ParseInput(String command) throws IOException {
        String[] cmd_splitted;
        String cmd = command;
        cmd_splitted = cmd.split(" ");
        switch (cmd_splitted[0]) {
            case "add":
                op.add_New(cmd_splitted[1]);
                break;
            case "new":
                op.CreateNewOrder();
                break;
            case "quit":
                System.exit(1);
                break;
            case "calculate":
                if (cmd_splitted[1] == "area") {
                    op.CalculateAllPieces();
                } else if (cmd_splitted[1] == "price") {
                    op.CalculateTotalPrice();
                }
                break;
            default:
                System.out.println("Unknown Command");
                break;
        }
    }
}

