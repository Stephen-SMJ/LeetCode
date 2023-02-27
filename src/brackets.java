import java.lang.reflect.Array;
import java.util.*;

public class brackets {
	public static boolean isValid(String s) {
		if(s.length() % 2 != 0 || !isLeft(s)){
			return false;
		}
		//Deque<Character> charArr = new ArrayDeque<>();
		Deque<Character> charArr = new LinkedList<>();
		for(char c:s.toCharArray()){ //{[()]} {}()[]
			if (c == '{' ){
				charArr.push('}');
			} else if (c == '['){
				charArr.push(']');
			}else if(c == '('){
				charArr.push(')');
			}else if(c != charArr.pop()){
				return false;
			}
		}
		return charArr.isEmpty();
	}
	public static boolean isLeft(String s){
		switch (s.charAt(0)){
			case '}':
			case ')':
			case ']':
				return false;
			default: return true;
		}
	}

	public static void main(String[] args) {
		String s1 = "{[()]}";
		String s2 = "{}()[]";
		String s3 = "{]{)(]";
		System.out.println(brackets.isValid(s1));
		System.out.println(brackets.isValid(s2));
		System.out.println(brackets.isValid(s3));
		System.out.println(isLeft("()"));
	}
}
