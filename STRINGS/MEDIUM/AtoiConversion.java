package MEDIUM;

public class AtoiConversion {
    public static void main(String[] args) {

    }
    public static int myAtoi(String s){
        s=s.trim();
        int sign=1;
        int result=0;
        int i=0;
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        } else if (s.charAt(i)=='+') {
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            result=(result*10)+s.charAt(i)-'0';
            if(result*sign>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if (result*sign<Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int)(result*sign);
    }
}
