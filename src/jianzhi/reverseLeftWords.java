package jianzhi;


public class reverseLeftWords {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);

    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords.reverseLeftWords("hello", 2));
    }
}
