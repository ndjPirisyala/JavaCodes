import java.util.*;

public class TestTriangle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day : ");
        int n = sc.nextInt();
        check(n);
        System.out.print("Enter the number of thieves : ");
        int t = sc.nextInt();
        thieves(t);
    }

    public static void check(int n){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<30;i++){
            int num=i*(i+1)/2;
            if(num >0 && num <= 30){
                arr.add(num);
            }
        }
        if(arr.contains(n)){
            System.out.println("Today is an active day!");
        }
        else{
            System.out.println("Today is not an active day!");
        }
        System.out.println("***********************************");
    }

    public static void thieves(int t){
        int count=1;
        while((t/2)%2==0){
            t=t/2;
            count++;
        }
        System.out.println("Number of thieves in the beginning = "+(t/2));
        System.out.println("It was started "+(count+1)+" months ago");
    }
}

