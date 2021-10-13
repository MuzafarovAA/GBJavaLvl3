public class Homework {

    public static int[] getArrayAfterLastFour(int[] array) throws RuntimeException {
        int position = -1;
        for (int i = (array.length - 1); i > 0; i--) {
            if (array[i] == 4) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            throw new RuntimeException("В массиве отсутствует 4");
        }
        int[] arrayResult = new int[((array.length - 1) - position)];
        for (int j = 0; j < arrayResult.length; j++) {
            arrayResult[j] = array[position + 1 + j];
        }
        return arrayResult;
    }

    public static boolean checkArrayOnesAndFours(int[] array) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                hasOne = true;
            } else if (array[i] == 4) {
                hasFour = true;
            } else return false;
        }
        return hasOne && hasFour;
    }

}
