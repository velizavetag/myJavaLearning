package com.packageChallenge;

public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
    }

    public static boolean areEqualByThreeDecimalPlaces(double one, double two){
        int intOne = (int)(one * 1000);
        int intTwo = (int)(two * 1000);

        if(intOne == intTwo){
            return true;
        } else {
            return false;
        }
    }
}
