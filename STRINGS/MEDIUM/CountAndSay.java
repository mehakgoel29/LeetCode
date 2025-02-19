package MEDIUM;

public class CountAndSay {
    public String countAndSay(int n) {
        String ans="";
        int count=1;
        if(n==1){
            return "1";
        }
        String prevTerm=countAndSay(n-1);

        for(int i=0;i<prevTerm.length();i++){
            if(i + 1 < prevTerm.length()&& prevTerm.charAt(i)==prevTerm.charAt(i+1)){
                count++;
            }
            else{
                ans+=count;
                ans+=prevTerm.charAt(i);
                count=1;
            }
        }

        return ans;

    }
}
