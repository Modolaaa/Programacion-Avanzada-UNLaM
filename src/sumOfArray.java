public class sumOfArray {

    public static int sumOfArrayIterative(int[] array){
        int sum = 0;
        for(int myElem: array){
            sum+=myElem;
        }
        return sum;
    }
    public static int sumOfArrayWrapper(int[]array){
        return sumOfArrayRecursive(array,0);
    }

    public static int sumOfArrayRecursive(int[] array, int index){
        if(array.length <=index){
            return 0;
        }
        return array[index] + sumOfArrayRecursive(array, index + 1);
    }

    public static int sumOfArrayDACWrapper(int[]array){
        return sumOfArrayDac(array, 0, array.length -1);
    }

    public static int sumOfArrayDac(int[]array, int min, int max){
        if(min == max){
            return array[min];
        }
        if(min>max){
            return 0;
        }
        int mid = (min+max)/2;
        int left = sumOfArrayDac(array,min,mid-1);
        int right = sumOfArrayDac(array,mid+1,max);
        return array[mid] + left + right;
    }

}
