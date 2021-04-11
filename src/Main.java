import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        OrderPlywood op = new OrderPlywood();
        op.CreateNewOrder();
        op.add_New("100x100");
        op.add_New("1000x400");
        System.out.println(op.CalculateAll());

    }
}
