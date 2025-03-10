public class MaxVehicle {
    public static int maxVehicle(int[][] matrix){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for (int row = 0; row < matrix.length; row++) {
            int count=0;
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if(matrix[row][cols]==1){
                    count++;
                }
            }
            if(count>max){
                max=count;
                index=row;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0,0,0}, {0,0,0}};
        System.out.println(maxVehicle(arr));
    }
}
