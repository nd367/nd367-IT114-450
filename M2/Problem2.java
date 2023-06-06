package M2;
import java.util.Arrays;
public class Problem2 {
    public static void main(String[] args) {
        //Don't edit anything here
        double[] a1 = new double[]{10.001, 11.591, 0.011, 5.991, 16.121, 0.131, 100.981, 1.001};
        double[] a2 = new double[]{1.99, 1.99, 0.99, 1.99, 0.99, 1.99, 0.99, 0.99};
        double[] a3 = new double[]{0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
        double[] a4 = new double[]{10.01, -12.22, 0.23, 19.20, -5.13, 3.12};
        
        getTotal(a1);
        getTotal(a2);
        getTotal(a3);
        getTotal(a4);
    }
    static void getTotal(double[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        double total = 0;
        String totalOutput = "";
        //TODO add/edit code here
        //nd367, 6/5/2023, Only output the sum/total of the array values

        for (double i : arr)
            total += i;
       
        //set the double to a string variable
        totalOutput = total+"";
        //end add/edit section
        String onlyTwoDecimal = String.format("%1.2f", total);
        System.out.println("Total is " + onlyTwoDecimal);
        System.out.println("End process");
    }
    
    
}
