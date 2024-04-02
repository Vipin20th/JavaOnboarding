package collections;

import java.util.HashMap;
import java.util.Scanner;

public class MapCollection {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        sc.nextLine();
        for(int  i=0;i<n;i++)
        {
            String s=sc.nextLine();
            int x=sc.nextInt();
            mp.put(s,x);
            sc.nextLine();
        }
        while(sc.hasNextLine())
        {
            String x = sc.nextLine();
            if(mp.containsKey(x))
            {
                int k= mp.get(x);
                System.out.println(x+"="+k);
            }
            else
            {
                System.out.println("Not found");
            }
        }
    }
}
