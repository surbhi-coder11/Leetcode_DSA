import java.util.*;

class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    private int current;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        current = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int val = pq.poll();
            set.remove(val);
            return val;
        }
        return current++;
    }

    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}
