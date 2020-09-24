import java.util.Arrays;

public class A1_Driver {

    //public static void main(String[] args) {
        //Question1
        /*
        int arr[] = {51, 88, 3, 70, 96, 38, 47};
        //int arr[] = {51, 88, 3};
        System.out.println("Input: " + Arrays.toString(arr));
        sortOddBack(arr);
        System.out.println("Output: " + Arrays.toString(arr));
         */

        //Question3
    //    int arr[] = { 42, 21, 10, 31, 7};
    //    System.out.print(searchDoProduct(arr,arr.length));

    //}
    //Question 1
    public static void sortOddBack(int arr[]){

        int oddCounter = 0;
        int evenCounter = 0;

            for(int i=0; i<arr.length; i++){
                if( arr[i]%2 != 0 && oddCounter+evenCounter < arr.length-1){

                    //Declare a temporary integer which equals to arr[i]
                    int temp = arr[i];
                    //If index i != the last index in the array, then let the current index of array = next index
                    if(i != arr.length-1){
                        for(int j=i; j<arr.length-1; j++){
                            arr[j] = arr[j + 1];
                        }
                    }
                    arr[arr.length-1]=temp;
                    oddCounter++;
                }
                evenCounter++;
            }
    }


    //Question 2
    static String searchDoProduct(int arr[], int n){
            String str = "";
            int maxIndex = 0;
            int subMaxIndex = 0;
            int minIndex = 0;
            int subMinIndex = 0;

            if (arr[0]>=arr[1]){
                maxIndex = 0;
                subMaxIndex = 1;
            }
            else{
                maxIndex = 1;
                subMaxIndex = 0;
            }

            if (arr[n-2]>=arr[n-1]){
                minIndex = n-1;
                subMinIndex = n-2;
            }
            else{
                minIndex = n-2;
                subMinIndex = n-1;
            }

            for (int i=2; i<n; i++){
                if(arr[i]>arr[maxIndex]){
                    subMaxIndex = maxIndex;
                    maxIndex = i;
                }
                else if(arr[i]<arr[maxIndex] && arr[i]>arr[subMaxIndex]){
                    subMaxIndex = i;
                }
            }

            for (int i=n-3; i>=0; i--){
                if(arr[i]<arr[minIndex]){
                    subMinIndex = minIndex;
                    minIndex = i;
                }
                else if(arr[i]>arr[minIndex] && arr[i]<arr[subMinIndex]){
                    subMinIndex = i;
                }
            }

            str = "➢ The two indices with largest product between their values are: index "+maxIndex+" and index "+subMaxIndex+", storing values "+ arr[maxIndex]+" and\n" +
                    arr[subMaxIndex]+", and the value of their product is "+arr[maxIndex]*arr[subMaxIndex]+".\n" +
                    "➢ The two indices with smallest product between their values are: index "+minIndex+" and index "+subMinIndex+", storing values "+arr[subMinIndex]+" and\n" +
                    +arr[minIndex]+" and the value of their product is "+arr[minIndex]*arr[subMinIndex]+".";

            return str;
        }

    }
