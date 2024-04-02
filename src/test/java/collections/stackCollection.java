package collections;

import java.util.Scanner;
import java.util.Stack;

public class stackCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            Stack<String> paren = new Stack<String>();
            for (String p : input.split("")) {
                if (paren.isEmpty()) {
                    paren.push(p);
                } else {
                    String top = paren.peek();
                    if (p.equals("}") && top.equals("{")
                            || (p.equals("]") && top.equals("[")
                            || (p.equals(")") && top.equals("(")))) {
                        paren.pop();
                    } else {
                        paren.push(p);
                    }
                }
            }
            String toPrint = (paren.isEmpty()) ? "true" : "false";
            System.out.println(toPrint);
        }
    }
}
