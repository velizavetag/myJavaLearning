package com.packageChallenge;

public class Main {

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0 ){
            System.out.println("Invalid value");
        } else{
            int mb = kiloBytes / 1024;
            int kb = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + mb + " MB and " + kb + " KB");
        }
    }
    public static void main(String[] args) {
	// write your code here
        printMegaBytesAndKiloBytes(2050);
    }
}
