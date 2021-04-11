import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class OrderPlywood {

    private File order = null;
    private int order_number = 1;
    private double total_sq = 0;
    private double price_per_sqm = 0.35;
    private boolean order_file_correct = false;


    public void AddNewPiece(String size) throws IOException {

        OutputStreamWriter ost = new FileWriter(order, true);


        String[] a = size.split("x");
        int size_x = Integer.parseInt(a[0]);
        int size_y = Integer.parseInt(a[1]);

        ost.write(size_x + "," + size_y);
        System.out.println("Plywood piece with size " + size_x + "mm x " + size_y + "mm added to order number " + order_number);
        ost.write(System.lineSeparator());
        ost.close();


    }

    public void CreateNewOrder() {
        total_sq = 0;
        while (order_file_correct == false) {

            order = new File("orders/order_" + order_number + ".txt");
            if (order.exists()) {
                order_number++;
                order = null;
            } else {
                System.out.println("Order with number " + order_number + " created.");
                order_file_correct = true;
            }
        }
    }

    public void CalculateArea() throws IOException {

        InputStreamReader isr = new FileReader(order);
        Scanner read_file = new Scanner(isr);

        while (read_file.hasNext()) {
            String a[] = read_file.nextLine().split(",");
            double piece_sq = (Double.parseDouble(a[0]) / 1000) * (Double.parseDouble(a[1]) / 1000);
            total_sq = total_sq + piece_sq;
        }

        System.out.println("Total " + total_sq + " cubic meters.");
        isr.close();
    }

    public void CalculatePrice() {

        double price;
        price = total_sq * price_per_sqm;
        System.out.println("Total price: " + price + "$");
    }

    public void ListOrders() {
        String[] orders_list;
        order = new File("orders");
        orders_list = order.list();
        System.out.println(Arrays.toString(orders_list));

    }

    public void OpenOrder(int number){
        order = new File("orders/order_" + number + ".txt");
        System.out.println(order.getName() + " selected.");
    }
    public void ListPieces() throws FileNotFoundException {
        InputStreamReader isr = new FileReader(order);
        Scanner read_file = new Scanner(isr);
        System.out.println("Pieces list:");

        while (read_file.hasNext()) {
            String a[] = read_file.nextLine().split(",");
            System.out.println(a[0]+"mm x "+a[1]+"mm");
        }

    }
}
