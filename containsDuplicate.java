import java.util.HashMap;

public class containsDuplicate {

        //method 1
        public boolean containsDuplicate2(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int count = 0; 
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
                if (count>=2) {
                    return true;
                }
            }
            return false; 
        }

    //method 2
    public boolean containsDuplicate1(int[] nums) {
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
            if(map.get(key)>=2){
                return true;
            }
        }
        return false;
    }
}


/*
 time complexity : o(n)
 space complexity : o(n)
 */

