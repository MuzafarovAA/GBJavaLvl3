package lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    private static final ArrayList<Method> methodList = new ArrayList<>();
    private static final ArrayList<Method> beforeList = new ArrayList<>();
    private static final ArrayList<Method> afterList = new ArrayList<>();
    private static Constructor constructor;

    public static void main(String[] args) {
        try {
            start(Tests.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void start(Class<Tests> testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        constructor = testClass.getConstructor();
        checkAnnotations(testClass);
        checkTheOnlyOne();
        beforeSuiteExecute();
        mainExecute();
        afterSuiteExecute();
    }

    private static void mainExecute() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        methodList.sort(Comparator.comparingInt((Method method) -> {
            return method.getAnnotation(Test.class).priority();
        }).reversed());
        for (Method method : methodList) {
            method.invoke(constructor.newInstance());
        }
    }

    private static void afterSuiteExecute() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (!afterList.isEmpty()) {
            afterList.get(0).invoke(constructor.newInstance());
        }
    }

    private static void beforeSuiteExecute() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (!beforeList.isEmpty()) {
            beforeList.get(0).invoke(constructor.newInstance());
        }
    }

    private static void checkTheOnlyOne() throws RuntimeException {
        if (beforeList.size() > 1) {
            throw new RuntimeException("Метод с аннотацией @BeforeSuite должен присутствовать в единственном экземпляре");
        }
        if (afterList.size() > 1) {
            throw new RuntimeException("Метод с аннотацией @AfterSuite должен присутствовать в единственном экземпляре");
        }
    }

    private static <T> void checkAnnotations(Class<T> testClass) {
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeList.add(method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterList.add(method);
            }
        }
    }

}
