import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection2 {
        //Method 1
        //time comp: o(m*n) space comp: o(n) //array
        public int[] intersect1(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        list.add(nums1[i]);
                        nums2[j] = Integer.MIN_VALUE; // Avoid duplicates
                        break;
                    }
                }
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }
        //Method 2
        //time: o(m+n) space:o(n)
        public int[] intersect2(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            // Populate the HashMap with counts from nums1
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                } else {
                    map.put(nums1[i], 1);
                }
            }

            // Find intersections using nums2
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }

            // Convert the ArrayList to an array
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }

            return result;
        }


}
