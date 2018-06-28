import java.util.*;

//the Element class
class Element{
    int ele;
    ArrayList<String> lisArr = new ArrayList<String>();
    int lisLength;

    Element(int ele){
        this.ele=ele;
        this.lisLength=1;
        this.lisArr.add(Integer.toString(this.ele));
    }
}

public class Question2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of participants...");
        int len = sc.nextInt();

        //declare the object array
        Element[] objArr = new Element[len];
        Random r = new Random();
        //creating the objects array
        for (int i=0;i<len;i++) {
            objArr[i] = new Element(r.nextInt(len-1)+1);
        }

        //the algorithm
        int max = 1;
        int maxIndex=0;

        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(objArr[i].ele>objArr[j].ele){
                    if(objArr[i].lisLength<objArr[j].lisLength+1){
                        //updating lisLength
                        objArr[i].lisLength=objArr[j].lisLength+1;
                        //updating lisArray
                        objArr[i].lisArr.clear();
                        int temp=objArr[j].lisArr.size();
                        String sub;
                        for(int y=0;y<temp;y++){
                            sub=objArr[j].lisArr.get(y);
                            sub+=" "+Integer.toString(objArr[i].ele);
                            objArr[i].lisArr.add(sub);
                        }
                    }
                    else if(objArr[i].lisLength==objArr[j].lisLength+1){
                        //updating lisArray
                        int temp=objArr[j].lisArr.size();
                        String sub;
                        for(int y=0;y<temp;y++){
                            sub=objArr[j].lisArr.get(y);
                            sub+=" "+Integer.toString(objArr[i].ele);
                            objArr[i].lisArr.add(sub);
                        }
                    }
                    else{continue;}
                }
                else{continue;}
            }
            //updating the max & maxIndex variables
            if(objArr[i].lisLength>max){
                max=objArr[i].lisLength;
                maxIndex=i;
            }
        }

        //Printing all numbers in order
        System.out.println("\nThe numbers are...");
        for(int f=0;f<len;f++){
            System.out.print(objArr[f].ele + " ");
        }

        //Printing the winning numbers
        System.out.println("\nThe winning number are...");
        for(int x=0;x<objArr[maxIndex].lisArr.size();x++){
            System.out.println(objArr[maxIndex].lisArr.get(x));
        }
    }
}

