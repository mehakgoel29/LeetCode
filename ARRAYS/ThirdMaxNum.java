import java.util.ArrayList;
import java.util.Arrays;

public class ThirdMaxNum {
    public int thirdMax(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        if(list.size()>=3){
            return list.get(list.size()-3);
        }
        else{
            return list.get(list.size()-1);
        }
    }
}
