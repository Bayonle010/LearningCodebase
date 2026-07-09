package Java.JavaCollections.map;

import javax.swing.text.StyleContext;
import java.util.*;

public class RoughBookForMap {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Bayo", 100);
        map.put("Mark", 102);

        System.out.println(map);

        Collection<Integer> values  = map.values();
        Set<String> keys = map.keySet();
        Set<Map.Entry<String, Integer>> keyvalues = map.entrySet();
        for (Map.Entry<String, Integer> entry : keyvalues){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(keys);
        System.out.println(values);
        System.out.println(keyvalues);

    }


}
