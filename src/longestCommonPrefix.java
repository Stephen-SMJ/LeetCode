import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class longestCommonPrefix {
	//	private String getSmallestStr(String[] strs) {
//		return Arrays.stream(strs).max(Comparator.comparingInt(String::length).reversed()).get();
//	}
	private Integer getSmallestStr(String[] ars) {
		int minStrLen = ars[0].length();
		int currentLen;
		for (int i = 1; i < ars.length; i++) {
			currentLen = ars[i].length();
			if (currentLen < minStrLen) {
				minStrLen = currentLen;
			}
		}
		return minStrLen;
	}
	public String longestCommonPrefix (String[]strs){
		String str = strs[0];
		int minLen = getSmallestStr(strs);
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < minLen; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (str.charAt(i) != strs[j].charAt(i)) {
					return prefix.toString();
				}else {
					continue;
				}
			}
			prefix.append(str.charAt(i));
		}
		return prefix.toString();
	}

	public static void main(String[] args) {
		String[] arr = {"flower", "flow", "flight"};
		longestCommonPrefix longestCommonPrefix = new longestCommonPrefix();
		String prefix = longestCommonPrefix.longestCommonPrefix(arr);
		System.out.println(prefix);
	}
}
