package activities;

public class Activity2 {
    public static void main(String args[]){
        int arr[]={10,77,10,54,-11,10};
        int sum =0;
        for(int i=0;i<arr.length;i++){
          if(arr[i]%10==0){
              sum=sum+arr[i];
          }
        }
        if(sum==30){
            System.out.println("The sum of all numbers is equal to 30");
        }
        else{
            System.out.println("The sum of all numbers is not equal to 30");
        }
    }
}
