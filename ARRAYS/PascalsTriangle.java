import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
        public List<Integer> generateRow(int rows){
            ArrayList<Integer> list=new ArrayList<>();
            int ans=1;
            list.add(ans);
            for(int i=1;i<rows;i++){
                ans*=(rows-i);
                ans=ans/i;
                list.add(ans);
            }
            return list;
        }
        public static long nCr(int n, int r) {  // n means number of elements and r means row number
            long res = 1;
            for (int i = 0; i < r; i++) {
                res = res * (n - i);
                res = res / (i + 1);
            }
            return res;
        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result=new ArrayList<>();
            for(int i=1;i<=numRows;i++){
                result.add(generateRow(i));
            }
            return result;
        }
    }
