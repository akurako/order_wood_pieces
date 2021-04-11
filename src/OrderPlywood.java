import java.io.*;
import java.util.Scanner;


public class OrderPlywood {

    File order = null;
    int order_number = 1;


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

    public String CalculateAll() throws FileNotFoundException {

        int obshaja_ploshadj = 0;

        InputStreamReader isr = new FileReader(order);
        Scanner read_file = new Scanner(isr);
        while (read_file.hasNext()) {
            String a[] = read_file.nextLine().split(",");
            int ploshadj_detali = Integer.parseInt(a[0]) * Integer.parseInt(a[1]);
            obshaja_ploshadj = obshaja_ploshadj + ploshadj_detali;

        }

        return "Total " + obshaja_ploshadj + " cubic mm";
    }
}
