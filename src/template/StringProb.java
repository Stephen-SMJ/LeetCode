package template;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class StringProb {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray(); //abcdfgh 2
        for (int i=0; i<s.length(); i+=2*k){
            int start = i;
            int end = Math.min(chars.length-1, i+k-1);
            while(start < end){
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }

        }
        return new String(chars);
    }
    public static String reverseWords(String s) {
        String[] stringArray = s.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<stringArray.length; i++){
            if (stringArray[i] == "")
                continue;
            result.add(stringArray[i]);
        }
        int i = 0;
        int j = result.size()-1;
        while (i<j){
            String tmp = result.get(i);
            result.set(i,result.get(j));
            result.set(j,tmp);
            i++;
            j--;
        }
        String res = "";
        for (int a=0; a<result.size(); a++){
            if (a == result.size()-1){
                res += result.get(a);
            }
            res += result.get(a) + " ";
        }

        return res; //java中不能用-1表时最后一个索引


    }
    public static String reverseString(String inputStr) {
        char[] chars = inputStr.toCharArray();
        int halfwayPoint = chars.length / 2;

        for (int i = 0; i < halfwayPoint; i++) {
            char temp = chars[i];
            chars[i] = chars[halfwayPoint - i];
            chars[halfwayPoint - i] = temp;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String test = "hello World";
        System.out.println(reverseString(test));
    }
}
