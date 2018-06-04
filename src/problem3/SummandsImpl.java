package problem3;

import java.util.ArrayList;

/**
 * Created by USER on 04.06.2018.
 */
public class SummandsImpl implements Summands {

    @Override
    public ArrayList<ArrayList<Integer>> allMaxProduct(long n) {

        Summa summa = new Summa();
        summa.execute((int) n);
        ArrayList<ArrayList<Integer>> allMaxProduct = summa.getAllMaxProduct();
        int maxProduct = summa.getMaxProduct();
        System.out.println();
        System.out.println(allMaxProduct);
        System.out.println("max * = " + maxProduct);
        System.out.println();

        return allMaxProduct;
    }

    @Override
    public ArrayList<ArrayList<Integer>> maxPairProduct(long n) {
        SummaPairs summaPairs = new SummaPairs();
        summaPairs.execute((int) n);
        ArrayList<ArrayList<Integer>> allMaxProduct = summaPairs.getAllMaxProduct();
        int maxProduct = summaPairs.getMaxProduct();
        System.out.println();
        System.out.println(allMaxProduct);
        System.out.println("max * = " + maxProduct);
        System.out.println();

        return allMaxProduct;
    }
}
