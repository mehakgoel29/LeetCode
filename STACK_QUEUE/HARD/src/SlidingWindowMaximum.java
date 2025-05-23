import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    //brute force
    //GIVES TLE
    public int[] maxSlidingWindowBrute(int[] nums, int k) {
        int n=nums.length;
        int [] res=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(nums[j]>max){
                    max=nums[j];
                }
            }
            res[i]=max;
        }
        return res;
    }


    //optimal
    /*
    We'll maintain a deque of indices of array elements.
    For every index:
    Remove indices outside the window.
    Remove indices of elements smaller than current element from the back.
    Add current index.
    Add nums[deque.front] to result if window is full.
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the window
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            // Remove smaller elements from the back
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            // Add current index
            q.offerLast(i);
            // Store result if the first full window is complete
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }
    }
