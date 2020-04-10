import java.util.*;

public class Nearby {

    private static int[][] multi = new int[][] {
        { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
        { 1, 3, 5, 7 },
        { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    public static int[] nearby(int x, int y, int range) {
        int rangeLeft = range;
        int rangeRight = range;
        int arrayRange;
        int index = y - range;
        int[] result;
        int[] oneDimension = multi[x];

        if (range > y) {
            rangeLeft = y;
            index = 0;
        } else if (range > oneDimension.length - y - 1) {
            rangeRight = oneDimension.length - y - 1;
        }

        arrayRange = rangeLeft + rangeRight;

        if (index < 0) {
            arrayRange = 1;
            result = new int[arrayRange];
            result[0] = oneDimension[1];   
        } else if (oneDimension.length - y == 1) {
            arrayRange = rangeLeft;
            result = new int[arrayRange];
            for (int i=0; i<arrayRange; i++) {
                result[i] = oneDimension[index];
                index++;
            }
        } else {
            result = new int[arrayRange];
            for (int i=0; i<arrayRange; i++) {
                if (index!=y) {
                    result[i] = oneDimension[index];
                } else {
                    result[i] = oneDimension[index+1];
                    index++;
                }    
                index++;
            }
        } 

        return result;   

    }

    public static void main(String[] args) {
        int[] result1 = nearby(0, 2, 2);
        int[] result2 = nearby(1, 0, 1);
        int[] result3 = nearby(1, 3, 5);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

}