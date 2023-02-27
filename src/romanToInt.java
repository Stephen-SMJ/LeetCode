import java.util.HashMap;
import java.util.Map;

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */
/*
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/roman-to-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class romanToInt {
	public int romanToInt(String s) { //解法1.用哈希
		HashMap<Character,Integer> number = new HashMap<>();
		number.put('I',1);
		number.put('V',5);
		number.put('X',10);
		number.put('L',50);
		number.put('C',100);
		number.put('D',500);
		number.put('M',1000);
		int sum = 0;
		int prenum = number.get(s.charAt(0));
		for (int i = 1; i<s.length(); i++){  //"XIV" 跟后一个比较索引会超出限制，因此跟前一个比较。
			if (prenum >= number.get(s.charAt(i))){
				sum += prenum;
			}else {
				sum -= prenum;
			}
			prenum = number.get(s.charAt(i));
		}
		sum += prenum;
		return sum;
	}

	public int getValue(char ch){  //解法2.用switch会更快。
		switch (ch){
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	public int romanToIntSwitch(String s) {
		int sum = 0;
		int prenum = getValue(s.charAt(0));
		for (int i = 1; i<s.length(); i++){  //"XIV" 跟后一个比较索引会超出限制，因此跟前一个比较。
			int num = getValue(s.charAt(i));
			if (prenum >= num){
				sum += prenum;
			}else {
				sum -= prenum;
			}
			prenum = num;
		}
		sum += prenum;
		return sum;
	}

	public static void main(String[] args) {
		romanToInt romanToInt = new romanToInt();
		System.out.println(romanToInt.romanToIntSwitch("III"));
		System.out.println(romanToInt.romanToIntSwitch("IV"));
		System.out.println(romanToInt.romanToIntSwitch("IX"));
		System.out.println(romanToInt.romanToIntSwitch("LVIII"));
		System.out.println(romanToInt.romanToIntSwitch("MCMXCIV"));
	}
}
