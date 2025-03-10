public class PeakElement {
    public static int peakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
        }
        return start;
    }
    public int peakIndexInMountainArrayLinear(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
    public int peakIndexInMountainArray3(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
               return mid;
            }
            else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1] ){
                start=mid+1;
            }
            else if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1] ){
                end=mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr={0,5,10,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
