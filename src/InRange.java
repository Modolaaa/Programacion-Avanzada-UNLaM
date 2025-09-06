public class InRange {
    public static int inRangeIterative(int[] nums, int min, int max){
        int contador = 0;
        for(int elem : nums){
            if(elem>=min && elem<=max){
                contador++;
            }
        }
        return contador;
    }

    public static int inRangeRecursive(int[]nums, int min, int max, int contador, int index){
        if(index>= nums.length){
            return contador;
        }
        if(nums[index]>=min && nums[index]<= max){
            contador++;
        }
        index++;
        return inRangeRecursive(nums,min,max,contador,index);
    }

    public static int sortedInRange(int[] nums, int min, int max) {
        int left = lowerBound(nums, min);
        int right = upperBound(nums, max);

        if (left == nums.length || right == -1 || left > right) {
            return 0; // no hay elementos en el rango
        }
        return right - left + 1;
    }

    // busca el índice del primer elemento >= target
    private static int lowerBound(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // busca el índice del último elemento <= target
    private static int upperBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

}
