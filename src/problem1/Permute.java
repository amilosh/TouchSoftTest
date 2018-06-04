package problem1;

import java.util.ArrayList;

/**
 * In this class we will get all combinations that can compose
 * from digits.
 * Example: 12345
 * We wil get:
 *     1, 234
 *     12, 34
 *     123, 4
 *     1, 2, 34
 *     1, 23, 4
 *     12, 3, 4
 *     1, 2, 3, 4
 */
public class Permute {

    ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> execute(String digits) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        permute(digits, digits.length(), combination);
        return combinations;
    }

    public void permute(String digits, int stayNumber, ArrayList<Integer> combination) {
        for (int i = 1; i < stayNumber; i++) {

            ArrayList<Integer> innerCombination = new ArrayList<Integer>(combination);
            String firsNumber = digits.substring(0, i);
            String secondNumber = digits.substring(i, stayNumber);

            Integer x = Integer.valueOf(firsNumber);
            innerCombination.add(x);

            permute(secondNumber, stayNumber - i, innerCombination);


            Integer y = Integer.valueOf(secondNumber);

            innerCombination.add(y);
            combinations.add(innerCombination);


        }

    }

}
