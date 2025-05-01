public class example extends Overriding{

    public void onDraw() {
        System.out.println("this is the overriden function");
    }

    public static void main(String[] args) {
        System.out.println(nearestPrime(100));

    }
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;

        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0) {
                return false;
            }
            }
        return true;
    }
    public static int nearestPrime(int n){
        if(isPrime(n)){
            return n;
        }
        int low=n-1;
        int high=n+1;
       while(true){
           if(isPrime(low)){
               return low;
           }
           if(isPrime(high)){
               return high;
           }
           low--;
           high++;
       }
    }
}
