package com.packageChallenge;

public class Main {

    public static boolean bark(boolean barking, int hourOfDay){

        if(hourOfDay <0 || hourOfDay > 23){
            return false;
        } else if((hourOfDay < 8 || hourOfDay > 22) && barking == true){
            return true;
        } else{
            return false;
        }

    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(bark(true,1));
        System.out.println(bark(false,2));
        System.out.println(bark(true,8));
        System.out.println(bark(true, -1));
    }
}
