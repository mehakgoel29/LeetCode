public class MaxPersonOnCruise {
    public static int maxPerson(int[]E, int[]L){
        int i=0; int j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(i<E.length && j<L.length){
            sum=sum+E[i]-L[j];
            if(sum>max) {
                max = sum;
            }
            i++;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] E={7,0,5,1,3};
//        int[] L={1,2,1,3,4};
        int[] E={3,5,2,0};
        int[] L={0,2,4,4};
        System.out.println(maxPerson(E,L));
    }
}
