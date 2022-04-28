import java.util.Random;

/**
 * @author YFCodeDream
 * @version 1.0.0
 * @date 2022/4/28
 * @description test
 */
public class Main {
    public static void main(String[] args) {
        HashUSet<Integer> testHashSet = new HashUSet<>();
        int[] testArr = {7, 10, 11, 5, 12, 17, 2, 19, 0, 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < testArr.length; i++) {
            testHashSet.add(testArr[i]);
        }

        System.out.println(testHashSet);

        testHashSet.increaseCapacity();

//        for (int i = 0; i < 8; i++) {
//            boolean add = testHashSet.add(i);
//            System.out.println(add);
//        }

        System.out.println(testHashSet);

        HashSimpleMap<Integer, Integer> integerIntegerHashSimpleMap = new HashSimpleMap<>();
    }
}
