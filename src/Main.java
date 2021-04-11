import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        OrderPlywood op = new OrderPlywood();
        op.CreateNewOrder();
        op.add_New("400x1000");
        op.add_New("1000x2000");
        System.out.println(op.CalculateAllPieces());
        System.out.println(op.CalculateTotalPrice());
    }
}
