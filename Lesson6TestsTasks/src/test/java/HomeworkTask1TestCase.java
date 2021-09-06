import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HomeworkTask1TestCase {

    private Homework homework;

    @BeforeEach
    public void init() {
        homework = new Homework();
    }

    @Test
    public void test_Task1_1() {
        Assertions.assertArrayEquals(new int[]{1, 7}, homework.getArrayAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test_Task1_2() {
        Assertions.assertArrayEquals(new int[]{4, 1, 7}, homework.getArrayAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test_Task1_3() {
        Assertions.assertArrayEquals(new int[]{5, 7}, homework.getArrayAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test_Task1_Exception1() {
        Assertions.assertThrows(RuntimeException.class, () -> homework.getArrayAfterLastFour(new int[]{1, 2, 3, 5, 6, 7}));
    }

    @Test
    public void test_Task1_Exception2() {
        Assertions.assertThrows(RuntimeException.class, () -> homework.getArrayAfterLastFour(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @ParameterizedTest
    @MethodSource("dataForTask1")
    public void test_Task1(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, homework.getArrayAfterLastFour(array));
    }
    public static Stream<Arguments> dataForTask1() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{4, 1, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{5, 7}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForTask1Exceptions")
    public void test_Task1_Exceptions(int[] array) {
        Assertions.assertThrows(RuntimeException.class, () -> homework.getArrayAfterLastFour(array));
    }
    public static Stream<Arguments> dataForTask1Exceptions() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 6, 7}));
        return out.stream();
    }

}
