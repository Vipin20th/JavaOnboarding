package coreJava;

import java.util.Arrays;
import java.util.HashMap;

public class HomeTaskArrayString {

    //Write a program to find the missing number in integer array of 1 to 100
    public static void missingNumber(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        int newSum = 0;
        int diff = arr[1] - arr[0];
        for (int j = 1; j <= arr.length + diff; j++) {
            newSum = newSum + j;
        }
        int missingNum = newSum - sum;
        System.out.println(missingNum);
    }

//2. Write a program to find biggest and smallest number in a array.
    public static void findBiggestNum(int[] arr) {
        Arrays.sort(arr);
        int biggest = arr[arr.length - 1];
        int smallest = arr[0];
        System.out.println("smallest: "+smallest);
        System.out.println("Biggest: "+biggest);
    }

    //1. write a program to Print duplicate characters from String
    public static void duplicateStringChar(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        map.forEach((k, v) -> System.out.println((k + ":" + v)));
    }

    //2. write a program to check if two strings are rotations of each other
    public static void verifyRotate(String s, String s1) {
        char[] arr = s.toCharArray();
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        System.out.println(Arrays.equals(arr, arr1));
    }
    public static void main(String[] args) {
        HomeTaskArrayString.missingNumber(new int[] { 1, 4, 5, 2, 7, 8, 6, 9 });
        HomeTaskArrayString.findBiggestNum(new int[]{44,66,99,77,33,22,55});
        HomeTaskArrayString.duplicateStringChar("w3schools");
        HomeTaskArrayString.verifyRotate("abcd","cdab");
    }
}
