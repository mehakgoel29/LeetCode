import java.util.Stack;

public class TheCelebrityProblem {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> s=new Stack<>();
        // step 1:  push all elements
        int n=mat.length;
        for(int i=0;i<n;i++){
            s.push(i);
        }
        //step 2: pop 2 elements and compare
        while(s.size()>1){
            int a=s.pop();
            int b=s.pop();

            if(knows(mat,a,b)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int ans=s.peek();
        //step 3: check for zeroCount and oneCount

        int zeroCount=0;
        for(int i=0;i<n;i++){
            if(mat[ans][i]==0){
                zeroCount++;
            }
        }
        if(zeroCount!=n-1){
            return -1;
        }
        int oneCount=0;
        for(int i=0;i<n;i++){
            if(i != ans && mat[i][ans]==1){
                oneCount++;
            }
        }
        if(oneCount!=n-1){
            return -1;
        }

        return ans;

    }
    public boolean knows(int mat[][], int a , int b){
        if(mat[a][b]==1){
            return true;
        }
        else{
            return false;
        }
    }
}
