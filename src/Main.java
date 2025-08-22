
public class Main {
    public static void main(String[] args) {

        // twoSum
        int [] myArray = new int[]{1,2,3,10,200,1,2};
        int elemTrue = 13;
        int elemFalse = 205;

        // True
        System.out.println(TwoSum.twoSumMap(myArray, elemTrue));
        System.out.println(TwoSum.twoSumTwoPointers(myArray, elemTrue));
        System.out.println(TwoSum.twoSumBruteForce(myArray, elemTrue));

        //False
        System.out.println(TwoSum.twoSumMap(myArray, elemFalse));
        System.out.println(TwoSum.twoSumTwoPointers(myArray, elemFalse));
        System.out.println(TwoSum.twoSumBruteForce(myArray, elemFalse));

        //StreetNumbers

        System.out.println(StreetNumbers.streetNumbersQuadratic(8));
        System.out.println(StreetNumbers.streetNumbersLinear(8));
        System.out.println(StreetNumbers.streetNumbersConstant(8));

        //System.out.println(StreetNumbers.streetNumbersQuadratic(65918161)); tarda mucho
        //System.out.println(StreetNumbers.streetNumbersLinear(65918161)); fuera de rango del entero
        System.out.println(StreetNumbers.streetNumbersConstant(65918161));


        System.out.println(StreetNumbers.streetNumbersQuadratic(9800));
        System.out.println(StreetNumbers.streetNumbersLinear(9800));
        System.out.println(StreetNumbers.streetNumbersConstant(9800));
    }
}

