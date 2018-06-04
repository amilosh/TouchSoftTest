package problem1;

import java.util.ArrayList;

/*
* This class concatenates numbers (ArrayList<Integer>) and signs (String) combinations.
* */
public class Concat {

    public static String execute(ArrayList<Integer> integerList, String signCombination) {

        StringBuilder expression = new StringBuilder();

        char[] signsArray = signCombination.toCharArray();

        for (int i = 0; i < integerList.size()-1; i++) {
            expression.append(integerList.get(i));
            expression.append(signsArray[i]);
        }
        expression.append(integerList.get(integerList.size()-1));

        return expression.toString();
    }

}
