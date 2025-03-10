public class GreaterThanPriorElement {
    public static void main(String[] args) {
        int[] arr={7,4,8,2,9};
        System.out.println(maxSoFar(arr));
        System.out.println(maxSoFar2(arr));

    }
    public static int maxSoFar(int[] arr){
        int count=1;
        for (int i = 1; i < arr.length ; i++) {
            Boolean flag=true;
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[i]){
                    flag=false;
                    break;
                }
            }
            if(flag==true) {
                count++;
            }
        }
        return count;
    }
    //Method 2
    public static int maxSoFar2(int[] arr){
        int count=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                count++;
                max=arr[i];
            }
        }
        return count;
    }
}
