import java.io.*;
import java.util.Scanner;


public class OrderPlywood {

    File order = null;
    int order_number = 1;
    double total_sq = 0;
    double price_per_sqm = 0.35;


    public void add_New(String size) throws IOException {

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
        String filename = "order";
        boolean order_file_correct = false;
        while (order_file_correct == false) {

            order = new File("orders/" + filename + "_" + order_number + ".txt");
            if (order.exists()) {
                order_number++;
                order = null;
            } else {
                System.out.println("Order with number " + order_number + " created.");
                order_file_correct = true;
            }
        }
    }

    public String CalculateAllPieces() throws FileNotFoundException {

        InputStreamReader isr = new FileReader(order);
        Scanner read_file = new Scanner(isr);
        while (read_file.hasNext()) {
            String a[] = read_file.nextLine().split(",");
            double piece_sq = (Double.parseDouble(a[0])/1000) * (Double.parseDouble(a[1])/1000);
            total_sq = total_sq + piece_sq;

        }

        return "Total " + total_sq + " cubic meters.";
    }
    public String CalculateTotalPrice(){
        double price;
        price = total_sq * price_per_sqm;

        return "Total price: "+price+"$";
    }
}
