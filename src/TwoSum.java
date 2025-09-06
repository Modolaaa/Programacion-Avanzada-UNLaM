import java.util.*;

public class TwoSum {

    public static Boolean twoSumTwoPointers(int[] myArray, int elem) {
        Arrays.sort(myArray);
        int start = 0;
        int end = myArray.length - 1;

        while (start < end) {
            if (myArray[start] + myArray[end] < elem) {
                start++;
            } else if (myArray[start] + myArray[end] > elem) {
                end--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static Boolean twoSumMap(int[] myArray, int elem) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();


        for (int i = 0; i < myArray.length - 1; i++) {
            myMap.put(myArray[i], i);
        }
        for (int i = 0; i < myArray.length - 1; i++) {
            int result = elem - myArray[i];
            if (myMap.containsKey(result)) {
                return myMap.get(result) != i;
            }
        }
        return false;
    }

    public static Boolean twoSumBruteForce(int[] myArray, int elem) {
        for (int i = 0; i < myArray.length - 1; i++) {
            for (int j = 0; j < myArray.length - 1; j++) {
                if (myArray[i] + myArray[j] == elem && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}

