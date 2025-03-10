import java.util.Scanner;

public class TimeForWashing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int weight=sc.nextInt();
        if(weight>7000){
            System.out.println("OVERLOADED");
        }
        else if(weight==0){
            System.out.println(0);
        }
        else if (weight>1 && weight<2000) {
            System.out.println(25);
        }
        else if (weight>2001 && weight<4000) {
            System.out.println(35);
        }
        else if (weight>4001 && weight<7000) {
            System.out.println(45);
        }
        else{
            System.out.println("Enter valid weight");
        }

    }

}
