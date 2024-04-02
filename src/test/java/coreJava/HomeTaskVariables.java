package coreJava;

public class HomeTaskVariables {

    //1. Daniel has 3 apples; Amber has 2 apples. How many apples do Daniel and Amber have together?
    //2. Daniel has 3.5 apples and Amber has 2.5 apples. How many apples do Daniel and Amber have together?
    public static void method(double a, double b){
        double c = a+b;
        System.out.println((int)c);
    }

    public static void main(String[] args) {
        HomeTaskVariables.method(3, 2);
        HomeTaskVariables.method(3.5, 2.5);
    }
}
