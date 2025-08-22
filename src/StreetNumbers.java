public class StreetNumbers {
    public static int sumOfRangeIterative(int min, int max){
        int res = 0;
        for(int i = min; i <= max; i++){
            res += i;
        }
        return res;
    }

    public static int sumOfRangeConstant(int min, int max){
        if (min > max) return 0; // seguridad
        return (max * (max + 1)) / 2 - ((min - 1) * min) / 2;
    }

    public static int streetNumbersQuadratic(int max){
        for(int i = 1; i <= max; i++){
            if(sumOfRangeIterative(1, i - 1) == sumOfRangeIterative(i + 1, max)){
                return i;
            }
        }
        return -1;
    }

    public static int streetNumbersLinear(int max){
        for(int i = 1; i <= max; i++){
            if(sumOfRangeConstant(1, i - 1) == sumOfRangeConstant(i + 1, max)){
                return i;
            }
        }
        return -1;
    }

    public static int streetNumbersConstant(int max) {

        long value = ((long) max * (max + 1)) / 2;
        long i = (long) Math.sqrt(value);

        if (i * i == value) {
            return (int) i;
        }
        return -1;
    }


}
