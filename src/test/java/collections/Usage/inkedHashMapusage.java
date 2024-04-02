package collections.Usage;

import java.util.LinkedHashMap;

public class inkedHashMapusage {
    public static void main(String[] args) {
        LinkedHashMap<String, String> colors_map =  new LinkedHashMap<String, String>();
        colors_map.put("one", "Red");
        colors_map.put("two", "Green");
        colors_map.put("three", "Blue");

        // Original LinkedHashMap
        System.out.println("Original LinkedHashMap:" + colors_map);
        //isEmpty ()
        System.out.println("LinkedHashMap 'colors_map' empty?:" + colors_map.isEmpty());
        //size ()
        System.out.println("Size of the map: " + colors_map.size());
        //get ()
        System.out.println("Value for key = 'one':" + colors_map.get("one"));
        //containsKey ()
        System.out.println("colors_map contains key = 'two':"+
                colors_map.containsKey("two"));
        //containsValue ()
        System.out.println("colors_map contains value 'ree':"
                + colors_map.containsValue("ree"));
        //remove ()
        System.out.println("delete element 'one': " + colors_map.remove("one"));
        System.out.println("Updated colors_map:" + colors_map);
    }
}
