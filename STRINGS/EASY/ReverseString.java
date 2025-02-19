package EASY;

public class ReverseString {

        public String reverseWords(String s) {
            String[] words= s.trim().split("\\s+"); // \\s++ for removing multiple spaces
            int start=0;
            int end=words.length-1;
            StringBuilder result =new StringBuilder();
            while(start<end){
                String temp=words[start];
                words[start]=words[end];
                words[end]=temp;
                start++;
                end--;
            }

            for(int i=0;i<words.length;i++){
                result.append(words[i]);
                if(i<words.length-1){ //agr wo word end m nhi aata tbhi usme space add krna hai
                    result.append(" ");
                }

            }
            return result.toString();

        }
    }

    //time : o(n)
    //space:o(n)