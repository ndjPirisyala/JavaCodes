import java.util.*;

class Number{
    int ele;
    ArrayList<String> maxZ = new ArrayList<String>();
    ArrayList<String> minZ = new ArrayList<String>();

    Number(int ele){
        this.ele=ele;
        this.maxZ.add(Integer.toString(this.ele));
        this.minZ.add(Integer.toString(this.ele));
    }
}

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();

        //declare the object array
        Number[] arr = new Number[n];
        String flag="";

        //creating the objects array
        for (int i=0;i<n;i++) {
            System.out.println("Enter the number");
            int ele = sc.nextInt();
            arr[i] = new Number(ele);
        }

        //the algorithm
        int resLen = 1;
        int resIndex=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if((arr[i].ele > arr[j].ele) && (arr[i].maxZ.get(0).split(" ").length < arr[j].minZ.get(0).split(" ").length+1)){
                    arr[i].maxZ.clear();
                    int temp = arr[j].minZ.size();
                    for (int x=0;x<temp;x++){
                        String sub = arr[j].minZ.get(x);
                        sub+=" " + Integer.toString(arr[i].ele);
                        arr[i].maxZ.add(sub);
                    }
                }
                else if((arr[i].ele > arr[j].ele) && (arr[i].maxZ.get(0).split(" ").length == arr[j].minZ.get(0).split(" ").length+1)){
                    int temp = arr[j].minZ.size();
                    for (int x=0;x<temp;x++) {
                        String sub = arr[j].minZ.get(x);
                        sub +=" "+ Integer.toString(arr[i].ele);
                        arr[i].maxZ.add(sub);
                    }
                }
                else if((arr[i].ele < arr[j].ele) && (arr[i].minZ.get(0).split(" ").length < arr[j].maxZ.get(0).split(" ").length+1)){
                    arr[i].minZ.clear();
                    int temp = arr[j].maxZ.size();
                    for (int x=0;x<temp;x++){
                        String sub = arr[j].maxZ.get(x);
                        sub+=" " + Integer.toString(arr[i].ele);
                        arr[i].minZ.add(sub);
                    }
                }
                else if((arr[i].ele < arr[j].ele) && (arr[i].minZ.get(0).split(" ").length == arr[j].maxZ.get(0).split(" ").length+1)){
                    int temp = arr[j].maxZ.size();
                    for (int x=0;x<temp;x++) {
                        String sub = arr[j].maxZ.get(x);
                        sub +=" "+ Integer.toString(arr[i].ele);
                        arr[i].minZ.add(sub);
                    }
                }
                else{continue;}
            }


            if(arr[i].maxZ.get(0).length() > arr[i].minZ.get(0).length()){
                flag="max";
                if(resLen < arr[i].maxZ.get(0).length()){
                    resLen = arr[i].maxZ.get(0).length();
                    resIndex=i;
                }
            }
            else if(arr[i].maxZ.get(0).length() < arr[i].minZ.get(0).length()){
                flag="min";
                if(resLen < arr[i].minZ.get(0).length()){
                    resLen = arr[i].minZ.get(0).length();
                    resIndex=i;
                }
            }
            else{
                flag="both";
                resLen = arr[i].maxZ.get(0).length();
                resIndex=i;
            }
        }

        ArrayList<String> ans = new ArrayList<String>();
        if(flag.equals("max")){
            for(int t=0;t<arr[resIndex].maxZ.size();t++){
                ans.add(arr[resIndex].maxZ.get(t));
            }
        }
        else if(flag.equals("min")){
            for(int t=0;t<arr[resIndex].minZ.size();t++){
                ans.add(arr[resIndex].minZ.get(t));
            }
        }
        else{
            for(int t=0;t<arr[resIndex].maxZ.size();t++){
                ans.add(arr[resIndex].maxZ.get(t));
            }
            for(int t=0;t<arr[resIndex].minZ.size();t++){
                ans.add(arr[resIndex].minZ.get(t));
            }
        }
        Set<String> ansUnique = new HashSet<String>(ans);
        for (String temp : ansUnique){
            System.out.println(temp);
        }
        System.out.println("\nThe number of Zig-Zags is - "+ansUnique.size());
    }
}