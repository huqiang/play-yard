package qiang.hu.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class TopK {
    public List<Integer> topK(List<Integer> list, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));
        for (var i : list) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (queue.peek() < i) {
                queue.poll();
                queue.add(i);
            }
        }
        return queue.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).toList();
    }

    public static void main(String[] args) {
        var topK = new TopK();
        IntStream.range(0, 10).forEach(i -> {
            int n = (int) (Math.random() * 100);
            List<Integer> list = new ArrayList<>(n);
            for (var j = 0; j < n; j++) {
                list.add((int) (Math.random() * 1000));
            }
            System.out.println(list);
            System.out.println(topK.topK(list, 5));
        });
    }
}
