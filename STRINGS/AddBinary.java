public class AddBinary {

        public String addBinary(String a, String b) {
            int i=a.length()-1;
            int j=b.length()-1;
            StringBuilder result=new StringBuilder();
            int carry=0;
            while(i>=0 || j>=0 || carry>0){
                int bitA=0;
                int bitB=0;
                if(i>=0){
                    bitA=a.charAt(i)-'0';   //'1'->49 and '0'->48
                    i--;
                }
                if(j>=0){
                    bitB=b.charAt(j)-'0';
                    j--;
                }
                int sum=bitA+bitB+carry;
                int rem=sum%2;
                carry=sum/2;
                result.append(rem);
            }
            return result.reverse().toString();

        }

}
