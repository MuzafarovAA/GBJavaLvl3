package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkPt1Pt2 {

    public static void main(String[] args) {

        String[] array1 = {"0", "1", "2", "3", "4"};
        Integer[] array2 = {0, 1, 2, 3, 4};
        Double[] array3 = {0.0, 1.0, 2.0, 3.0, 4.0};

        replace(array1, 2, 4);
        System.out.println(Arrays.toString(array1));

        replace(array2, 0, 1);
        System.out.println(Arrays.toString(array2));

        replace(array3, 3, 1);
        System.out.println(Arrays.toString(array3));

        System.out.println("-----");

        ArrayList<String> arrayList1 = new ArrayList<>(transformToArrayList(array1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(transformToArrayList(array2));
        ArrayList<Double> arrayList3 = new ArrayList<>(transformToArrayList(array3));

        arrayList1.add("5");
        arrayList2.add(5);
        arrayList3.add(5.0);

        System.out.println(Arrays.toString(arrayList1.toArray()));
        System.out.println(Arrays.toString(arrayList2.toArray()));
        System.out.println(Arrays.toString(arrayList3.toArray()));

    }

    private static <T> void replace(T[] array, int pos1, int pos2) {
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    private static <T> ArrayList<T> transformToArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : array) {
            arrayList.add(t);
        }
        return arrayList;
    }

}