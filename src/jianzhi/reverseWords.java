package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class reverseWords {
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr)); //通过 ArrayList.asList() 函数得到的 ArrayList 并不是我们常用的 java.util.ArrayList 而是 Arrays类中一个内部类ArrayList。
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals("")){ //此时list是对象类型，对象要用equals！！！！
                list.remove(i);
                i--;
            }
        }
        String[] newArr = list.toArray(new String[list.size()]);
        int a = 0, b = (newArr.length - 1);
        while (a < b){
            String tmp = newArr[a];
            newArr[a] = newArr[b];
            newArr[b] = tmp;
            a++;
            b--;
        }
        return String.join(" ", newArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" the   sky is blue "));
    }
}
