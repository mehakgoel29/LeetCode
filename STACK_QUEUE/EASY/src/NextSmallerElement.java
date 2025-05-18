import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {
        NextSmallerElement ng = new NextSmallerElement();
        int[] arr = {4, 5, 2, 25};
        int[] result = ng.NextSmallerElement(arr);
        System.out.println(Arrays.toString(result));
    }

    private int[] NextSmallerElement(int[] arr) {
        Stack<Integer> s= new Stack<>();
        int[] res=new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            int num = arr[i];
            while (!s.isEmpty() && s.peek() >= num) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }
            s.push(num);
        }
        return res;
    }

}
