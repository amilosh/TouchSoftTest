package problem3;

import java.util.ArrayList;

public class Summa {

    // we take ArrayList<Integer>, and if its elements sum >= maxProduct,
    //                                 then ArrayList<Integer> add to allMaxProduct
    ArrayList<ArrayList<Integer>> allMaxProduct;
    int maxProduct;

    public Summa() {
        this.allMaxProduct = new ArrayList<ArrayList<Integer>>();
        this.maxProduct = 0;
    }

    public ArrayList<ArrayList<Integer>> getAllMaxProduct() {
        return allMaxProduct;
    }

    public int getMaxProduct() {
        return maxProduct;
    }

    public void execute(int number) {
        int expectedSum = (int) number;
        ArrayList<Integer> innerIntegers = new ArrayList<Integer>();

        find(number - 1, innerIntegers, expectedSum);
    }

    /*
    * Find all combination of different numbers
    * and its sum wil be equally expectedSum.
    * And then check this combination by maxProduct
    * */
    public void find(int number, ArrayList<Integer> outerIntegers,int expectedSum) {

        for (int i = number; i > 0; i--) {
            ArrayList<Integer> innerIntegers = new ArrayList<Integer>(outerIntegers);
            innerIntegers.add(i);

            if (sumOfNumbers(innerIntegers) == expectedSum) {
                System.out.println(innerIntegers
                        + " max * =  " + multiplicationOfNumbers(innerIntegers));
                if (multiplicationOfNumbers(innerIntegers) == this.maxProduct) {
                    this.allMaxProduct.add(innerIntegers);
                } else if (multiplicationOfNumbers(innerIntegers) > this.maxProduct) {
                    this.allMaxProduct.clear();
                    this.allMaxProduct.add(innerIntegers);
                    this.maxProduct = multiplicationOfNumbers(innerIntegers);
                }
            }

            find(i - 1, innerIntegers, expectedSum);
        }

    }



    public int sumOfNumbers(ArrayList<Integer> innerIntegers) {
        int sum = 0;
        for (int number : innerIntegers) {
            sum += number;
        }
        return sum;
    }

    public int multiplicationOfNumbers(ArrayList<Integer> innerIntegers) {
        int multiplication = 1;
        for (int number : innerIntegers) {
            multiplication *= number;
        }
        return multiplication;
    }

}
