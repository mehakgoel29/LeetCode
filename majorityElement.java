import java.util.HashMap;

public class majorityElement {
    //leetcode question 169
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            
            // Outer loop to consider each element as a potential majority element
            for (int i = 0; i < nums.length; i++) {
                int count = 0; // Reset count for each new candidate element
                
                // Inner loop to count occurrences of nums[i]
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
                
                // If the count of nums[i] is greater than or equal to n / 2, it's the majority element
                if (count > n / 2) {
                    return nums[i];
                }
            }
            return -1; 
        }
    }
    
}


/*
 time complexity : o(n^2)
 space complexity : o(1)
 */



 /*Boyer-Moore Voting Algorithm (Optimal Approach):
Time Complexity: O(n)
Space Complexity: O(1) */
//didnt implement yet

/*
 time complexity : o(n)
 space complexity : o(n)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
     for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)>n/2){
                return key;
            }
        }
        return -1;
    }
}
