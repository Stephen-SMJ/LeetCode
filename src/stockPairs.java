import java.util.*;

public class stockPairs {
	public static int CheckstockPairs(List<Integer> stocksProfit, long target) {
		HashMap<Integer, Boolean> pairs = new HashMap<>();
		int count = 0;
		for (int i=0; i<stocksProfit.size(); i++){
			if (!pairs.containsKey(stocksProfit.get(i))){
				for (int j=i+1; j< stocksProfit.size(); j++){
					if (stocksProfit.get(i) + stocksProfit.get(j) == target){
						pairs.put(stocksProfit.get(i),true);
						pairs.put(stocksProfit.get(j),true);
						count++;
						break;
					}
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		Collections.addAll(arr,6, 6, 3, 9, 3, 5, 1);
		int tar = 12;
		System.out.println(CheckstockPairs(arr,tar));
	}
}
