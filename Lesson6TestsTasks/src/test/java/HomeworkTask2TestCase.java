import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HomeworkTask2TestCase {

    private Homework homework;

    @BeforeEach
    public void init() {
        homework = new Homework();
    }

    @Test
    public void test_Task2_1() {
        Assertions.assertTrue(homework.checkArrayOnesAndFours(new int[]{1, 1, 1, 4, 4, 1, 4 ,4}));
    }

    @Test
    public void test_Task2_2() {
        Assertions.assertFalse(homework.checkArrayOnesAndFours(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void test_Task2_3() {
        Assertions.assertTrue(homework.checkArrayOnesAndFours(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void test_Task2_4() {
        Assertions.assertFalse(homework.checkArrayOnesAndFours(new int[]{1, 1, 1, 4, 4, 1, 3, 4 ,4}));
    }

    @ParameterizedTest
    @MethodSource("dataForTask2")
    public void test_Task2(int[] array) {
        Assertions.assertTrue(homework.checkArrayOnesAndFours(array));
    }
    public static Stream<Arguments> dataForTask2() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4 ,4}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 3, 4 ,4}));
        return out.stream();
    }

}
