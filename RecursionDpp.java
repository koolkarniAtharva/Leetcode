import java.util.*;

public class RecursionDpp {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;

        // PrintAllOccurences(arr, key, 0);
        // printDigits(2019);
        // System.out.println(TotalLengthofStr("heyyy"));
        toh(3, 1, 2, 3);
    }
    // TODO Q1:-For a given integer array of size N.You have to find all the
    // occurrences (indices) of a given element(Key)and print them .Use a recursive
    // function to solve this problem.

    public static void PrintAllOccurences(int[] arr, int key, int idx) {
        if (idx == arr.length) {
            return;
        }

        if (arr[idx] == key) {
            System.out.print(idx + " ");
            ;
        }

        PrintAllOccurences(arr, key, idx + 1);

    }

    // TODO Q2:- You are given a number (eg - 2019), convert it into a String of
    // english like “two zero one nine”. Use a recursive function to solve this
    // problem.NOTE-The digits of the number will only be in the range 0-9 and the
    // last digit of a number can’t be 0.

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void printDigits(int number) {
        if (number == 0) {
            return;
        }
        int lastDigit = number % 10;
        printDigits(number / 10);
        System.out.print(digits[lastDigit] + " ");
    }

    // TODO Q3 :- Write a program to find Length of a String using Recursion

    public static int TotalLengthofStr(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return TotalLengthofStr(str.substring(1))+1;
        
    }

    // TODO Q4:- Tower of Hanoi(imp) You have 3 towers and N disks of different sizes which can slide on to any tower.The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e.,each disk sits on top of an even larger one).
    
    // You have the following constraints:
    // (1) Only one disk can be moved at a time.
    // (2) A disk is slid off the top of one tower onto another tower.
    // (3)A disk cannot be placed on top of a smaller disk . Write a program to move the disks from the first tower to the last using Stacks.
    // Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
    // An example with 2 disks i.e. N=2 :
    // Step 1 : Shift the first disk from 'A' to 'B'. 
    // Step 2 : Shift the second disk from 'A' to 'C'.
    // Step 3 : Shift the first disk from 'B' to 'C'.
    
    // An example with 3 disks i.e. N=3 :
    // Step 1 : Shift the first disk from 'A' to 'C'.
    // Step 2 : Shift second disk from 'A' to 'B'.
    // Step 3 : Shift the first disk from 'C' to 'B'.
    // Step 4 : Shift the third disk from 'A' to 'C'.
    // Step 5 : Shift the first disk from 'B' to 'A'.
    // Step 6 : Shift second disk from 'B' to 'C'.
    // Step 7 : Shift the first disk from 'A' to 'C'.

    public static void toh(int n , int A , int C , int B){
        if(n==0){
            return;
        }
        toh(n-1,A,B,C);
        System.out.println("Shift the " + n + " disk from "+A+" to "+C);
        toh(n-1,B,C,A);
        
    }

}
