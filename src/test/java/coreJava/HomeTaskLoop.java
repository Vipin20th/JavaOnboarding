package coreJava;

public class HomeTaskLoop {

    public static void pyramid() {
        int a = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a++ + " ");
            }
            System.out.println();
        }
    }

    public static void pyramid1() {
        int y = 0;
        int x = 2;
        for (int i = 0; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(y + "\t");
                y = y + x;
            }

            System.out.println("");
        }
    }

    public static void pyramid2() {
        int y = 0;
        int x =3;
        for(int i=0; i<= 5 ;i++){

            for(int j=1; j <= i ; j++){
                System.out.print(y + "\t");
                y = y + x;
            }

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        HomeTaskLoop.pyramid();
        HomeTaskLoop.pyramid1();
        HomeTaskLoop.pyramid2();
    }
}
