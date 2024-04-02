package coreJava;

import java.util.Scanner;

public class HomeTaskBasic {

    //1. Create code which displays in console “Hello, NAME”, where NAME is taken from Command line (1 mark)
    public static void printString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, " + scan.nextLine().toUpperCase());
    }

    //2. Create "calculator" which takes two numbers and an operation from the command line and outputs the result of the operation to the console. Add addition, subtraction, multiplication and division. (4 marks)
    public static void calculator(){
        Scanner scan = new Scanner(System.in);
        char operator = scan.next().charAt(0);
        int firstValue = scan.nextInt();
        int SecondValue = scan.nextInt();
        int newValue = 0;
        switch(operator){
            case '+':
                newValue =  firstValue + SecondValue;
                break;
            case '-':
                newValue = firstValue - SecondValue;
                break;
            case '*':
                newValue = firstValue * SecondValue;
                break;
            case '/':
                newValue = firstValue /SecondValue;
                break;
        }
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        HomeTaskBasic.printString();
        HomeTaskBasic.calculator();
    }
}
