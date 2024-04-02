package collections.Usage;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetUsage {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Re");
        set.add("Do");
        set.add("Fa");
        set.add("Sol");
        set.add("La");
        set.add("Ti");
        set.add("Mi");
        System.out.println(set);
        set.remove("Fa");// removing an element from our set
        set.remove("Score");//trying to remove element that isn't in set
        System.out.println(set.remove("Score"));
        System.out.println("Print our set without elements removed: ");
        System.out.println(set);
        set.clear();
        System.out.println("Print out our set after clear command: ");
        System.out.println(set);
    }
}
