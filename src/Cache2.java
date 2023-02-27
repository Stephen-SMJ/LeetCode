import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

class CacheNode {
    int key;
    int value;
    int weight;
    int timeStamp;

    CacheNode(int key, int value, int weight, int timeStamp) {
        this.key = key;
        this.value = value;
        this.weight = weight;
        this.timeStamp = timeStamp;
    }
}

public class Cache2 {
    int capacity;
    int timeStamp;
    Map<Integer, CacheNode> map;
    PriorityQueue<CacheNode> pq;

    Cache2(int capacity) {
        this.capacity = capacity;
        this.timeStamp = 0;
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) ->
            (int) (b.weight / (Math.log(b.timeStamp - a.timeStamp + 1) + 1) -
                a.weight / (Math.log(a.timeStamp - b.timeStamp + 1) + 1)));
    }

    int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheNode node = map.get(key);
        node.timeStamp = ++timeStamp;
        pq.remove(node);
        pq.add(node);
        return node.value;
    }

    void put(int key, int value, int weight) {
        if (capacity <= 0) {
            return;
        }
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.value = value;
            node.weight = weight;
            node.timeStamp = ++timeStamp;
            pq.remove(node);
            pq.add(node);
        } else {
            if (map.size() == capacity) {
                CacheNode node = pq.poll();
                map.remove(node.key);
            }
            CacheNode node = new CacheNode(key, value, weight, ++timeStamp);
            map.put(key, node);
            pq.add(node);
        }
    }
}
