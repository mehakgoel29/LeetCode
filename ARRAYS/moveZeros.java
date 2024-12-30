public class moveZeros {
        public void moveZeroes(int[] nums) {
            int index=0; //for non zero elements
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[index]=nums[i];
                    index++;
                }
            }
            //add zeroes to the remaining indices
            for(int i=index;i<nums.length;i++){
                nums[i]=0;
            }
        }

}
