/**
 * Question 1
 */

public class Q1 {

    public void sortOddBack(int arr[]){
        int counter = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 != 0){
                arr[counter++] = arr[i];
            }
        }
        while (counter < arr.length){
            arr[counter++] = 0;
        }
    }
}
