import java.util.*;

class Node{
	int key;
	int val;
	int weight;
	int timeStamp;

	public Node(int key, int val, int weight, int timeStamp) {
		this.key = key;
		this.val = val;
		this.weight = weight;
		this.timeStamp = timeStamp;
	}
}

public class Cache {
	int capacity;
	int timeStamp;
	Map<Integer,Node> nodeMap;  //k-v映射
	PriorityQueue<Node> prque;  //存节点和优先级 Java优先级队列默认每次取出来的为最小元素

	public Cache(int capacity){
		this.capacity = capacity;
		this.timeStamp = 0;
		nodeMap = new HashMap<>();
		Comparator<Node> timeWeightComparator = new Comparator<Node>() { //定义满队时的优先级
			@Override //问题 ： 1.为什么每次跳过0，从1和2开始比较，2.明明是取最高的，但o1和o2貌似是两个node进行比较？
			public int compare(Node o1, Node o2) {  // 返回负数是升序 1 2 3 4 5 升序  5 4 3 2 1 降序
				return (int) (o1.weight / (Math.log(o1.timeStamp - o2.timeStamp + 1) + 1) -
						(o2.weight / (Math.log(o2.timeStamp - o1.timeStamp + 1) + 1)));  //o1 : 2/3 o2  2/log2+1 = 0
			}
		};
		prque = new PriorityQueue<>(timeWeightComparator);
	}

	public int get(int key){  //时间复杂度，O1,hashmap.get为O1
		if (!nodeMap.containsKey(key)){
			return -1;
		}
		Node getNode = nodeMap.get(key);
		getNode.timeStamp = ++timeStamp;
//		prque.remove(getNode);
//		prque.add(getNode);
		return getNode.val;
	}

	void put(int key, int val, int weight){ //最好的情况是O1，已经包含这个建了，直接修改值。，平均logN，因为优先队列put是OlogN，
		if (this.capacity <= 0){
			return;
		}
		if (nodeMap.containsKey(key)){
			Node newNode = nodeMap.get(key); //此时newnode指向nodemap中的元素，因此修改newnode相当于直接修改了nodemap中的元素。
			newNode.val = val;
			newNode.weight = weight;
			newNode.timeStamp = ++ timeStamp;
//			prque.remove(newNode); //如果已经有了则先删除，再重新插入一个新的
//			prque.add(newNode);
		}else {
			if (nodeMap.size() == capacity){
				Node leastNode = prque.poll(); //OlogN
				assert leastNode != null;
				nodeMap.remove(leastNode.key);
			}
			Node newNode = new Node(key, val, weight, ++timeStamp);
			prque.add(newNode); //OlogN 队列和map中的node都指向newNode,所以直接对node进行修改也会同时修改队列和map中的node。
			nodeMap.put(key,newNode);
		}

	}

	public static void main(String[] args) {
		Cache cache = new Cache(5);
		cache.put(0,15,3);
		cache.put(1,28,10);
		cache.put(2,16,4);
		cache.put(3,4,6);
		cache.put(4,75,5);
		cache.put(4,100,100);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(0));

	}
}

