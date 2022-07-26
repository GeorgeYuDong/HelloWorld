package company.datastructure;

import java.util.ArrayList;
import java.util.List;

public class HeapTopK {

    //寻找前K个最大的数，使用小顶堆
    public static List<Integer> topKMax(int[] nums, int k) {
        HeapNode pq = new HeapNode(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        var nums = new int[]{1, 5, 4, 3, 2, 6};
        System.out.println(topKMax(nums, 3));
    }
}
