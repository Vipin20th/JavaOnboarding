package coreJava;

import java.util.HashMap;
import java.util.Map;

public class LanguageConstruct {

    public static int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) {
            if (speed <= 65) {
                return 0;
            } else if (66 <= speed && speed <= 85) {
                return 1;
            } else if (86 <= speed) {
                return 2;
            }
        }
        if (speed <= 60) {
            return 0;
        } else if (61 <= speed && speed <= 80) {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean method2(int a, int b) {
        if (a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6)
            return true;
        return false;
    }

    public static int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5)  // your first case was correct
            return 0;

        if (candy * 2 <= tea || tea * 2 <= candy)  // must be <= not >=
            return 2;

        return 1;  // after you handle the first two cases, just return 1
    }


    public static int blueTicket(int a, int b, int c) {
        if (a + b == 10 || b + c == 10 || c + a == 10) {
            return 10;
        }
        if (a == c + 10 || b == c + 10) {
            return 5;
        }
        return 0;
    }


    public static boolean inOrder(int a, int b, int c, boolean bOk) {
        if (bOk)
            return c > b;
        return b > a && c > b;
    }


    public static boolean shareDigit(int a, int b) {
        return a / 10 == b / 10 ||
                a / 10 == b % 10 ||
                a % 10 == b % 10 ||
                a % 10 == b / 10;
    }


    public static int sumLimit2(int a, int b) {
        String str = Integer.toString(a + b);
        String str2 = Integer.toString(a);
        if (str.length() == str2.length()) {
            return a + b;
        }
        return a;
    }


    public static String withoutString(String base, String remove) {
        base = base.replace(remove.toUpperCase(), "");
        base = base.replace(remove.toLowerCase(), "");
        return base.replace(remove, "");
    }

    public static int maxBlock(String str) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                count++;
                max = count;
            } else {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                    if (max < count) {
                        max = count;
                    }
                }
                else {
                    count = 1;
                }
            }
        }
        return max;
    }

    public static int sumNumbers(String str) {
        int sum = 0, num = 0;
        for (char c : (str + ".").toCharArray())
            if (Character.isDigit(c)) {
                if (num > 0)
                    num *= 10;
                num += (c - '0');
            } else {
                sum += num;
                num = 0;
            }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(LanguageConstruct.caughtSpeeding(65, false));
        System.out.println(LanguageConstruct.method2(4, 5));
        System.out.println(LanguageConstruct.teaParty(20, 6));
        System.out.println(LanguageConstruct.blueTicket(9, 2, 0));
        System.out.println(LanguageConstruct.inOrder(1, 2, 1, false));
        System.out.println(LanguageConstruct.shareDigit(12, 43));
        System.out.println(LanguageConstruct.sumLimit2(8, 3));
        System.out.println(LanguageConstruct.withoutString("Hello there", "llo"));
        System.out.println(LanguageConstruct.maxBlock("abbCCCddBBBxx"));
        System.out.println(LanguageConstruct.sumNumbers("aa11b33"));
    }
    //1. You are driving a little too fast, and a police officer stops you. Write code to compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less, the result is 0. If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the result is 2. Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
    //
    //Test your logic at :http://codingbat.com/prob/p157733
    //
    //2. The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6. Or if their sum or difference is  6. Note: the function Math.abs(num) computes the absolute value of a number.
    //
    //
    //3. We are having a party with amounts of tea and candy. Return the int outcome of the party encoded as 0=bad, 1=good, or 2=great. A party is good (1) if both tea and candy are at least 5. However, if either tea or candy is at least double the amount of the other one, the party is great (2). However, in all cases, if either tea or candy is less than 5, the party is always bad (0).
    //
    //Test your logic at :http://codingbat.com/prob/p177181
    //
    //4. You have a blue lottery ticket, with ints a, b, and c on it. This makes three pairs, which we'll call ab, bc, and ac. Consider the sum of the numbers in each pair. If any pair sums to exactly 10, the result is 10. Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5. Otherwise the result is 0.
    //
    //Test your logic at :http://codingbat.com/prob/p192267
    //
    //5. Given three ints, a b c, return true if b is greater than a, and c is greater than b. However, with the exception that if "bOk" is true, b does not need to be greater than a.
    //
    //inOrder(1, 2, 4, false) ? true
    //inOrder(1, 2, 1, false) ? false
    //inOrder(1, 1, 2, true) ? true
    //Test your logic at :http://codingbat.com/prob/p154188
    //
    //6. Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers, such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives the left digit while the % "mod" n%10 gives the right digit.)
    //
    //shareDigit(12, 23) ? true
    //shareDigit(12, 43) ? false
    //shareDigit(12, 44) ? false
    //Test your logic at : http://codingbat.com/prob/p153748
    //
    //7. Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a. If the sum has more digits than a, just return a without b. (Note: one way to compute the number of digits of a non-negative int n is to convert it to a string with String.valueOf(n) and then check the length of the string.)
    //
    //sumLimit(2, 3) ? 5
    //sumLimit(8, 3) ? 8
    //sumLimit(8, 1) ? 9
    //Test your logic at :http://codingbat.com/prob/p118077
    //
    //8. Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    //
    //withoutString("Hello there", "llo") ? "He there"
    //withoutString("Hello there", "e") ? "Hllo thr"
    //withoutString("Hello there", "x") ? "Hello there"
    //Test your logic at : http://codingbat.com/prob/p192570
    //
    //9. Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
    //
    //maxBlock("hoopla") ? 2
    //maxBlock("abbCCCddBBBxx") ? 3
    //maxBlock("") ? 0
    //Test your logic at : http://codingbat.com/prob/p179479
    //
    //10. Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    //
    //sumNumbers("abc123xyz") ? 123
    //sumNumbers("aa11b33") ? 44
    //sumNumbers("7 11") ? 18
    //Test your logic at : http://codingbat.com/prob/p121193
}
