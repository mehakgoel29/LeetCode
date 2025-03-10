import java.util.Scanner;

public class TwoFourWheeler {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v= sc.nextInt(); //total number of vehicles
        int w=sc.nextInt();  //total number of wheels
        int FW =(w-2*v)/2;
        if(w>=2 && (w%2==0) && v<w)
            System.out.println("FW= "+FW+" TW= "+(v- FW));
        else
            System.out.println("INVALID INPUT");
    }
}
