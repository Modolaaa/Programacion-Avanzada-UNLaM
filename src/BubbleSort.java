public class BubbleSort {
    public static void bubbleSort(int[] myArray){

        boolean change;
        int swap;

        for(int i = 0; i<myArray.length;i++){
            change = false;
            for(int j=0;j<myArray.length-1-i;j++){
                if(myArray[j]>myArray[j+1]){
                    swap = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = swap;
                    change = true;
                }
            }
            if(!change){
                return;
            }
        }
    }
}
