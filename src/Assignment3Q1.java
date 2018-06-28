import java.util.*;
import java.util.stream.IntStream;

public class Assignment3Q1{
    public static void main(String args[]){
        int[] arr = new int[5];
        arr[0]=500;
        System.out.println(IntStream.of(arr).anyMatch(x -> x == 50));

        ArrayList<Integer> go = new ArrayList<Integer>();
        go.add(600);
        System.out.println(go.contains(60));



    }
}