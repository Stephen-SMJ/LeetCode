package jianzhi;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import javafx.beans.property.FloatProperty;

import java.util.Arrays;
import java.util.Map;

public class maxProfit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE; // neng bu neng bei hui???
        for (int price : prices){
            min = Math.min(min,price);
            profit = Math.max(profit, price - min);
            int[] a = new int[12];
            Arrays.stream(a).max();
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
