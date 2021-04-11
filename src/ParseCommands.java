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
            case "list":
                switch (cmd_splitted[1]) {
                    case "orders" -> op.ListOrders();
                    case "pieces" -> op.ListPieces();
                    default -> System.out.println("Awailable commands: list orders, list pieces");
                }

                break;
            case "open":
                op.OpenOrder(Integer.parseInt(cmd_splitted[1]));
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

