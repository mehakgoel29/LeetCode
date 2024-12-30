import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class threeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int counter = 0; counter <= nums.length - 3; counter++) {
                int target = nums[counter];
                int i = counter + 1;
                int j = nums.length - 1;

                while (i < j) {
                    if (nums[i] + nums[j] == -target) {
                        List<Integer> list = new ArrayList<>(); // Initialize new list here
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(target);
                        i++;
                        j--;
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    } else if (nums[i] + nums[j] >-target) {
                        //agr sum bda ara h toh hm usi ko minus krenge na jiski vjh se sum bda h mtlb ki bda vla number and hmare case m sorting ho rkhi h toh hm fr
                        //j ko hi chota krenge n kyunki i or j m se j hi hmesha bda hoga
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            return result;
        }
    }


