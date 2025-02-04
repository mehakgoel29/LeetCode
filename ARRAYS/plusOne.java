public class plusOne{
    public int[] plusOnecal(int[] digits) {
    int n = digits.length;
    for(int i=digits.length-1;i>=0;i--){
        if(digits[i]<=8){
            digits[i]=digits[i]+1;
            break;
        }
        else{
            digits[i]=0;
        }
    }
    if(digits[0]==0){ //because no leading zeros should be there 
       int[]newArr=new int[n+1];
       for(int i =0;i<newArr.length;i++){
        if(i==0){
            newArr[0]=1;
        }
        else{
            newArr[i]=digits[i-1];
        }
       }
       return newArr;
    }
    else{
        return digits;
    }
    
}}

/*Time Complexity: O(n), where  n is the length of the digits array.
Space Complexity: O(n) in the worst case when a new array is created (when all digits are 9). */