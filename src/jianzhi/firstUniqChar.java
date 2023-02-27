package jianzhi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class firstUniqChar {
    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Boolean> charHashMap = new LinkedHashMap<>();  //LinkedHashMap是有序的，如果要遍历hashmap的话只能用LinkedHashMap
        for (char c : arr)
            charHashMap.put(c,!charHashMap.containsKey(c));
        for(Map.Entry<Character, Boolean> d : charHashMap.entrySet()){  //java中遍历hashmap的方法，背会！
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

}
