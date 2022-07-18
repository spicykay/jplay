package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    private static void printPQ(final PriorityQueue<Integer> pq, String description) {
        System.out.println(description);
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.forEach(i -> System.out.println(i));
    }

    public static void main(String[] args) {
        printPQ(new PriorityQueue<>((a,b) -> a-b), "regular:custom-comparator");
        printPQ(new PriorityQueue<>(), "nocomparator");
        printPQ(new PriorityQueue<>((a,b) -> b-a), "reverse:custom-comparator");
        printPQ(new PriorityQueue<>(Comparator.reverseOrder()), "reverse:comparator");
        System.out.println("hello world");
    }
}
