package jianzhi;

public class translateNum{
    public int translateNum(int num) {
        //5 1
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i=2; i<=s.length(); i++){  // 12358
            String tmp = s.substring(i-2,i); //compare with 10 if >10 <25 is ok;
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a+b : b;
            a = b;
            b = c;
        }
        return b;

    }

}
