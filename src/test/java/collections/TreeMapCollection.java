package collections;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int Q = scanner.nextInt(); // Number of queries
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int q = 0; q < Q; q++) {
                char operation = scanner.next().charAt(0);

                switch (operation) {
                    case 'a':
                        int key = scanner.nextInt();
                        int value = scanner.nextInt();
                        treeMap.put(key, value);
                        break;

                    case 'b':
                        int queryKey = scanner.nextInt();
                        System.out.println(treeMap.containsKey(queryKey) ? treeMap.get(queryKey) : -1);
                        break;

                    case 'c':
                        System.out.println(treeMap.size());
                        break;

                    case 'd':
                        int removeKey = scanner.nextInt();
                        treeMap.remove(removeKey);
                        break;

                    case 'e':
                        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());
                        }
                        break;
                }
            }
        }
        scanner.close();
    }

}
