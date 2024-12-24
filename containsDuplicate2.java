import java.util.HashMap;

public class containsDuplicate2 {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
           if(map.containsKey(nums[i])){
              if(Math.abs(i-map.get(nums[i]))<=k){
                return true;
              }
           }
           map.put(nums[i],i);
       }
       return false;
}


        public boolean containsNearbyDuplicate2(int[] nums, int k) {
           for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k && i!=j){
                    return true;
                }
            }
           }
           return false; 
        }

}
