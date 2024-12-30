import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
    public List<String> Ranges(int[] nums) {
        ArrayList<String> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0; i<n;i++){
            int start=nums[i];
            while(i+1<n && nums[i]+1==nums[i+1]){
                i++;
            }
            if(start!=nums[i]){
                list.add(start+"->"+nums[i]);
            }
            else{
                list.add(start+"");
                // list.add(String.valueOf(start));
                //can also convert it to string explicitly
            }
        }
        return list;
    }
}